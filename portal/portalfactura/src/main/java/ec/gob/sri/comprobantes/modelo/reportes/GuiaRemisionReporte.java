package ec.gob.sri.comprobantes.modelo.reportes;

import ec.gob.sri.comprobantes.util.*;
import java.util.*;
import ec.gob.sri.comprobantes.modelo.guia.*;

public class GuiaRemisionReporte
{
    private GuiaRemision guiaRemision;
    private String nombreComprobante;
    private String numDocSustento;
    private String fechaEmisionSustento;
    private String numeroAutorizacion;
    private String motivoTraslado;
    private String destino;
    private String rucDestinatario;
    private String razonSocial;
    private String docAduanero;
    private String codigoEstab;
    private String ruta;
    private List<DetalleGuiaReporte> detalles;
    private List<GuiaRemisionReporte> guiaRemisionList;
    
    public GuiaRemisionReporte(final GuiaRemision guiaRemision) {
        super();
        this.guiaRemision = guiaRemision;
    }
    
    public GuiaRemisionReporte() {
        super();
    }
    
    public GuiaRemision getGuiaRemision() {
        return this.guiaRemision;
    }
    
    public void setGuiaRemision(final GuiaRemision guiaRemision) {
        this.guiaRemision = guiaRemision;
    }
    
    public String getNombreComprobante() {
        return this.nombreComprobante;
    }
    
    public void setNombreComprobante(final String nombreComprobante) {
        this.nombreComprobante = nombreComprobante;
    }
    
    public String getNumDocSustento() {
        return this.numDocSustento;
    }
    
    public void setNumDocSustento(final String numDocSustento) {
        this.numDocSustento = numDocSustento;
    }
    
    public String getFechaEmisionSustento() {
        return this.fechaEmisionSustento;
    }
    
    public void setFechaEmisionSustento(final String fechaEmisionSustento) {
        this.fechaEmisionSustento = fechaEmisionSustento;
    }
    
    public String getNumeroAutorizacion() {
        return this.numeroAutorizacion;
    }
    
    public void setNumeroAutorizacion(final String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }
    
    public String getMotivoTraslado() {
        return this.motivoTraslado;
    }
    
    public void setMotivoTraslado(final String motivoTraslado) {
        this.motivoTraslado = motivoTraslado;
    }
    
    public String getDestino() {
        return this.destino;
    }
    
    public void setDestino(final String destino) {
        this.destino = destino;
    }
    
    public String getRucDestinatario() {
        return this.rucDestinatario;
    }
    
    public void setRucDestinatario(final String rucDestinatario) {
        this.rucDestinatario = rucDestinatario;
    }
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getDocAduanero() {
        return this.docAduanero;
    }
    
    public void setDocAduanero(final String docAduanero) {
        this.docAduanero = docAduanero;
    }
    
    public String getCodigoEstab() {
        return this.codigoEstab;
    }
    
    public void setCodigoEstab(final String cosdigoEstab) {
        this.codigoEstab = cosdigoEstab;
    }
    
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(final String ruta) {
        this.ruta = ruta;
    }
    
    public List<GuiaRemisionReporte> getGuiaRemisionList() {
        this.guiaRemisionList = new ArrayList<GuiaRemisionReporte>();
        for (final Destinatario dest : this.guiaRemision.getDestinatarios().getDestinatario()) {
            final GuiaRemisionReporte gr = new GuiaRemisionReporte();
            gr.setNombreComprobante(StringUtil.obtenerDocumentoModificado(dest.getCodDocSustento()));
            gr.setNumDocSustento(dest.getNumDocSustento());
            gr.setFechaEmisionSustento(dest.getFechaEmisionDocSustento());
            gr.setNumeroAutorizacion(dest.getNumAutDocSustento());
            gr.setMotivoTraslado(dest.getMotivoTraslado());
            gr.setDestino(dest.getDirDestinatario());
            gr.setRucDestinatario(dest.getIdentificacionDestinatario());
            gr.setRazonSocial(dest.getRazonSocialDestinatario());
            gr.setDocAduanero(dest.getDocAduaneroUnico());
            gr.setCodigoEstab(dest.getCodEstabDestino());
            gr.setRuta(dest.getRuta());
            gr.setDetalles(this.obtenerDetalles(dest));
            this.guiaRemisionList.add(gr);
        }
        return this.guiaRemisionList;
    }
    
    private List<DetalleGuiaReporte> obtenerDetalles(final Destinatario dest) {
        final List<DetalleGuiaReporte> list = new ArrayList<DetalleGuiaReporte>();
        for (final Detalle detalle : dest.getDetalles().getDetalle()) {
            final DetalleGuiaReporte dgr = new DetalleGuiaReporte();
            dgr.setCantidad(detalle.getCantidad().toString());
            dgr.setDescripcion(detalle.getDescripcion());
            dgr.setCodigoPrincipal(detalle.getCodigoInterno());
            dgr.setCodigoAuxiliar(detalle.getCodigoAdicional());
            list.add(dgr);
        }
        return list;
    }
    
    public void setGuiaRemisionList(final List<GuiaRemisionReporte> guiaRemisionList) {
        this.guiaRemisionList = guiaRemisionList;
    }
    
    public List<DetalleGuiaReporte> getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(final List<DetalleGuiaReporte> detalles) {
        this.detalles = detalles;
    }
}
