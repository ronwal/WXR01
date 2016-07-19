package net.fecuador.persist.model.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Latinus on 17/3/16.
 */
@Entity
@Table(name = "empresa", schema = "public", catalog = "factura_ecuador")
public class EmpresaEntity {
    private String empCodigo;
    private String empDireccion;
    private String empMail;
    private String empRazonSocial;
    private String empTelefono;
    private String empUrl;
    private Collection<UsuarioEntity> usuariosByEmpCodigo;

    @Id
    @Column(name = "emp_codigo", nullable = false, insertable = true, updatable = true, length = 13)
    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Basic
    @Column(name = "emp_direccion", nullable = false, insertable = true, updatable = true, length = 250)
    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    @Basic
    @Column(name = "emp_mail", nullable = false, insertable = true, updatable = true, length = 100)
    public String getEmpMail() {
        return empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    @Basic
    @Column(name = "emp_razon_social", nullable = false, insertable = true, updatable = true, length = 250)
    public String getEmpRazonSocial() {
        return empRazonSocial;
    }

    public void setEmpRazonSocial(String empRazonSocial) {
        this.empRazonSocial = empRazonSocial;
    }

    @Basic
    @Column(name = "emp_telefono", nullable = false, insertable = true, updatable = true, length = 20)
    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    @Basic
    @Column(name = "emp_url", nullable = true, insertable = true, updatable = true, length = 50)
    public String getEmpUrl() {
        return empUrl;
    }

    public void setEmpUrl(String empUrl) {
        this.empUrl = empUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpresaEntity that = (EmpresaEntity) o;

        if (empCodigo != null ? !empCodigo.equals(that.empCodigo) : that.empCodigo != null) return false;
        if (empDireccion != null ? !empDireccion.equals(that.empDireccion) : that.empDireccion != null) return false;
        if (empMail != null ? !empMail.equals(that.empMail) : that.empMail != null) return false;
        if (empRazonSocial != null ? !empRazonSocial.equals(that.empRazonSocial) : that.empRazonSocial != null)
            return false;
        if (empTelefono != null ? !empTelefono.equals(that.empTelefono) : that.empTelefono != null) return false;
        if (empUrl != null ? !empUrl.equals(that.empUrl) : that.empUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empCodigo != null ? empCodigo.hashCode() : 0;
        result = 31 * result + (empDireccion != null ? empDireccion.hashCode() : 0);
        result = 31 * result + (empMail != null ? empMail.hashCode() : 0);
        result = 31 * result + (empRazonSocial != null ? empRazonSocial.hashCode() : 0);
        result = 31 * result + (empTelefono != null ? empTelefono.hashCode() : 0);
        result = 31 * result + (empUrl != null ? empUrl.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "empresaByEmpCodigo")
    public Collection<UsuarioEntity> getUsuariosByEmpCodigo() {
        return usuariosByEmpCodigo;
    }

    public void setUsuariosByEmpCodigo(Collection<UsuarioEntity> usuariosByEmpCodigo) {
        this.usuariosByEmpCodigo = usuariosByEmpCodigo;
    }
}
