package comprobantes.administracion.modelo;

import java.util.Date;

public class ImpuestoValor
{
    private String codigo;
    private Integer codigoImpuesto;
    private Double porcentaje;
    private Double porcentajeRentencion;
    private String tipoImpuesto;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public ImpuestoValor() {
        super();
    }
    
    public ImpuestoValor(final ImpuestoValor i) {
        super();
        this.codigo = i.getCodigo();
        this.codigoImpuesto = i.getCodigoImpuesto();
        this.porcentaje = i.getPorcentaje();
        this.porcentajeRentencion = i.getPorcentajeRentencion();
        this.tipoImpuesto = i.getTipoImpuesto();
        this.descripcion = i.getDescripcion();
        this.fechaInicio = i.getFechaInicio();
        this.fechaFin = i.getFechaFin();
    }
    
    public ImpuestoValor(final Integer codigoImpuesto, final String tipoImpuesto) {
        super();
        this.codigoImpuesto = codigoImpuesto;
        this.tipoImpuesto = tipoImpuesto;
    }
    
    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }
    
    public Integer getCodigoImpuesto() {
        return this.codigoImpuesto;
    }
    
    public void setCodigoImpuesto(final Integer codigoImpuesto) {
        this.codigoImpuesto = codigoImpuesto;
    }
    
    public Double getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(final Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public Double getPorcentajeRentencion() {
        return this.porcentajeRentencion;
    }
    
    public void setPorcentajeRentencion(final Double porcentajeRentencion) {
        this.porcentajeRentencion = porcentajeRentencion;
    }
    
    public String getTipoImpuesto() {
        return this.tipoImpuesto;
    }
    
    public void setTipoImpuesto(final String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public String toString() {
        if ((this.codigoImpuesto != 1 && this.codigoImpuesto != 2 && this.codigoImpuesto != 3) || (!this.tipoImpuesto.equals("R") && !this.tipoImpuesto.equals("I") && !this.tipoImpuesto.equals("A"))) {
            return null;
        }
        if (this.getCodigo() != null) {
            return this.getCodigo() + " - " + this.getDescripcion();
        }
        return "Seleccione....";
    }
}
