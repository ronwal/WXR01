package ec.fecuador.persistence.factecuador.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Walter on 22/2/17.
 */
@Entity
@Table(name = "menu_system", schema = "public", catalog = "factura_ecuador")
public class MenuSystemEntity {
    private Integer idMenu;
    private String nombreMenu;
    private String urlParth;
    private Date fechaCrea;
    private Integer userCrea;
    private Collection<DetalleMenuSystemEntity> detalleMenuSystemsByIdMenu;

    @Id
    @Column(name = "id_menu", nullable = false)
    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    @Basic
    @Column(name = "nombre_menu", nullable = false, length = 25)
    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    @Basic
    @Column(name = "url_parth", nullable = false, length = 100)
    public String getUrlParth() {
        return urlParth;
    }

    public void setUrlParth(String urlParth) {
        this.urlParth = urlParth;
    }

    @Basic
    @Column(name = "fecha_crea", nullable = true)
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

        MenuSystemEntity that = (MenuSystemEntity) o;

        if (idMenu != null ? !idMenu.equals(that.idMenu) : that.idMenu != null) return false;
        if (nombreMenu != null ? !nombreMenu.equals(that.nombreMenu) : that.nombreMenu != null) return false;
        if (urlParth != null ? !urlParth.equals(that.urlParth) : that.urlParth != null) return false;
        if (fechaCrea != null ? !fechaCrea.equals(that.fechaCrea) : that.fechaCrea != null) return false;
        if (userCrea != null ? !userCrea.equals(that.userCrea) : that.userCrea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMenu != null ? idMenu.hashCode() : 0;
        result = 31 * result + (nombreMenu != null ? nombreMenu.hashCode() : 0);
        result = 31 * result + (urlParth != null ? urlParth.hashCode() : 0);
        result = 31 * result + (fechaCrea != null ? fechaCrea.hashCode() : 0);
        result = 31 * result + (userCrea != null ? userCrea.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "menuSystemByIdMenu")
    public Collection<DetalleMenuSystemEntity> getDetalleMenuSystemsByIdMenu() {
        return detalleMenuSystemsByIdMenu;
    }

    public void setDetalleMenuSystemsByIdMenu(Collection<DetalleMenuSystemEntity> detalleMenuSystemsByIdMenu) {
        this.detalleMenuSystemsByIdMenu = detalleMenuSystemsByIdMenu;
    }
}
