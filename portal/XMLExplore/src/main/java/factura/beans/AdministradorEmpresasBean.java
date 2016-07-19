/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.beans;

import ec.ste.factura.controllers.AdministradorEmpresasController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.util.FacesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German17
 */
@ManagedBean
@ViewScoped
public class AdministradorEmpresasBean implements Serializable {

    private final AdministradorEmpresasController controller = new AdministradorEmpresasController();

    private boolean entidadRegistrada = false;

    /**
     * Creates a new instance of AdministradorEmpresaBean
     */
    public AdministradorEmpresasBean() {
    }

    public Empresa getModel() {
        return controller.getModel();
    }

    public void setModel(Empresa model) {
        controller.setModel(model);
    }

    public String getFilter() {
        return controller.getFilter();
    }

    public void setFilter(String filter) {
        controller.setFilter(filter);
    }

    public boolean isEntidadRegistrada() {
        return entidadRegistrada;
    }

    public void setEntidadRegistrada(boolean entidadRegistrada) {
        this.entidadRegistrada = entidadRegistrada;
    }
    
    

    public void nuevo(ActionEvent e) {
        controller.setModel(new Empresa());
        entidadRegistrada = false;
    }

    public void guardar(ActionEvent evt) {
        try {
            controller.guardar();
            entidadRegistrada = true;
            FacesUtil.addInfoMessage("Se ha guardado correctamente");
        } catch (Exception ex) {
            entidadRegistrada = false;
            Logger.getLogger(AdministradorEmpresasBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
        }
    }

    public void editar(ActionEvent evt) {
        String codigo = (String) evt.getComponent().getAttributes().get("codigo");
        try {
            controller.editar(codigo);
            entidadRegistrada = true;
        } catch (Exception ex) {
            entidadRegistrada = false;
            Logger.getLogger(AdministradorEmpresasBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
        }
    }

    public void eliminar(ActionEvent evt) {
        String codigo = (String) evt.getComponent().getAttributes().get("codigo");
        try {
            controller.editar(codigo);
            entidadRegistrada = false;
        } catch (Exception ex) {
            entidadRegistrada = true;
            Logger.getLogger(AdministradorEmpresasBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.addErrorMessage(ex.getLocalizedMessage());
        }
    }

    public List<Empresa> getListaEmpresas() {
        return controller.getListaEmpresas();
    }

}
