package ec.gob.sri.comprobantes.modelo;

import java.math.*;

public class SubtotalImpuesto
{
    private String codigoProducto;
    private Integer codigoImpuesto;
    private String codigo;
    private BigDecimal porcentaje;
    private BigDecimal baseImponible;
    private BigDecimal subtotal;
    private BigDecimal valorIce;
    
    public BigDecimal getValorIce() {
        return this.valorIce;
    }
    
    public void setValorIce(final BigDecimal valorIce) {
        this.valorIce = valorIce;
    }
    
    public SubtotalImpuesto(final String codigoProducto, final Integer codigoImpuesto, final String codigo, final BigDecimal porcentaje, final BigDecimal baseImponible, final BigDecimal subtotal) {
        super();
        this.codigoProducto = codigoProducto;
        this.codigoImpuesto = codigoImpuesto;
        this.codigo = codigo;
        this.porcentaje = porcentaje;
        this.baseImponible = baseImponible;
        this.subtotal = subtotal;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }
    
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(final BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    public Integer getCodigoImpuesto() {
        return this.codigoImpuesto;
    }
    
    public void setCodigoImpuesto(final Integer codigoImpuesto) {
        this.codigoImpuesto = codigoImpuesto;
    }
    
    public String getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(final String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public BigDecimal getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(final BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public BigDecimal getBaseImponible() {
        return this.baseImponible;
    }
    
    public void setBaseImponible(final BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }
}
