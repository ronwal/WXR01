package comprobantes.modelo.reportes;

import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;

import java.util.ArrayList;
import java.util.List;

public class NotaDebitoReporte
{
    private NotaDebito notaDebito;
    private List<DetallesAdicionalesReporte> detallesAdiciones;
    private List<InformacionAdicional> infoAdicional;
    
    public NotaDebitoReporte(final NotaDebito notaDebito) {
        super();
        this.notaDebito = notaDebito;
    }
    
    public List<DetallesAdicionalesReporte> getDetallesAdiciones() {
        this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
        for (final NotaDebito.Motivos.Motivo motivo : this.notaDebito.getMotivos().getMotivo()) {
            final DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
            detAd.setRazonModificacion(motivo.getRazon());
            detAd.setValorModificacion(motivo.getValor().toString());
            detAd.setInfoAdicional(this.getInfoAdicional());
            this.detallesAdiciones.add(detAd);
        }
        return this.detallesAdiciones;
    }
    
    public void setDetallesAdiciones(final List<DetallesAdicionalesReporte> detallesAdiciones) {
        this.detallesAdiciones = detallesAdiciones;
    }
    
    public NotaDebito getNotaDebito() {
        return this.notaDebito;
    }
    
    public void setNotaDebito(final NotaDebito notaDebito) {
        this.notaDebito = notaDebito;
    }
    
    public List<InformacionAdicional> getInfoAdicional() {
        if (this.notaDebito.getInfoAdicional() != null && !this.notaDebito.getInfoAdicional().getCampoAdicional().isEmpty()) {
            this.infoAdicional = new ArrayList<InformacionAdicional>();
            for (final NotaDebito.InfoAdicional.CampoAdicional info : this.notaDebito.getInfoAdicional().getCampoAdicional()) {
                final InformacionAdicional ia = new InformacionAdicional(info.getValue(), info.getNombre());
                this.infoAdicional.add(ia);
            }
        }
        return this.infoAdicional;
    }
    
    public void setInfoAdicional(final List<InformacionAdicional> infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
}
