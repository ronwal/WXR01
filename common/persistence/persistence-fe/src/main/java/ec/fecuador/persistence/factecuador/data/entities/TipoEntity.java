package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "tipo", schema = "public", catalog = "factura_ecuador")
public class TipoEntity implements Serializable {
    private String tipCodigo;
    private String tipNombre;
    private Collection<FacturaEntity> facturasByTipCodigo;
    private Collection<GuiaRemisionEntity> guiaRemisionsByTipCodigo;
    private Collection<NotaCreditoEntity> notaCreditosByTipCodigo;
    private Collection<NotaDebitoEntity> notaDebitosByTipCodigo;
    private Collection<RetencionEntity> retencionsByTipCodigo;

    @Id
    @Column(name = "tip_codigo", nullable = false, length = 3)
    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    @Basic
    @Column(name = "tip_nombre", nullable = false, length = 50)
    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoEntity that = (TipoEntity) o;

        if (tipCodigo != null ? !tipCodigo.equals(that.tipCodigo) : that.tipCodigo != null) return false;
        if (tipNombre != null ? !tipNombre.equals(that.tipNombre) : that.tipNombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tipCodigo != null ? tipCodigo.hashCode() : 0;
        result = 31 * result + (tipNombre != null ? tipNombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoByTipCodigo")
    public Collection<FacturaEntity> getFacturasByTipCodigo() {
        return facturasByTipCodigo;
    }

    public void setFacturasByTipCodigo(Collection<FacturaEntity> facturasByTipCodigo) {
        this.facturasByTipCodigo = facturasByTipCodigo;
    }

    @OneToMany(mappedBy = "tipoByTipCodigo")
    public Collection<GuiaRemisionEntity> getGuiaRemisionsByTipCodigo() {
        return guiaRemisionsByTipCodigo;
    }

    public void setGuiaRemisionsByTipCodigo(Collection<GuiaRemisionEntity> guiaRemisionsByTipCodigo) {
        this.guiaRemisionsByTipCodigo = guiaRemisionsByTipCodigo;
    }

    @OneToMany(mappedBy = "tipoByTipCodigo")
    public Collection<NotaCreditoEntity> getNotaCreditosByTipCodigo() {
        return notaCreditosByTipCodigo;
    }

    public void setNotaCreditosByTipCodigo(Collection<NotaCreditoEntity> notaCreditosByTipCodigo) {
        this.notaCreditosByTipCodigo = notaCreditosByTipCodigo;
    }

    @OneToMany(mappedBy = "tipoByTipCodigo")
    public Collection<NotaDebitoEntity> getNotaDebitosByTipCodigo() {
        return notaDebitosByTipCodigo;
    }

    public void setNotaDebitosByTipCodigo(Collection<NotaDebitoEntity> notaDebitosByTipCodigo) {
        this.notaDebitosByTipCodigo = notaDebitosByTipCodigo;
    }

    @OneToMany(mappedBy = "tipoByTipCodigo")
    public Collection<RetencionEntity> getRetencionsByTipCodigo() {
        return retencionsByTipCodigo;
    }

    public void setRetencionsByTipCodigo(Collection<RetencionEntity> retencionsByTipCodigo) {
        this.retencionsByTipCodigo = retencionsByTipCodigo;
    }
}
