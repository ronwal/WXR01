package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "retencion", schema = "public", catalog = "factura_ecuador")
public class RetencionEntity {
    private Integer retCodigo;
    private String retEstablecimiento;
    private String retFechaAutorizacion;
    private Date retFechaEmision;
    private String retIdentificacionEmisor;
    private String retIdentificacionRetenido;
    private String retNumAutorizacion;
    private String retPuntoEmision;
    private String retRazonSocialEmisor;
    private String retRazonSocialRetenido;
    private Integer retSecuencial;
    private Double retValorRetenido;
    private String empCodigo;
    private String tipCodigo;
    private Collection<DetalleRetencionEntity> detalleRetencionsByRetCodigo;
    private EmpresaEntity empresaByEmpCodigo;
    private TipoEntity tipoByTipCodigo;

    @Id
    @Column(name = "ret_codigo", nullable = false)
    public Integer getRetCodigo() {
        return retCodigo;
    }

    public void setRetCodigo(Integer retCodigo) {
        this.retCodigo = retCodigo;
    }

    @Basic
    @Column(name = "ret_establecimiento", nullable = false, length = 3)
    public String getRetEstablecimiento() {
        return retEstablecimiento;
    }

    public void setRetEstablecimiento(String retEstablecimiento) {
        this.retEstablecimiento = retEstablecimiento;
    }

    @Basic
    @Column(name = "ret_fecha_autorizacion", nullable = false, length = 50)
    public String getRetFechaAutorizacion() {
        return retFechaAutorizacion;
    }

    public void setRetFechaAutorizacion(String retFechaAutorizacion) {
        this.retFechaAutorizacion = retFechaAutorizacion;
    }

    @Basic
    @Column(name = "ret_fecha_emision", nullable = false)
    public Date getRetFechaEmision() {
        return retFechaEmision;
    }

    public void setRetFechaEmision(Date retFechaEmision) {
        this.retFechaEmision = retFechaEmision;
    }

    @Basic
    @Column(name = "ret_identificacion_emisor", nullable = false, length = 13)
    public String getRetIdentificacionEmisor() {
        return retIdentificacionEmisor;
    }

    public void setRetIdentificacionEmisor(String retIdentificacionEmisor) {
        this.retIdentificacionEmisor = retIdentificacionEmisor;
    }

    @Basic
    @Column(name = "ret_identificacion_retenido", nullable = false, length = 13)
    public String getRetIdentificacionRetenido() {
        return retIdentificacionRetenido;
    }

    public void setRetIdentificacionRetenido(String retIdentificacionRetenido) {
        this.retIdentificacionRetenido = retIdentificacionRetenido;
    }

    @Basic
    @Column(name = "ret_num_autorizacion", nullable = false, length = 100)
    public String getRetNumAutorizacion() {
        return retNumAutorizacion;
    }

    public void setRetNumAutorizacion(String retNumAutorizacion) {
        this.retNumAutorizacion = retNumAutorizacion;
    }

    @Basic
    @Column(name = "ret_punto_emision", nullable = false, length = 3)
    public String getRetPuntoEmision() {
        return retPuntoEmision;
    }

    public void setRetPuntoEmision(String retPuntoEmision) {
        this.retPuntoEmision = retPuntoEmision;
    }

    @Basic
    @Column(name = "ret_razon_social_emisor", nullable = false, length = 250)
    public String getRetRazonSocialEmisor() {
        return retRazonSocialEmisor;
    }

    public void setRetRazonSocialEmisor(String retRazonSocialEmisor) {
        this.retRazonSocialEmisor = retRazonSocialEmisor;
    }

    @Basic
    @Column(name = "ret_razon_social_retenido", nullable = false, length = 250)
    public String getRetRazonSocialRetenido() {
        return retRazonSocialRetenido;
    }

    public void setRetRazonSocialRetenido(String retRazonSocialRetenido) {
        this.retRazonSocialRetenido = retRazonSocialRetenido;
    }

