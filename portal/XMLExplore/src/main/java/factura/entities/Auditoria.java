package factura.entities;
// Generated 13-dic-2013 0:40:01 by Hibernate Tools 3.2.1.GA

import ec.ste.factura.DatabaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Auditoria generated by hbm2java
 */
@Entity
@Table(name = "auditoria", schema = "public")
public class Auditoria extends DatabaseEntity implements java.io.Serializable {

    private int audCodigo;
    private Usuario usuario;
    private Date audFecha;

    public Auditoria() {
    }

    public Auditoria(int audCodigo, Date audFecha) {
        this.audCodigo = audCodigo;
        this.audFecha = audFecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aud_codigo", unique = true, nullable = false)
    public int getAudCodigo() {
        return this.audCodigo;
    }

    public void setAudCodigo(int audCodigo) {
        this.audCodigo = audCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usu_codigo")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "aud_fecha", nullable = false, length = 13)
    public Date getAudFecha() {
        return this.audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }
}