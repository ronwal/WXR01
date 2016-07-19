package ec.gob.sri.comprobantes.modelo;

import java.math.*;

public class TotalImpuesto
{
    Integer codigo;
    String codigoPorcentaje;
    BigDecimal baseImponible;
    BigDecimal valor;
    
    public BigDecimal getBaseImponible() {
        return this.baseImponible;
    }
    
    public void setBaseImponible(final BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigoPorcentaje() {
        return this.codigoPorcentaje;
    }
    
    public void setCodigoPorcentaje(final String codigoPorcentaje) {
        this.codigoPorcentaje = codigoPorcentaje;
    }
    
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }
}
