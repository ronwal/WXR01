package ec.gob.sri.comprobantes.modelo;

public class CampoAdicional
{
    private String nombre;
    private String valor;
    
    public CampoAdicional() {
        super();
    }
    
    public CampoAdicional(final String nombre, final String valor) {
        super();
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(final String valor) {
        this.valor = valor;
    }
}
