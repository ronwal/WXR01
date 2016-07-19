package comprobantes.modelo.factura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuesto", propOrder = { "codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor" })
public class Impuesto
{
    protected String codigo;
    protected String codigoPorcentaje;
    protected BigDecimal tarifa;
    protected BigDecimal baseImponible;
    protected BigDecimal valor;
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final String value) {
        this.codigo = value;
    }
    
    public String getCodigoPorcentaje() {
        return this.codigoPorcentaje;
    }
    
    public void setCodigoPorcentaje(final String value) {
        this.codigoPorcentaje = value;
    }
    
    public BigDecimal getTarifa() {
        return this.tarifa;
    }
    
    public void setTarifa(final BigDecimal value) {
        this.tarifa = value;
    }
    
    public BigDecimal getBaseImponible() {
        return this.baseImponible;
    }
    
    public void setBaseImponible(final BigDecimal value) {
        this.baseImponible = value;
    }
    
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(final BigDecimal value) {
        this.valor = value;
    }
}
