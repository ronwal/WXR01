package comprobantes.administracion.modelo;

public class ClaveContingencia
{
    private Integer codigo;
    private String clave;
    private String usada;
    private String codigoComprobante;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(final String clave) {
        this.clave = clave;
    }
    
    public String getUsada() {
        return this.usada;
    }
    
    public void setUsada(final String usada) {
        this.usada = usada;
    }
    
    public String getCodigoComprobante() {
        return this.codigoComprobante;
    }
    
    public void setCodigoComprobante(final String codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }
}
