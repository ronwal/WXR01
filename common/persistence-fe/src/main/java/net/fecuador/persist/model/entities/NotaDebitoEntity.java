package net.fecuador.persist.model.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@javax.persistence.Table(name = "nota_debito", schema = "public", catalog = "factura_ecuador")
public class NotaDebitoEntity {
    private int ndeCodigo;

    @Id
    @javax.persistence.Column(name = "nde_codigo", nullable = false, insertable = true, updatable = true)
    public int getNdeCodigo() {
        return ndeCodigo;
    }

    public void setNdeCodigo(int ndeCodigo) {
        this.ndeCodigo = ndeCodigo;
    }

    private String ndeEstablecimiento;

    @Basic
    @javax.persistence.Column(name = "nde_establecimiento", nullable = false, insertable = true, updatable = true, length = 3)
    public String getNdeEstablecimiento() {
        return ndeEstablecimiento;
    }

    public void setNdeEstablecimiento(String ndeEstablecimiento) {
        this.ndeEstablecimiento = ndeEstablecimiento;
    }

    private String ndeFechaAutorizacion;

    @Basic
    @javax.persistence.Column(name = "nde_fecha_autorizacion", nullable = false, insertable = true, updatable = true, length = 50)
    public String getNdeFechaAutorizacion() {
        return ndeFechaAutorizacion;
    }

    public void setNdeFechaAutorizacion(String ndeFechaAutorizacion) {
        this.ndeFechaAutorizacion = ndeFechaAutorizacion;
    }

    private Date ndeFechaEmision;

    @Basic
    @javax.persistence.Column(name = "nde_fecha_emision", nullable = false, insertable = true, updatable = true)
    public Date getNdeFechaEmision() {
        return ndeFechaEmision;
    }

    public void setNdeFechaEmision(Date ndeFechaEmision) {
        this.ndeFechaEmision = ndeFechaEmision;
    }

    private String ndeIdentificacionComprador;

    @Basic
    @javax.persistence.Column(name = "nde_identificacion_comprador", nullable = false, insertable = true, updatable = true, length = 13)
    public String getNdeIdentificacionComprador() {
        return ndeIdentificacionComprador;
    }

    public void setNdeIdentificacionComprador(String ndeIdentificacionComprador) {
        this.ndeIdentificacionComprador = ndeIdentificacionComprador;
    }

    private String ndeNumAutorizacion;

    @Basic
    @javax.persistence.Column(name = "nde_num_autorizacion", nullable = false, insertable = true, updatable = true, length = 100)
    public String getNdeNumAutorizacion() {
        return ndeNumAutorizacion;
    }

    public void setNdeNumAutorizacion(String ndeNumAutorizacion) {
        this.ndeNumAutorizacion = ndeNumAutorizacion;
    }

    private String ndeNumDocModificado;

    @Basic
    @javax.persistence.Column(name = "nde_num_doc_modificado", nullable = false, insertable = true, updatable = true, length = 25)
    public String getNdeNumDocModificado() {
        return ndeNumDocModificado;
    }

    public void setNdeNumDocModificado(String ndeNumDocModificado) {
        this.ndeNumDocModificado = ndeNumDocModificado;
    }

    private String ndePuntoEmision;

    @Basic
    @javax.persistence.Column(name = "nde_punto_emision", nullable = false, insertable = true, updatable = true, length = 3)
    public String getNdePuntoEmision() {
        return ndePuntoEmision;
    }

    public void setNdePuntoEmision(String ndePuntoEmision) {
        this.ndePuntoEmision = ndePuntoEmision;
    }

    private String ndeRazonSocialComprador;

    @Basic
    @javax.persistence.Column(name = "nde_razon_social_comprador", nullable = false, insertable = true, updatable = true, length = 250)
    public String getNdeRazonSocialComprador() {
        return ndeRazonSocialComprador;
    }

    public void setNdeRazonSocialComprador(String ndeRazonSocialComprador) {
        this.ndeRazonSocialComprador = ndeRazonSocialComprador;
    }

    private int ndeSecuencial;

    @Basic
    @javax.persistence.Column(name = "nde_secuencial", nullable = false, insertable = true, updatable = true)
    public int getNdeSecuencial() {
        return ndeSecuencial;
    }

    public void setNdeSecuencial(int ndeSecuencial) {
        this.ndeSecuencial = ndeSecuencial;
    }

    private double ndeTotalSinImpuestos;

    @Basic
    @javax.persistence.Column(name = "nde_total_sin_impuestos", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getNdeTotalSinImpuestos() {
        return ndeTotalSinImpuestos;
    }

    public void setNdeTotalSinImpuestos(double ndeTotalSinImpuestos) {
        this.ndeTotalSinImpuestos = ndeTotalSinImpuestos;
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

    private String ndeIdentificacionVendedor;

    @Basic
    @javax.persistence.Column(name = "nde_identificacion_vendedor", nullable = false, insertable = true, updatable = true, length = 13)
    public String getNdeIdentificacionVendedor() {
        return ndeIdentificacionVendedor;
    }

    public void setNdeIdentificacionVendedor(String ndeIdentificacionVendedor) {
        this.ndeIdentificacionVendedor = ndeIdentificacionVendedor;
    }

    private String ndeRazonSocialVendedor;

    @Basic
    @javax.persistence.Column(name = "nde_razon_social_vendedor", nullable = false, insertable = true, updatable = true, length = 250)
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

        if (ndeCodigo != that.ndeCodigo) return false;
        if (ndeSecuencial != that.ndeSecuencial) return false;
        if (Double.compare(that.ndeTotalSinImpuestos, ndeTotalSinImpuestos) != 0) return false;
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
        int result;
        long temp;
        result = ndeCodigo;
        result = 31 * result + (ndeEstablecimiento != null ? ndeEstablecimiento.hashCode() : 0);
        result = 31 * result + (ndeFechaAutorizacion != null ? ndeFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (ndeFechaEmision != null ? ndeFechaEmision.hashCode() : 0);
        result = 31 * result + (ndeIdentificacionComprador != null ? ndeIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (ndeNumAutorizacion != null ? ndeNumAutorizacion.hashCode() : 0);
        result = 31 * result + (ndeNumDocModificado != null ? ndeNumDocModificado.hashCode() : 0);
        result = 31 * result + (ndePuntoEmision != null ? ndePuntoEmision.hashCode() : 0);
        result = 31 * result + (ndeRazonSocialComprador != null ? ndeRazonSocialComprador.hashCode() : 0);
        result = 31 * result + ndeSecuencial;
        temp = Double.doubleToLongBits(ndeTotalSinImpuestos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        result = 31 * result + (ndeIdentificacionVendedor != null ? ndeIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (ndeRazonSocialVendedor != null ? ndeRazonSocialVendedor.hashCode() : 0);
        return result;
    }
}
