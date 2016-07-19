package comprobantes.administracion.modelo;

public class Clientes
{
    private Integer codCliente;
    private String apellido;
    private String tipoIdentificacion;
    private String numeroIdentificacio;
    private String telefonoConvencional;
    private String extencion;
    private String celular;
    private String correo;
    private String direccion;
    private String tipoCliente;
    
    public Integer getCodCliente() {
        return this.codCliente;
    }
    
    public void setCodCliente(final Integer codCliente) {
        this.codCliente = codCliente;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }
    
    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }
    
    public void setTipoIdentificacion(final String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    
    public String getNumeroIdentificacio() {
        return this.numeroIdentificacio;
    }
    
    public void setNumeroIdentificacio(final String numeroIdentificacio) {
        this.numeroIdentificacio = numeroIdentificacio;
    }
    
    public String getTelefonoConvencional() {
        return this.telefonoConvencional;
    }
    
    public void setTelefonoConvencional(final String telefonoConvencional) {
        this.telefonoConvencional = telefonoConvencional;
    }
    
    public String getExtencion() {
        return this.extencion;
    }
    
    public void setExtencion(final String extencion) {
        this.extencion = extencion;
    }
    
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(final String celular) {
        this.celular = celular;
    }
    
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(final String correo) {
        this.correo = correo;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }
    
    public String getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(final String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
