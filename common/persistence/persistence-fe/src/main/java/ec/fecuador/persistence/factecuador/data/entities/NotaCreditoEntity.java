package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "nota_credito", schema = "public", catalog = "factura_ecuador")
public class NotaCreditoEntity {
    private Integer ncrCodigo;
    private String ncrEstablecimiento;
    private String ncrFechaAutorizacion;
    private Date ncrFechaEmision;
    private String ncrIdentificacionComprador;
    private String ncrNumAutorizacion;
    private String ncrNumDocModificado;
    private String ncrPuntoEmision;
    private String ncrRazonSocialComprador;
    private Integer ncrSecuencial;
    private Double ncrTotalSinImpuestos;
    private Double ncrValorModificacion;
    private String empCodigo;
    private String tipCodigo;
    private String ncrIdentificacionVendedor;
    private String ncrRazonSocialVendedor;
    private EmpresaEntity empresaByEmpCodigo;
    private TipoEntity tipoByTipCodigo;

    @Id
    @Column(name = "ncr_codigo", nullable = false)
    public Integer getNcrCodigo() {
        return ncrCodigo;
    }

    public void setNcrCodigo(Integer ncrCodigo) {
        this.ncrCodigo = ncrCodigo;
    }

    @Basic
    @Column(name = "ncr_establecimiento", nullable = false, length = 3)
    public String getNcrEstablecimiento() {
        return ncrEstablecimiento;
    }

    public void setNcrEstablecimiento(String ncrEstablecimiento) {
        this.ncrEstablecimiento = ncrEstablecimiento;
    }

    @Basic
    @Column(name = "ncr_fecha_autorizacion", nullable = false, length = 50)
    public String getNcrFechaAutorizacion() {
        return ncrFechaAutorizacion;
    }

    public void setNcrFechaAutorizacion(String ncrFechaAutorizacion) {
        this.ncrFechaAutorizacion = ncrFechaAutorizacion;
    }

    @Basic
    @Column(name = "ncr_fecha_emision", nullable = false)
    public Date getNcrFechaEmision() {
        return ncrFechaEmision;
    }

    public void setNcrFechaEmision(Date ncrFechaEmision) {
        this.ncrFechaEmision = ncrFechaEmision;
    }

    @Basic
    @Column(name = "ncr_identificacion_comprador", nullable = false, length = 13)
    public String getNcrIdentificacionComprador() {
        return ncrIdentificacionComprador;
    }

    public void setNcrIdentificacionComprador(String ncrIdentificacionComprador) {
        this.ncrIdentificacionComprador = ncrIdentificacionComprador;
    }

    @Basic
    @Column(name = "ncr_num_autorizacion", nullable = false, length = 100)
    public String getNcrNumAutorizacion() {
        return ncrNumAutorizacion;
    }

    public void setNcrNumAutorizacion(String ncrNumAutorizacion) {
        this.ncrNumAutorizacion = ncrNumAutorizacion;
    }

    @Basic
    @Column(name = "ncr_num_doc_modificado", nullable = false, length = 25)
    public String getNcrNumDocModificado() {
        return ncrNumDocModificado;
    }

    public void setNcrNumDocModificado(String ncrNumDocModificado) {
        this.ncrNumDocModificado = ncrNumDocModificado;
    }

    @Basic
    @Column(name = "ncr_punto_emision", nullable = false, length = 3)
    public String getNcrPuntoEmision() {
        return ncrPuntoEmision;
    }

    public void setNcrPuntoEmision(String ncrPuntoEmision) {
        this.ncrPuntoEmision = ncrPuntoEmision;
    }

    @Basic
    @Column(name = "ncr_razon_social_comprador", nullable = false, length = 250)
    public String getNcrRazonSocialComprador() {
        return ncrRazonSocialComprador;
    }

    public void setNcrRazonSocialComprador(String ncrRazonSocialComprador) {
        this.ncrRazonSocialComprador = ncrRazonSocialComprador;
    }

    @Basic
    @Column(name = "ncr_secuencial", nullable = false)
    public Integer getNcrSecuencial() {
        return ncrSecuencial;
    }

    public void setNcrSecuencial(Integer ncrSecuencial) {
        this.ncrSecuencial = ncrSecuencial;
    }

    @Basic
    @Column(name = "ncr_total_sin_impuestos", nullable = false, precision = 0)
    public Double getNcrTotalSinImpuestos() {
        return ncrTotalSinImpuestos;
    }

    public void setNcrTotalSinImpuestos(Double ncrTotalSinImpuestos) {
        this.ncrTotalSinImpuestos = ncrTotalSinImpuestos;
    }

    @Basic
    @Column(name = "ncr_valor_modificacion", nullable = false, precision = 0)
    public Double getNcrValorModificacion() {
        return ncrValorModificacion;
    }

    public void setNcrValorModificacion(Double ncrValorModificacion) {
        this.ncrValorModificacion = ncrValorModificacion;
    }

    @Basic
    @Column(name = "emp_codigo", nullable = true, length = 13)
    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Basic
    @Column(name = "tip_codigo", nullable = true, length = 3)
    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    @Basic
    @Column(name = "ncr_identificacion_vendedor", nullable = false, length = 13)
    public String getNcrIdentificacionVendedor() {
        return ncrIdentificacionVendedor;
    }

