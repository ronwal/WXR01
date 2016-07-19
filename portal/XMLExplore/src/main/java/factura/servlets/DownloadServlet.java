/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.servlets;

import ec.ste.factura.DaoManager;
import ec.ste.factura.beans.Login;
import ec.ste.factura.dao.DetalleAuditoriaDao;
import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.dao.RetencionDao;
import ec.ste.factura.entities.*;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FacesUtil;
import ec.ste.factura.util.StoreUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author German17
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"*.dde"})
public class DownloadServlet extends HttpServlet {

    private final static Logger log = Logger.getLogger(DownloadServlet.class);

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

        String validacionSesion = (String) request.getSession().getAttribute("validacionSesion");

        if (!validacion.equals(validacionSesion)) {
            validacionSesion = (String) request.getSession().getAttribute("validacionBusqueda");
            if (!validacion.equals(validacionSesion)) {
                presentarError(request, response, "Acceso no permitido");
                return;
            }
        }

        String fileName = null;
        InputStream input = null;
        try {
            String tipoDocumento = "S/E";
            int codigo = 0;
            if (tipo.equals("F")) {
                Factura f = FACTURA_DAO.findFacturaByPrimaryKey(Integer.parseInt(id));
                if (f != null) {
                    fileName = StoreUtil.getFileName(f);
                    input = StoreUtil.openFile(f.getEmpresa().getEmpCodigo(), "facturas", fileName);
                    tipoDocumento = "FAC";
                    codigo = f.getFacCodigo();
                }
            } else if (tipo.equals("R")) {
                Retencion r = RETENCION_DAO.findRetencionByPrimaryKey(Integer.parseInt(id));
                if (r != null) {
                    fileName = StoreUtil.getFileName(r);
                    input = StoreUtil.openFile(r.getEmpresa().getEmpCodigo(), "retenciones", fileName);
                    tipoDocumento = "CR";
                    codigo = r.getRetCodigo();
                }
            }else if (tipo.equals("NC")) {
                NotaCredito r = DaoManager.NOTA_CREDITO_DAO.findNotaCreditoByPrimaryKey(Integer.parseInt(id));
                if (r != null) {
                    fileName = StoreUtil.getFileName(r);
                    input = StoreUtil.openFile(r.getEmpresa().getEmpCodigo(), "notas-credito", fileName);
                    tipoDocumento = "NC";
                    codigo = r.getNcrCodigo();
                }
            }else if (tipo.equals("GR")) {
                GuiaRemision r = DaoManager.GUIA_REMISION_DAO.findGuiaRemisionByPrimaryKey(Integer.parseInt(id));
                if (r != null) {
                    fileName = StoreUtil.getFileName(r);
                    input = StoreUtil.openFile(r.getEmpresa().getEmpCodigo(), "guias-remision", fileName);
                    tipoDocumento = "GR";
                    codigo = r.getGreCodigo();
                }
            }

            if (input != null) {
                byte buffer[] = new byte[1024 * 10];
                int readed;
                response.setContentType("text/xml");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                OutputStream out = response.getOutputStream();
                while ((readed = input.read(buffer)) > 0) {
                    out.write(buffer, 0, readed);
                }
                out.flush();
                out.close();
                input.close();
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
                da.setDauCodigoDocumento(codigo);
                da.setDauDetalle("Descarga de XML: "+fileName);
                DETALLE_AUDITORIA_DAO.insert(da);
            } else {
                presentarError(request, response, "No se encuentra el documento");
            }

        } catch (DaoException ex) {
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
