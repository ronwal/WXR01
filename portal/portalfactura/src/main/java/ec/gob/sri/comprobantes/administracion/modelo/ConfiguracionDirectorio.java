package ec.gob.sri.comprobantes.administracion.modelo;

public class ConfiguracionDirectorio
{
    private Integer codigoDirectorio;
    private String path;
    
    public ConfiguracionDirectorio() {
        super();
    }
    
    public ConfiguracionDirectorio(final int codigoDirectorio, final String path) {
        super();
        this.codigoDirectorio = codigoDirectorio;
        this.path = path;
    }
    
    public Integer getCodigoDirectorio() {
        return this.codigoDirectorio;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public void setCodigoDirectorio(final Integer codigoDirectorio) {
        this.codigoDirectorio = codigoDirectorio;
    }
    
    public void setPath(final String path) {
        this.path = path;
    }
}