    public void setNcrIdentificacionVendedor(String ncrIdentificacionVendedor) {
        this.ncrIdentificacionVendedor = ncrIdentificacionVendedor;
    }

    @Basic
    @Column(name = "ncr_razon_social_vendedor", nullable = false, length = 250)
    public String getNcrRazonSocialVendedor() {
        return ncrRazonSocialVendedor;
    }

    public void setNcrRazonSocialVendedor(String ncrRazonSocialVendedor) {
        this.ncrRazonSocialVendedor = ncrRazonSocialVendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaCreditoEntity that = (NotaCreditoEntity) o;

        if (ncrCodigo != null ? !ncrCodigo.equals(that.ncrCodigo) : that.ncrCodigo != null) return false;
        if (ncrEstablecimiento != null ? !ncrEstablecimiento.equals(that.ncrEstablecimiento) : that.ncrEstablecimiento != null)
            return false;
        if (ncrFechaAutorizacion != null ? !ncrFechaAutorizacion.equals(that.ncrFechaAutorizacion) : that.ncrFechaAutorizacion != null)
            return false;
        if (ncrFechaEmision != null ? !ncrFechaEmision.equals(that.ncrFechaEmision) : that.ncrFechaEmision != null)
            return false;
        if (ncrIdentificacionComprador != null ? !ncrIdentificacionComprador.equals(that.ncrIdentificacionComprador) : that.ncrIdentificacionComprador != null)
            return false;
        if (ncrNumAutorizacion != null ? !ncrNumAutorizacion.equals(that.ncrNumAutorizacion) : that.ncrNumAutorizacion != null)
            return false;
        if (ncrNumDocModificado != null ? !ncrNumDocModificado.equals(that.ncrNumDocModificado) : that.ncrNumDocModificado != null)
            return false;
        if (ncrPuntoEmision != null ? !ncrPuntoEmision.equals(that.ncrPuntoEmision) : that.ncrPuntoEmision != null)
            return false;
        if (ncrRazonSocialComprador != null ? !ncrRazonSocialComprador.equals(that.ncrRazonSocialComprador) : that.ncrRazonSocialComprador != null)
            return false;
        if (ncrSecuencial != null ? !ncrSecuencial.equals(that.ncrSecuencial) : that.ncrSecuencial != null)
            return false;
        if (ncrTotalSinImpuestos != null ? !ncrTotalSinImpuestos.equals(that.ncrTotalSinImpuestos) : that.ncrTotalSinImpuestos != null)
            return false;
        if (ncrValorModificacion != null ? !ncrValorModificacion.equals(that.ncrValorModificacion) : that.ncrValorModificacion != null)
            return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;
        if (ncrIdentificacionVendedor != null ? !ncrIdentificacionVendedor.equals(that.ncrIdentificacionVendedor) : that.ncrIdentificacionVendedor != null)
            return false;
        if (ncrRazonSocialVendedor != null ? !ncrRazonSocialVendedor.equals(that.ncrRazonSocialVendedor) : that.ncrRazonSocialVendedor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ncrCodigo != null ? ncrCodigo.hashCode() : 0;
        result = 31 * result + (ncrEstablecimiento != null ? ncrEstablecimiento.hashCode() : 0);
        result = 31 * result + (ncrFechaAutorizacion != null ? ncrFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (ncrFechaEmision != null ? ncrFechaEmision.hashCode() : 0);
        result = 31 * result + (ncrIdentificacionComprador != null ? ncrIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (ncrNumAutorizacion != null ? ncrNumAutorizacion.hashCode() : 0);
        result = 31 * result + (ncrNumDocModificado != null ? ncrNumDocModificado.hashCode() : 0);
        result = 31 * result + (ncrPuntoEmision != null ? ncrPuntoEmision.hashCode() : 0);
        result = 31 * result + (ncrRazonSocialComprador != null ? ncrRazonSocialComprador.hashCode() : 0);
        result = 31 * result + (ncrSecuencial != null ? ncrSecuencial.hashCode() : 0);
        result = 31 * result + (ncrTotalSinImpuestos != null ? ncrTotalSinImpuestos.hashCode() : 0);
        result = 31 * result + (ncrValorModificacion != null ? ncrValorModificacion.hashCode() : 0);
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        result = 31 * result + (ncrIdentificacionVendedor != null ? ncrIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (ncrRazonSocialVendedor != null ? ncrRazonSocialVendedor.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    public EmpresaEntity getEmpresaByEmpCodigo() {
        return empresaByEmpCodigo;
    }

    public void setEmpresaByEmpCodigo(EmpresaEntity empresaByEmpCodigo) {
        this.empresaByEmpCodigo = empresaByEmpCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "tip_codigo", referencedColumnName = "tip_codigo")
    public TipoEntity getTipoByTipCodigo() {
        return tipoByTipCodigo;
    }

    public void setTipoByTipCodigo(TipoEntity tipoByTipCodigo) {
        this.tipoByTipCodigo = tipoByTipCodigo;
    }
}
