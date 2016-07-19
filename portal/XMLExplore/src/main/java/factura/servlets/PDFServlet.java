/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.servlets;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;
import ec.ste.factura.ConfigurationManager;
import ec.ste.factura.DaoManager;
import ec.ste.factura.beans.Login;
import ec.ste.factura.dao.DetalleAuditoriaDao;
import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.dao.RetencionDao;
import ec.ste.factura.entities.*;
import ec.ste.factura.util.FacesUtil;
import ec.ste.factura.util.StoreUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 *
 * @author German17
 */
@WebServlet(name = "PDFServlet", urlPatterns = {"*.rpt"})
public class PDFServlet extends HttpServlet {

    private ReporteUtil rptUtil = new ReporteUtil();

    private final static Logger log = Logger.getLogger(PDFServlet.class);
    private static final FacturaDao FACTURA_DAO = new FacturaDao();
    private static final RetencionDao RETENCION_DAO = new RetencionDao();
    private static final DetalleAuditoriaDao DETALLE_AUDITORIA_DAO = new DetalleAuditoriaDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("t");
        String id = request.getParameter("k");
        String validacion = request.getParameter("v");

        if (tipo == null) {
            presentarError(request, response, "Tipo de documento desconocido");
            return;
        }
        if (id == null) {
            presentarError(request, response, "Identificador de documento desconocido");
            return;
        }

        if (validacion == null) {
            presentarError(request, response, "Acceso no permitido");
            return;
        }

        String validacionSesion = (String) request.getSession().getAttribute("validacionDescarga");

        if (!validacion.equals(validacionSesion)) {
            validacionSesion = (String) request.getSession().getAttribute("validacionBusqueda");
            if (!validacion.equals(validacionSesion)) {
                presentarError(request, response, "Acceso no permitido");
                return;
            }
        }

        String fileName = null;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String tipoDocumento = "S/E";
        ConfigurationManager config = ConfigurationManager.getInstance();
        try {
            int code = 0;

            if (tipo.equals("F")) {
                ec.ste.factura.entities.Factura f = FACTURA_DAO.findFacturaByPrimaryKey(Integer.parseInt(id));
                if (f != null) {
                    fileName = StoreUtil.getFileName(f);
                    
                    DocumentoAutorizado documentoAutorizado=LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(f.getEmpresa().getEmpCodigo(), "facturas", fileName));
                    Factura fact = (Factura)documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + f.getFacIdentificacionVendedor() + ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "factura.jasper", new FacturaReporte(fact), f.getFacNumAutorizacion(), f.getFacFechaAutorizacion(), out, logo, config.getReportsPath());
                    tipoDocumento = "FAC";
                    code = f.getFacCodigo();

                }
            } else if (tipo.equals("R")) {
                Retencion r = RETENCION_DAO.findRetencionByPrimaryKey(Integer.parseInt(id));
                if (r != null) {
                    fileName = StoreUtil.getFileName(r);
                    DocumentoAutorizado documentoAutorizado=LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "retenciones", fileName));
                    ComprobanteRetencion fact = (ComprobanteRetencion)documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + r.getRetIdentificacionEmisor() + ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    ComprobanteRetencionReporte crr=new ComprobanteRetencionReporte(fact);
                    
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "comprobanteRetencion.jasper", crr, r.getRetNumAutorizacion(), r.getRetFechaAutorizacion(), out, logo, config.getReportsPath());
                    tipoDocumento = "CR";
                    code = r.getRetCodigo();
                }
            }else if (tipo.equals("NC")) {
                NotaCredito r = DaoManager.NOTA_CREDITO_DAO.findNotaCreditoByPrimaryKey(Integer.parseInt(id));
                if (r != null) {
                    fileName = StoreUtil.getFileName(r);
                    DocumentoAutorizado documentoAutorizado=LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "notas-credito", fileName));
                    ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito fact = (ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito)documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + r.getNcrIdentificacionVendedor()+ ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    NotaCreditoReporte crr=new NotaCreditoReporte(fact);
                    
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "notaCreditoFinal.jasper", crr, r.getNcrNumAutorizacion(), r.getNcrFechaAutorizacion(), out, logo, config.getReportsPath());
                    tipoDocumento = "CR";
                    code = r.getNcrCodigo();
                }
            }else if (tipo.equals("GR")) {
                GuiaRemision r = DaoManager.GUIA_REMISION_DAO.findGuiaRemisionByPrimaryKey(Integer.parseInt(id));
                if (r != null) {
                    fileName = StoreUtil.getFileName(r);
                    DocumentoAutorizado documentoAutorizado=LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "guias-remision", fileName));
                    ec.gob.sri.comprobantes.modelo.guia.GuiaRemision fact = (ec.gob.sri.comprobantes.modelo.guia.GuiaRemision)documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + r.getGreIdentificacionVendedor()+ ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    GuiaRemisionReporte crr=new GuiaRemisionReporte(fact);
                    
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "guiaRemisionFinal.jasper", crr, r.getGreNumAutorizacion(), r.getGreFechaAutorizacion(),fact, out, logo, config.getReportsPath());
                    tipoDocumento = "GR";
                    code = r.getGreCodigo();
                }
            }

            if (out.toByteArray().length>0) {
                response.setContentType("application/pdf");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
                OutputStream rout = response.getOutputStream();
                rout.write(out.toByteArray());
                rout.flush();
                rout.close();

                Login login = FacesUtil.findBean(request, response, "login");
                if (login == null) {
                    System.out.println("Login no recuperado para auditoria");
                    return;
                }
                Auditoria aud = login.getController().getAuditoria();
                if (aud == null) {
                    System.out.println("Auditoria no recuperado para detalle auditoria");
                    return;
                }
                DetalleAuditoria da = new DetalleAuditoria();
                da.setAuditoria(aud);
                da.setDauAccion("DOW");
                da.setDauFecha(new Date());
                da.setDauTipoDocumento(tipoDocumento);
                da.setDauCodigoDocumento(code);
                da.setDauDetalle("Descarga de PDF:" + fileName);
                DETALLE_AUDITORIA_DAO.insert(da);

            } else {
                presentarError(request, response, "No se encuentra el documento");
            }

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            presentarError(request, response, "Problema al encontrar documento");
        }

    }

    public void presentarError(HttpServletRequest request, HttpServletResponse response, String error) throws IOException {
        PrintWriter pw = response.getWriter();
        try {
            response.setContentType("text/html");

            pw.write(error);
            pw.flush();
            pw.close();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            pw.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
