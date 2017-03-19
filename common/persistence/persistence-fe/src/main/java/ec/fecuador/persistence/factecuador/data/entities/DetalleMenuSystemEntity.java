package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "detalle_menu_system", schema = "public", catalog = "factura_ecuador")
public class DetalleMenuSystemEntity implements Serializable {
    private Integer idDetalleMenu;
    private Integer idMenu;
    private String prfCodigo;
    private Date fechaCrea;
    private Integer userCrea;
    private MenuSystemEntity menuSystemByIdMenu;
    private PerfilEntity perfilByPrfCodigo;

    @Id
    @Column(name = "id_detalle_menu", nullable = false)
    public Integer getIdDetalleMenu() {
        return idDetalleMenu;
    }

    public void setIdDetalleMenu(Integer idDetalleMenu) {
        this.idDetalleMenu = idDetalleMenu;
    }

    @Basic
    @Column(name = "id_menu", nullable = false)
    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    @Basic
    @Column(name = "prf_codigo", nullable = true, length = 4)
    public String getPrfCodigo() {
        return prfCodigo;
    }

    public void setPrfCodigo(String prfCodigo) {
        this.prfCodigo = prfCodigo;
    }

    @Basic
    @Column(name = "fecha_crea", nullable = false)
    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    @Basic
    @Column(name = "user_crea", nullable = false)
    public Integer getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(Integer userCrea) {
        this.userCrea = userCrea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleMenuSystemEntity that = (DetalleMenuSystemEntity) o;

        if (idDetalleMenu != null ? !idDetalleMenu.equals(that.idDetalleMenu) : that.idDetalleMenu != null)
            return false;
        if (idMenu != null ? !idMenu.equals(that.idMenu) : that.idMenu != null) return false;
        if (prfCodigo != null ? !prfCodigo.equals(that.prfCodigo) : that.prfCodigo != null) return false;
        if (fechaCrea != null ? !fechaCrea.equals(that.fechaCrea) : that.fechaCrea != null) return false;
        if (userCrea != null ? !userCrea.equals(that.userCrea) : that.userCrea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleMenu != null ? idDetalleMenu.hashCode() : 0;
        result = 31 * result + (idMenu != null ? idMenu.hashCode() : 0);
        result = 31 * result + (prfCodigo != null ? prfCodigo.hashCode() : 0);
        result = 31 * result + (fechaCrea != null ? fechaCrea.hashCode() : 0);
        result = 31 * result + (userCrea != null ? userCrea.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", nullable = false)
    public MenuSystemEntity getMenuSystemByIdMenu() {
        return menuSystemByIdMenu;
    }

    public void setMenuSystemByIdMenu(MenuSystemEntity menuSystemByIdMenu) {
        this.menuSystemByIdMenu = menuSystemByIdMenu;
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
