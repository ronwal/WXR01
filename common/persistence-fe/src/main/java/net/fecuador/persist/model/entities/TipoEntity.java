package net.fecuador.persist.model.entities;

import javax.persistence.*;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@Table(name = "tipo", schema = "public", catalog = "factura_ecuador")
public class TipoEntity {
    private String tipCodigo;
    private String tipNombre;

    @Id
    @Column(name = "tip_codigo", nullable = false, insertable = true, updatable = true, length = 3)
    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    @Basic
    @Column(name = "tip_nombre", nullable = false, insertable = true, updatable = true, length = 50)
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
}
