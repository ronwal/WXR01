/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.factura.configuracion;

import ec.factura.configuracion.DAO.ValidationDAO;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.dao.UsuarioDao;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.exception.DaoException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author @rw_r
 */
@ManagedBean
@CustomScoped(value = "#{window}")
public class controlUsuarios implements Serializable {

    @ManagedProperty(value = "#{param.id}")
    private int id;
    private final ValidationDAO validation = new ValidationDAO();

    public String executeAction() {
        //application logic can be added here
        return null;
    }

    public void corrSinEmail(String ruc) {
        //application logic can be added here
        System.out.println(ruc);
    }

    public void corrNoEncrip(String ruc) throws DaoException {
        try {
            for (Object objUsuario : validation.noEncrip(ruc)) {
                Usuario usuario = (Usuario) objUsuario;
                usuario.setUsuClave(Crypt.encrypt(ruc, usuario.getUsuIdentificacion()));
                new UsuarioDao().update(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(ruc);
    }

    public long getUsers() {
        return validation.usersNoEMail();
    }

    public long getUsersClave() {
        return validation.usersNoEncrip();
    }

    public List getDetailNoMail() {
        return validation.noEMailDetail();
    }
    
    public List getDetailNoEn() {
        return validation.noEncripDetail();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
