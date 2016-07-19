package net.fecuador.persist.model.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@javax.persistence.Table(name = "factura", schema = "public", catalog = "factura_ecuador")
public class FacturaEntity {
    private int facCodigo;

    @Id
    @javax.persistence.Column(name = "fac_codigo", nullable = false, insertable = true, updatable = true)
    public int getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(int facCodigo) {
        this.facCodigo = facCodigo;
    }

    private String facEstablecimiento;

    @Basic
    @javax.persistence.Column(name = "fac_establecimiento", nullable = false, insertable = true, updatable = true, length = 3)
    public String getFacEstablecimiento() {
        return facEstablecimiento;
    }

    public void setFacEstablecimiento(String facEstablecimiento) {
        this.facEstablecimiento = facEstablecimiento;
    }

    private String facFechaAutorizacion;

    @Basic
    @javax.persistence.Column(name = "fac_fecha_autorizacion", nullable = false, insertable = true, updatable = true, length = 50)
    public String getFacFechaAutorizacion() {
        return facFechaAutorizacion;
    }

    public void setFacFechaAutorizacion(String facFechaAutorizacion) {
        this.facFechaAutorizacion = facFechaAutorizacion;
    }

    private Date facFechaEmision;

    @Basic
    @javax.persistence.Column(name = "fac_fecha_emision", nullable = false, insertable = true, updatable = true)
    public Date getFacFechaEmision() {
        return facFechaEmision;
    }

    public void setFacFechaEmision(Date facFechaEmision) {
        this.facFechaEmision = facFechaEmision;
    }

    private String facIdentificacionComprador;

    @Basic
    @javax.persistence.Column(name = "fac_identificacion_comprador", nullable = false, insertable = true, updatable = true, length = 13)
    public String getFacIdentificacionComprador() {
        return facIdentificacionComprador;
    }

    public void setFacIdentificacionComprador(String facIdentificacionComprador) {
        this.facIdentificacionComprador = facIdentificacionComprador;
    }

    private String facIdentificacionVendedor;

    @Basic
    @javax.persistence.Column(name = "fac_identificacion_vendedor", nullable = false, insertable = true, updatable = true, length = 13)
    public String getFacIdentificacionVendedor() {
        return facIdentificacionVendedor;
    }

    public void setFacIdentificacionVendedor(String facIdentificacionVendedor) {
        this.facIdentificacionVendedor = facIdentificacionVendedor;
    }

    private double facImporteTotal;

