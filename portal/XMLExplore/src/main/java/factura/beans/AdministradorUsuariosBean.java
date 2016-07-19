/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.beans;

import ec.ste.factura.controllers.AdministradorUsuariosController;
import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.util.FacesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author German17
 */
@ManagedBean
@ViewScoped
public class AdministradorUsuariosBean implements Serializable {

    @ManagedProperty(value = "#{login}")
    private Login login;

    private AdministradorUsuariosController controller = new AdministradorUsuariosController();

    /**
     * Creates a new instance of UsuarioEmpresaBean
     */
    public AdministradorUsuariosBean() {
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
        controller.setLogin(login.getController());
    }

    public void setLogin(LoginController login) {
        controller.setLogin(login);
    }

    public Usuario getModel() {
        return controller.getModel();
    }

    public void setModel(Usuario model) {
        controller.setModel(model);
    }

    public boolean isAdministradorSistema() {
        return controller.isAdministradorSistema();
    }

    public boolean isCambiarClave() {
        return controller.isCambiarClave();
    }

    public void setCambiarClave(boolean cambiarClave) {
        controller.setCambiarClave(cambiarClave);
    }

    public boolean isCargadorDatos() {
        return controller.isCargadorDatos();
    }
    
    

    public void guardar(ActionEvent e) {
        try {
            controller.guardar();
            FacesUtil.addInfoMessage("Se ha guardado exitosamente");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
        }
    }

    public void restablecerClave(ActionEvent e) {
        int codigo = ((Number) e.getComponent().getAttributes().get("usuCodigo")).intValue();
        try {
            controller.restablecerClave(codigo);
            FacesUtil.addInfoMessage("Se ha restablecido la clave exitosamente");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    public void editar(ActionEvent e) {
        int codigo = ((Number) e.getComponent().getAttributes().get("usuCodigo")).intValue();
        try {
            controller.editar(codigo);
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
        }
    }

    public void eliminar(ActionEvent e) {
        int codigo = ((Number) e.getComponent().getAttributes().get("usuCodigo")).intValue();
        try {
            controller.eliminar(codigo);
            FacesUtil.addInfoMessage("Se ha eliminado exitosamente");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
        }
    }

    public void nuevo(ActionEvent e) {
        controller.setModel(new Usuario());
        controller.getModel().setEmpresa(new Empresa());
    }

    public List<SelectItem> getListaPerfiles() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        list.add(new SelectItem("SE", "(SIN ESPECIFICAR)"));
        for (Perfil p : controller.getListaPerfiles()) {
            list.add(new SelectItem(p.getPrfCodigo(), p.getPrfNombre()));
        }
        return list;
    }

    public List<SelectItem> getListaEmpresas() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        list.add(new SelectItem("SE", "(SIN ESPECIFICAR)"));
        for (Empresa p : controller.getListaEmpresas()) {
            list.add(new SelectItem(p.getEmpCodigo(), p.getEmpRazonSocial()));
        }
        return list;
    }

    public List<Usuario> getListaUsuarios() {
        return controller.getListaUsuariosAdministradorSistema();
    }

    public int getMaxLongitudCodigo() {
       /* if (controller.getModel().getPerfil() != null) {
            if (controller.getModel().getPerfil().getPrfCodigo() != null) {
                if (controller.getModel().getPerfil().getPrfCodigo().equals(Constantes.PRF_CARGA_DATOS_EMPRESA)) {
                    return 13;
                }
            }
        }*/
        return 20;
    }

}
