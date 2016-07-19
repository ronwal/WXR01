package net.fecuador.persist.model.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@Table(name = "perfil", schema = "public", catalog = "factura_ecuador")
public class PerfilEntity {
    private String prfCodigo;
    private String prfNombre;
    private Collection<UsuarioEntity> usuariosByPrfCodigo;

    @Id
    @Column(name = "prf_codigo", nullable = false, insertable = true, updatable = true, length = 3)
    public String getPrfCodigo() {
        return prfCodigo;
    }

    public void setPrfCodigo(String prfCodigo) {
        this.prfCodigo = prfCodigo;
    }

    @Basic
    @Column(name = "prf_nombre", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPrfNombre() {
        return prfNombre;
    }

    public void setPrfNombre(String prfNombre) {
        this.prfNombre = prfNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerfilEntity that = (PerfilEntity) o;

        if (prfCodigo != null ? !prfCodigo.equals(that.prfCodigo) : that.prfCodigo != null) return false;
        if (prfNombre != null ? !prfNombre.equals(that.prfNombre) : that.prfNombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prfCodigo != null ? prfCodigo.hashCode() : 0;
        result = 31 * result + (prfNombre != null ? prfNombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "perfilByPrfCodigo")
    public Collection<UsuarioEntity> getUsuariosByPrfCodigo() {
        return usuariosByPrfCodigo;
    }

    public void setUsuariosByPrfCodigo(Collection<UsuarioEntity> usuariosByPrfCodigo) {
        this.usuariosByPrfCodigo = usuariosByPrfCodigo;
    }
}
