package comprobantes.administracion.modelo;

import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;

import java.math.BigDecimal;
import java.util.List;

public class Producto
{
    private Integer codigo;
    private String codigoPrincipal;
    private String codigoAuxiliar;
    private String nombre;
    private BigDecimal valorUnitario;
    private String tipoProducto;
    private List<InformacionAdicionalProducto> infoAdicionalList;
    private List<ImpuestoProducto> impuestoProducto;
    private List<ImpuestoValor> impuestoValor;
    private Integer codigoImpuesto;
    private String iva;
    private String ice;
    private Double cantidad;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigoPrincipal() {
        return this.codigoPrincipal;
    }
    
    public void setCodigoPrincipal(final String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
    }
    
    public String getCodigoAuxiliar() {
        return this.codigoAuxiliar;
    }
    
    public void setCodigoAuxiliar(final String codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }
    
    public void setValorUnitario(final BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public String getTipoProducto() {
        return this.tipoProducto;
    }
    
    public void setTipoProducto(final String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    public List<InformacionAdicionalProducto> getInfoAdicionalList() {
        return this.infoAdicionalList;
    }
    
    public void setInfoAdicionalList(final List<InformacionAdicionalProducto> infoAdicionalList) {
        this.infoAdicionalList = infoAdicionalList;
    }
    
    public List<ImpuestoProducto> getImpuestoProducto() {
        return this.impuestoProducto;
    }
    
    public void setImpuestoProducto(final List<ImpuestoProducto> impuestoProducto) {
        this.impuestoProducto = impuestoProducto;
    }
    
    public String getIva() {
        return this.iva;
    }
    
    public void setIva(final String iva) {
        this.iva = iva;
    }
    
    public String getIce() {
        return this.ice;
    }
    
    public void setIce(final String ice) {
        this.ice = ice;
    }
    
    public List<ImpuestoValor> getImpuestoValor() {
        return this.impuestoValor;
    }
    
    public void setImpuestoValor(final List<ImpuestoValor> impuestoValor) {
        this.impuestoValor = impuestoValor;
    }
    
    public Double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(final Double cantidad) {
        this.cantidad = cantidad;
    }
    
    public Integer getCodigoImpuesto() {
        return this.codigoImpuesto;
    }
    
    public void setCodigoImpuesto(final Integer codigoImpuesto) {
        this.codigoImpuesto = codigoImpuesto;
    }
}
