package ec.gob.sri.comprobantes.util;

public enum TipoCompradorEnum
{
    CONSUMIDOR_FINAL("07"), 
    RUC("04"), 
    CEDULA("05"), 
    PASAPORTE("06");
    
    private String code;
    
    private TipoCompradorEnum(final String code) {
        this.code = code;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public static String retornaCodigo(final String valor) {
        String codigo = null;
        if (valor.equals("C")) {
            codigo = TipoCompradorEnum.CEDULA.getCode();
        }
        if (valor.equals("R")) {
            codigo = TipoCompradorEnum.RUC.getCode();
        }
        if (valor.equals("P")) {
            codigo = TipoCompradorEnum.PASAPORTE.getCode();
        }
        if (valor.equals("F")) {
            codigo = TipoCompradorEnum.CONSUMIDOR_FINAL.getCode();
        }
        return codigo;
    }
}
