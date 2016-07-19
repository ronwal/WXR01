package net.fecuador.persist.model.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@Table(name = "usuario", schema = "public", catalog = "factura_ecuador")
public class UsuarioEntity {
    private int usuCodigo;
    private boolean usuActivo;
    private String usuClave;
    private String usuIdentificacion;
    private String usuMail;
    private String usuNick;
    private String usuNombre;
    private String empCodigo;
    private String prfCodigo;
    private Collection<AuditoriaEntity> auditoriasByUsuCodigo;
    private EmpresaEntity empresaByEmpCodigo;
    private PerfilEntity perfilByPrfCodigo;

    @Id
    @Column(name = "usu_codigo", nullable = false, insertable = true, updatable = true)
    public int getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(int usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @Basic
    @Column(name = "usu_activo", nullable = false, insertable = true, updatable = true)
    public boolean isUsuActivo() {
        return usuActivo;
    }

    public void setUsuActivo(boolean usuActivo) {
        this.usuActivo = usuActivo;
    }

    @Basic
    @Column(name = "usu_clave", nullable = false, insertable = true, updatable = true, length = 250)
    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    @Basic
    @Column(name = "usu_identificacion", nullable = false, insertable = true, updatable = true, length = 13)
    public String getUsuIdentificacion() {
        return usuIdentificacion;
    }

    public void setUsuIdentificacion(String usuIdentificacion) {
        this.usuIdentificacion = usuIdentificacion;
    }

    @Basic
    @Column(name = "usu_mail", nullable = false, insertable = true, updatable = true, length = 50)
    public String getUsuMail() {
        return usuMail;
    }

    public void setUsuMail(String usuMail) {
        this.usuMail = usuMail;
    }

    @Basic
    @Column(name = "usu_nick", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUsuNick() {
        return usuNick;
    }

    public void setUsuNick(String usuNick) {
        this.usuNick = usuNick;
    }

    @Basic
    @Column(name = "usu_nombre", nullable = false, insertable = true, updatable = true, length = 150)
    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    @Basic
    @Column(name = "emp_codigo", nullable = true, insertable = true, updatable = true, length = 13)
    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Basic
    @Column(name = "prf_codigo", nullable = true, insertable = true, updatable = true, length = 3)
    public String getPrfCodigo() {
        return prfCodigo;
    }

    public void setPrfCodigo(String prfCodigo) {
        this.prfCodigo = prfCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (usuCodigo != that.usuCodigo) return false;
        if (usuActivo != that.usuActivo) return false;
        if (usuClave != null ? !usuClave.equals(that.usuClave) : that.usuClave != null) return false;
        if (usuIdentificacion != null ? !usuIdentificacion.equals(that.usuIdentificacion) : that.usuIdentificacion != null)
            return false;
        if (usuMail != null ? !usuMail.equals(that.usuMail) : that.usuMail != null) return false;
        if (usuNick != null ? !usuNick.equals(that.usuNick) : that.usuNick != null) return false;
        if (usuNombre != null ? !usuNombre.equals(that.usuNombre) : that.usuNombre != null) return false;
        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (prfCodigo != null ? !prfCodigo.equals(that.prfCodigo) : that.prfCodigo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usuCodigo;
        result = 31 * result + (usuActivo ? 1 : 0);
        result = 31 * result + (usuClave != null ? usuClave.hashCode() : 0);
        result = 31 * result + (usuIdentificacion != null ? usuIdentificacion.hashCode() : 0);
        result = 31 * result + (usuMail != null ? usuMail.hashCode() : 0);
        result = 31 * result + (usuNick != null ? usuNick.hashCode() : 0);
        result = 31 * result + (usuNombre != null ? usuNombre.hashCode() : 0);
        result = 31 * result + (empCodigo != null ? empCodigo.hashCode() : 0);
        result = 31 * result + (prfCodigo != null ? prfCodigo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usuarioByUsuCodigo")
    public Collection<AuditoriaEntity> getAuditoriasByUsuCodigo() {
        return auditoriasByUsuCodigo;
    }

    public void setAuditoriasByUsuCodigo(Collection<AuditoriaEntity> auditoriasByUsuCodigo) {
        this.auditoriasByUsuCodigo = auditoriasByUsuCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    public EmpresaEntity getEmpresaByEmpCodigo() {
        return empresaByEmpCodigo;
    }

    public void setEmpresaByEmpCodigo(EmpresaEntity empresaByEmpCodigo) {
        this.empresaByEmpCodigo = empresaByEmpCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "prf_codigo", referencedColumnName = "prf_codigo")
    public PerfilEntity getPerfilByPrfCodigo() {
        return perfilByPrfCodigo;
    }

    public void setPerfilByPrfCodigo(PerfilEntity perfilByPrfCodigo) {
        this.perfilByPrfCodigo = perfilByPrfCodigo;
    }
}
