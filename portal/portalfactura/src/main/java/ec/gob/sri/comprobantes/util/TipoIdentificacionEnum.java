package ec.gob.sri.comprobantes.util;

public enum TipoIdentificacionEnum
{
    SELECCIONE("SELECCIONE", ""), 
    R("RUC", "R"), 
    C("CEDULA", "C"), 
    P("PASAPORTE", "P");
    
    private String code;
    private String descripcion;
    
    private TipoIdentificacionEnum(final String descripcion, final String code) {
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
