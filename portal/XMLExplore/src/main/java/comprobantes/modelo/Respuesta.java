package comprobantes.modelo;

import java.sql.Date;

public class Respuesta
{
    private Integer codigo;
    private String claveDeAcceso;
    private String archivo;
    private String estado;
    private Date fecha;
    
    public Respuesta() {
        super();
    }
    
    public Respuesta(final Integer codigo, final String claveDeAcceso, final String archivo, final String estado, final Date fecha) {
        super();
        this.codigo = codigo;
        this.claveDeAcceso = claveDeAcceso;
        this.archivo = archivo;
        this.estado = estado;
        this.fecha = fecha;
    }
    
    public String getArchivo() {
        return this.archivo;
    }
    
    public void setArchivo(final String archivo) {
        this.archivo = archivo;
    }
    
    public String getClaveDeAcceso() {
        return this.claveDeAcceso;
    }
    
    public void setClaveDeAcceso(final String claveDeAcceso) {
        this.claveDeAcceso = claveDeAcceso;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(final String estado) {
        this.estado = estado;
    }
    
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }
}