    @Basic
    @javax.persistence.Column(name = "fac_importe_total", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getFacImporteTotal() {
        return facImporteTotal;
    }

    public void setFacImporteTotal(double facImporteTotal) {
        this.facImporteTotal = facImporteTotal;
    }

    private String facNumAutorizacion;

    @Basic
    @javax.persistence.Column(name = "fac_num_autorizacion", nullable = false, insertable = true, updatable = true, length = 100)
    public String getFacNumAutorizacion() {
        return facNumAutorizacion;
    }

    public void setFacNumAutorizacion(String facNumAutorizacion) {
        this.facNumAutorizacion = facNumAutorizacion;
    }

    private String facPuntoEmision;

    @Basic
    @javax.persistence.Column(name = "fac_punto_emision", nullable = false, insertable = true, updatable = true, length = 3)
    public String getFacPuntoEmision() {
        return facPuntoEmision;
    }

    public void setFacPuntoEmision(String facPuntoEmision) {
        this.facPuntoEmision = facPuntoEmision;
    }

    private String facRazonSocialComprador;

    @Basic
    @javax.persistence.Column(name = "fac_razon_social_comprador", nullable = false, insertable = true, updatable = true, length = 250)
    public String getFacRazonSocialComprador() {
        return facRazonSocialComprador;
    }

    public void setFacRazonSocialComprador(String facRazonSocialComprador) {
        this.facRazonSocialComprador = facRazonSocialComprador;
    }

    private String facRazonSocialVendedor;

    @Basic
    @javax.persistence.Column(name = "fac_razon_social_vendedor", nullable = false, insertable = true, updatable = true, length = 250)
    public String getFacRazonSocialVendedor() {
        return facRazonSocialVendedor;
    }

    public void setFacRazonSocialVendedor(String facRazonSocialVendedor) {
        this.facRazonSocialVendedor = facRazonSocialVendedor;
    }

    private int facSecuencial;

    @Basic
    @javax.persistence.Column(name = "fac_secuencial", nullable = false, insertable = true, updatable = true)
    public int getFacSecuencial() {
        return facSecuencial;
    }

    public void setFacSecuencial(int facSecuencial) {
        this.facSecuencial = facSecuencial;
    }

    private double facTotalDescuento;

    @Basic
    @javax.persistence.Column(name = "fac_total_descuento", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getFacTotalDescuento() {
        return facTotalDescuento;
    }

    public void setFacTotalDescuento(double facTotalDescuento) {
        this.facTotalDescuento = facTotalDescuento;
    }

    private double facTotalSinImpuestos;

    @Basic
    @javax.persistence.Column(name = "fac_total_sin_impuestos", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getFacTotalSinImpuestos() {
        return facTotalSinImpuestos;
    }

    public void setFacTotalSinImpuestos(double facTotalSinImpuestos) {
        this.facTotalSinImpuestos = facTotalSinImpuestos;
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

        FacturaEntity that = (FacturaEntity) o;

        if (facCodigo != that.facCodigo) return false;
        if (Double.compare(that.facImporteTotal, facImporteTotal) != 0) return false;
        if (facSecuencial != that.facSecuencial) return false;
        if (Double.compare(that.facTotalDescuento, facTotalDescuento) != 0) return false;
        if (Double.compare(that.facTotalSinImpuestos, facTotalSinImpuestos) != 0) return false;
        if (facEstablecimiento != null ? !facEstablecimiento.equals(that.facEstablecimiento) : that.facEstablecimiento != null)
            return false;
        if (facFechaAutorizacion != null ? !facFechaAutorizacion.equals(that.facFechaAutorizacion) : that.facFechaAutorizacion != null)
            return false;
        if (facFechaEmision != null ? !facFechaEmision.equals(that.facFechaEmision) : that.facFechaEmision != null)
            return false;
        if (facIdentificacionComprador != null ? !facIdentificacionComprador.equals(that.facIdentificacionComprador) : that.facIdentificacionComprador != null)
            return false;
        if (facIdentificacionVendedor != null ? !facIdentificacionVendedor.equals(that.facIdentificacionVendedor) : that.facIdentificacionVendedor != null)
            return false;
        if (facNumAutorizacion != null ? !facNumAutorizacion.equals(that.facNumAutorizacion) : that.facNumAutorizacion != null)
            return false;
        if (facPuntoEmision != null ? !facPuntoEmision.equals(that.facPuntoEmision) : that.facPuntoEmision != null)
            return false;
        if (facRazonSocialComprador != null ? !facRazonSocialComprador.equals(that.facRazonSocialComprador) : that.facRazonSocialComprador != null)
            return false;
        if (facRazonSocialVendedor != null ? !facRazonSocialVendedor.equals(that.facRazonSocialVendedor) : that.facRazonSocialVendedor != null)
            return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = facCodigo;
        result = 31 * result + (facEstablecimiento != null ? facEstablecimiento.hashCode() : 0);
        result = 31 * result + (facFechaAutorizacion != null ? facFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (facFechaEmision != null ? facFechaEmision.hashCode() : 0);
        result = 31 * result + (facIdentificacionComprador != null ? facIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (facIdentificacionVendedor != null ? facIdentificacionVendedor.hashCode() : 0);
        temp = Double.doubleToLongBits(facImporteTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (facNumAutorizacion != null ? facNumAutorizacion.hashCode() : 0);
        result = 31 * result + (facPuntoEmision != null ? facPuntoEmision.hashCode() : 0);
        result = 31 * result + (facRazonSocialComprador != null ? facRazonSocialComprador.hashCode() : 0);
        result = 31 * result + (facRazonSocialVendedor != null ? facRazonSocialVendedor.hashCode() : 0);
        result = 31 * result + facSecuencial;
        temp = Double.doubleToLongBits(facTotalDescuento);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(facTotalSinImpuestos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return result;
    }
}
