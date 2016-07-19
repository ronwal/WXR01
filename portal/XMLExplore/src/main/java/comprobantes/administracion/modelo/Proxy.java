package comprobantes.administracion.modelo;

public class Proxy
{
    private String url;
    private Integer puerto;
    private String usuario;
    private String clave;
    private String wsProduccion;
    private String wsPruebas;
    
    public Proxy() {
        super();
    }
    
    public Proxy(final String url, final Integer puerto, final String usuario, final String clave, final String wsProduccion, final String wsPruebas) {
        super();
        this.url = url;
        this.puerto = puerto;
        this.usuario = usuario;
        this.clave = clave;
        this.wsProduccion = wsProduccion;
        this.wsPruebas = wsPruebas;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
    
    public Integer getPuerto() {
        return this.puerto;
    }
    
    public void setPuerto(final Integer puerto) {
        this.puerto = puerto;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }
    
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(final String clave) {
        this.clave = clave;
    }
    
    public String getWsProduccion() {
        return this.wsProduccion;
    }
    
    public void setWsProduccion(final String wsProduccion) {
        this.wsProduccion = wsProduccion;
    }
    
    public String getWsPruebas() {
        return this.wsPruebas;
    }
    
    public void setWsPruebas(final String wsPruebas) {
        this.wsPruebas = wsPruebas;
    }
}
