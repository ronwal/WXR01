package ec.gob.sri.comprobantes.util;

public enum TipoClienteEnum
{
    C("CLIENTE", "C"), 
    R("SUJETOS RETENIDOS", "R"), 
    D("DESTINATARIOS", "D");
    
    private String code;
    private String descripcion;
    
    private TipoClienteEnum(final String descripcion, final String code) {
        this.code = code;
        this.descripcion = descripcion;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public String toString() {
        return this.descripcion;
    }
}