    @Basic
    @Column(name = "ret_secuencial", nullable = false)
    public Integer getRetSecuencial() {
        return retSecuencial;
    }

    public void setRetSecuencial(Integer retSecuencial) {
        this.retSecuencial = retSecuencial;
    }

    @Basic
    @Column(name = "ret_valor_retenido", nullable = false, precision = 0)
    public Double getRetValorRetenido() {
        return retValorRetenido;
    }

    public void setRetValorRetenido(Double retValorRetenido) {
        this.retValorRetenido = retValorRetenido;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RetencionEntity that = (RetencionEntity) o;

        if (retCodigo != null ? !retCodigo.equals(that.retCodigo) : that.retCodigo != null) return false;
        if (retEstablecimiento != null ? !retEstablecimiento.equals(that.retEstablecimiento) : that.retEstablecimiento != null)
            return false;
        if (retFechaAutorizacion != null ? !retFechaAutorizacion.equals(that.retFechaAutorizacion) : that.retFechaAutorizacion != null)
            return false;
        if (retFechaEmision != null ? !retFechaEmision.equals(that.retFechaEmision) : that.retFechaEmision != null)
            return false;
        if (retIdentificacionEmisor != null ? !retIdentificacionEmisor.equals(that.retIdentificacionEmisor) : that.retIdentificacionEmisor != null)
            return false;
        if (retIdentificacionRetenido != null ? !retIdentificacionRetenido.equals(that.retIdentificacionRetenido) : that.retIdentificacionRetenido != null)
            return false;
        if (retNumAutorizacion != null ? !retNumAutorizacion.equals(that.retNumAutorizacion) : that.retNumAutorizacion != null)
            return false;
        if (retPuntoEmision != null ? !retPuntoEmision.equals(that.retPuntoEmision) : that.retPuntoEmision != null)
            return false;
        if (retRazonSocialEmisor != null ? !retRazonSocialEmisor.equals(that.retRazonSocialEmisor) : that.retRazonSocialEmisor != null)
            return false;
        if (retRazonSocialRetenido != null ? !retRazonSocialRetenido.equals(that.retRazonSocialRetenido) : that.retRazonSocialRetenido != null)
            return false;
        if (retSecuencial != null ? !retSecuencial.equals(that.retSecuencial) : that.retSecuencial != null)
            return false;
        if (retValorRetenido != null ? !retValorRetenido.equals(that.retValorRetenido) : that.retValorRetenido != null)
            return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retCodigo != null ? retCodigo.hashCode() : 0;
        result = 31 * result + (retEstablecimiento != null ? retEstablecimiento.hashCode() : 0);
        result = 31 * result + (retFechaAutorizacion != null ? retFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (retFechaEmision != null ? retFechaEmision.hashCode() : 0);
        result = 31 * result + (retIdentificacionEmisor != null ? retIdentificacionEmisor.hashCode() : 0);
        result = 31 * result + (retIdentificacionRetenido != null ? retIdentificacionRetenido.hashCode() : 0);
        result = 31 * result + (retNumAutorizacion != null ? retNumAutorizacion.hashCode() : 0);
        result = 31 * result + (retPuntoEmision != null ? retPuntoEmision.hashCode() : 0);
        result = 31 * result + (retRazonSocialEmisor != null ? retRazonSocialEmisor.hashCode() : 0);
        result = 31 * result + (retRazonSocialRetenido != null ? retRazonSocialRetenido.hashCode() : 0);
        result = 31 * result + (retSecuencial != null ? retSecuencial.hashCode() : 0);
        result = 31 * result + (retValorRetenido != null ? retValorRetenido.hashCode() : 0);
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "retencionByRetCodigo")
    public Collection<DetalleRetencionEntity> getDetalleRetencionsByRetCodigo() {
        return detalleRetencionsByRetCodigo;
    }

    public void setDetalleRetencionsByRetCodigo(Collection<DetalleRetencionEntity> detalleRetencionsByRetCodigo) {
        this.detalleRetencionsByRetCodigo = detalleRetencionsByRetCodigo;
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
