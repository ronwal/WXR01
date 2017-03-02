package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "detalle_auditoria", schema = "public", catalog = "factura_ecuador")
public class DetalleAuditoriaEntity {
    private Integer dauCodigo;
    private String dauAccion;
    private Integer dauCodigoDocumento;
    private Timestamp dauFecha;
    private Integer audCodigo;
    private String dauDetalle;
    private String dauTipoDocumento;
    private AuditoriaEntity auditoriaByAudCodigo;

    @Id
    @Column(name = "dau_codigo", nullable = false)
    public Integer getDauCodigo() {
        return dauCodigo;
    }

    public void setDauCodigo(Integer dauCodigo) {
        this.dauCodigo = dauCodigo;
    }

    @Basic
    @Column(name = "dau_accion", nullable = false, length = 3)
    public String getDauAccion() {
        return dauAccion;
    }

    public void setDauAccion(String dauAccion) {
        this.dauAccion = dauAccion;
    }

    @Basic
    @Column(name = "dau_codigo_documento", nullable = false)
    public Integer getDauCodigoDocumento() {
        return dauCodigoDocumento;
    }

    public void setDauCodigoDocumento(Integer dauCodigoDocumento) {
        this.dauCodigoDocumento = dauCodigoDocumento;
    }

    @Basic
    @Column(name = "dau_fecha", nullable = false)
    public Timestamp getDauFecha() {
        return dauFecha;
    }

    public void setDauFecha(Timestamp dauFecha) {
        this.dauFecha = dauFecha;
    }

    @Basic
    @Column(name = "aud_codigo", nullable = true)
    public Integer getAudCodigo() {
        return audCodigo;
    }

    public void setAudCodigo(Integer audCodigo) {
        this.audCodigo = audCodigo;
    }

    @Basic
    @Column(name = "dau_detalle", nullable = true, length = 250)
    public String getDauDetalle() {
        return dauDetalle;
    }

    public void setDauDetalle(String dauDetalle) {
        this.dauDetalle = dauDetalle;
    }

    @Basic
    @Column(name = "dau_tipo_documento", nullable = false, length = 50)
    public String getDauTipoDocumento() {
        return dauTipoDocumento;
    }

    public void setDauTipoDocumento(String dauTipoDocumento) {
        this.dauTipoDocumento = dauTipoDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleAuditoriaEntity that = (DetalleAuditoriaEntity) o;

        if (dauCodigo != null ? !dauCodigo.equals(that.dauCodigo) : that.dauCodigo != null) return false;
        if (dauAccion != null ? !dauAccion.equals(that.dauAccion) : that.dauAccion != null) return false;
        if (dauCodigoDocumento != null ? !dauCodigoDocumento.equals(that.dauCodigoDocumento) : that.dauCodigoDocumento != null)
            return false;
        if (dauFecha != null ? !dauFecha.equals(that.dauFecha) : that.dauFecha != null) return false;
        if (audCodigo != null ? !audCodigo.equals(that.audCodigo) : that.audCodigo != null) return false;
        if (dauDetalle != null ? !dauDetalle.equals(that.dauDetalle) : that.dauDetalle != null) return false;
        if (dauTipoDocumento != null ? !dauTipoDocumento.equals(that.dauTipoDocumento) : that.dauTipoDocumento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dauCodigo != null ? dauCodigo.hashCode() : 0;
        result = 31 * result + (dauAccion != null ? dauAccion.hashCode() : 0);
        result = 31 * result + (dauCodigoDocumento != null ? dauCodigoDocumento.hashCode() : 0);
        result = 31 * result + (dauFecha != null ? dauFecha.hashCode() : 0);
        result = 31 * result + (audCodigo != null ? audCodigo.hashCode() : 0);
        result = 31 * result + (dauDetalle != null ? dauDetalle.hashCode() : 0);
        result = 31 * result + (dauTipoDocumento != null ? dauTipoDocumento.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "aud_codigo", referencedColumnName = "aud_codigo")
    public AuditoriaEntity getAuditoriaByAudCodigo() {
        return auditoriaByAudCodigo;
    }

    public void setAuditoriaByAudCodigo(AuditoriaEntity auditoriaByAudCodigo) {
        this.auditoriaByAudCodigo = auditoriaByAudCodigo;
    }
}
