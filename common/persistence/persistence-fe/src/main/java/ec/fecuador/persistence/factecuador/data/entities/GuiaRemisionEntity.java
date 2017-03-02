package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "guia_remision", schema = "public", catalog = "factura_ecuador")
public class GuiaRemisionEntity {
    private Integer greCodigo;
    private String greEstablecimiento;
    private String greFechaAutorizacion;
    private Date greFechaEmision;
    private String greNumAutorizacion;
    private String greNumDocModificado;
    private String grePuntoEmision;
    private String greRazonSocialComprador;
    private Integer greSecuencial;
    private Double greTotalSinImpuestos;
    private Double greValorModificacion;
    private String empCodigo;
    private String tipCodigo;
    private String greIdentificacionVendedor;
    private String greIdentificacionComprador;
    private String greRazonSocialVendedor;
    private EmpresaEntity empresaByEmpCodigo;
    private TipoEntity tipoByTipCodigo;

    @Id
    @Column(name = "gre_codigo", nullable = false)
    public Integer getGreCodigo() {
        return greCodigo;
    }

    public void setGreCodigo(Integer greCodigo) {
        this.greCodigo = greCodigo;
    }

    @Basic
    @Column(name = "gre_establecimiento", nullable = false, length = 3)
    public String getGreEstablecimiento() {
        return greEstablecimiento;
    }

    public void setGreEstablecimiento(String greEstablecimiento) {
        this.greEstablecimiento = greEstablecimiento;
    }

    @Basic
    @Column(name = "gre_fecha_autorizacion", nullable = false, length = 50)
    public String getGreFechaAutorizacion() {
        return greFechaAutorizacion;
    }

    public void setGreFechaAutorizacion(String greFechaAutorizacion) {
        this.greFechaAutorizacion = greFechaAutorizacion;
    }

    @Basic
    @Column(name = "gre_fecha_emision", nullable = false)
    public Date getGreFechaEmision() {
        return greFechaEmision;
    }

    public void setGreFechaEmision(Date greFechaEmision) {
        this.greFechaEmision = greFechaEmision;
    }

    @Basic
    @Column(name = "gre_num_autorizacion", nullable = false, length = 100)
    public String getGreNumAutorizacion() {
        return greNumAutorizacion;
    }

    public void setGreNumAutorizacion(String greNumAutorizacion) {
        this.greNumAutorizacion = greNumAutorizacion;
    }

    @Basic
    @Column(name = "gre_num_doc_modificado", nullable = false, length = 25)
    public String getGreNumDocModificado() {
        return greNumDocModificado;
    }

    public void setGreNumDocModificado(String greNumDocModificado) {
        this.greNumDocModificado = greNumDocModificado;
    }

    @Basic
    @Column(name = "gre_punto_emision", nullable = false, length = 3)
    public String getGrePuntoEmision() {
        return grePuntoEmision;
    }

    public void setGrePuntoEmision(String grePuntoEmision) {
        this.grePuntoEmision = grePuntoEmision;
    }

    @Basic
    @Column(name = "gre_razon_social_comprador", nullable = false, length = 250)
    public String getGreRazonSocialComprador() {
        return greRazonSocialComprador;
    }

    public void setGreRazonSocialComprador(String greRazonSocialComprador) {
        this.greRazonSocialComprador = greRazonSocialComprador;
    }

    @Basic
    @Column(name = "gre_secuencial", nullable = false)
    public Integer getGreSecuencial() {
        return greSecuencial;
    }

    public void setGreSecuencial(Integer greSecuencial) {
        this.greSecuencial = greSecuencial;
    }

    @Basic
    @Column(name = "gre_total_sin_impuestos", nullable = false, precision = 0)
    public Double getGreTotalSinImpuestos() {
        return greTotalSinImpuestos;
    }

    public void setGreTotalSinImpuestos(Double greTotalSinImpuestos) {
        this.greTotalSinImpuestos = greTotalSinImpuestos;
    }

    @Basic
    @Column(name = "gre_valor_modificacion", nullable = false, precision = 0)
    public Double getGreValorModificacion() {
        return greValorModificacion;
    }

