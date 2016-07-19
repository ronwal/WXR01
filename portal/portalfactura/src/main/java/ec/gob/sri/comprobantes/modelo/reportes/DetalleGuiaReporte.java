package ec.gob.sri.comprobantes.modelo.reportes;

public class DetalleGuiaReporte
{
    private String cantidad;
    private String descripcion;
    private String codigoPrincipal;
    private String codigoAuxiliar;
    
    public String getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(final String cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCodigoPrincipal() {
        return this.codigoPrincipal;
    }
    
    public void setCodigoPrincipal(final String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
    }
    
    public String getCodigoAuxiliar() {
        return this.codigoAuxiliar;
    }
    
    public void setCodigoAuxiliar(final String codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }
}
