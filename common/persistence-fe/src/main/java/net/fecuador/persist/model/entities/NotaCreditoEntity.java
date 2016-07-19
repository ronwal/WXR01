package net.fecuador.persist.model.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@javax.persistence.Table(name = "nota_credito", schema = "public", catalog = "factura_ecuador")
public class NotaCreditoEntity {
    private int ncrCodigo;

    @Id
    @javax.persistence.Column(name = "ncr_codigo", nullable = false, insertable = true, updatable = true)
    public int getNcrCodigo() {
        return ncrCodigo;
    }

    public void setNcrCodigo(int ncrCodigo) {
        this.ncrCodigo = ncrCodigo;
    }

    private String ncrEstablecimiento;

    @Basic
    @javax.persistence.Column(name = "ncr_establecimiento", nullable = false, insertable = true, updatable = true, length = 3)
    public String getNcrEstablecimiento() {
        return ncrEstablecimiento;
    }

    public void setNcrEstablecimiento(String ncrEstablecimiento) {
        this.ncrEstablecimiento = ncrEstablecimiento;
    }

    private String ncrFechaAutorizacion;

    @Basic
    @javax.persistence.Column(name = "ncr_fecha_autorizacion", nullable = false, insertable = true, updatable = true, length = 50)
    public String getNcrFechaAutorizacion() {
        return ncrFechaAutorizacion;
    }

    public void setNcrFechaAutorizacion(String ncrFechaAutorizacion) {
        this.ncrFechaAutorizacion = ncrFechaAutorizacion;
    }

    private Date ncrFechaEmision;

    @Basic
    @javax.persistence.Column(name = "ncr_fecha_emision", nullable = false, insertable = true, updatable = true)
    public Date getNcrFechaEmision() {
        return ncrFechaEmision;
    }

    public void setNcrFechaEmision(Date ncrFechaEmision) {
        this.ncrFechaEmision = ncrFechaEmision;
    }

    private String ncrIdentificacionComprador;

    @Basic
    @javax.persistence.Column(name = "ncr_identificacion_comprador", nullable = false, insertable = true, updatable = true, length = 13)
    public String getNcrIdentificacionComprador() {
        return ncrIdentificacionComprador;
    }

    public void setNcrIdentificacionComprador(String ncrIdentificacionComprador) {
        this.ncrIdentificacionComprador = ncrIdentificacionComprador;
    }

    private String ncrNumAutorizacion;

    @Basic
    @javax.persistence.Column(name = "ncr_num_autorizacion", nullable = false, insertable = true, updatable = true, length = 100)
    public String getNcrNumAutorizacion() {
        return ncrNumAutorizacion;
    }

    public void setNcrNumAutorizacion(String ncrNumAutorizacion) {
        this.ncrNumAutorizacion = ncrNumAutorizacion;
    }

    private String ncrNumDocModificado;

    @Basic
    @javax.persistence.Column(name = "ncr_num_doc_modificado", nullable = false, insertable = true, updatable = true, length = 25)
    public String getNcrNumDocModificado() {
        return ncrNumDocModificado;
    }

    public void setNcrNumDocModificado(String ncrNumDocModificado) {
        this.ncrNumDocModificado = ncrNumDocModificado;
    }

    private String ncrPuntoEmision;

    @Basic
    @javax.persistence.Column(name = "ncr_punto_emision", nullable = false, insertable = true, updatable = true, length = 3)
    public String getNcrPuntoEmision() {
        return ncrPuntoEmision;
    }

    public void setNcrPuntoEmision(String ncrPuntoEmision) {
        this.ncrPuntoEmision = ncrPuntoEmision;
    }

    private String ncrRazonSocialComprador;

    @Basic
    @javax.persistence.Column(name = "ncr_razon_social_comprador", nullable = false, insertable = true, updatable = true, length = 250)
    public String getNcrRazonSocialComprador() {
        return ncrRazonSocialComprador;
    }

    public void setNcrRazonSocialComprador(String ncrRazonSocialComprador) {
        this.ncrRazonSocialComprador = ncrRazonSocialComprador;
    }

    private int ncrSecuencial;

    @Basic
    @javax.persistence.Column(name = "ncr_secuencial", nullable = false, insertable = true, updatable = true)
    public int getNcrSecuencial() {
        return ncrSecuencial;
    }

    public void setNcrSecuencial(int ncrSecuencial) {
        this.ncrSecuencial = ncrSecuencial;
    }

    private double ncrTotalSinImpuestos;

    @Basic
    @javax.persistence.Column(name = "ncr_total_sin_impuestos", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getNcrTotalSinImpuestos() {
        return ncrTotalSinImpuestos;
    }

    public void setNcrTotalSinImpuestos(double ncrTotalSinImpuestos) {
        this.ncrTotalSinImpuestos = ncrTotalSinImpuestos;
    }

    private double ncrValorModificacion;

    @Basic
    @javax.persistence.Column(name = "ncr_valor_modificacion", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getNcrValorModificacion() {
        return ncrValorModificacion;
    }

    public void setNcrValorModificacion(double ncrValorModificacion) {
        this.ncrValorModificacion = ncrValorModificacion;
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

    private String ncrIdentificacionVendedor;

    @Basic
    @javax.persistence.Column(name = "ncr_identificacion_vendedor", nullable = false, insertable = true, updatable = true, length = 13)
    public String getNcrIdentificacionVendedor() {
        return ncrIdentificacionVendedor;
    }

    public void setNcrIdentificacionVendedor(String ncrIdentificacionVendedor) {
        this.ncrIdentificacionVendedor = ncrIdentificacionVendedor;
    }

    private String ncrRazonSocialVendedor;

    @Basic
    @javax.persistence.Column(name = "ncr_razon_social_vendedor", nullable = false, insertable = true, updatable = true, length = 250)
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

        if (ncrCodigo != that.ncrCodigo) return false;
        if (ncrSecuencial != that.ncrSecuencial) return false;
        if (Double.compare(that.ncrTotalSinImpuestos, ncrTotalSinImpuestos) != 0) return false;
        if (Double.compare(that.ncrValorModificacion, ncrValorModificacion) != 0) return false;
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
        int result;
        long temp;
        result = ncrCodigo;
        result = 31 * result + (ncrEstablecimiento != null ? ncrEstablecimiento.hashCode() : 0);
        result = 31 * result + (ncrFechaAutorizacion != null ? ncrFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (ncrFechaEmision != null ? ncrFechaEmision.hashCode() : 0);
        result = 31 * result + (ncrIdentificacionComprador != null ? ncrIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (ncrNumAutorizacion != null ? ncrNumAutorizacion.hashCode() : 0);
        result = 31 * result + (ncrNumDocModificado != null ? ncrNumDocModificado.hashCode() : 0);
        result = 31 * result + (ncrPuntoEmision != null ? ncrPuntoEmision.hashCode() : 0);
        result = 31 * result + (ncrRazonSocialComprador != null ? ncrRazonSocialComprador.hashCode() : 0);
        result = 31 * result + ncrSecuencial;
        temp = Double.doubleToLongBits(ncrTotalSinImpuestos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ncrValorModificacion);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        result = 31 * result + (ncrIdentificacionVendedor != null ? ncrIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (ncrRazonSocialVendedor != null ? ncrRazonSocialVendedor.hashCode() : 0);
        return result;
    }
}
