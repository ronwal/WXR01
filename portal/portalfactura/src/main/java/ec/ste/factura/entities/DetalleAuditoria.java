package ec.ste.factura.entities;
// Generated 13-dic-2013 0:40:01 by Hibernate Tools 3.2.1.GA

import ec.ste.factura.DatabaseEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DetalleAuditoria generated by hbm2java
 */
@Entity
@Table(name = "detalle_auditoria", schema = "public")
public class DetalleAuditoria extends DatabaseEntity implements java.io.Serializable {

    private int dauCodigo;
    private Auditoria auditoria;
    private Date dauFecha;
    private String dauAccion;
    private String dauTipoDocumento;
    private int dauCodigoDocumento;
    private String dauDetalle;

    public DetalleAuditoria() {
    }

    public DetalleAuditoria(int dauCodigo, Date dauFecha, String dauAccion, String dauTipoDocumento, int dauCodigoDocumento) {
        this.dauCodigo = dauCodigo;
        this.dauFecha = dauFecha;
        this.dauAccion = dauAccion;
        this.dauTipoDocumento = dauTipoDocumento;
        this.dauCodigoDocumento = dauCodigoDocumento;
    }

    public DetalleAuditoria(int dauCodigo, Auditoria auditoria, Date dauFecha, String dauAccion, String dauTipoDocumento, int dauCodigoDocumento) {
        this.dauCodigo = dauCodigo;
        this.auditoria = auditoria;
        this.dauFecha = dauFecha;
        this.dauAccion = dauAccion;
        this.dauTipoDocumento = dauTipoDocumento;
        this.dauCodigoDocumento = dauCodigoDocumento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dau_codigo", unique = true, nullable = false)
    public int getDauCodigo() {
        return this.dauCodigo;
    }

    public void setDauCodigo(int dauCodigo) {
        this.dauCodigo = dauCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aud_codigo")
    public Auditoria getAuditoria() {
        return this.auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dau_fecha", nullable = false, length = 13)
    public Date getDauFecha() {
        return this.dauFecha;
    }

    public void setDauFecha(Date dauFecha) {
        this.dauFecha = dauFecha;
    }

    @Column(name = "dau_accion", nullable = false, length = 3)
    public String getDauAccion() {
        return this.dauAccion;
    }

    public void setDauAccion(String dauAccion) {
        this.dauAccion = dauAccion;
    }

    @Column(name = "dau_tipo_documento", nullable = false, length = 50)
    public String getDauTipoDocumento() {
        return this.dauTipoDocumento;
    }

    public void setDauTipoDocumento(String dauTipoDocumento) {
        this.dauTipoDocumento = dauTipoDocumento;
    }

    @Column(name = "dau_codigo_documento", nullable = false)
    public int getDauCodigoDocumento() {
        return this.dauCodigoDocumento;
    }

    public void setDauCodigoDocumento(int dauCodigoDocumento) {
        this.dauCodigoDocumento = dauCodigoDocumento;
    }

    @Column(name = "dau_detalle", length = 250)
    public String getDauDetalle() {
        return dauDetalle;
    }

    public void setDauDetalle(String dauDetalle) {
        this.dauDetalle = dauDetalle;
    }
    
    
}