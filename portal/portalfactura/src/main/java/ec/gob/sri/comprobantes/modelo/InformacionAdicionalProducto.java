package ec.gob.sri.comprobantes.modelo;

public class InformacionAdicionalProducto
{
    private String atributo;
    private String valor;
    private Integer codigoProducto;
    private Integer codigo;
    
    public InformacionAdicionalProducto() {
        super();
    }
    
    public InformacionAdicionalProducto(final String atributo, final String valor) {
        super();
        this.atributo = atributo;
        this.valor = valor;
    }
    
    public String getAtributo() {
        return this.atributo;
    }
    
    public void setAtributo(final String atributo) {
        this.atributo = atributo;
    }
    
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(final String valor) {
        this.valor = valor;
    }
    
    public Integer getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(final Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
}
