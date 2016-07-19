/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.beans;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;

import ec.ste.factura.ConfigurationManager;
import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.dao.NotaCreditoDao;
import ec.ste.factura.dao.RetencionDao;
import ec.ste.factura.entities.Auditoria;
import ec.ste.factura.entities.DetalleAuditoria;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.Retencion;
import ec.ste.factura.util.Attach;
import ec.ste.factura.util.CommonClass;
import ec.ste.factura.util.Destinatario;
import ec.ste.factura.util.FacesUtil;
import ec.ste.factura.util.Mail;
import ec.ste.factura.util.StoreUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author German17
 */
@ManagedBean
@SessionScoped
public class SendByMailBean {

    private ReporteUtil rptUtil = new ReporteUtil();

    private final FacturaDao facturaDao = new FacturaDao();
    private final RetencionDao retencionDao = new RetencionDao();
    private final NotaCreditoDao notaCreditoDao = new NotaCreditoDao();
    

    private String dest;
    private String cc;
    private int key;

    /**
     * Creates a new instance of SendByMailBean
     */
    public SendByMailBean() {
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void send(ActionEvent e) {
        Object t = e.getComponent().getAttributes().get("tipo");
        String tipo = (String) t;
        ConfigurationManager config = ConfigurationManager.getInstance();
        if (tipo.equals("F")) {
            try {
                Factura f = facturaDao.findFacturaByPrimaryKey(key);
                if (f != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    String fileName = StoreUtil.getFileName(f);
                    System.out.println("PK "+key+" FL "+fileName);
                    DocumentoAutorizado documentoAutorizado = LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(f.getEmpresa().getEmpCodigo(), "facturas", fileName));
                    ec.gob.sri.comprobantes.modelo.factura.Factura fact = (ec.gob.sri.comprobantes.modelo.factura.Factura) documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + f.getFacIdentificacionVendedor() + ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "factura.jasper", new FacturaReporte(fact), f.getFacNumAutorizacion(), f.getFacFechaAutorizacion(), out, logo, config.getReportsPath());
                    List<Attach> attachments = new ArrayList<Attach>();
                    attachments.add(new Attach(fileName.replaceAll(".xml", "") + ".pdf", out.toByteArray(), "application/pdf"));
                    attachments.add(new Attach(fileName, StoreUtil.openFileAsBytes(f.getEmpresa().getEmpCodigo(), "facturas", fileName), "application/xml"));
                    Mail mail = new Mail();
                    mail.setEmailEmpr(f.getEmpresa().getEmpMail());
                    List<Destinatario> destList = new ArrayList<Destinatario>();
                    
                    if (CommonClass.emailRgexvalidate(dest.trim())) {
                        String delims = ";";
			String[] emails = dest.split(delims);
			if (emails.length == 1) {
				delims = ",";
				emails = dest.split(delims);
			}
                        for (String email : emails) {
                            destList.add(new Destinatario(email, email));
                        }
                    }
                    
                    if (cc.trim().length() > 0) {
                        destList.add(new Destinatario(cc, cc));
                    }
                    mail.enviar("Ha recibido una nueva Factura de " + f.getEmpresa().getEmpRazonSocial(),
                            "plantilla.html",
                            f.getEmpresa().getEmpRazonSocial(),
                            f.getFacRazonSocialComprador(),
                            Mail.dateFormat.format(f.getFacFechaEmision()),
                            f.getFacEstablecimiento() + "-" + f.getFacPuntoEmision() + "-" + f.getFacSecuencial(),
                            "Mail: " + f.getEmpresa().getEmpMail() + " Teléfono: " + f.getEmpresa().getEmpTelefono(),
                            "Esta es una notificación automática de  " + f.getEmpresa().getEmpRazonSocial() + " a través de www.facturaecuador.com",
                            destList,
                            "facturaEcuador",
                            attachments,
                            f.getEmpresa().getEmpCodigo());
                    Login login = FacesUtil.findBean("login");
                    if (login == null) {
                        System.out.println("Login no recuperado para auditoria");
                        return;
                    }
                    Auditoria aud = login.getController().getAuditoria();
                    if (aud == null) {
                        System.out.println("Auditoria no recuperada para detalle auditoria");
                        return;
                    }
                    DetalleAuditoria da = new DetalleAuditoria();
                    da.setAuditoria(aud);
                    da.setDauAccion("ENV");
                    da.setDauFecha(new Date());
                    da.setDauTipoDocumento("FAC");
                    da.setDauCodigoDocumento(f.getFacCodigo());
                    da.setDauDetalle("Envio de documento : " + fileName + " a: " + dest + " cc: " + cc);
                }
            } catch (Exception ex) {
                Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (tipo.equals("R")) {
            try {
                Retencion r = retencionDao.findRetencionByPrimaryKey(key);
                if (r != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    String fileName = StoreUtil.getFileName(r);
                    DocumentoAutorizado documentoAutorizado = LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "retenciones", fileName));
                    ComprobanteRetencion fact = (ComprobanteRetencion) documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + r.getRetIdentificacionEmisor() + ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "comprobanteRetencion.jasper", new ComprobanteRetencionReporte(fact), r.getRetNumAutorizacion(), r.getRetFechaAutorizacion(), out, logo, config.getReportsPath());
                    List<Attach> attachments = new ArrayList<Attach>();
                    attachments.add(new Attach(fileName.replaceAll(".xml", "") + ".pdf", out.toByteArray(), "application/pdf"));
                    attachments.add(new Attach(fileName, StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "retenciones", fileName), "application/xml"));
                    Mail mail = new Mail();
                    List<Destinatario> destList = new ArrayList<Destinatario>();
                    destList.add(new Destinatario(dest, dest));
                    if (cc.trim().length() > 0) {
                        destList.add(new Destinatario(cc, cc));
                    }
                    mail.enviar("Ha recibido un Comprobante de Retención de " + r.getEmpresa().getEmpRazonSocial(),
                            "plantilla.html",
                            r.getEmpresa().getEmpRazonSocial(),
                            r.getRetRazonSocialRetenido(),
                            Mail.dateFormat.format(r.getRetFechaEmision()),
                            r.getRetEstablecimiento() + "-" + r.getRetPuntoEmision() + "-" + r.getRetSecuencial(),
                            "Mail: " + r.getEmpresa().getEmpMail() + " Teléfono: " + r.getEmpresa().getEmpTelefono(),
                            "Esta es una notificación automática de  " + r.getEmpresa().getEmpRazonSocial() + " a través de www.facturaecuador.com",
                            destList,
                            "facturaEcuador",
                            attachments,
                            r.getEmpresa().getEmpCodigo());
                    Login login = FacesUtil.findBean("login");
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
                    da.setDauAccion("ENV");
                    da.setDauFecha(new Date());
                    da.setDauTipoDocumento("CR");
                    da.setDauCodigoDocumento(r.getRetCodigo());
                    da.setDauDetalle("Envio de documento a: " + dest + " cc: " + cc);
                }
            } catch (Exception ex) {
                Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (tipo.equals("NC")) {
            try {
                ec.ste.factura.entities.NotaCredito r = notaCreditoDao.findNotaCreditoByPrimaryKey(key);
                if (r != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    String fileName = StoreUtil.getFileName(r);
                    DocumentoAutorizado documentoAutorizado = LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "notas-credito", fileName));
                    NotaCredito fact = (NotaCredito) documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + r.getNcrIdentificacionVendedor() + ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "notaCreditoFinal.jasper", new NotaCreditoReporte(fact), r.getNcrNumAutorizacion(), r.getNcrFechaAutorizacion(), out, logo, config.getReportsPath());
                    List<Attach> attachments = new ArrayList<Attach>();
                    attachments.add(new Attach(fileName.replaceAll(".xml", "") + ".pdf", out.toByteArray(), "application/pdf"));
                    attachments.add(new Attach(fileName, StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "notas-credito", fileName), "application/xml"));
                    Mail mail = new Mail();
                    List<Destinatario> destList = new ArrayList<Destinatario>();
                    destList.add(new Destinatario(dest, dest));
                    if (cc.trim().length() > 0) {
                        destList.add(new Destinatario(cc, cc));
                    }
                    mail.enviar("Ha recibido una nueva Nota de Crédito de " + r.getNcrRazonSocialVendedor(),
                            "plantilla.html",
                            r.getNcrRazonSocialVendedor(),
                            r.getNcrIdentificacionComprador(),
                            Mail.dateFormat.format(r.getNcrFechaEmision()),
                            r.getNcrEstablecimiento() + "-" + r.getNcrPuntoEmision() + "-" + r.getNcrSecuencial(),
                            "Mail: " + r.getEmpresa().getEmpMail() + " Teléfono: " + r.getEmpresa().getEmpTelefono(),
                            "Esta es una notificación automática de  " + r.getEmpresa().getEmpRazonSocial() + " a través de www.facturaecuador.com",
                            destList,
                            "facturaEcuador",
                            attachments,
                            r.getEmpresa().getEmpCodigo());
                    Login login = FacesUtil.findBean("login");
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
                    da.setDauAccion("ENV");
                    da.setDauFecha(new Date());
                    da.setDauTipoDocumento("NC");
                    da.setDauCodigoDocumento(r.getNcrCodigo());
                    da.setDauDetalle("Envio de documento a: " + dest + " cc: " + cc);
                }
            } catch (Exception ex) {
                Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (tipo.equals("GR")) {
            try {
                ec.ste.factura.entities.GuiaRemision r = DaoManager.GUIA_REMISION_DAO.findGuiaRemisionByPrimaryKey(key);
                if (r != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    String fileName = StoreUtil.getFileName(r);
                    DocumentoAutorizado documentoAutorizado = LectorComprobante.extraerInstanciaDocumento(StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "guias-remision", fileName));
                    GuiaRemision fact = (GuiaRemision) documentoAutorizado.getDocumento();
                    String logo = config.getLogosPath() + r.getGreIdentificacionVendedor()+ ".png";
                    File flogo = new File(logo);
                    if (!flogo.exists()) {
                        logo = config.getStorePath() + "no-logo.png";
                    }
                    rptUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath() + "guiaRemisionFinal.jasper", new GuiaRemisionReporte(fact), r.getGreNumAutorizacion(), r.getGreFechaAutorizacion(),fact, out, logo, config.getReportsPath());
                    List<Attach> attachments = new ArrayList<Attach>();
                    attachments.add(new Attach(fileName.replaceAll(".xml", "") + ".pdf", out.toByteArray(), "application/pdf"));
                    attachments.add(new Attach(fileName, StoreUtil.openFileAsBytes(r.getEmpresa().getEmpCodigo(), "guias-remision", fileName), "application/xml"));
                    Mail mail = new Mail();
                    List<Destinatario> destList = new ArrayList<Destinatario>();
                    destList.add(new Destinatario(dest, dest));
                    if (cc.trim().length() > 0) {
                        destList.add(new Destinatario(cc, cc));
                    }
                    mail.enviar("Ha recibido una nueva Guia de Remision de " + r.getGreRazonSocialVendedor(),
                            "plantilla.html",
                            r.getGreRazonSocialVendedor(),
                            r.getGreIndetificacionComprador(),
                            Mail.dateFormat.format(r.getGreFechaEmision()),
                            r.getGreEstablecimiento() + "-" + r.getGrePuntoEmision() + "-" + r.getGreSecuencial(),
                            "Mail: " + r.getEmpresa().getEmpMail() + " Teléfono: " + r.getEmpresa().getEmpTelefono(),
                            "Esta es una notificación automática de  " + r.getEmpresa().getEmpRazonSocial() + " a través de www.facturaecuador.com",
                            destList,
                            "facturaEcuador",
                            attachments,
                            r.getEmpresa().getEmpCodigo());
                    Login login = FacesUtil.findBean("login");
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
                    da.setDauAccion("ENV");
                    da.setDauFecha(new Date());
                    da.setDauTipoDocumento("GR");
                    da.setDauCodigoDocumento(r.getGreCodigo());
                    da.setDauDetalle("Envio de documento a: " + dest + " cc: " + cc);
                }
            } catch (Exception ex) {
                Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
