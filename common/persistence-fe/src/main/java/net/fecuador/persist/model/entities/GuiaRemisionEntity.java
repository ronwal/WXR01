package net.fecuador.persist.model.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@javax.persistence.Table(name = "guia_remision", schema = "public", catalog = "factura_ecuador")
public class GuiaRemisionEntity {
    private int greCodigo;

    @Id
    @javax.persistence.Column(name = "gre_codigo", nullable = false, insertable = true, updatable = true)
    public int getGreCodigo() {
        return greCodigo;
    }

    public void setGreCodigo(int greCodigo) {
        this.greCodigo = greCodigo;
    }

    private String greEstablecimiento;

    @Basic
    @javax.persistence.Column(name = "gre_establecimiento", nullable = false, insertable = true, updatable = true, length = 3)
    public String getGreEstablecimiento() {
        return greEstablecimiento;
    }

    public void setGreEstablecimiento(String greEstablecimiento) {
        this.greEstablecimiento = greEstablecimiento;
    }

    private String greFechaAutorizacion;

    @Basic
    @javax.persistence.Column(name = "gre_fecha_autorizacion", nullable = false, insertable = true, updatable = true, length = 50)
    public String getGreFechaAutorizacion() {
        return greFechaAutorizacion;
    }

    public void setGreFechaAutorizacion(String greFechaAutorizacion) {
        this.greFechaAutorizacion = greFechaAutorizacion;
    }

    private Date greFechaEmision;

    @Basic
    @javax.persistence.Column(name = "gre_fecha_emision", nullable = false, insertable = true, updatable = true)
    public Date getGreFechaEmision() {
        return greFechaEmision;
    }

    public void setGreFechaEmision(Date greFechaEmision) {
        this.greFechaEmision = greFechaEmision;
    }

    private String greNumAutorizacion;

    @Basic
    @javax.persistence.Column(name = "gre_num_autorizacion", nullable = false, insertable = true, updatable = true, length = 100)
    public String getGreNumAutorizacion() {
        return greNumAutorizacion;
    }

    public void setGreNumAutorizacion(String greNumAutorizacion) {
        this.greNumAutorizacion = greNumAutorizacion;
    }

    private String greNumDocModificado;

    @Basic
    @javax.persistence.Column(name = "gre_num_doc_modificado", nullable = false, insertable = true, updatable = true, length = 25)
    public String getGreNumDocModificado() {
        return greNumDocModificado;
    }

    public void setGreNumDocModificado(String greNumDocModificado) {
        this.greNumDocModificado = greNumDocModificado;
    }

    private String grePuntoEmision;

    @Basic
    @javax.persistence.Column(name = "gre_punto_emision", nullable = false, insertable = true, updatable = true, length = 3)
    public String getGrePuntoEmision() {
        return grePuntoEmision;
    }

    public void setGrePuntoEmision(String grePuntoEmision) {
        this.grePuntoEmision = grePuntoEmision;
    }

    private String greRazonSocialComprador;

    @Basic
    @javax.persistence.Column(name = "gre_razon_social_comprador", nullable = false, insertable = true, updatable = true, length = 250)
    public String getGreRazonSocialComprador() {
        return greRazonSocialComprador;
    }

    public void setGreRazonSocialComprador(String greRazonSocialComprador) {
        this.greRazonSocialComprador = greRazonSocialComprador;
    }

    private int greSecuencial;

    @Basic
    @javax.persistence.Column(name = "gre_secuencial", nullable = false, insertable = true, updatable = true)
    public int getGreSecuencial() {
        return greSecuencial;
    }

    public void setGreSecuencial(int greSecuencial) {
        this.greSecuencial = greSecuencial;
    }

    private double greTotalSinImpuestos;

    @Basic
    @javax.persistence.Column(name = "gre_total_sin_impuestos", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getGreTotalSinImpuestos() {
        return greTotalSinImpuestos;
    }

    public void setGreTotalSinImpuestos(double greTotalSinImpuestos) {
        this.greTotalSinImpuestos = greTotalSinImpuestos;
    }

    private double greValorModificacion;

    @Basic
    @javax.persistence.Column(name = "gre_valor_modificacion", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getGreValorModificacion() {
        return greValorModificacion;
    }

    public void setGreValorModificacion(double greValorModificacion) {
        this.greValorModificacion = greValorModificacion;
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

    private String greIdentificacionVendedor;

    @Basic
    @javax.persistence.Column(name = "gre_identificacion_vendedor", nullable = false, insertable = true, updatable = true, length = 13)
    public String getGreIdentificacionVendedor() {
        return greIdentificacionVendedor;
    }

    public void setGreIdentificacionVendedor(String greIdentificacionVendedor) {
        this.greIdentificacionVendedor = greIdentificacionVendedor;
    }

    private String greIdentificacionComprador;

    @Basic
    @javax.persistence.Column(name = "gre_identificacion_comprador", nullable = false, insertable = true, updatable = true, length = 13)
    public String getGreIdentificacionComprador() {
        return greIdentificacionComprador;
    }

    public void setGreIdentificacionComprador(String greIdentificacionComprador) {
        this.greIdentificacionComprador = greIdentificacionComprador;
    }

    private String greRazonSocialVendedor;

    @Basic
    @javax.persistence.Column(name = "gre_razon_social_vendedor", nullable = false, insertable = true, updatable = true, length = 250)
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

        if (greCodigo != that.greCodigo) return false;
        if (greSecuencial != that.greSecuencial) return false;
        if (Double.compare(that.greTotalSinImpuestos, greTotalSinImpuestos) != 0) return false;
        if (Double.compare(that.greValorModificacion, greValorModificacion) != 0) return false;
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
        int result;
        long temp;
        result = greCodigo;
        result = 31 * result + (greEstablecimiento != null ? greEstablecimiento.hashCode() : 0);
        result = 31 * result + (greFechaAutorizacion != null ? greFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (greFechaEmision != null ? greFechaEmision.hashCode() : 0);
        result = 31 * result + (greNumAutorizacion != null ? greNumAutorizacion.hashCode() : 0);
        result = 31 * result + (greNumDocModificado != null ? greNumDocModificado.hashCode() : 0);
        result = 31 * result + (grePuntoEmision != null ? grePuntoEmision.hashCode() : 0);
        result = 31 * result + (greRazonSocialComprador != null ? greRazonSocialComprador.hashCode() : 0);
        result = 31 * result + greSecuencial;
        temp = Double.doubleToLongBits(greTotalSinImpuestos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(greValorModificacion);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        result = 31 * result + (greIdentificacionVendedor != null ? greIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (greIdentificacionComprador != null ? greIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (greRazonSocialVendedor != null ? greRazonSocialVendedor.hashCode() : 0);
        return result;
    }
}
