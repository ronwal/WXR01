package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "factura", schema = "public", catalog = "factura_ecuador")
public class FacturaEntity {
    private Integer facCodigo;
    private String facEstablecimiento;
    private String facFechaAutorizacion;
    private Date facFechaEmision;
    private String facIdentificacionComprador;
    private String facIdentificacionVendedor;
    private Double facImporteTotal;
    private String facNumAutorizacion;
    private String facPuntoEmision;
    private String facRazonSocialComprador;
    private String facRazonSocialVendedor;
    private Integer facSecuencial;
    private Double facTotalDescuento;
    private Double facTotalSinImpuestos;
    private String empCodigo;
    private String tipCodigo;
    private EmpresaEntity empresaByEmpCodigo;
    private TipoEntity tipoByTipCodigo;

    @Id
    @Column(name = "fac_codigo", nullable = false)
    public Integer getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(Integer facCodigo) {
        this.facCodigo = facCodigo;
    }

    @Basic
    @Column(name = "fac_establecimiento", nullable = false, length = 3)
    public String getFacEstablecimiento() {
        return facEstablecimiento;
    }

    public void setFacEstablecimiento(String facEstablecimiento) {
        this.facEstablecimiento = facEstablecimiento;
    }

    @Basic
    @Column(name = "fac_fecha_autorizacion", nullable = false, length = 50)
    public String getFacFechaAutorizacion() {
        return facFechaAutorizacion;
    }

    public void setFacFechaAutorizacion(String facFechaAutorizacion) {
        this.facFechaAutorizacion = facFechaAutorizacion;
    }

    @Basic
    @Column(name = "fac_fecha_emision", nullable = false)
    public Date getFacFechaEmision() {
        return facFechaEmision;
    }

    public void setFacFechaEmision(Date facFechaEmision) {
        this.facFechaEmision = facFechaEmision;
    }

    @Basic
    @Column(name = "fac_identificacion_comprador", nullable = false, length = 13)
    public String getFacIdentificacionComprador() {
        return facIdentificacionComprador;
    }

    public void setFacIdentificacionComprador(String facIdentificacionComprador) {
        this.facIdentificacionComprador = facIdentificacionComprador;
    }

    @Basic
    @Column(name = "fac_identificacion_vendedor", nullable = false, length = 13)
    public String getFacIdentificacionVendedor() {
        return facIdentificacionVendedor;
    }

    public void setFacIdentificacionVendedor(String facIdentificacionVendedor) {
        this.facIdentificacionVendedor = facIdentificacionVendedor;
    }

    @Basic
    @Column(name = "fac_importe_total", nullable = false, precision = 0)
    public Double getFacImporteTotal() {
        return facImporteTotal;
    }

    public void setFacImporteTotal(Double facImporteTotal) {
        this.facImporteTotal = facImporteTotal;
    }

    @Basic
    @Column(name = "fac_num_autorizacion", nullable = false, length = 100)
    public String getFacNumAutorizacion() {
        return facNumAutorizacion;
    }

    public void setFacNumAutorizacion(String facNumAutorizacion) {
        this.facNumAutorizacion = facNumAutorizacion;
    }

    @Basic
    @Column(name = "fac_punto_emision", nullable = false, length = 3)
    public String getFacPuntoEmision() {
        return facPuntoEmision;
    }

    public void setFacPuntoEmision(String facPuntoEmision) {
        this.facPuntoEmision = facPuntoEmision;
    }

    @Basic
    @Column(name = "fac_razon_social_comprador", nullable = false, length = 250)
    public String getFacRazonSocialComprador() {
        return facRazonSocialComprador;
    }

    public void setFacRazonSocialComprador(String facRazonSocialComprador) {
        this.facRazonSocialComprador = facRazonSocialComprador;
    }

    @Basic
    @Column(name = "fac_razon_social_vendedor", nullable = false, length = 250)
    public String getFacRazonSocialVendedor() {
        return facRazonSocialVendedor;
    }

