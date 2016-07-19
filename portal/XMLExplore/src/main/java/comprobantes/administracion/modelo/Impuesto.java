package comprobantes.administracion.modelo;

public class Impuesto
{
    private Integer codigo;
    private String descripcion;
    private String estado;
    private Double porcentaje;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(final String estado) {
        this.estado = estado;
    }
    
    public String toString() {
        return this.getDescripcion();
    }
    
    public Double getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(final Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
