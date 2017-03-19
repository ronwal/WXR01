package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "perfil", schema = "public", catalog = "factura_ecuador")
public class PerfilEntity implements Serializable{
    private String prfCodigo;
    private String prfNombre;
    private List<DetalleMenuSystemEntity> detalleMenuSystem;
    private List<UsuarioEntity> usuarios;

    @Id
    @Column(name = "prf_codigo", nullable = false, length = 3)
    public String getPrfCodigo() {
        return prfCodigo;
    }

    public void setPrfCodigo(String prfCodigo) {
        this.prfCodigo = prfCodigo;
    }

    @Basic
    @Column(name = "prf_nombre", nullable = false, length = 50)
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
    public List<DetalleMenuSystemEntity> getDetalleMenuSystem() {
        return detalleMenuSystem;
    }

    public void setDetalleMenuSystem(List<DetalleMenuSystemEntity> detalleMenuSystems) {
        this.detalleMenuSystem = detalleMenuSystems;
    }

    @OneToMany(mappedBy = "perfil")
    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }
}
