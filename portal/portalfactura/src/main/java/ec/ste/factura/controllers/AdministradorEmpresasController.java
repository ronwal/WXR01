/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.controllers;

import ec.ste.factura.entities.Empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author German17
 */
public class AdministradorEmpresasController extends DaoManager implements Serializable {

    private String filter = "";
    private Empresa model = new Empresa();

    public Empresa getModel() {
        return model;
    }

    public void setModel(Empresa model) {
        this.model = model;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void guardar() throws Exception {
        if (model.getEmpCodigo() == null) {
            throw new Exception("Debe especificar el RUC");
        }
        if (model.getEmpCodigo().trim().length() != 13) {
            throw new Exception("El RUC, debe contener 13 dígitos");
        }
        if(model.getEmpRazonSocial().trim().length()==0){
            throw new Exception("La Razón Social no puede estar vacía");
        }
        
        if(model.getEmpUrl().trim().length()==0){
            throw new Exception("La dirección URL no puede quedar vacía");
        }
        
        String url=model.getEmpUrl().trim();
        if(!url.endsWith(".com")){
            throw new Exception("La dirección URL debe terminar en .com");
        }
        
        Empresa empUrl=EMPRESA_DAO.findEmpresaByUrl(url);
        if(empUrl!=null){
            if(!empUrl.getEmpCodigo().equals(model.getEmpCodigo())){
                throw new Exception("La dirección URL ya se encuentra registrada, favor especifique una distinta");
            }
        }
        
        Empresa buffer = EMPRESA_DAO.findEmpresaByPrimaryKey(model.getEmpCodigo());
        if (buffer != null) {
            EMPRESA_DAO.update(model);
        } else {
            EMPRESA_DAO.insert(model);
        }

    }

    public void editar(String codigo) throws Exception {
        Empresa u = EMPRESA_DAO.findEmpresaByPrimaryKey(codigo);
        if (u != null) {
            model = u;
        }
    }

    public void eliminar(String codigo) throws Exception {
        Empresa u = EMPRESA_DAO.findEmpresaByPrimaryKey(codigo);
        if (u != null) {
            EMPRESA_DAO.delete(u);
        }
    }

    public List<Empresa> getListaEmpresas() {
        try {
            return EMPRESA_DAO.filterByEmpRazonSocial(filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Empresa>();
    }

}
