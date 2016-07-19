package comprobantes.modelo.reportes;

import ec.gob.sri.comprobantes.modelo.factura.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaReporte
{
    private Factura factura;
    private String detalle1;
    private String detalle2;
    private String detalle3;
    private List<DetallesAdicionalesReporte> detallesAdiciones;
    private List<InformacionAdicional> infoAdicional;
    
    public FacturaReporte(final Factura factura) {
        super();
        this.factura = factura;
    }
    
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(final Factura factura) {
        this.factura = factura;
    }
    
    public String getDetalle1() {
        return this.detalle1;
    }
    
    public void setDetalle1(final String detalle1) {
        this.detalle1 = detalle1;
    }
    
    public String getDetalle2() {
        return this.detalle2;
    }
    
    public void setDetalle2(final String detalle2) {
        this.detalle2 = detalle2;
    }
    
    public String getDetalle3() {
        return this.detalle3;
    }
    
    public void setDetalle3(final String detalle3) {
        this.detalle3 = detalle3;
    }
    
    public List<DetallesAdicionalesReporte> getDetallesAdiciones() {
        this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
        for (final Factura.Detalles.Detalle det : this.getFactura().getDetalles().getDetalle()) {
            final DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
            detAd.setCodigoPrincipal(det.getCodigoPrincipal());
            detAd.setCodigoAuxiliar(det.getCodigoAuxiliar());
            detAd.setDescripcion(det.getDescripcion());
            detAd.setCantidad(det.getCantidad().toString());
            detAd.setPrecioTotalSinImpuesto(det.getPrecioTotalSinImpuesto().toString());
            detAd.setPrecioUnitario(det.getPrecioUnitario().toString());
            if (det.getDescuento() != null) {
                detAd.setDescuento(det.getDescuento().toString());
            }
            int i = 0;
            if (det.getDetallesAdicionales() != null && det.getDetallesAdicionales().getDetAdicional() != null && !det.getDetallesAdicionales().getDetAdicional().isEmpty()) {
                for (final Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional detAdicional : det.getDetallesAdicionales().getDetAdicional()) {
                    if (i == 0) {
                        detAd.setDetalle1(detAdicional.getNombre());
                    }
                    if (i == 1) {
                        detAd.setDetalle2(detAdicional.getNombre());
                    }
                    if (i == 2) {
                        detAd.setDetalle3(detAdicional.getNombre());
                    }
                    ++i;
                }
            }
            detAd.setInfoAdicional(this.getInfoAdicional());
            this.detallesAdiciones.add(detAd);
        }
        return this.detallesAdiciones;
    }
    
    public void setDetallesAdiciones(final List<DetallesAdicionalesReporte> detallesAdiciones) {
        this.detallesAdiciones = detallesAdiciones;
    }
    
    public List<InformacionAdicional> getInfoAdicional() {
        System.out.println("--->" + this.getFactura());
        if (this.getFactura().getInfoAdicional() != null) {
            this.infoAdicional = new ArrayList<InformacionAdicional>();
            if (this.getFactura().getInfoAdicional().getCampoAdicional() != null && !this.factura.getInfoAdicional().getCampoAdicional().isEmpty()) {
                for (final Factura.InfoAdicional.CampoAdicional ca : this.getFactura().getInfoAdicional().getCampoAdicional()) {
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
