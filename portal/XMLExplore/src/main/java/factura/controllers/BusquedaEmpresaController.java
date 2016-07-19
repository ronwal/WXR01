/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.controllers;

import ec.ste.factura.DaoManager;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.util.PSAssistant;

import java.io.Serializable;

/**
 *
 * @author German17
 */
public class BusquedaEmpresaController extends DaoManager implements Serializable {

    private PSAssistant<Empresa> psaEmpresa = new PSAssistant<Empresa>(EMPRESA_INFO);

  

   
    public BusquedaEmpresaController() {
   
    }

    public PSAssistant<Empresa> getPsaEmpresa() {
        return psaEmpresa;
    }

    public void setPsaEmpresa(PSAssistant<Empresa> psaEmpresa) {
        this.psaEmpresa = psaEmpresa;
    }

    

}
