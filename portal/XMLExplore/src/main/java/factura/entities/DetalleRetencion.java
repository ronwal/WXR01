/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.entities;

import ec.ste.factura.DatabaseEntity;

import javax.persistence.*;

/**
 *
 * @author German17
 */
@Entity
@Table(name = "detalle_retencion", schema = "public")
public class DetalleRetencion extends DatabaseEntity implements java.io.Serializable {

    private int dcrCodigo;
    private Retencion retencion;
    private String dcrCodigoImpuesto;
    private String dcrCodigoRetencion;
    private String dcrCodigoSustento;
    private String dcrDocumentoSustento;
    private double dcrBaseImponible;
    private double dcrPorcentaje;
    private double dcrValorRetenido;

    public DetalleRetencion() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dcr_codigo", unique = true, nullable = false)
    public int getDcrCodigo() {
        return dcrCodigo;
    }

    public void setDcrCodigo(int dcrCodigo) {
        this.dcrCodigo = dcrCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ret_codigo")
    public Retencion getRetencion() {
        return retencion;
    }

    public void setRetencion(Retencion retencion) {
        this.retencion = retencion;
    }

    @Column(name = "dcr_codigo_impuesto", nullable = false, length = 1)
    public String getDcrCodigoImpuesto() {
        return dcrCodigoImpuesto;
    }

    public void setDcrCodigoImpuesto(String dcrCodigoImpuesto) {
        this.dcrCodigoImpuesto = dcrCodigoImpuesto;
    }

    @Column(name = "dcr_codigo_retencion", nullable = false, length = 5)
    public String getDcrCodigoRetencion() {
        return dcrCodigoRetencion;
    }

    public void setDcrCodigoRetencion(String dcrCodigoRetencion) {
        this.dcrCodigoRetencion = dcrCodigoRetencion;
    }

    @Column(name = "dcr_codigo_sustento", nullable = false, length = 2)
    public String getDcrCodigoSustento() {
        return dcrCodigoSustento;
    }

    public void setDcrCodigoSustento(String dcrCodigoSustento) {
        this.dcrCodigoSustento = dcrCodigoSustento;
    }

    @Column(name = "dcr_documento_sustento", nullable = false, length = 15)
    public String getDcrDocumentoSustento() {
        return dcrDocumentoSustento;
    }

    public void setDcrDocumentoSustento(String dcrDocumentoSustento) {
        this.dcrDocumentoSustento = dcrDocumentoSustento;
    }

    @Column(name = "dcr_base_imponible", nullable = false, precision = 17, scale = 17)
    public double getDcrBaseImponible() {
        return dcrBaseImponible;
    }

    public void setDcrBaseImponible(double dcrBaseImponible) {
        this.dcrBaseImponible = dcrBaseImponible;
    }

    @Column(name = "dcr_porcentaje", nullable = false, precision = 17, scale = 17)
    public double getDcrPorcentaje() {
        return dcrPorcentaje;
    }

    public void setDcrPorcentaje(double dcrPorcentaje) {
        this.dcrPorcentaje = dcrPorcentaje;
    }

    @Column(name = "dcr_valor_retenido", nullable = false, precision = 17, scale = 17)
    public double getDcrValorRetenido() {
        return dcrValorRetenido;
    }

    public void setDcrValorRetenido(double dcrValorRetenido) {
        this.dcrValorRetenido = dcrValorRetenido;
    }

}
