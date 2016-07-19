package ec.ste.factura.entities;
// Generated 13-dic-2013 0:40:01 by Hibernate Tools 3.2.1.GA

import ec.ste.factura.DatabaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity

@Table(name = "usuario", schema = "public")
public class Usuario extends DatabaseEntity implements java.io.Serializable {

    private int usuCodigo;
    private Empresa empresa;
    private Perfil perfil;
    private String usuIdentificacion;
    private String usuNombre;
    private String usuMail="";
    private String usuNick;
    private String usuClave;
    private boolean usuActivo;

    public Usuario() {
        perfil=new Perfil();
    }

    public Usuario(int usuCodigo, String usuIdentificacion, String usuNombre, String usuMail, String usuNick, String usuClave, boolean usuActivo) {
        this.usuCodigo = usuCodigo;
        this.usuIdentificacion = usuIdentificacion;
        this.usuNombre = usuNombre;
        this.usuMail = usuMail;
        this.usuNick = usuNick;
        this.usuClave = usuClave;
        this.usuActivo = usuActivo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_codigo", unique = true, nullable = false)
    public int getUsuCodigo() {
        return this.usuCodigo;
    }

    public void setUsuCodigo(int usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_codigo")
    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prf_codigo")
    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Column(name = "usu_identificacion", nullable = false, length = 13)
    public String getUsuIdentificacion() {
        return this.usuIdentificacion;
    }

    public void setUsuIdentificacion(String usuIdentificacion) {
        this.usuIdentificacion = usuIdentificacion;
    }

    @Column(name = "usu_nombre", nullable = false, length = 150)
    public String getUsuNombre() {
        return this.usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    @Column(name = "usu_mail", nullable = false, length = 300)
    public String getUsuMail() {
        return this.usuMail;
    }

    public void setUsuMail(String usuMail) {
        this.usuMail = usuMail;
    }

    @Column(name = "usu_nick", nullable = false, length = 20)
    public String getUsuNick() {
        return this.usuNick;
    }

    public void setUsuNick(String usuNick) {
        this.usuNick = usuNick;
    }

    @Column(name = "usu_clave", nullable = false, length = 250)
    public String getUsuClave() {
        return this.usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    @Column(name = "usu_activo", nullable = false)
    public boolean isUsuActivo() {
        return this.usuActivo;
    }

    public void setUsuActivo(boolean usuActivo) {
        this.usuActivo = usuActivo;
    }
}