package comprobantes.modelo.notacredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "totalImpuesto" })
@XmlRootElement(name = "totalConImpuestos")
public class TotalConImpuestos
{
    protected List<TotalImpuesto> totalImpuesto;
    
    public List<TotalImpuesto> getTotalImpuesto() {
        if (this.totalImpuesto == null) {
            this.totalImpuesto = new ArrayList<TotalImpuesto>();
        }
        return this.totalImpuesto;
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "codigo", "codigoPorcentaje", "baseImponible", "valor" })
    public static class TotalImpuesto
    {
        protected String codigo;
        protected String codigoPorcentaje;
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
}
