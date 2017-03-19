package ec.gob.fecuador.portal.controller.empresa;

import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;
import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.common.navigation.SessionCookie;
import ec.gob.fecuador.portal.controller.login.LoginController;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Walter on 3/3/17.
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    private UsuarioEntity usuarioSel;
    private List<PerfilEntity> perfiles;

    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    @PostConstruct
    public void init() {
        perfiles = facElectOpDAO.getAllPerfil();
    }

    public void onRowSelect(SelectEvent event) {
        setUsuarioSel((UsuarioEntity) event.getObject());
        FacesMessage msg = new FacesMessage("Seleccionado: ", this.usuarioSel.getUsuNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Desmarcado: ", ((UsuarioEntity) event.getObject()).getUsuNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setUsuarioSel(new UsuarioEntity());

    }

    public void newUser() {
        setUsuarioSel(new UsuarioEntity());
        FacesMessage msg = new FacesMessage("Añadir: ", "Crecar nuevo usuario");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void updateUser() {
            if (this.usuarioSel.getUsuCodigo() != null)
            this.facElectOpDAO.actualizarUser(this.usuarioSel);
        else {
            String codEmp = (String) SessionCookie.getValCookie(LoginController.EMPRESA_USER);
            this.usuarioSel.setEmpCodigo(codEmp);
            this.facElectOpDAO.insertUser(this.getUsuarioSel());
        }

        FacesMessage msg = new FacesMessage("Actualizado: ", "Usuario Actualizado correctamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        RequestContext.getCurrentInstance().execute("PF('userEditWgt').hide()");
        RequestContext.getCurrentInstance().update(":userForm:userTable");
    }

    public UsuarioEntity getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(UsuarioEntity usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

    public List<PerfilEntity> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilEntity> perfiles) {
        this.perfiles = perfiles;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
