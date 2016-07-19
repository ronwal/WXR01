package ec.gob.sri.comprobantes.util;

public enum TipoComprobanteEnum
{
    LOTE("00", "lote.xsd", ""), 
    FACTURA("01", "factura.xsd", "FACTURA"), 
    NOTA_DE_CREDITO("04", "notaCredito.xsd", "NOTA DE CREDITO"), 
    NOTA_DE_DEBITO("05", "notaDebito.xsd", "NOTA DE DEBITO"), 
    GUIA_DE_REMISION("06", "guiaRemision.xsd", "GUIA DE REMISION"), 
    COMPROBANTE_DE_RETENCION("07", "comprobanteRetencion.xsd", "COMPROBANTE DE RETENCION"), 
    LIQUIDACION_DE_COMPRAS("03", "", "LIQ.DE COMPRAS");
    
    private String code;
    private String xsd;
    private String descripcion;
    
    private TipoComprobanteEnum(final String code, final String xsd, final String descripcion) {
        this.code = code;
        this.xsd = xsd;
        this.descripcion = descripcion;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getXsd() {
        return this.xsd;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public static String retornaCodigo(final String valor) {
        String codigo = null;
        if (valor.equals(TipoComprobanteEnum.FACTURA.getDescripcion())) {
            codigo = TipoComprobanteEnum.FACTURA.getCode();
        }
        else if (valor.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getDescripcion())) {
            codigo = TipoComprobanteEnum.NOTA_DE_DEBITO.getCode();
        }
        else if (valor.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getDescripcion())) {
            codigo = TipoComprobanteEnum.NOTA_DE_CREDITO.getCode();
        }
        else if (valor.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getDescripcion())) {
            codigo = TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode();
        }
        else if (valor.equals(TipoComprobanteEnum.GUIA_DE_REMISION.getDescripcion())) {
            codigo = TipoComprobanteEnum.GUIA_DE_REMISION.getCode();
        }
        else if (valor.equals(TipoComprobanteEnum.LIQUIDACION_DE_COMPRAS.getDescripcion())) {
            codigo = TipoComprobanteEnum.LIQUIDACION_DE_COMPRAS.getCode();
        }
        return codigo;
    }
}
