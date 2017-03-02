package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "auditoria", schema = "public", catalog = "factura_ecuador")
public class AuditoriaEntity {
    private Integer audCodigo;
    private Timestamp audFecha;
    private Integer usuCodigo;
    private UsuarioEntity usuarioByUsuCodigo;
    private Collection<DetalleAuditoriaEntity> detalleAuditoriasByAudCodigo;

    @Id
    @Column(name = "aud_codigo", nullable = false)
    public Integer getAudCodigo() {
        return audCodigo;
    }

    public void setAudCodigo(Integer audCodigo) {
        this.audCodigo = audCodigo;
    }

    @Basic
    @Column(name = "aud_fecha", nullable = false)
    public Timestamp getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Timestamp audFecha) {
        this.audFecha = audFecha;
    }

    @Basic
    @Column(name = "usu_codigo", nullable = true)
    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditoriaEntity that = (AuditoriaEntity) o;

        if (audCodigo != null ? !audCodigo.equals(that.audCodigo) : that.audCodigo != null) return false;
        if (audFecha != null ? !audFecha.equals(that.audFecha) : that.audFecha != null) return false;
        if (usuCodigo != null ? !usuCodigo.equals(that.usuCodigo) : that.usuCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = audCodigo != null ? audCodigo.hashCode() : 0;
        result = 31 * result + (audFecha != null ? audFecha.hashCode() : 0);
        result = 31 * result + (usuCodigo != null ? usuCodigo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "usu_codigo", referencedColumnName = "usu_codigo")
    public UsuarioEntity getUsuarioByUsuCodigo() {
        return usuarioByUsuCodigo;
    }

    public void setUsuarioByUsuCodigo(UsuarioEntity usuarioByUsuCodigo) {
        this.usuarioByUsuCodigo = usuarioByUsuCodigo;
    }

    @OneToMany(mappedBy = "auditoriaByAudCodigo")
    public Collection<DetalleAuditoriaEntity> getDetalleAuditoriasByAudCodigo() {
        return detalleAuditoriasByAudCodigo;
    }

    public void setDetalleAuditoriasByAudCodigo(Collection<DetalleAuditoriaEntity> detalleAuditoriasByAudCodigo) {
        this.detalleAuditoriasByAudCodigo = detalleAuditoriasByAudCodigo;
    }
}
