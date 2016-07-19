package comprobantes.modelo.reportes;

import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;

import java.util.ArrayList;
import java.util.List;

public class NotaCreditoReporte
{
    private NotaCredito notaCredito;
    private List<DetallesAdicionalesReporte> detallesAdiciones;
    private List<InformacionAdicional> infoAdicional;
    
    public NotaCreditoReporte(final NotaCredito notaCredito) {
        super();
        this.notaCredito = notaCredito;
    }
    
    public NotaCredito getNotaCredito() {
        return this.notaCredito;
    }
    
    public void setNotaCredito(final NotaCredito notaCredito) {
        this.notaCredito = notaCredito;
    }
    
    public List<DetallesAdicionalesReporte> getDetallesAdiciones() {
        this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
        for (final NotaCredito.Detalles.Detalle det : this.getNotaCredito().getDetalles().getDetalle()) {
            final DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
            detAd.setCodigoPrincipal(det.getCodigoInterno());
            detAd.setCodigoAuxiliar(det.getCodigoAdicional());
            detAd.setDescripcion(det.getDescripcion());
            detAd.setCantidad(det.getCantidad().toString());
            detAd.setPrecioTotalSinImpuesto(det.getPrecioTotalSinImpuesto().toString());
            detAd.setPrecioUnitario(det.getPrecioUnitario().toString());
            detAd.setDescuento(det.getDescuento().toString());
            int i = 0;
            if (det.getDetallesAdicionales() != null && det.getDetallesAdicionales().getDetAdicional() != null) {
                for (final NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional detAdicional : det.getDetallesAdicionales().getDetAdicional()) {
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
        if (this.notaCredito.getInfoAdicional() != null) {
            this.infoAdicional = new ArrayList<InformacionAdicional>();
            if (this.notaCredito.getInfoAdicional().getCampoAdicional() != null && !this.notaCredito.getInfoAdicional().getCampoAdicional().isEmpty()) {
                for (final NotaCredito.InfoAdicional.CampoAdicional ca : this.notaCredito.getInfoAdicional().getCampoAdicional()) {
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
