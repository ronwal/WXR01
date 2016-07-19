package net.fecuador.persist.model.entities;

import javax.persistence.*;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@Table(name = "detalle_retencion", schema = "public", catalog = "factura_ecuador")
public class DetalleRetencionEntity {
    private int dcrCodigo;
    private double dcrBaseImponible;
    private String dcrCodigoImpuesto;
    private String dcrCodigoRetencion;
    private String dcrCodigoSustento;
    private String dcrDocumentoSustento;
    private double dcrPorcentaje;
    private double dcrValorRetenido;
    private Integer retCodigo;

    @Id
    @Column(name = "dcr_codigo", nullable = false, insertable = true, updatable = true)
    public int getDcrCodigo() {
        return dcrCodigo;
    }

    public void setDcrCodigo(int dcrCodigo) {
        this.dcrCodigo = dcrCodigo;
    }

    @Basic
    @Column(name = "dcr_base_imponible", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getDcrBaseImponible() {
        return dcrBaseImponible;
    }

    public void setDcrBaseImponible(double dcrBaseImponible) {
        this.dcrBaseImponible = dcrBaseImponible;
    }

    @Basic
    @Column(name = "dcr_codigo_impuesto", nullable = false, insertable = true, updatable = true, length = 1)
    public String getDcrCodigoImpuesto() {
        return dcrCodigoImpuesto;
    }

    public void setDcrCodigoImpuesto(String dcrCodigoImpuesto) {
        this.dcrCodigoImpuesto = dcrCodigoImpuesto;
    }

    @Basic
    @Column(name = "dcr_codigo_retencion", nullable = false, insertable = true, updatable = true, length = 5)
    public String getDcrCodigoRetencion() {
        return dcrCodigoRetencion;
    }

    public void setDcrCodigoRetencion(String dcrCodigoRetencion) {
        this.dcrCodigoRetencion = dcrCodigoRetencion;
    }

    @Basic
    @Column(name = "dcr_codigo_sustento", nullable = false, insertable = true, updatable = true, length = 2)
    public String getDcrCodigoSustento() {
        return dcrCodigoSustento;
    }

    public void setDcrCodigoSustento(String dcrCodigoSustento) {
        this.dcrCodigoSustento = dcrCodigoSustento;
    }

    @Basic
    @Column(name = "dcr_documento_sustento", nullable = false, insertable = true, updatable = true, length = 15)
    public String getDcrDocumentoSustento() {
        return dcrDocumentoSustento;
    }

    public void setDcrDocumentoSustento(String dcrDocumentoSustento) {
        this.dcrDocumentoSustento = dcrDocumentoSustento;
    }

    @Basic
    @Column(name = "dcr_porcentaje", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getDcrPorcentaje() {
        return dcrPorcentaje;
    }

    public void setDcrPorcentaje(double dcrPorcentaje) {
        this.dcrPorcentaje = dcrPorcentaje;
    }

    @Basic
    @Column(name = "dcr_valor_retenido", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getDcrValorRetenido() {
        return dcrValorRetenido;
    }

    public void setDcrValorRetenido(double dcrValorRetenido) {
        this.dcrValorRetenido = dcrValorRetenido;
    }

    @Basic
    @Column(name = "ret_codigo", nullable = true, insertable = true, updatable = true)
    public Integer getRetCodigo() {
        return retCodigo;
    }

    public void setRetCodigo(Integer retCodigo) {
        this.retCodigo = retCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleRetencionEntity that = (DetalleRetencionEntity) o;

        if (dcrCodigo != that.dcrCodigo) return false;
        if (Double.compare(that.dcrBaseImponible, dcrBaseImponible) != 0) return false;
        if (Double.compare(that.dcrPorcentaje, dcrPorcentaje) != 0) return false;
        if (Double.compare(that.dcrValorRetenido, dcrValorRetenido) != 0) return false;
        if (dcrCodigoImpuesto != null ? !dcrCodigoImpuesto.equals(that.dcrCodigoImpuesto) : that.dcrCodigoImpuesto != null)
            return false;
        if (dcrCodigoRetencion != null ? !dcrCodigoRetencion.equals(that.dcrCodigoRetencion) : that.dcrCodigoRetencion != null)
            return false;
        if (dcrCodigoSustento != null ? !dcrCodigoSustento.equals(that.dcrCodigoSustento) : that.dcrCodigoSustento != null)
            return false;
        if (dcrDocumentoSustento != null ? !dcrDocumentoSustento.equals(that.dcrDocumentoSustento) : that.dcrDocumentoSustento != null)
            return false;
        if (retCodigo != null ? !retCodigo.equals(that.retCodigo) : that.retCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dcrCodigo;
        temp = Double.doubleToLongBits(dcrBaseImponible);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dcrCodigoImpuesto != null ? dcrCodigoImpuesto.hashCode() : 0);
        result = 31 * result + (dcrCodigoRetencion != null ? dcrCodigoRetencion.hashCode() : 0);
        result = 31 * result + (dcrCodigoSustento != null ? dcrCodigoSustento.hashCode() : 0);
        result = 31 * result + (dcrDocumentoSustento != null ? dcrDocumentoSustento.hashCode() : 0);
        temp = Double.doubleToLongBits(dcrPorcentaje);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dcrValorRetenido);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (retCodigo != null ? retCodigo.hashCode() : 0);
        return result;
    }
}
