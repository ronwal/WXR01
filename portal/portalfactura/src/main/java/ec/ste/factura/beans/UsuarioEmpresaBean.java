/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.beans;

import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.controllers.UsuarioEmpresaController;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;

/**
 *
 * @author German17
 */
@ManagedBean
@ViewScoped
public class UsuarioEmpresaBean implements Serializable{
    
    private final static Logger log = Logger.getLogger(UsuarioEmpresaBean.class);
    
    @ManagedProperty(value = "#{login}")
    private Login login;
    
    private UsuarioEmpresaController controller=new UsuarioEmpresaController();

    /**
     * Creates a new instance of UsuarioEmpresaBean
     */
    public UsuarioEmpresaBean() {
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

    public void guardar(ActionEvent e) {
        try {
            controller.guardar();
            FacesUtil.addInfoMessage("Se ha guardado exitosamente");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
            log.error(ex.getMessage(), ex);
        }
    }
    
    

    public void editar(ActionEvent e) {
        int codigo=((Number)e.getComponent().getAttributes().get("usuCodigo")).intValue();
        try {
            controller.editar(codigo);
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    public void eliminar(ActionEvent e) {
        int codigo=((Number)e.getComponent().getAttributes().get("usuCodigo")).intValue();
        try {
            controller.eliminar(codigo);
            FacesUtil.addInfoMessage("Se ha eliminado exitosamente");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
            log.error(ex.getMessage(), ex);
        }
    }
    
    public void nuevo(ActionEvent e){
        controller.setModel(new Usuario());
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

    public List<SelectItem> getListaPerfiles() {
        List<SelectItem> list=new ArrayList<SelectItem>();
        for(Perfil p:controller.getListaPerfiles()){
            list.add(new SelectItem(p.getPrfCodigo(), p.getPrfNombre()));
        }
        return list;
    }

    public List<Usuario> getListaUsuarios() {
        return controller.getListaUsuariosAdministradorEmpresa();
    }
    
    public List<Usuario> getFilterUsuarios(String txtCriteria) {
        return controller.getListaUsuariosAdministradorEmpresa(txtCriteria);
    }

    

    
    
    
    
}