    public void setGreValorModificacion(Double greValorModificacion) {
        this.greValorModificacion = greValorModificacion;
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
    @Column(name = "gre_identificacion_vendedor", nullable = false, length = 13)
    public String getGreIdentificacionVendedor() {
        return greIdentificacionVendedor;
    }

    public void setGreIdentificacionVendedor(String greIdentificacionVendedor) {
        this.greIdentificacionVendedor = greIdentificacionVendedor;
    }

    @Basic
    @Column(name = "gre_identificacion_comprador", nullable = false, length = 13)
    public String getGreIdentificacionComprador() {
        return greIdentificacionComprador;
    }

    public void setGreIdentificacionComprador(String greIdentificacionComprador) {
        this.greIdentificacionComprador = greIdentificacionComprador;
    }

    @Basic
    @Column(name = "gre_razon_social_vendedor", nullable = false, length = 250)
    public String getGreRazonSocialVendedor() {
        return greRazonSocialVendedor;
    }

    public void setGreRazonSocialVendedor(String greRazonSocialVendedor) {
        this.greRazonSocialVendedor = greRazonSocialVendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuiaRemisionEntity that = (GuiaRemisionEntity) o;

        if (greCodigo != null ? !greCodigo.equals(that.greCodigo) : that.greCodigo != null) return false;
        if (greEstablecimiento != null ? !greEstablecimiento.equals(that.greEstablecimiento) : that.greEstablecimiento != null)
            return false;
        if (greFechaAutorizacion != null ? !greFechaAutorizacion.equals(that.greFechaAutorizacion) : that.greFechaAutorizacion != null)
            return false;
        if (greFechaEmision != null ? !greFechaEmision.equals(that.greFechaEmision) : that.greFechaEmision != null)
            return false;
        if (greNumAutorizacion != null ? !greNumAutorizacion.equals(that.greNumAutorizacion) : that.greNumAutorizacion != null)
            return false;
        if (greNumDocModificado != null ? !greNumDocModificado.equals(that.greNumDocModificado) : that.greNumDocModificado != null)
            return false;
        if (grePuntoEmision != null ? !grePuntoEmision.equals(that.grePuntoEmision) : that.grePuntoEmision != null)
            return false;
        if (greRazonSocialComprador != null ? !greRazonSocialComprador.equals(that.greRazonSocialComprador) : that.greRazonSocialComprador != null)
            return false;
        if (greSecuencial != null ? !greSecuencial.equals(that.greSecuencial) : that.greSecuencial != null)
            return false;
        if (greTotalSinImpuestos != null ? !greTotalSinImpuestos.equals(that.greTotalSinImpuestos) : that.greTotalSinImpuestos != null)
            return false;
        if (greValorModificacion != null ? !greValorModificacion.equals(that.greValorModificacion) : that.greValorModificacion != null)
            return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;
        if (greIdentificacionVendedor != null ? !greIdentificacionVendedor.equals(that.greIdentificacionVendedor) : that.greIdentificacionVendedor != null)
            return false;
        if (greIdentificacionComprador != null ? !greIdentificacionComprador.equals(that.greIdentificacionComprador) : that.greIdentificacionComprador != null)
            return false;
        if (greRazonSocialVendedor != null ? !greRazonSocialVendedor.equals(that.greRazonSocialVendedor) : that.greRazonSocialVendedor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = greCodigo != null ? greCodigo.hashCode() : 0;
        result = 31 * result + (greEstablecimiento != null ? greEstablecimiento.hashCode() : 0);
        result = 31 * result + (greFechaAutorizacion != null ? greFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (greFechaEmision != null ? greFechaEmision.hashCode() : 0);
        result = 31 * result + (greNumAutorizacion != null ? greNumAutorizacion.hashCode() : 0);
        result = 31 * result + (greNumDocModificado != null ? greNumDocModificado.hashCode() : 0);
        result = 31 * result + (grePuntoEmision != null ? grePuntoEmision.hashCode() : 0);
        result = 31 * result + (greRazonSocialComprador != null ? greRazonSocialComprador.hashCode() : 0);
        result = 31 * result + (greSecuencial != null ? greSecuencial.hashCode() : 0);
        result = 31 * result + (greTotalSinImpuestos != null ? greTotalSinImpuestos.hashCode() : 0);
        result = 31 * result + (greValorModificacion != null ? greValorModificacion.hashCode() : 0);
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        result = 31 * result + (greIdentificacionVendedor != null ? greIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (greIdentificacionComprador != null ? greIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (greRazonSocialVendedor != null ? greRazonSocialVendedor.hashCode() : 0);
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
