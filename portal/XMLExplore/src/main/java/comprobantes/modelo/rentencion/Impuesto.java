package comprobantes.modelo.rentencion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuesto", propOrder = { "codigo", "codigoRetencion", "baseImponible", "porcentajeRetener", "valorRetenido", "codDocSustento", "numDocSustento", "fechaEmisionDocSustento" })
public class Impuesto
{
    protected String codigo;
    protected String codigoRetencion;
    protected BigDecimal baseImponible;
    protected BigDecimal porcentajeRetener;
    protected BigDecimal valorRetenido;
    protected String codDocSustento;
    protected String numDocSustento;
    protected String fechaEmisionDocSustento;
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final String value) {
        this.codigo = value;
    }
    
    public String getCodigoRetencion() {
        return this.codigoRetencion;
    }
    
    public void setCodigoRetencion(final String value) {
        this.codigoRetencion = value;
    }
    
    public BigDecimal getBaseImponible() {
        return this.baseImponible;
    }
    
    public void setBaseImponible(final BigDecimal value) {
        this.baseImponible = value;
    }
    
    public BigDecimal getPorcentajeRetener() {
        return this.porcentajeRetener;
    }
    
    public void setPorcentajeRetener(final BigDecimal value) {
        this.porcentajeRetener = value;
    }
    
    public BigDecimal getValorRetenido() {
        return this.valorRetenido;
    }
    
    public void setValorRetenido(final BigDecimal value) {
        this.valorRetenido = value;
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
    
    public String getFechaEmisionDocSustento() {
        return this.fechaEmisionDocSustento;
    }
    
    public void setFechaEmisionDocSustento(final String value) {
        this.fechaEmisionDocSustento = value;
    }
}
