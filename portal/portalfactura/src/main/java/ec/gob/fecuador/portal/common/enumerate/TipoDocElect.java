package ec.gob.fecuador.portal.common.enumerate;

/**
 * Created by Walter on 23/2/17.
 */
public enum TipoDocElect {
    FACTURA("fact"),
    NOTA_CREDITO("notcred"),
    NOTA_DEBITO("notdeb"),
    COMPROVANTE_RETENCION("compret"),
    GUIA_REMIION("guirem"),;

    private String value;

    TipoDocElect(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public String getName(){
        return this.name();
    }

    @Override
    public String toString() {
        return this.name();
    }
}