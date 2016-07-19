package net.fecuador.persist.model.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@javax.persistence.Table(name = "retencion", schema = "public", catalog = "factura_ecuador")
public class RetencionEntity {
    private int retCodigo;

    @Id
    @javax.persistence.Column(name = "ret_codigo", nullable = false, insertable = true, updatable = true)
    public int getRetCodigo() {
        return retCodigo;
    }

    public void setRetCodigo(int retCodigo) {
        this.retCodigo = retCodigo;
    }

    private String retEstablecimiento;

    @Basic
    @javax.persistence.Column(name = "ret_establecimiento", nullable = false, insertable = true, updatable = true, length = 3)
    public String getRetEstablecimiento() {
        return retEstablecimiento;
    }

    public void setRetEstablecimiento(String retEstablecimiento) {
        this.retEstablecimiento = retEstablecimiento;
    }

    private String retFechaAutorizacion;

    @Basic
    @javax.persistence.Column(name = "ret_fecha_autorizacion", nullable = false, insertable = true, updatable = true, length = 50)
    public String getRetFechaAutorizacion() {
        return retFechaAutorizacion;
    }

    public void setRetFechaAutorizacion(String retFechaAutorizacion) {
        this.retFechaAutorizacion = retFechaAutorizacion;
    }

    private Date retFechaEmision;

    @Basic
    @javax.persistence.Column(name = "ret_fecha_emision", nullable = false, insertable = true, updatable = true)
    public Date getRetFechaEmision() {
        return retFechaEmision;
    }

    public void setRetFechaEmision(Date retFechaEmision) {
        this.retFechaEmision = retFechaEmision;
    }

    private String retIdentificacionEmisor;

    @Basic
    @javax.persistence.Column(name = "ret_identificacion_emisor", nullable = false, insertable = true, updatable = true, length = 13)
    public String getRetIdentificacionEmisor() {
        return retIdentificacionEmisor;
    }

    public void setRetIdentificacionEmisor(String retIdentificacionEmisor) {
        this.retIdentificacionEmisor = retIdentificacionEmisor;
    }

    private String retIdentificacionRetenido;

    @Basic
    @javax.persistence.Column(name = "ret_identificacion_retenido", nullable = false, insertable = true, updatable = true, length = 13)
    public String getRetIdentificacionRetenido() {
        return retIdentificacionRetenido;
    }

    public void setRetIdentificacionRetenido(String retIdentificacionRetenido) {
        this.retIdentificacionRetenido = retIdentificacionRetenido;
    }

    private String retNumAutorizacion;

    @Basic
    @javax.persistence.Column(name = "ret_num_autorizacion", nullable = false, insertable = true, updatable = true, length = 100)
    public String getRetNumAutorizacion() {
        return retNumAutorizacion;
    }

    public void setRetNumAutorizacion(String retNumAutorizacion) {
        this.retNumAutorizacion = retNumAutorizacion;
    }

    private String retPuntoEmision;

    @Basic
    @javax.persistence.Column(name = "ret_punto_emision", nullable = false, insertable = true, updatable = true, length = 3)
    public String getRetPuntoEmision() {
        return retPuntoEmision;
    }

    public void setRetPuntoEmision(String retPuntoEmision) {
        this.retPuntoEmision = retPuntoEmision;
    }

    private String retRazonSocialEmisor;

    @Basic
    @javax.persistence.Column(name = "ret_razon_social_emisor", nullable = false, insertable = true, updatable = true, length = 250)
    public String getRetRazonSocialEmisor() {
        return retRazonSocialEmisor;
    }

    public void setRetRazonSocialEmisor(String retRazonSocialEmisor) {
        this.retRazonSocialEmisor = retRazonSocialEmisor;
    }

    private String retRazonSocialRetenido;

    @Basic
    @javax.persistence.Column(name = "ret_razon_social_retenido", nullable = false, insertable = true, updatable = true, length = 250)
    public String getRetRazonSocialRetenido() {
        return retRazonSocialRetenido;
    }

    public void setRetRazonSocialRetenido(String retRazonSocialRetenido) {
        this.retRazonSocialRetenido = retRazonSocialRetenido;
    }

    private int retSecuencial;

    @Basic
    @javax.persistence.Column(name = "ret_secuencial", nullable = false, insertable = true, updatable = true)
    public int getRetSecuencial() {
        return retSecuencial;
    }

    public void setRetSecuencial(int retSecuencial) {
        this.retSecuencial = retSecuencial;
    }

    private double retValorRetenido;

    @Basic
    @javax.persistence.Column(name = "ret_valor_retenido", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getRetValorRetenido() {
        return retValorRetenido;
    }

    public void setRetValorRetenido(double retValorRetenido) {
        this.retValorRetenido = retValorRetenido;
    }

    private String empCodigo;

    @Basic
    @javax.persistence.Column(name = "emp_codigo", nullable = true, insertable = true, updatable = true, length = 13)
    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    private String tipCodigo;

    @Basic
    @javax.persistence.Column(name = "tip_codigo", nullable = true, insertable = true, updatable = true, length = 3)
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

        if (retCodigo != that.retCodigo) return false;
        if (retSecuencial != that.retSecuencial) return false;
        if (Double.compare(that.retValorRetenido, retValorRetenido) != 0) return false;
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
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = retCodigo;
        result = 31 * result + (retEstablecimiento != null ? retEstablecimiento.hashCode() : 0);
        result = 31 * result + (retFechaAutorizacion != null ? retFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (retFechaEmision != null ? retFechaEmision.hashCode() : 0);
        result = 31 * result + (retIdentificacionEmisor != null ? retIdentificacionEmisor.hashCode() : 0);
        result = 31 * result + (retIdentificacionRetenido != null ? retIdentificacionRetenido.hashCode() : 0);
        result = 31 * result + (retNumAutorizacion != null ? retNumAutorizacion.hashCode() : 0);
        result = 31 * result + (retPuntoEmision != null ? retPuntoEmision.hashCode() : 0);
        result = 31 * result + (retRazonSocialEmisor != null ? retRazonSocialEmisor.hashCode() : 0);
        result = 31 * result + (retRazonSocialRetenido != null ? retRazonSocialRetenido.hashCode() : 0);
        result = 31 * result + retSecuencial;
        temp = Double.doubleToLongBits(retValorRetenido);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return result;
    }
}