    public void setFacRazonSocialVendedor(String facRazonSocialVendedor) {
        this.facRazonSocialVendedor = facRazonSocialVendedor;
    }

    @Basic
    @Column(name = "fac_secuencial", nullable = false)
    public Integer getFacSecuencial() {
        return facSecuencial;
    }

    public void setFacSecuencial(Integer facSecuencial) {
        this.facSecuencial = facSecuencial;
    }

    @Basic
    @Column(name = "fac_total_descuento", nullable = false, precision = 0)
    public Double getFacTotalDescuento() {
        return facTotalDescuento;
    }

    public void setFacTotalDescuento(Double facTotalDescuento) {
        this.facTotalDescuento = facTotalDescuento;
    }

    @Basic
    @Column(name = "fac_total_sin_impuestos", nullable = false, precision = 0)
    public Double getFacTotalSinImpuestos() {
        return facTotalSinImpuestos;
    }

    public void setFacTotalSinImpuestos(Double facTotalSinImpuestos) {
        this.facTotalSinImpuestos = facTotalSinImpuestos;
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

        FacturaEntity that = (FacturaEntity) o;

        if (facCodigo != null ? !facCodigo.equals(that.facCodigo) : that.facCodigo != null) return false;
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
        if (facImporteTotal != null ? !facImporteTotal.equals(that.facImporteTotal) : that.facImporteTotal != null)
            return false;
        if (facNumAutorizacion != null ? !facNumAutorizacion.equals(that.facNumAutorizacion) : that.facNumAutorizacion != null)
            return false;
        if (facPuntoEmision != null ? !facPuntoEmision.equals(that.facPuntoEmision) : that.facPuntoEmision != null)
            return false;
        if (facRazonSocialComprador != null ? !facRazonSocialComprador.equals(that.facRazonSocialComprador) : that.facRazonSocialComprador != null)
            return false;
        if (facRazonSocialVendedor != null ? !facRazonSocialVendedor.equals(that.facRazonSocialVendedor) : that.facRazonSocialVendedor != null)
            return false;
        if (facSecuencial != null ? !facSecuencial.equals(that.facSecuencial) : that.facSecuencial != null)
            return false;
        if (facTotalDescuento != null ? !facTotalDescuento.equals(that.facTotalDescuento) : that.facTotalDescuento != null)
            return false;
        if (facTotalSinImpuestos != null ? !facTotalSinImpuestos.equals(that.facTotalSinImpuestos) : that.facTotalSinImpuestos != null)
            return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = facCodigo != null ? facCodigo.hashCode() : 0;
        result = 31 * result + (facEstablecimiento != null ? facEstablecimiento.hashCode() : 0);
        result = 31 * result + (facFechaAutorizacion != null ? facFechaAutorizacion.hashCode() : 0);
        result = 31 * result + (facFechaEmision != null ? facFechaEmision.hashCode() : 0);
        result = 31 * result + (facIdentificacionComprador != null ? facIdentificacionComprador.hashCode() : 0);
        result = 31 * result + (facIdentificacionVendedor != null ? facIdentificacionVendedor.hashCode() : 0);
        result = 31 * result + (facImporteTotal != null ? facImporteTotal.hashCode() : 0);
        result = 31 * result + (facNumAutorizacion != null ? facNumAutorizacion.hashCode() : 0);
        result = 31 * result + (facPuntoEmision != null ? facPuntoEmision.hashCode() : 0);
        result = 31 * result + (facRazonSocialComprador != null ? facRazonSocialComprador.hashCode() : 0);
        result = 31 * result + (facRazonSocialVendedor != null ? facRazonSocialVendedor.hashCode() : 0);
        result = 31 * result + (facSecuencial != null ? facSecuencial.hashCode() : 0);
        result = 31 * result + (facTotalDescuento != null ? facTotalDescuento.hashCode() : 0);
        result = 31 * result + (facTotalSinImpuestos != null ? facTotalSinImpuestos.hashCode() : 0);
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (tipCodigo != null ? tipCodigo.hashCode() : 0);
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
