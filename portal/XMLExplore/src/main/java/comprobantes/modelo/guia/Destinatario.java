package comprobantes.modelo.guia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinatario", propOrder = { "identificacionDestinatario", "razonSocialDestinatario", "dirDestinatario", "motivoTraslado", "docAduaneroUnico", "codEstabDestino", "ruta", "codDocSustento", "numDocSustento", "numAutDocSustento", "fechaEmisionDocSustento", "detalles" })
public class Destinatario
{
    protected String identificacionDestinatario;
    protected String razonSocialDestinatario;
    protected String dirDestinatario;
    protected String motivoTraslado;
    protected String docAduaneroUnico;
    protected String codEstabDestino;
    protected String ruta;
    protected String codDocSustento;
    protected String numDocSustento;
    protected String numAutDocSustento;
    protected String fechaEmisionDocSustento;
    protected Detalles detalles;
    
    public String getIdentificacionDestinatario() {
        return this.identificacionDestinatario;
    }
    
    public void setIdentificacionDestinatario(final String value) {
        this.identificacionDestinatario = value;
    }
    
    public String getRazonSocialDestinatario() {
        return this.razonSocialDestinatario;
    }
    
    public void setRazonSocialDestinatario(final String value) {
        this.razonSocialDestinatario = value;
    }
    
    public String getDirDestinatario() {
        return this.dirDestinatario;
    }
    
    public void setDirDestinatario(final String value) {
        this.dirDestinatario = value;
    }
    
    public String getMotivoTraslado() {
        return this.motivoTraslado;
    }
    
    public void setMotivoTraslado(final String value) {
        this.motivoTraslado = value;
    }
    
    public String getDocAduaneroUnico() {
        return this.docAduaneroUnico;
    }
    
    public void setDocAduaneroUnico(final String value) {
        this.docAduaneroUnico = value;
    }
    
    public String getCodEstabDestino() {
        return this.codEstabDestino;
    }
    
    public void setCodEstabDestino(final String value) {
        this.codEstabDestino = value;
    }
    
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(final String value) {
        this.ruta = value;
    }
    
    public String getCodDocSustento() {
        return this.codDocSustento;
    }
    
    public void setCodDocSustento(final String value) {
        this.codDocSustento = value;
    }
    
    public String getNumDocSustento() {
        return this.numDocSustento;
    }
    
    public void setNumDocSustento(final String value) {
        this.numDocSustento = value;
    }
    
    public String getNumAutDocSustento() {
        return this.numAutDocSustento;
    }
    
    public void setNumAutDocSustento(final String value) {
        this.numAutDocSustento = value;
    }
    
    public String getFechaEmisionDocSustento() {
        return this.fechaEmisionDocSustento;
    }
    
    public void setFechaEmisionDocSustento(final String value) {
        this.fechaEmisionDocSustento = value;
    }
    
    public Detalles getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(final Detalles value) {
        this.detalles = value;
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "detalle" })
    public static class Detalles
    {
        protected List<Detalle> detalle;
        
        public List<Detalle> getDetalle() {
            if (this.detalle == null) {
                this.detalle = new ArrayList<Detalle>();
            }
            return this.detalle;
        }
    }
}
