package ec.fecuador.util;

public class Destinatario
{
    private String nombre="Destinatario";
    private String mail;
    
    public Destinatario(final String nombre, final String mail) {
        super();
        this.nombre = nombre;
        this.mail = mail;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(final String mail) {
        this.mail = mail;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
}
