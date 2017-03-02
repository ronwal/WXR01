package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "detalle_retencion", schema = "public", catalog = "factura_ecuador")
public class DetalleRetencionEntity {
    private Integer dcrCodigo;
    private Double dcrBaseImponible;
    private String dcrCodigoImpuesto;
    private String dcrCodigoRetencion;
    private String dcrCodigoSustento;
    private String dcrDocumentoSustento;
    private Double dcrPorcentaje;
    private Double dcrValorRetenido;
    private Integer retCodigo;
    private RetencionEntity retencionByRetCodigo;

    @Id
    @Column(name = "dcr_codigo", nullable = false)
    public Integer getDcrCodigo() {
        return dcrCodigo;
    }

    public void setDcrCodigo(Integer dcrCodigo) {
        this.dcrCodigo = dcrCodigo;
    }

    @Basic
    @Column(name = "dcr_base_imponible", nullable = false, precision = 0)
    public Double getDcrBaseImponible() {
        return dcrBaseImponible;
    }

    public void setDcrBaseImponible(Double dcrBaseImponible) {
        this.dcrBaseImponible = dcrBaseImponible;
    }

    @Basic
    @Column(name = "dcr_codigo_impuesto", nullable = false, length = -1)
    public String getDcrCodigoImpuesto() {
        return dcrCodigoImpuesto;
    }

    public void setDcrCodigoImpuesto(String dcrCodigoImpuesto) {
        this.dcrCodigoImpuesto = dcrCodigoImpuesto;
    }

    @Basic
    @Column(name = "dcr_codigo_retencion", nullable = false, length = 5)
    public String getDcrCodigoRetencion() {
        return dcrCodigoRetencion;
    }

    public void setDcrCodigoRetencion(String dcrCodigoRetencion) {
        this.dcrCodigoRetencion = dcrCodigoRetencion;
    }

    @Basic
    @Column(name = "dcr_codigo_sustento", nullable = false, length = 2)
    public String getDcrCodigoSustento() {
        return dcrCodigoSustento;
    }

    public void setDcrCodigoSustento(String dcrCodigoSustento) {
        this.dcrCodigoSustento = dcrCodigoSustento;
    }

    @Basic
    @Column(name = "dcr_documento_sustento", nullable = false, length = 15)
    public String getDcrDocumentoSustento() {
        return dcrDocumentoSustento;
    }

    public void setDcrDocumentoSustento(String dcrDocumentoSustento) {
        this.dcrDocumentoSustento = dcrDocumentoSustento;
    }

    @Basic
    @Column(name = "dcr_porcentaje", nullable = false, precision = 0)
    public Double getDcrPorcentaje() {
        return dcrPorcentaje;
    }

    public void setDcrPorcentaje(Double dcrPorcentaje) {
        this.dcrPorcentaje = dcrPorcentaje;
    }

    @Basic
    @Column(name = "dcr_valor_retenido", nullable = false, precision = 0)
    public Double getDcrValorRetenido() {
        return dcrValorRetenido;
    }

    public void setDcrValorRetenido(Double dcrValorRetenido) {
        this.dcrValorRetenido = dcrValorRetenido;
    }

    @Basic
    @Column(name = "ret_codigo", nullable = true)
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

        if (dcrCodigo != null ? !dcrCodigo.equals(that.dcrCodigo) : that.dcrCodigo != null) return false;
        if (dcrBaseImponible != null ? !dcrBaseImponible.equals(that.dcrBaseImponible) : that.dcrBaseImponible != null)
            return false;
        if (dcrCodigoImpuesto != null ? !dcrCodigoImpuesto.equals(that.dcrCodigoImpuesto) : that.dcrCodigoImpuesto != null)
            return false;
        if (dcrCodigoRetencion != null ? !dcrCodigoRetencion.equals(that.dcrCodigoRetencion) : that.dcrCodigoRetencion != null)
            return false;
        if (dcrCodigoSustento != null ? !dcrCodigoSustento.equals(that.dcrCodigoSustento) : that.dcrCodigoSustento != null)
            return false;
        if (dcrDocumentoSustento != null ? !dcrDocumentoSustento.equals(that.dcrDocumentoSustento) : that.dcrDocumentoSustento != null)
            return false;
        if (dcrPorcentaje != null ? !dcrPorcentaje.equals(that.dcrPorcentaje) : that.dcrPorcentaje != null)
            return false;
        if (dcrValorRetenido != null ? !dcrValorRetenido.equals(that.dcrValorRetenido) : that.dcrValorRetenido != null)
            return false;
        if (retCodigo != null ? !retCodigo.equals(that.retCodigo) : that.retCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dcrCodigo != null ? dcrCodigo.hashCode() : 0;
        result = 31 * result + (dcrBaseImponible != null ? dcrBaseImponible.hashCode() : 0);
        result = 31 * result + (dcrCodigoImpuesto != null ? dcrCodigoImpuesto.hashCode() : 0);
        result = 31 * result + (dcrCodigoRetencion != null ? dcrCodigoRetencion.hashCode() : 0);
        result = 31 * result + (dcrCodigoSustento != null ? dcrCodigoSustento.hashCode() : 0);
        result = 31 * result + (dcrDocumentoSustento != null ? dcrDocumentoSustento.hashCode() : 0);
        result = 31 * result + (dcrPorcentaje != null ? dcrPorcentaje.hashCode() : 0);
        result = 31 * result + (dcrValorRetenido != null ? dcrValorRetenido.hashCode() : 0);
        result = 31 * result + (retCodigo != null ? retCodigo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ret_codigo", referencedColumnName = "ret_codigo")
    public RetencionEntity getRetencionByRetCodigo() {
        return retencionByRetCodigo;
    }

    public void setRetencionByRetCodigo(RetencionEntity retencionByRetCodigo) {
        this.retencionByRetCodigo = retencionByRetCodigo;
    }
}
