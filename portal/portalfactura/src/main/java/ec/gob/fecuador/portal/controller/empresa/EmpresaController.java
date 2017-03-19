package ec.gob.fecuador.portal.controller.empresa;

import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;
import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.common.navigation.SessionCookie;
import ec.gob.fecuador.portal.controller.login.LoginController;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 * Created by Walter on 2/3/17.
 */
@ManagedBean
@ViewScoped
public class EmpresaController {
    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;
    private EmpresaEntity empresa;
    private UsuarioEntity usuario;

    @PostConstruct
    private void init() {
        String codEmp = (String) SessionCookie.getValCookie(LoginController.EMPRESA_USER);
        this.empresa = this.facElectOpDAO.getEmpbyId(codEmp);
        String user = (String) SessionCookie.getValCookie(LoginController.APP_USER);
        this.usuario = facElectOpDAO.getAUser(user, codEmp);
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
