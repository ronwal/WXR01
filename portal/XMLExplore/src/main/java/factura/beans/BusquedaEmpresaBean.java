/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.beans;

import ec.ste.factura.controllers.BusquedaEmpresaController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.util.FacesUtil;
import ec.ste.factura.util.PSAssistant;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 *
 * @author German17
 */
@ManagedBean
@SessionScoped
public class BusquedaEmpresaBean implements Serializable {

    private final BusquedaEmpresaController controller = new BusquedaEmpresaController();

    /**
     * Creates a new instance of BusquedaEmpresaBean
     */
    public BusquedaEmpresaBean() {
    }

    public PSAssistant<Empresa> getPsaEmpresa() {
        return controller.getPsaEmpresa();
    }

    public void buscar(ActionEvent e) {
        if (controller.getPsaEmpresa().getSelected() != null) {
            if (controller.getPsaEmpresa().getSelected().getEmpUrl() != null) {
                FacesUtil.redirect(controller.getPsaEmpresa().getSelected().getEmpUrl());
            }
        }

    }

    

}
