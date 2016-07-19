package comprobantes.util;

public enum TipoEmisionEnum
{
    NORMAL("NORMAL"), 
    CONTINGENCIA("INDISPONIBILIDAD DE SISTEMA");
    
    private String code;
    
    private TipoEmisionEnum(final String code) {
        this.code = code;
    }
    
    public String getCode() {
        return this.code;
    }
}
