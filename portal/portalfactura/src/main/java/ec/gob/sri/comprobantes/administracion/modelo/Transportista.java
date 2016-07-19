package ec.gob.sri.comprobantes.administracion.modelo;

public class Transportista
{
    private Integer codigo;
    private String razonSocial;
    private String tipoIdentificacion;
    private String identificacion;
    private String placa;
    private String mail;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }
    
    public void setTipoIdentificacion(final String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(final String identificacion) {
        this.identificacion = identificacion;
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(final String placa) {
        this.placa = placa;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(final String mail) {
        this.mail = mail;
    }
}
