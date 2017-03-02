package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "nota_debito", schema = "public", catalog = "factura_ecuador")
public class NotaDebitoEntity {
    private Integer ndeCodigo;
    private String ndeEstablecimiento;
    private String ndeFechaAutorizacion;
    private Date ndeFechaEmision;
    private String ndeIdentificacionComprador;
    private String ndeNumAutorizacion;
    private String ndeNumDocModificado;
    private String ndePuntoEmision;
    private String ndeRazonSocialComprador;
    private Integer ndeSecuencial;
    private Double ndeTotalSinImpuestos;
    private String empCodigo;
    private String tipCodigo;
    private String ndeIdentificacionVendedor;
    private String ndeRazonSocialVendedor;
    private EmpresaEntity empresaByEmpCodigo;
    private TipoEntity tipoByTipCodigo;

    @Id
    @Column(name = "nde_codigo", nullable = false)
    public Integer getNdeCodigo() {
        return ndeCodigo;
    }

    public void setNdeCodigo(Integer ndeCodigo) {
        this.ndeCodigo = ndeCodigo;
    }

    @Basic
    @Column(name = "nde_establecimiento", nullable = false, length = 3)
    public String getNdeEstablecimiento() {
        return ndeEstablecimiento;
    }

    public void setNdeEstablecimiento(String ndeEstablecimiento) {
        this.ndeEstablecimiento = ndeEstablecimiento;
    }

    @Basic
    @Column(name = "nde_fecha_autorizacion", nullable = false, length = 50)
    public String getNdeFechaAutorizacion() {
        return ndeFechaAutorizacion;
    }

    public void setNdeFechaAutorizacion(String ndeFechaAutorizacion) {
        this.ndeFechaAutorizacion = ndeFechaAutorizacion;
    }

    @Basic
    @Column(name = "nde_fecha_emision", nullable = false)
    public Date getNdeFechaEmision() {
        return ndeFechaEmision;
    }

    public void setNdeFechaEmision(Date ndeFechaEmision) {
        this.ndeFechaEmision = ndeFechaEmision;
    }

    @Basic
    @Column(name = "nde_identificacion_comprador", nullable = false, length = 13)
    public String getNdeIdentificacionComprador() {
        return ndeIdentificacionComprador;
    }

    public void setNdeIdentificacionComprador(String ndeIdentificacionComprador) {
        this.ndeIdentificacionComprador = ndeIdentificacionComprador;
    }

    @Basic
    @Column(name = "nde_num_autorizacion", nullable = false, length = 100)
    public String getNdeNumAutorizacion() {
        return ndeNumAutorizacion;
    }

    public void setNdeNumAutorizacion(String ndeNumAutorizacion) {
        this.ndeNumAutorizacion = ndeNumAutorizacion;
    }

    @Basic
    @Column(name = "nde_num_doc_modificado", nullable = false, length = 25)
    public String getNdeNumDocModificado() {
        return ndeNumDocModificado;
    }

    public void setNdeNumDocModificado(String ndeNumDocModificado) {
        this.ndeNumDocModificado = ndeNumDocModificado;
    }

    @Basic
    @Column(name = "nde_punto_emision", nullable = false, length = 3)
    public String getNdePuntoEmision() {
        return ndePuntoEmision;
    }

    public void setNdePuntoEmision(String ndePuntoEmision) {
        this.ndePuntoEmision = ndePuntoEmision;
    }

    @Basic
    @Column(name = "nde_razon_social_comprador", nullable = false, length = 250)
    public String getNdeRazonSocialComprador() {
        return ndeRazonSocialComprador;
    }

    public void setNdeRazonSocialComprador(String ndeRazonSocialComprador) {
        this.ndeRazonSocialComprador = ndeRazonSocialComprador;
    }

    @Basic
    @Column(name = "nde_secuencial", nullable = false)
    public Integer getNdeSecuencial() {
        return ndeSecuencial;
    }

    public void setNdeSecuencial(Integer ndeSecuencial) {
        this.ndeSecuencial = ndeSecuencial;
    }

    @Basic
    @Column(name = "nde_total_sin_impuestos", nullable = false, precision = 0)
    public Double getNdeTotalSinImpuestos() {
        return ndeTotalSinImpuestos;
    }

