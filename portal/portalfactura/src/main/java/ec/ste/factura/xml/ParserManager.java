/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.xml;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.rentencion.Impuesto;
import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;
import ec.ste.factura.ConfigurationManager;
import ec.ste.factura.ConfigurationReader;
import ec.ste.factura.Constantes;
import ec.ste.factura.DatabaseEntity;
import ec.ste.factura.beans.SendByMailBean;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.DetalleRetencion;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Retencion;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.model.FECDocumento;
import ec.ste.factura.util.Attach;
import ec.ste.factura.util.CommonClass;
import ec.ste.factura.util.DataFormatUtil;
import ec.ste.factura.util.Destinatario;
import ec.ste.factura.util.Mail;
import ec.ste.factura.util.StoreUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author German17
 */
public class ParserManager extends DaoManager {

    private final Logger log = Logger.getLogger(ParserManager.class);

    public void parseDocument(String ruc, String file, int registerType, byte xmlData[]) throws Exception {
        ParserBase base = new ParserBase();
        ConfigurationReader.read();

        log.trace("Recibiendo archivo: " + file);

        DocumentoAutorizado doc = base.parseXMLFile(ruc, file, registerType, xmlData);

        log.trace("Archivo base interpretado");

        DatabaseEntity entity = null;

        if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.factura.Factura) {
            log.trace("Archivo reconocido como Factura");
            ec.gob.sri.comprobantes.modelo.factura.Factura fact = (ec.gob.sri.comprobantes.modelo.factura.Factura) doc.getDocumento();
            //validación de emisor y receptor adecuado
            Tipo tipoRegistro = new Tipo();
            if (registerType == FECDocumento.ARCHIVO_ENVIADO) {
                if (!fact.getInfoTributaria().getRuc().equals(ruc)) {
                    throw new Exception("El documento enviado no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("ENV");
            } else if (registerType == FECDocumento.ARCHIVO_RECIBIDO) {
                if (!fact.getInfoFactura().getIdentificacionComprador().equals(ruc)) {
                    throw new Exception("El documento recibido no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("REC");
            } else {
                throw new Exception("El tipo de registro no corresponde a un tipo valido.");
            }

            Factura f = new Factura();
            Empresa empresa = new Empresa();
            empresa.setEmpCodigo(ruc);
            f.setEmpresa(empresa);
            f.setFacEstablecimiento(fact.getInfoTributaria().getEstab());
            f.setFacFechaAutorizacion(doc.getFechaAutorizacion());
            f.setFacFechaEmision(DataFormatUtil.getDdMMyyyyFormat().parse(fact.getInfoFactura().getFechaEmision()));
            f.setFacIdentificacionComprador(fact.getInfoFactura().getIdentificacionComprador());
            f.setFacIdentificacionVendedor(fact.getInfoTributaria().getRuc());
            f.setFacImporteTotal(fact.getInfoFactura().getImporteTotal().doubleValue());
            f.setFacNumAutorizacion(doc.getNumeroAutorizacion());
            f.setFacPuntoEmision(fact.getInfoTributaria().getPtoEmi());
            f.setFacRazonSocialComprador(fact.getInfoFactura().getRazonSocialComprador());
            f.setFacRazonSocialVendedor(fact.getInfoTributaria().getRazonSocial());
            f.setFacSecuencial(Integer.parseInt(fact.getInfoTributaria().getSecuencial()));
            f.setFacTotalDescuento(fact.getInfoFactura().getTotalDescuento().doubleValue());
            f.setFacTotalSinImpuestos(fact.getInfoFactura().getTotalSinImpuestos().doubleValue());
            f.setTipo(tipoRegistro);

            entity = f;

            log.trace("Extraccion de datos completada");
            if (!FACTURA_DAO.checkIsRegistered((Factura) entity)) {
                try {
                    FACTURA_DAO.insert((Factura) entity);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    throw new Exception("Error-50: No se puede registrar en la base de datos");
                }
                log.trace("Factura Registrada");
                StoreUtil.storeFile(ruc, "facturas", StoreUtil.getFileName(entity), xmlData);

                String correo = "";
                for (ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional.CampoAdicional i : fact.getInfoAdicional().getCampoAdicional()) {
                    if (i.getNombre().toLowerCase().contains("correo")
                            || i.getNombre().toLowerCase().contains("mail")) {
                        correo = i.getValue().trim().toLowerCase();
                        if (Boolean.valueOf(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_DEBUG, "true"))) {
                            correo = "fe_facturaecuador@hotmail.com;ronlad.rw@gmail.com";
                        }
                    }
                }

                if (tipoRegistro.getTipCodigo().equals("ENV")) {
                    String destinatario = f.getFacIdentificacionComprador();
                    Usuario user = USUARIO_DAO.personalizedFilter(f.getEmpresa(), destinatario);
                    if (user == null) {
                        user = new Usuario();
                        user.setEmpresa(f.getEmpresa());
                        user.setPerfil(new Perfil(Constantes.PRF_CLIENTE_PROVEEDOR, ""));
                        user.setUsuActivo(true);
                        user.setUsuClave(Crypt.encrypt(f.getEmpresa().getEmpCodigo(), destinatario));
                        user.setUsuIdentificacion(destinatario);
                        user.setUsuNick(destinatario);
                        user.setUsuMail(correo);
                        user.setUsuNombre(f.getFacRazonSocialComprador());
                        USUARIO_DAO.insert(user);
                    } else if (CommonClass.isEmpty(user.getUsuMail())) {
                        user.setUsuMail(correo);
                        USUARIO_DAO.update(user);
                    }

                    if (user.getUsuMail() != null) {
                        if (user.getUsuMail().trim().length() > 0) {
                            sendFactura(f, user);
                        }
                    }
                }
            } else {
                throw new Exception("Error-11: La factura ya se halla registrada");
            }
        } else if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion) {
            log.trace("Archivo reconocido como Comprobante de Retencion");
            ComprobanteRetencion ret = (ComprobanteRetencion) doc.getDocumento();

            Tipo tipoRegistro = new Tipo();
            if (registerType == FECDocumento.ARCHIVO_ENVIADO) {
                if (!ret.getInfoTributaria().getRuc().equals(ruc)) {
                    throw new Exception("El documento enviado no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("ENV");
            } else if (registerType == FECDocumento.ARCHIVO_RECIBIDO) {
                if (!ret.getInfoCompRetencion().getIdentificacionSujetoRetenido().equals(ruc)) {
                    throw new Exception("El documento recibido no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("REC");
            } else {
                throw new Exception("El tipo de registro no corresponde a un tipo valido.");
            }

            Retencion r = new Retencion();
            Empresa empresa = new Empresa();
            empresa.setEmpCodigo(ruc);
            r.setEmpresa(empresa);
            r.setRetEstablecimiento(ret.getInfoTributaria().getEstab());
            r.setRetFechaAutorizacion(doc.getFechaAutorizacion());
            r.setRetFechaEmision(DataFormatUtil.getDdMMyyyyFormat().parse(ret.getInfoCompRetencion().getFechaEmision()));
            r.setRetIdentificacionEmisor(ret.getInfoTributaria().getRuc());
            r.setRetIdentificacionRetenido(ret.getInfoCompRetencion().getIdentificacionSujetoRetenido());
            r.setRetNumAutorizacion(doc.getNumeroAutorizacion());
            r.setRetPuntoEmision(ret.getInfoTributaria().getPtoEmi());
            r.setRetRazonSocialEmisor(ret.getInfoTributaria().getRazonSocial());
            r.setRetRazonSocialRetenido(ret.getInfoCompRetencion().getRazonSocialSujetoRetenido());
            r.setRetSecuencial(Integer.parseInt(ret.getInfoTributaria().getSecuencial()));
            r.setTipo(tipoRegistro);
            double total = 0.0;
            List<DetalleRetencion> detalles = new ArrayList<DetalleRetencion>();

            for (Impuesto i : ret.getImpuestos().getImpuesto()) {
                DetalleRetencion dr = new DetalleRetencion();
                dr.setDcrBaseImponible(i.getBaseImponible().doubleValue());
                dr.setDcrCodigoImpuesto(i.getCodigo());
                dr.setDcrCodigoRetencion(i.getCodigoRetencion());
                dr.setDcrCodigoSustento(i.getCodDocSustento());
                dr.setDcrDocumentoSustento(i.getNumDocSustento());
                dr.setDcrPorcentaje(i.getPorcentajeRetener().doubleValue());
                dr.setDcrValorRetenido(i.getValorRetenido().doubleValue());
                dr.setRetencion(r);
                total += dr.getDcrValorRetenido();
                detalles.add(dr);
            }

            r.setRetValorRetenido(total);

            log.trace("Extraccion de datos completada");

            Session session = HibernateUtil.openSession();
            Transaction tx = session.beginTransaction();
            try {
                if (!RETENCION_DAO.checkIsRegistered(r)) {

                    RETENCION_DAO.insert(r);

                    for (DetalleRetencion dr : detalles) {
                        session.save(dr);
                    }

                    log.trace("Comprobante de Retencion registrado");

                    StoreUtil.storeFile(ruc, "retenciones", StoreUtil.getFileName(r), xmlData);

                    String correo = "";
                    for (ComprobanteRetencion.InfoAdicional.CampoAdicional i : ret.getInfoAdicional().getCampoAdicional()) {
                        if (i.getNombre().toLowerCase().contains("correo")
                                || i.getNombre().toLowerCase().contains("mail")) {
                            correo = i.getValue().trim().toLowerCase();
                            if (Boolean.valueOf(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_DEBUG, "true"))) {
                                correo = "fe_facturaecuador@hotmail.com";
                            }
                        }
                    }

                    if (tipoRegistro.getTipCodigo().equals("ENV")) {
                        String destinatario = r.getRetIdentificacionRetenido();
                        Usuario user = USUARIO_DAO.personalizedFilter(r.getEmpresa(), destinatario);
                        if (user == null) {
                            user = new Usuario();
                            user.setEmpresa(r.getEmpresa());
                            user.setPerfil(new Perfil(Constantes.PRF_CLIENTE_PROVEEDOR, ""));
                            user.setUsuActivo(true);
                            user.setUsuClave(Crypt.encrypt(r.getEmpresa().getEmpCodigo(), destinatario));
                            user.setUsuIdentificacion(destinatario);
                            user.setUsuMail(correo);
                            user.setUsuNick(destinatario);
                            user.setUsuNombre(r.getRetRazonSocialRetenido());
                            USUARIO_DAO.insert(user);
                        } else if (CommonClass.isEmpty(user.getUsuMail())) {
                            user.setUsuMail(correo);
                            USUARIO_DAO.update(user);
                        }

                        if (user.getUsuMail() != null) {
                            if (user.getUsuMail().trim().length() > 0) {
                                sendComprobanteRetencion(r, user);
                            }
                        }
                    }
                } else {
                    throw new Exception("Error-11: El comprobante de retencion ya se halla registrado");
                }
            } catch (Exception ex) {
                tx.rollback();
                log.error(ex.getMessage(), ex);
                throw new Exception("Error-50: No se puede registrar en la base de datos");
            } finally {
                session.close();
            }

        } else if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito) {
            log.trace("Archivo reconocido como Nota de Credito");
            NotaCredito not = (NotaCredito) doc.getDocumento();

            Tipo tipoRegistro = new Tipo();
            if (registerType == FECDocumento.ARCHIVO_ENVIADO) {
                if (!not.getInfoTributaria().getRuc().equals(ruc)) {
                    throw new Exception("El documento enviado no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("ENV");
            } else if (registerType == FECDocumento.ARCHIVO_RECIBIDO) {
                if (!not.getInfoNotaCredito().getIdentificacionComprador().equals(ruc)) {
                    throw new Exception("El documento recibido no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("REC");
            } else {
                throw new Exception("El tipo de registro no corresponde a un tipo valido.");
            }

            ec.ste.factura.entities.NotaCredito nc = new ec.ste.factura.entities.NotaCredito();
            Empresa empresa = new Empresa();
            empresa.setEmpCodigo(ruc);
            nc.setEmpresa(empresa);
            nc.setNcrEstablecimiento(not.getInfoTributaria().getEstab());
            nc.setNcrFechaAutorizacion(doc.getFechaAutorizacion());
            nc.setNcrFechaEmision(DataFormatUtil.getDdMMyyyyFormat().parse(not.getInfoNotaCredito().getFechaEmision()));
            nc.setNcrIdentificacionComprador(not.getInfoNotaCredito().getIdentificacionComprador());
            nc.setNcrIdentificacionVendedor(not.getInfoTributaria().getRuc());
            nc.setNcrNumAutorizacion(doc.getNumeroAutorizacion());
            nc.setNcrNumDocModificado(not.getInfoNotaCredito().getNumDocModificado());
            nc.setNcrPuntoEmision(not.getInfoTributaria().getPtoEmi());
            nc.setNcrRazonSocialComprador(not.getInfoNotaCredito().getRazonSocialComprador());
            nc.setNcrRazonSocialVendedor(not.getInfoTributaria().getRazonSocial());
            nc.setNcrSecuencial(Integer.parseInt(not.getInfoTributaria().getSecuencial()));
            nc.setNcrTotalSinImpuestos(not.getInfoNotaCredito().getTotalSinImpuestos().doubleValue());
            nc.setNcrValorModificacion(not.getInfoNotaCredito().getValorModificacion().doubleValue());
            nc.setTipo(tipoRegistro);

            log.trace("Extraccion de datos completada");

            if (!NOTA_CREDITO_DAO.checkIsRegistered(nc)) {
                try {
                    NOTA_CREDITO_DAO.insert(nc);

                    log.trace("Nota de Credito registrada");

                    StoreUtil.storeFile(ruc, "notas-credito", StoreUtil.getFileName(nc), xmlData);

                    String correo = "";
                    for (NotaCredito.InfoAdicional.CampoAdicional i : not.getInfoAdicional().getCampoAdicional()) {
                        if (i.getNombre().toLowerCase().contains("correo")
                                || i.getNombre().toLowerCase().contains("mail")) {
                            correo = i.getValue().trim().toLowerCase();
                            if (Boolean.valueOf(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_DEBUG, "true"))) {
                                correo = "fe_facturaecuador@hotmail.com";
                            }
                        }
                    }

                    if (tipoRegistro.getTipCodigo().equals("ENV")) {
                        String destinatario = nc.getNcrIdentificacionComprador();
                        Usuario user = USUARIO_DAO.personalizedFilter(nc.getEmpresa(), destinatario);
                        if (user == null) {
                            user = new Usuario();
                            user.setEmpresa(nc.getEmpresa());
                            user.setPerfil(new Perfil(Constantes.PRF_CLIENTE_PROVEEDOR, ""));
                            user.setUsuActivo(true);
                            user.setUsuClave(Crypt.encrypt(nc.getEmpresa().getEmpCodigo(), destinatario));
                            user.setUsuIdentificacion(destinatario);
                            user.setUsuMail(correo);
                            user.setUsuNick(destinatario);
                            user.setUsuNombre(nc.getNcrRazonSocialComprador());
                            USUARIO_DAO.insert(user);
                        } else if (CommonClass.isEmpty(user.getUsuMail())) {
                            user.setUsuMail(correo);
                            USUARIO_DAO.update(user);
                        }
                        if (user.getUsuMail() != null) {
                            if (user.getUsuMail().trim().length() > 0) {
                                sendNotaCredito(nc, user);
                            }
                        }
                    }
                } catch (Exception ex) {
                    if (!ex.getMessage().contains("Error-11:")) {
                        if (nc.getNcrCodigo() != 0) {
                            NOTA_CREDITO_DAO.delete(nc);
                        }

                        log.error(ex.getMessage(), ex);
                        throw new Exception("Error-50: No se puede registrar en la base de datos");
                    }
                }
            } else {
                throw new Exception("Error-11: La nota de credito ya se halla registrado");
            }

        } else if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.guia.GuiaRemision) {
            log.trace("Archivo reconocido como Guia Remision");
            GuiaRemision gr = (GuiaRemision) doc.getDocumento();

            Tipo tipoRegistro = new Tipo();
            if (registerType == FECDocumento.ARCHIVO_ENVIADO) {
                if (!gr.getInfoTributaria().getRuc().equals(ruc)) {
                    throw new Exception("El documento enviado no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("ENV");
            } else if (registerType == FECDocumento.ARCHIVO_RECIBIDO) {
                if (!gr.getDestinatarios().getDestinatario().get(0).getIdentificacionDestinatario().equals(ruc)) {
                    throw new Exception("El documento recibido no corresponde al ruc de la empresa");
                }
                tipoRegistro.setTipCodigo("REC");
            } else {
                throw new Exception("El tipo de registro no corresponde a un tipo valido.");
            }

            ec.ste.factura.entities.GuiaRemision grem = new ec.ste.factura.entities.GuiaRemision();
            Empresa empresa = new Empresa();
            empresa.setEmpCodigo(ruc);
            grem.setEmpresa(empresa);
            grem.setGreEstablecimiento(gr.getInfoTributaria().getEstab());
            grem.setGreFechaAutorizacion(doc.getFechaAutorizacion());
            grem.setGreFechaEmision(DataFormatUtil.getDdMMyyyyFormat().parse(gr.getInfoGuiaRemision().getFechaIniTransporte()));
            grem.setGreIndetificacionComprador(gr.getDestinatarios().getDestinatario().get(0).getIdentificacionDestinatario());
            grem.setGreIdentificacionVendedor(gr.getInfoTributaria().getRuc());
            grem.setGreNumAutorizacion(doc.getNumeroAutorizacion());
            grem.setGreNumDocModificado(gr.getDestinatarios().getDestinatario().get(0).getNumDocSustento());
            grem.setGrePuntoEmision(gr.getInfoTributaria().getPtoEmi());
            grem.setGreRazonSocialComprador(gr.getDestinatarios().getDestinatario().get(0).getRazonSocialDestinatario());
            grem.setGreRazonSocialVendedor(gr.getInfoTributaria().getRazonSocial());
            grem.setGreSecuencial(Integer.parseInt(gr.getInfoTributaria().getSecuencial()));

            grem.setTipo(tipoRegistro);

            log.trace("Extraccion de datos completada");

            if (!GUIA_REMISION_DAO.checkIsRegistered(grem)) {
                try {
                    GUIA_REMISION_DAO.insert(grem);

                    log.trace("Guia de Remision registrada");

                    StoreUtil.storeFile(ruc, "guias-remision", StoreUtil.getFileName(grem), xmlData);
                } catch (Exception ex) {
                    log.error(ex.getMessage(), ex);
                    throw new Exception("Error-50: No se puede registrar en la base de datos");
                }
            } else {
                throw new Exception("Error-11: La guia de remision ya se halla registrado");
            }
        }
    }

    private void sendFactura(Factura f, Usuario u) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        ReporteUtil rptUtil = new ReporteUtil();
        try {

            if (f != null) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                String fileName = StoreUtil.getFileName(f);
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
                List<Destinatario> destList = new ArrayList<Destinatario>();
                if (u.getUsuMail() != null && CommonClass.emailRgexvalidate(u.getUsuMail().trim())) {
                    String delims = ";";
                    String[] emails = u.getUsuMail().split(delims);
                    if (emails.length == 1) {
                        delims = ",";
                        emails = u.getUsuMail().split(delims);
                    }

                    for (String email : emails) {
                        destList.add(new Destinatario(u.getUsuNombre(), email));
                    }
                }

                Empresa emp = EMPRESA_DAO.findEmpresaByPrimaryKey(f.getEmpresa().getEmpCodigo());

                mail.enviar("Ha recibido una nueva Factura de " + emp.getEmpRazonSocial(),//titulo
                        "plantilla.html",//plantilla
                        emp.getEmpRazonSocial(),
                        f.getFacRazonSocialComprador(),
                        Mail.dateFormat.format(f.getFacFechaEmision()),
                        f.getFacEstablecimiento() + "-" + f.getFacPuntoEmision() + "-" + f.getFacSecuencial(),
                        "Mail: " + emp.getEmpMail() + " Teléfono: " + emp.getEmpTelefono(),
                        "Esta es una notificación automática de  " + emp.getEmpRazonSocial() + " a través de www.facturaecuador.com",
                        destList,
                        "facturaEcuador",
                        attachments,
                        emp.getEmpCodigo());

            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendComprobanteRetencion(Retencion r, Usuario u) {
        try {
            ConfigurationManager config = ConfigurationManager.getInstance();
            ReporteUtil rptUtil = new ReporteUtil();

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
                if (u.getUsuMail() != null && CommonClass.emailRgexvalidate(u.getUsuMail().trim())) {
                    String delims = ";";
                    String[] emails = u.getUsuMail().split(delims);
                    if (emails.length == 1) {
                        delims = ",";
                        emails = u.getUsuMail().split(delims);
                    }

                    for (String email : emails) {
                        destList.add(new Destinatario(u.getUsuNombre(), email));
                    }
                }

                Empresa emp = EMPRESA_DAO.findEmpresaByPrimaryKey(r.getEmpresa().getEmpCodigo());
                r.setEmpresa(emp);

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

            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendNotaCredito(ec.ste.factura.entities.NotaCredito r, Usuario user) {
        try {
            ConfigurationManager config = ConfigurationManager.getInstance();
            ReporteUtil rptUtil = new ReporteUtil();
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
                if (user.getUsuMail() != null && CommonClass.emailRgexvalidate(user.getUsuMail().trim())) {
                    String delims = ";";
                    String[] emails = user.getUsuMail().split(delims);
                    if (emails.length == 1) {
                        delims = ",";
                        emails = user.getUsuMail().split(delims);
                    }

                    for (String email : emails) {
                        destList.add(new Destinatario(user.getUsuNombre(), email));
                    }
                }

                Empresa emp = EMPRESA_DAO.findEmpresaByPrimaryKey(r.getEmpresa().getEmpCodigo());
                r.setEmpresa(emp);

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

            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SendByMailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
