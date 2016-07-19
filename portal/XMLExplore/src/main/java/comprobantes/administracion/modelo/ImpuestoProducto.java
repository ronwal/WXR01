package comprobantes.administracion.modelo;

public class ImpuestoProducto
{
    private Integer codigoProducto;
    private String codigoImpuesto;
    
    public ImpuestoProducto() {
        super();
    }
    
    public ImpuestoProducto(final String codigoImpuesto) {
        super();
        this.codigoImpuesto = codigoImpuesto;
    }
    
    public Integer getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(final Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public String getCodigoImpuesto() {
        return this.codigoImpuesto;
    }
    
    public void setCodigoImpuesto(final String codigoImpuesto) {
        this.codigoImpuesto = codigoImpuesto;
    }
}
