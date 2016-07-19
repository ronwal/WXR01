package comprobantes.util.reportes;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.reportes.*;
import ec.gob.sri.comprobantes.util.*;
import ec.ste.factura.ConfigurationManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

import java.io.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteUtil {

    private static final String DIR_SUCURSAL = "DIR_SUCURSAL";
    private static final String CONT_ESPECIAL = "CONT_ESPECIAL";
    private static final String LLEVA_CONTABILIDAD = "LLEVA_CONTABILIDAD";

    public void generarReporte(final String urlReporte, final FacturaReporte fact, final String numAut, final String fechaAut, OutputStream out) throws SQLException, ClassNotFoundException {
        FileInputStream is = null;
        try {
            final JRDataSource dataSource = (JRDataSource) new JRBeanCollectionDataSource((Collection) fact.getDetallesAdiciones());
            is = new FileInputStream(urlReporte);
            final JasperPrint reporte_view = JasperFillManager.fillReport((InputStream) is, (Map) this.obtenerMapaParametrosReportes(this.obtenerParametrosInfoTriobutaria(fact.getFactura().getInfoTributaria(), numAut, fechaAut), this.obtenerInfoFactura(fact.getFactura().getInfoFactura(), fact)), dataSource);
            this.showReport(reporte_view, out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException e) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, (Throwable) e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex2) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
    }

    public void generarReporte(final String urlReporte, final NotaDebitoReporte rep, final String numAut, final String fechaAut, OutputStream out) throws SQLException, ClassNotFoundException {
        FileInputStream is = null;
        try {
            final JRDataSource dataSource = (JRDataSource) new JRBeanCollectionDataSource((Collection) rep.getDetallesAdiciones());
            is = new FileInputStream(urlReporte);
            final JasperPrint reporte_view = JasperFillManager.fillReport((InputStream) is, (Map) this.obtenerMapaParametrosReportes(this.obtenerParametrosInfoTriobutaria(rep.getNotaDebito().getInfoTributaria(), numAut, fechaAut), this.obtenerInfoND(rep.getNotaDebito().getInfoNotaDebito())), dataSource);
            this.showReport(reporte_view, out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException e) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, (Throwable) e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex2) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
    }

    public void generarReporte(final String urlReporte, final NotaCreditoReporte rep, final String numAut, final String fechaAut, OutputStream out) throws SQLException, ClassNotFoundException {
        FileInputStream is = null;
        try {
            final JRDataSource dataSource = (JRDataSource) new JRBeanCollectionDataSource((Collection) rep.getDetallesAdiciones());
            is = new FileInputStream(urlReporte);
            final JasperPrint reporte_view = JasperFillManager.fillReport((InputStream) is, (Map) this.obtenerMapaParametrosReportes(this.obtenerParametrosInfoTriobutaria(rep.getNotaCredito().getInfoTributaria(), numAut, fechaAut), this.obtenerInfoNC(rep.getNotaCredito().getInfoNotaCredito(), rep)), dataSource);
            this.showReport(reporte_view, out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException e) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, (Throwable) e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex2) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
    }

    public void generarReporte(final String urlReporte, final GuiaRemisionReporte rep, final String numAut, final String fechaAut, final GuiaRemision guiaRemision, OutputStream out) throws SQLException, ClassNotFoundException {
        FileInputStream is = null;
        try {
            final JRDataSource dataSource = (JRDataSource) new JRBeanCollectionDataSource((Collection) rep.getGuiaRemisionList());
            is = new FileInputStream(urlReporte);
            final JasperPrint reporte_view = JasperFillManager.fillReport((InputStream) is, (Map) this.obtenerMapaParametrosReportes(this.obtenerParametrosInfoTriobutaria(rep.getGuiaRemision().getInfoTributaria(), numAut, fechaAut), this.obtenerInfoGR(rep.getGuiaRemision().getInfoGuiaRemision(), guiaRemision)), dataSource);
            this.showReport(reporte_view, out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException e) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, (Throwable) e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex2) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
    }

    public void generarReporte(final String urlReporte, final ComprobanteRetencionReporte rep, final String numAut, final String fechaAut, OutputStream out) throws SQLException, ClassNotFoundException {
        FileInputStream is = null;
        try {
            final JRDataSource dataSource = (JRDataSource) new JRBeanCollectionDataSource((Collection) rep.getDetallesAdiciones());
            is = new FileInputStream(urlReporte);
            final JasperPrint reporte_view = JasperFillManager.fillReport((InputStream) is, (Map) this.obtenerMapaParametrosReportes(this.obtenerParametrosInfoTriobutaria(rep.getComprobanteRetencion().getInfoTributaria(), numAut, fechaAut), this.obtenerInfoCompRetencion(rep.getComprobanteRetencion().getInfoCompRetencion())), dataSource);
            this.showReport(reporte_view, out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException e) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, (Throwable) e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex2) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
    }

    private Map<String, Object> obtenerMapaParametrosReportes(final Map<String, Object> mapa1, final Map<String, Object> mapa2) {
        mapa1.putAll(mapa2);
        return mapa1;
    }

    private Map<String, Object> obtenerParametrosInfoTriobutaria(final InfoTributaria infoTributaria, final String numAut, final String fechaAut) throws SQLException, ClassNotFoundException {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("RUC", infoTributaria.getRuc());
        param.put("CLAVE_ACC", infoTributaria.getClaveAcceso());
        param.put("RAZON_SOCIAL", infoTributaria.getRazonSocial());
        param.put("DIR_MATRIZ", infoTributaria.getDirMatriz());
        try {

            param.put("LOGO", new FileInputStream(ConfigurationManager.getInstance().getLogosPath()+infoTributaria.getRuc().trim()+".png"));

        } catch (FileNotFoundException ex) {
            try {
                param.put("LOGO", new FileInputStream(ConfigurationManager.getInstance().getStorePath()+"no-logo.png"));
            } catch (FileNotFoundException ex2) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
        param.put("SUBREPORT_DIR", ConfigurationManager.getInstance().getReportsPath());
        param.put("TIPO_EMISION", this.obtenerTipoEmision(infoTributaria));
        param.put("NUM_AUT", numAut);
        param.put("FECHA_AUT", fechaAut);
        param.put("MARCA_AGUA", this.obtenerMarcaAgua(infoTributaria.getAmbiente()));
        param.put("NUM_FACT", infoTributaria.getEstab() + "-" + infoTributaria.getPtoEmi() + "-" + infoTributaria.getSecuencial());
        param.put("AMBIENTE", this.obtenerAmbiente(infoTributaria));
        param.put("NOM_COMERCIAL", infoTributaria.getNombreComercial());
        return param;
    }

    private String obtenerAmbiente(final InfoTributaria infoTributaria) {
        if (infoTributaria.getAmbiente().equals("2")) {
            return TipoAmbienteEnum.PRODUCCION.toString();
        }
        return TipoAmbienteEnum.PRUEBAS.toString();
    }

    private String obtenerTipoEmision(final InfoTributaria infoTributaria) {
        if (infoTributaria.getTipoEmision().equals("2")) {
            return TipoEmisionEnum.CONTINGENCIA.getCode();
        }
        if (infoTributaria.getTipoEmision().equals("1")) {
            return TipoEmisionEnum.NORMAL.getCode();
        }
        return null;
    }

    private InputStream obtenerMarcaAgua(final String ambiente) {
        try {
            if (ambiente.equals(TipoAmbienteEnum.PRODUCCION.getCode())) {
                final InputStream is = new BufferedInputStream(new FileInputStream(ConfigurationManager.getInstance().getReportsPath()+"images/produccion.jpeg"));
                return is;
            }
            final InputStream is = new BufferedInputStream(new FileInputStream(ConfigurationManager.getInstance().getReportsPath()+"images/pruebas.jpeg"));
            return is;
        } catch (FileNotFoundException fe) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, fe);
            return null;
        }
    }

    private Map<String, Object> obtenerInfoFactura(final Factura.InfoFactura infoFactura, final FacturaReporte fact) {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("DIR_SUCURSAL", infoFactura.getDirEstablecimiento());
        param.put("CONT_ESPECIAL", infoFactura.getContribuyenteEspecial());
        param.put("LLEVA_CONTABILIDAD", infoFactura.getObligadoContabilidad());
        param.put("RS_COMPRADOR", infoFactura.getRazonSocialComprador());
        param.put("RUC_COMPRADOR", infoFactura.getIdentificacionComprador());
        param.put("FECHA_EMISION", infoFactura.getFechaEmision());
        param.put("GUIA", infoFactura.getGuiaRemision());
        final TotalComprobante tc = this.getTotales(infoFactura);
        param.put("VALOR_TOTAL", infoFactura.getImporteTotal());
        param.put("DESCUENTO", infoFactura.getTotalDescuento());
        param.put("IVA", tc.getIva12());
        param.put("IVA_0", tc.getSubtotal0());
        param.put("IVA_12", tc.getSubtotal12());
        param.put("ICE", tc.getTotalIce());
        param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
        param.put("SUBTOTAL", infoFactura.getTotalSinImpuestos());
        if (infoFactura.getPropina() != null) {
            param.put("PROPINA", infoFactura.getPropina().toString());
        }
        param.put("TOTAL_DESCUENTO", this.calcularDescuento(fact));
        return param;
    }

    private String calcularDescuento(final FacturaReporte fact) {
        BigDecimal descuento = new BigDecimal(0);
        for (final DetallesAdicionalesReporte detalle : fact.getDetallesAdiciones()) {
            descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
        }
        return descuento.toString();
    }

    private TotalComprobante getTotales(final Factura.InfoFactura infoFactura) {
        BigDecimal totalIva12 = new BigDecimal(0.0);
        BigDecimal totalIva2 = new BigDecimal(0.0);
        BigDecimal iva12 = new BigDecimal(0.0);
        BigDecimal totalICE = new BigDecimal(0.0);
        BigDecimal totalSinImpuesto = new BigDecimal(0.0);
        final TotalComprobante tc = new TotalComprobante();
        for (final Factura.InfoFactura.TotalConImpuestos.TotalImpuesto ti : infoFactura.getTotalConImpuestos().getTotalImpuesto()) {
            final Integer cod = new Integer(ti.getCodigo());
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje())) {
                totalIva12 = totalIva12.add(ti.getBaseImponible());
                iva12 = iva12.add(ti.getValor());
            }
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje())) {
                totalIva2 = totalIva2.add(ti.getBaseImponible());
            }
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje())) {
                totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
            }
            if (TipoImpuestoEnum.ICE.getCode() == cod) {
                totalICE = totalICE.add(ti.getValor());
            }
        }
        tc.setIva12(iva12.toString());
        tc.setSubtotal0(totalIva2.toString());
        tc.setSubtotal12(totalIva12.toString());
        tc.setTotalIce(totalICE.toString());
        tc.setSubtotal(totalIva2.add(totalIva12));
        tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
        return tc;
    }

    private TotalComprobante getTotalesNC(final NotaCredito.InfoNotaCredito infoNc) {
        BigDecimal totalIva12 = new BigDecimal(0.0);
        BigDecimal totalIva2 = new BigDecimal(0.0);
        BigDecimal iva12 = new BigDecimal(0.0);
        BigDecimal totalICE = new BigDecimal(0.0);
        BigDecimal totalSinImpuesto = new BigDecimal(0.0);
        final TotalComprobante tc = new TotalComprobante();
        for (final TotalConImpuestos.TotalImpuesto ti : infoNc.getTotalConImpuestos().getTotalImpuesto()) {
            final Integer cod = new Integer(ti.getCodigo());
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje())) {
                totalIva12 = totalIva12.add(ti.getBaseImponible());
                iva12 = iva12.add(ti.getValor());
            }
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje())) {
                totalIva2 = totalIva2.add(ti.getBaseImponible());
            }
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje())) {
                totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
            }
            if (TipoImpuestoEnum.ICE.getCode() == cod) {
                totalICE = totalICE.add(ti.getValor());
            }
        }
        tc.setIva12(iva12.toString());
        tc.setSubtotal0(totalIva2.toString());
        tc.setSubtotal12(totalIva12.toString());
        tc.setTotalIce(totalICE.toString());
        tc.setSubtotal(totalIva2.add(totalIva12));
        tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
        return tc;
    }

    private TotalComprobante getTotalesND(final NotaDebito.InfoNotaDebito infoNotaDebito) {
        BigDecimal totalIva12 = new BigDecimal(0.0);
        BigDecimal totalIva2 = new BigDecimal(0.0);
        BigDecimal totalICE = new BigDecimal(0.0);
        BigDecimal iva12 = new BigDecimal(0.0);
        BigDecimal totalSinImpuesto = new BigDecimal(0.0);
        final TotalComprobante tc = new TotalComprobante();
        for (final ec.gob.sri.comprobantes.modelo.notadebito.Impuesto ti : infoNotaDebito.getImpuestos().getImpuesto()) {
            final Integer cod = new Integer(ti.getCodigo());
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje())) {
                totalIva12 = totalIva12.add(ti.getBaseImponible());
                iva12 = iva12.add(ti.getValor());
            }
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje())) {
                totalIva2 = totalIva2.add(ti.getBaseImponible());
            }
            if (TipoImpuestoEnum.IVA.getCode() == cod && TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje())) {
                totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
            }
            if (TipoImpuestoEnum.ICE.getCode() == cod) {
                totalICE = totalICE.add(ti.getValor());
            }
        }
        tc.setSubtotal0(totalIva2.toString());
        tc.setSubtotal12(totalIva12.toString());
        tc.setTotalIce(totalICE.toString());
        tc.setIva12(iva12.toString());
        tc.setSubtotalNoSujetoIva(totalSinImpuesto.toPlainString());
        return tc;
    }

    private Map<String, Object> obtenerInfoNC(final NotaCredito.InfoNotaCredito infoNC, final NotaCreditoReporte nc) {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("DIR_SUCURSAL", infoNC.getDirEstablecimiento());
        param.put("CONT_ESPECIAL", infoNC.getContribuyenteEspecial());
        param.put("LLEVA_CONTABILIDAD", infoNC.getObligadoContabilidad());
        param.put("RS_COMPRADOR", infoNC.getRazonSocialComprador());
        param.put("RUC_COMPRADOR", infoNC.getIdentificacionComprador());
        param.put("FECHA_EMISION", infoNC.getFechaEmision());
        final TotalComprobante tc = this.getTotalesNC(infoNC);
        param.put("IVA_0", tc.getSubtotal0());
        param.put("IVA_12", tc.getSubtotal12());
        param.put("ICE", tc.getTotalIce());
        param.put("VALOR_TOTAL", infoNC.getValorModificacion());
        param.put("IVA", tc.getIva12());
        param.put("SUBTOTAL", infoNC.getTotalSinImpuestos());
        param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
        param.put("NUM_DOC_MODIFICADO", infoNC.getNumDocModificado());
        param.put("FECHA_EMISION_DOC_SUSTENTO", infoNC.getFechaEmisionDocSustento());
        param.put("DOC_MODIFICADO", StringUtil.obtenerDocumentoModificado(infoNC.getCodDocModificado()));
        param.put("TOTAL_DESCUENTO", this.obtenerTotalDescuento(nc));
        param.put("RAZON_MODIF", infoNC.getMotivo());
        return param;
    }

    private Map<String, Object> obtenerInfoGR(final GuiaRemision.InfoGuiaRemision igr, final GuiaRemision guiaRemision) {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("DIR_SUCURSAL", igr.getDirEstablecimiento());
        param.put("CONT_ESPECIAL", igr.getContribuyenteEspecial());
        param.put("LLEVA_CONTABILIDAD", igr.getObligadoContabilidad());
        param.put("FECHA_INI_TRANSPORTE", igr.getFechaIniTransporte());
        param.put("FECHA_FIN_TRANSPORTE", igr.getFechaFinTransporte());
        param.put("RUC_TRANSPORTISTA", igr.getRucTransportista());
        param.put("RS_TRANSPORTISTA", igr.getRazonSocialTransportista());
        param.put("PLACA", igr.getPlaca());
        param.put("PUNTO_PARTIDA", igr.getDirPartida());
        param.put("INFO_ADICIONAL", this.getInfoAdicional(guiaRemision));
        return param;
    }

    public List<InformacionAdicional> getInfoAdicional(final GuiaRemision guiaRemision) {
        final List<InformacionAdicional> infoAdicional = new ArrayList<InformacionAdicional>();
        if (guiaRemision.getInfoAdicional() != null) {
            for (final GuiaRemision.InfoAdicional.CampoAdicional ca : guiaRemision.getInfoAdicional().getCampoAdicional()) {
                infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
            }
        }
        if (infoAdicional != null && !infoAdicional.isEmpty()) {
            return infoAdicional;
        }
        return null;
    }

    private String obtenerTotalDescuento(final NotaCreditoReporte nc) {
        BigDecimal descuento = new BigDecimal(0);
        for (final DetallesAdicionalesReporte detalle : nc.getDetallesAdiciones()) {
            descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
        }
        return descuento.toString();
    }

    private Map<String, Object> obtenerInfoND(final NotaDebito.InfoNotaDebito notaDebito) {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("DIR_SUCURSAL", notaDebito.getDirEstablecimiento());
        param.put("CONT_ESPECIAL", notaDebito.getContribuyenteEspecial());
        param.put("LLEVA_CONTABILIDAD", notaDebito.getObligadoContabilidad());
        param.put("RS_COMPRADOR", notaDebito.getRazonSocialComprador());
        param.put("RUC_COMPRADOR", notaDebito.getIdentificacionComprador());
        param.put("FECHA_EMISION", notaDebito.getFechaEmision());
        final TotalComprobante tc = this.getTotalesND(notaDebito);
        param.put("IVA_0", tc.getSubtotal0());
        param.put("IVA_12", tc.getSubtotal12());
        param.put("ICE", tc.getTotalIce());
        param.put("TOTAL", notaDebito.getValorTotal());
        param.put("IVA", tc.getIva12());
        param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
        param.put("NUM_DOC_MODIFICADO", notaDebito.getNumDocModificado());
        param.put("FECHA_EMISION_DOC_SUSTENTO", notaDebito.getFechaEmisionDocSustento());
        param.put("DOC_MODIFICADO", StringUtil.obtenerDocumentoModificado(notaDebito.getCodDocModificado()));
        param.put("TOTAL_SIN_IMP", notaDebito.getTotalSinImpuestos());
        return param;
    }

    private Map<String, Object> obtenerInfoCompRetencion(final ComprobanteRetencion.InfoCompRetencion infoComp) {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("DIR_SUCURSAL", infoComp.getDirEstablecimiento());
        param.put("RS_COMPRADOR", infoComp.getRazonSocialSujetoRetenido());
        param.put("RUC_COMPRADOR", infoComp.getIdentificacionSujetoRetenido());
        param.put("FECHA_EMISION", infoComp.getFechaEmision());
        param.put("CONT_ESPECIAL", infoComp.getContribuyenteEspecial());
        param.put("LLEVA_CONTABILIDAD", infoComp.getObligadoContabilidad());
        param.put("EJERCICIO_FISCAL", infoComp.getPeriodoFiscal());
        return param;
    }

    public void showReport(final JasperPrint jp, OutputStream out) {
        try {

            JasperExportManager.exportReportToPdfStream(jp, out);
            /* final JasperViwerSRI jv = new JasperViwerSRI(jp, Locale.getDefault());
             final List<JRSaveContributor> newSaveContributors = new LinkedList<JRSaveContributor>();
             final JRSaveContributor[] saveContributors = jv.getSaveContributors();
             for (int i = 0; i < saveContributors.length; ++i) {
             if (saveContributors[i] instanceof JRPdfSaveContributor) {
             newSaveContributors.add(saveContributors[i]);
             }
             }
             jv.setSaveContributors((JRSaveContributor[]) newSaveContributors.toArray(new JRSaveContributor[0]));
             final JFrame jf = new JFrame();
             jf.setTitle("Generador de RIDE");
             jf.getContentPane().add((Component) jv);
             jf.validate();
             jf.setVisible(true);
             jf.setSize(new Dimension(800, 650));
             jf.setLocation(300, 100);
             jf.setDefaultCloseOperation(1);*/
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
