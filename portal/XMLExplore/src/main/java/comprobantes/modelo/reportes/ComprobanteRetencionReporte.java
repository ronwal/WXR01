package comprobantes.modelo.reportes;

import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.rentencion.Impuesto;

import java.util.ArrayList;
import java.util.List;

public class ComprobanteRetencionReporte
{
    private ComprobanteRetencion comprobanteRetencion;
    private List<DetallesAdicionalesReporte> detallesAdiciones;
    private List<InformacionAdicional> infoAdicional;
    private static final String IVA = "IVA";
    private static final String RENTA = "RENTA";
    private static final String ICE = "ICE";
    private static final String ISD = "IMPUESTO A LA SALIDA DE DIVISAS";
    private static final String FACTURA = "FACTURA";
    private static final String NOTA_CREDITO = "NOTA DE CR\u00c9DITO";
    private static final String NOTA_DEBITO = "NOTA DE D\u00c9BITO";
    private static final String GUIA_REMISION = "GU\u00cdA DE REMISI\u00d3N";
    private static final String COMP_RETENCION = "COMPROBANTE RETENCI\u00d3N";
    
    public ComprobanteRetencionReporte(final ComprobanteRetencion comprobanteRetencion) {
        super();
        this.comprobanteRetencion = comprobanteRetencion;
    }
    
    public ComprobanteRetencion getComprobanteRetencion() {
        return this.comprobanteRetencion;
    }
    
    public void setComprobanteRetencion(final ComprobanteRetencion comprobanteRetencion) {
        this.comprobanteRetencion = comprobanteRetencion;
    }
    
    public List<DetallesAdicionalesReporte> getDetallesAdiciones() {
        this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
        System.out.println(this.comprobanteRetencion.getImpuestos().getImpuesto().size());
        for (final Impuesto im : this.comprobanteRetencion.getImpuestos().getImpuesto()) {
            final DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
            detAd.setBaseImponible(im.getBaseImponible().toString());
            detAd.setPorcentajeRetener(im.getPorcentajeRetener().toString());
            detAd.setValorRetenido(im.getValorRetenido().toString());
            detAd.setNombreImpuesto(this.obtenerImpuestoDecripcion(im.getCodigo()));
            detAd.setInfoAdicional(this.getInfoAdicional());
            detAd.setNumeroComprobante(im.getNumDocSustento());
            detAd.setNombreComprobante(this.obtenerDecripcionComprobante(im.getCodDocSustento()));
            detAd.setFechaEmisionCcompModificado(im.getFechaEmisionDocSustento());
            this.detallesAdiciones.add(detAd);
        }
        return this.detallesAdiciones;
    }
    
    private String obtenerDecripcionComprobante(final String codDocSustento) {
        if ("01".equals(codDocSustento)) {
            return "FACTURA";
        }
        if ("04".equals(codDocSustento)) {
            return "NOTA DE CR\u00c9DITO";
        }
        if ("05".equals(codDocSustento)) {
            return "NOTA DE D\u00c9BITO";
        }
        if ("06".equals(codDocSustento)) {
            return "GU\u00cdA DE REMISI\u00d3N";
        }
        if ("07".equals(codDocSustento)) {
            return "COMPROBANTE RETENCI\u00d3N";
        }
        return null;
    }
    
    private String obtenerImpuestoDecripcion(final String codigoImpuesto) {
        if (codigoImpuesto.equals("1")) {
            return "RENTA";
        }
        if (codigoImpuesto.equals("2")) {
            return "IVA";
        }
        if (codigoImpuesto.equals("3")) {
            return "ICE";
        }
        if (codigoImpuesto.equals("6")) {
            return "IMPUESTO A LA SALIDA DE DIVISAS";
        }
        return null;
    }
    
    public void setDetallesAdiciones(final List<DetallesAdicionalesReporte> detallesAdiciones) {
        this.detallesAdiciones = detallesAdiciones;
    }
    
    public List<InformacionAdicional> getInfoAdicional() {
        if (this.comprobanteRetencion.getInfoAdicional() != null) {
            this.infoAdicional = new ArrayList<InformacionAdicional>();
            if (this.comprobanteRetencion.getInfoAdicional().getCampoAdicional() != null && !this.comprobanteRetencion.getInfoAdicional().getCampoAdicional().isEmpty()) {
                for (final ComprobanteRetencion.InfoAdicional.CampoAdicional ca : this.comprobanteRetencion.getInfoAdicional().getCampoAdicional()) {
                    this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
                }
            }
        }
        return this.infoAdicional;
    }
    
    public void setInfoAdicional(final List<InformacionAdicional> infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
}
