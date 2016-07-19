package comprobantes.util;

import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.reportes.*;
import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
import ec.gob.sri.comprobantes.util.xml.XML2Java;
import ec.ste.factura.ConfigurationManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisualizacionRideUtil {

    private static final String ESTADO = "AUTORIZADO";

    public static void decodeArchivoBase64(final String nombreArch, String numeroAutorizacion, String fechaAut, OutputStream out) {
        try {
            final File file = new File(nombreArch);
            if (file.exists()) {
                final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                final DocumentBuilder builder = factory.newDocumentBuilder();
                final Document doc = builder.parse(file);
                final NodeList list = doc.getElementsByTagName("*");
                String docu = null;
                String numeroAut = "";
                String fechaAutorizacion = "";
                String estado = "";
                for (int i = 0; i < list.getLength(); ++i) {
                    final Element element = (Element) list.item(i);
                    if (element.getNodeName().equals("comprobante")) {
                        docu = element.getChildNodes().item(0).getNodeValue();
                    }
                    if (element.getNodeName().equals("estado")) {
                        estado = element.getChildNodes().item(0).getNodeValue();
                    }
                    if (numeroAutorizacion == null && fechaAut == null) {
                        if (element.getNodeName().equals("numeroAutorizacion")) {
                            numeroAut = element.getChildNodes().item(0).getNodeValue();
                        }
                        if (element.getNodeName().equals("fechaAutorizacion")) {
                            fechaAutorizacion += element.getChildNodes().item(0).getNodeValue();
                        }
                    }
                }
                if (fechaAut == null && numeroAutorizacion == null) {
                    fechaAut = fechaAutorizacion;
                    numeroAutorizacion = numeroAut;
                }
                if ("AUTORIZADO".equalsIgnoreCase(estado)) {
                    generar(docu, numeroAutorizacion, fechaAut, out);
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "El archivo seleccionado no es un comprobante autorizado.", "ERROR", 0);
                }
            } else {
                Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.INFO, "No existe archivo");
            }
        } catch (Exception e) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static void generar(final String docu, final String numeroAutorizacion, final String fechaAut, OutputStream out) {
        if (docu != null) {
            final File c = ArchivoUtils.stringToArchivo("factura.xml", docu);
            if (obtenerTipoComprobante(docu).equals("FA")) {
                try {
                    final Factura f = XML2Java.unmarshalFactura(c.getPath());
                    final FacturaReporte fr = new FacturaReporte(f);
                    generarReporte(fr, numeroAutorizacion, fechaAut, out);
                } catch (Exception ex) {
                    Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (obtenerTipoComprobante(docu).equals("ND")) {
                try {
                    final NotaDebito nd = XML2Java.unmarshalNotaDebito(c.getPath());
                    final NotaDebitoReporte ndR = new NotaDebitoReporte(nd);
                    generarReporte(ndR, numeroAutorizacion, fechaAut, out);
                } catch (Exception ex) {
                    Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (obtenerTipoComprobante(docu).equals("NC")) {
                try {
                    final NotaCredito nd2 = XML2Java.unmarshalNotaCredito(c.getPath());
                    final NotaCreditoReporte ndR2 = new NotaCreditoReporte(nd2);
                    generarReporte(ndR2, numeroAutorizacion, fechaAut, out);
                } catch (Exception ex) {
                    Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (obtenerTipoComprobante(docu).equals("CR")) {
                try {
                    final ComprobanteRetencion nd3 = XML2Java.unmarshalComprobanteRetencion(c.getPath());
                    final ComprobanteRetencionReporte ndR3 = new ComprobanteRetencionReporte(nd3);
                    generarReporte(ndR3, numeroAutorizacion, fechaAut, out);
                } catch (Exception ex) {
                    Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (obtenerTipoComprobante(docu).equals("GR")) {
                try {
                    final GuiaRemision gr = XML2Java.unmarshalGuiaRemision(c.getPath());
                    final GuiaRemisionReporte grr = new GuiaRemisionReporte(gr);
                    generarReporte(grr, numeroAutorizacion, fechaAut, gr, out);
                } catch (Exception ex) {
                    Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "El archivo seleccionado no es un comprobante autorizado.", "ERROR", 0);
        }
    }

    private static String obtenerTipoComprobante(final String docu) {
        if (docu.contains("<factura")) {
            return "FA";
        }
        if (docu.contains("<comprobanteRetencion")) {
            return "CR";
        }
        if (docu.contains("<notaCredito")) {
            return "NC";
        }
        if (docu.contains("<notaDebito")) {
            return "ND";
        }
        if (docu.contains("<guiaRemision")) {
            return "GR";
        }
        return null;
    }

    public static void generarReporte(final FacturaReporte xml, final String numAut, final String fechaAut, OutputStream out) {
        final ReporteUtil repUtil = new ReporteUtil();
        try {
            repUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath()+"factura.jasper", xml, numAut, fechaAut, out);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex2) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

    public static void generarReporte(final NotaCreditoReporte xml, final String numAut, final String fechaAut, OutputStream out) {
        final ReporteUtil repUtil = new ReporteUtil();
        try {
            repUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath()+"notaCreditoFinal.jasper", xml, numAut, fechaAut, out);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex2) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

    public static void generarReporte(final NotaDebitoReporte xml, final String numAut, final String fechaAut, OutputStream out) {
        final ReporteUtil repUtil = new ReporteUtil();
        try {
            repUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath()+"notaDebitoFinal.jasper", xml, numAut, fechaAut, out);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex2) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

    public static void generarReporte(final ComprobanteRetencionReporte xml, final String numAut, final String fechaAut, OutputStream out) {
        final ReporteUtil repUtil = new ReporteUtil();
        try {
            repUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath()+"comprobanteRetencion.jasper", xml, numAut, fechaAut, out);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex2) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

    public static void generarReporte(final GuiaRemisionReporte xml, final String numAut, final String fechaAut, final GuiaRemision gr, OutputStream out) {
        final ReporteUtil repUtil = new ReporteUtil();
        try {
            repUtil.generarReporte(ConfigurationManager.getInstance().getReportsPath()+"guiaRemisionFinal.jasper", xml, numAut, fechaAut, gr, out);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex2) {
            Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

}
