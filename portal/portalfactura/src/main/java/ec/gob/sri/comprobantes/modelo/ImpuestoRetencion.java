package ec.gob.sri.comprobantes.modelo;

import java.math.*;
import java.util.*;

public class ImpuestoRetencion
{
    private Integer codigo;
    private String codigoRetencion;
    private BigDecimal baseImponible;
    private BigDecimal porcentajeRetener;
    private BigDecimal valorRetenido;
    private String codDocSustento;
    private String numDocSustento;
    private String fechaEmisionDocSustento;
    private String nombreImpuesto;
    private List<CampoAdicional> camposAdicionales;
    
    public ImpuestoRetencion(final Integer codigo, final String codigoRetencion, final BigDecimal porcentajeRetener, final BigDecimal baseImponible, final BigDecimal valorRetenido, final String codDocSustento, final String numDocSustento, final String fechaEmisionDocSustento) {
        super();
        this.codigo = codigo;
        this.codigoRetencion = codigoRetencion;
        this.porcentajeRetener = porcentajeRetener;
        this.baseImponible = baseImponible;
        this.valorRetenido = valorRetenido;
        this.codDocSustento = codDocSustento;
        this.numDocSustento = numDocSustento;
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }
    
    public String getNombreImpuesto() {
        return this.nombreImpuesto;
    }
    
    public void setNombreImpuesto(final String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigoRetencion() {
        return this.codigoRetencion;
    }
    
    public void setCodigoRetencion(final String codigoRetencion) {
        this.codigoRetencion = codigoRetencion;
    }
    
    public BigDecimal getPorcentajeRetener() {
        return this.porcentajeRetener;
    }
    
    public void setPorcentajeRetener(final BigDecimal porcentajeRetener) {
        this.porcentajeRetener = porcentajeRetener;
    }
    
    public BigDecimal getBaseImponible() {
        return this.baseImponible;
    }
    
    public void setBaseImponible(final BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }
    
    public BigDecimal getValorRetenido() {
        return this.valorRetenido;
    }
    
    public void setValorRetenido(final BigDecimal valorRetenido) {
        this.valorRetenido = valorRetenido;
    }
    
    public String getCodDocSustento() {
        return this.codDocSustento;
    }
    
    public void setCodDocSustento(final String codDocSustento) {
        this.codDocSustento = codDocSustento;
    }
    
    public String getNumDocSustento() {
        return this.numDocSustento;
    }
    
    public void setNumDocSustento(final String numDocSustento) {
        this.numDocSustento = numDocSustento;
    }
    
    public String getFechaEmisionDocSustento() {
        return this.fechaEmisionDocSustento;
    }
    
    public void setFechaEmisionDocSustento(final String fechaEmisionDocSustento) {
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }
    
    public List<CampoAdicional> getCamposAdicionales() {
        return this.camposAdicionales;
    }
    
    public void setCamposAdicionales(final List<CampoAdicional> camposAdicionales) {
        this.camposAdicionales = camposAdicionales;
    }
}
