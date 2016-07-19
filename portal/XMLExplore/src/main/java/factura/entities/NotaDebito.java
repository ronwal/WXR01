package factura.entities;
// Generated 13-dic-2013 0:40:01 by Hibernate Tools 3.2.1.GA

import ec.ste.factura.DatabaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * NotaDebito generated by hbm2java
 */
@Entity
@Table(name = "nota_debito", schema = "public")
public class NotaDebito extends DatabaseEntity implements java.io.Serializable {

    private int ndeCodigo;
    private Empresa empresa;
    private Tipo tipo;
    private String ndeNumAutorizacion;
    private String ndeFechaAutorizacion;
    private String ndeEstablecimiento;
    private String ndePuntoEmision;
    private int ndeSecuencial;
    private Date ndeFechaEmision;
    private String ndeIdentificacionComprador;
    private String ndeRazonSocialComprador;
    private String ndeNumDocModificado;
    private double ndeTotalSinImpuestos;

    public NotaDebito() {
    }

    public NotaDebito(int ndeCodigo, String ndeNumAutorizacion, String ndeFechaAutorizacion, String ndeEstablecimiento, String ndePuntoEmision, int ndeSecuencial, Date ndeFechaEmision, String ndeIdentificacionComprador, String ndeRazonSocialComprador, String ndeNumDocModificado, double ndeTotalSinImpuestos) {
        this.ndeCodigo = ndeCodigo;
        this.ndeNumAutorizacion = ndeNumAutorizacion;
        this.ndeFechaAutorizacion = ndeFechaAutorizacion;
        this.ndeEstablecimiento = ndeEstablecimiento;
        this.ndePuntoEmision = ndePuntoEmision;
        this.ndeSecuencial = ndeSecuencial;
        this.ndeFechaEmision = ndeFechaEmision;
        this.ndeIdentificacionComprador = ndeIdentificacionComprador;
        this.ndeRazonSocialComprador = ndeRazonSocialComprador;
        this.ndeNumDocModificado = ndeNumDocModificado;
        this.ndeTotalSinImpuestos = ndeTotalSinImpuestos;
    }

    public NotaDebito(int ndeCodigo, Empresa empresa, Tipo tipo, String ndeNumAutorizacion, String ndeFechaAutorizacion, String ndeEstablecimiento, String ndePuntoEmision, int ndeSecuencial, Date ndeFechaEmision, String ndeIdentificacionComprador, String ndeRazonSocialComprador, String ndeNumDocModificado, double ndeTotalSinImpuestos) {
        this.ndeCodigo = ndeCodigo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.ndeNumAutorizacion = ndeNumAutorizacion;
        this.ndeFechaAutorizacion = ndeFechaAutorizacion;
        this.ndeEstablecimiento = ndeEstablecimiento;
        this.ndePuntoEmision = ndePuntoEmision;
        this.ndeSecuencial = ndeSecuencial;
        this.ndeFechaEmision = ndeFechaEmision;
        this.ndeIdentificacionComprador = ndeIdentificacionComprador;
        this.ndeRazonSocialComprador = ndeRazonSocialComprador;
        this.ndeNumDocModificado = ndeNumDocModificado;
        this.ndeTotalSinImpuestos = ndeTotalSinImpuestos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nde_codigo", unique = true, nullable = false)
    public int getNdeCodigo() {
        return this.ndeCodigo;
    }

    public void setNdeCodigo(int ndeCodigo) {
        this.ndeCodigo = ndeCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_codigo")
    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tip_codigo")
    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Column(name = "nde_num_autorizacion", nullable = false, length = 100)
    public String getNdeNumAutorizacion() {
        return this.ndeNumAutorizacion;
    }

    public void setNdeNumAutorizacion(String ndeNumAutorizacion) {
        this.ndeNumAutorizacion = ndeNumAutorizacion;
    }

    @Column(name = "nde_fecha_autorizacion", nullable = false, length = 50)
    public String getNdeFechaAutorizacion() {
        return this.ndeFechaAutorizacion;
    }

    public void setNdeFechaAutorizacion(String ndeFechaAutorizacion) {
        this.ndeFechaAutorizacion = ndeFechaAutorizacion;
    }

    @Column(name = "nde_establecimiento", nullable = false, length = 3)
    public String getNdeEstablecimiento() {
        return this.ndeEstablecimiento;
    }

    public void setNdeEstablecimiento(String ndeEstablecimiento) {
        this.ndeEstablecimiento = ndeEstablecimiento;
    }

    @Column(name = "nde_punto_emision", nullable = false, length = 3)
    public String getNdePuntoEmision() {
        return this.ndePuntoEmision;
    }

    public void setNdePuntoEmision(String ndePuntoEmision) {
        this.ndePuntoEmision = ndePuntoEmision;
    }

    @Column(name = "nde_secuencial", nullable = false)
    public int getNdeSecuencial() {
        return this.ndeSecuencial;
    }

    public void setNdeSecuencial(int ndeSecuencial) {
        this.ndeSecuencial = ndeSecuencial;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "nde_fecha_emision", nullable = false, length = 13)
    public Date getNdeFechaEmision() {
        return this.ndeFechaEmision;
    }

    public void setNdeFechaEmision(Date ndeFechaEmision) {
        this.ndeFechaEmision = ndeFechaEmision;
    }

    @Column(name = "nde_identificacion_comprador", nullable = false, length = 13)
    public String getNdeIdentificacionComprador() {
        return this.ndeIdentificacionComprador;
    }

    public void setNdeIdentificacionComprador(String ndeIdentificacionComprador) {
        this.ndeIdentificacionComprador = ndeIdentificacionComprador;
    }

    @Column(name = "nde_razon_social_comprador", nullable = false, length = 250)
    public String getNdeRazonSocialComprador() {
        return this.ndeRazonSocialComprador;
    }

    public void setNdeRazonSocialComprador(String ndeRazonSocialComprador) {
        this.ndeRazonSocialComprador = ndeRazonSocialComprador;
    }

    @Column(name = "nde_num_doc_modificado", nullable = false, length = 25)
    public String getNdeNumDocModificado() {
        return this.ndeNumDocModificado;
    }

    public void setNdeNumDocModificado(String ndeNumDocModificado) {
        this.ndeNumDocModificado = ndeNumDocModificado;
    }

    @Column(name = "nde_total_sin_impuestos", nullable = false, precision = 17, scale = 17)
    public double getNdeTotalSinImpuestos() {
        return this.ndeTotalSinImpuestos;
    }

    public void setNdeTotalSinImpuestos(double ndeTotalSinImpuestos) {
        this.ndeTotalSinImpuestos = ndeTotalSinImpuestos;
    }
}