    public void setNdeTotalSinImpuestos(Double ndeTotalSinImpuestos) {
        this.ndeTotalSinImpuestos = ndeTotalSinImpuestos;
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
    @Column(name = "nde_identificacion_vendedor", nullable = false, length = 13)
    public String getNdeIdentificacionVendedor() {
        return ndeIdentificacionVendedor;
    }

    public void setNdeIdentificacionVendedor(String ndeIdentificacionVendedor) {
        this.ndeIdentificacionVendedor = ndeIdentificacionVendedor;
    }

    @Basic
    @Column(name = "nde_razon_social_vendedor", nullable = false, length = 250)
    public String getNdeRazonSocialVendedor() {
        return ndeRazonSocialVendedor;
    }

    public void setNdeRazonSocialVendedor(String ndeRazonSocialVendedor) {
        this.ndeRazonSocialVendedor = ndeRazonSocialVendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaDebitoEntity that = (NotaDebitoEntity) o;

        if (ndeCodigo != null ? !ndeCodigo.equals(that.ndeCodigo) : that.ndeCodigo != null) return false;
        if (ndeEstablecimiento != null ? !ndeEstablecimiento.equals(that.ndeEstablecimiento) : that.ndeEstablecimiento != null)
            return false;
        if (ndeFechaAutorizacion != null ? !ndeFechaAutorizacion.equals(that.ndeFechaAutorizacion) : that.ndeFechaAutorizacion != null)
            return false;
        if (ndeFechaEmision != null ? !ndeFechaEmision.equals(that.ndeFechaEmision) : that.ndeFechaEmision != null)
            return false;
        if (ndeIdentificacionComprador != null ? !ndeIdentificacionComprador.equals(that.ndeIdentificacionComprador) : that.ndeIdentificacionComprador != null)
            return false;
        if (ndeNumAutorizacion != null ? !ndeNumAutorizacion.equals(that.ndeNumAutorizacion) : that.ndeNumAutorizacion != null)
            return false;
        if (ndeNumDocModificado != null ? !ndeNumDocModificado.equals(that.ndeNumDocModificado) : that.ndeNumDocModificado != null)
            return false;
        if (ndePuntoEmision != null ? !ndePuntoEmision.equals(that.ndePuntoEmision) : that.ndePuntoEmision != null)
            return false;
        if (ndeRazonSocialComprador != null ? !ndeRazonSocialComprador.equals(that.ndeRazonSocialComprador) : that.ndeRazonSocialComprador != null)
            return false;
        if (ndeSecuencial != null ? !ndeSecuencial.equals(that.ndeSecuencial) : that.ndeSecuencial != null)
            return false;
        if (ndeTotalSinImpuestos != null ? !ndeTotalSinImpuestos.equals(that.ndeTotalSinImpuestos) : that.ndeTotalSinImpuestos != null)
            return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;
        if (ndeIdentificacionVendedor != null ? !ndeIdentificacionVendedor.equals(that.ndeIdentificacionVendedor) : that.ndeIdentificacionVendedor != null)
            return false;
        if (ndeRazonSocialVendedor != null ? !ndeRazonSocialVendedor.equals(that.ndeRazonSocialVendedor) : that.ndeRazonSocialVendedor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ndeCodigo != null ? ndeCodigo.hashCode() : 0;
        result = 31 * result + (ndeEstablecimiento != null ? ndeEstablecimiento.hashCode() : 0);
        result = 31 * result + (ndeFechaAutorizacion != null ? ndeFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (ndeFechaEmision != null ? ndeFechaEmision.hashCode() : 0);
        result = 31 * result + (ndeIdentificacionComprador != null ? ndeIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (ndeNumAutorizacion != null ? ndeNumAutorizacion.hashCode() : 0);
        result = 31 * result + (ndeNumDocModificado != null ? ndeNumDocModificado.hashCode() : 0);
        result = 31 * result + (ndePuntoEmision != null ? ndePuntoEmision.hashCode() : 0);
        result = 31 * result + (ndeRazonSocialComprador != null ? ndeRazonSocialComprador.hashCode() : 0);
        result = 31 * result + (ndeSecuencial != null ? ndeSecuencial.hashCode() : 0);
        result = 31 * result + (ndeTotalSinImpuestos != null ? ndeTotalSinImpuestos.hashCode() : 0);
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        result = 31 * result + (ndeIdentificacionVendedor != null ? ndeIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (ndeRazonSocialVendedor != null ? ndeRazonSocialVendedor.hashCode() : 0);
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
