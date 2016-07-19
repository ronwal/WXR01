/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.controllers;

import ec.ste.factura.Constantes;

import static ec.ste.factura.DaoManager.USUARIO_DAO;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author German17
 */
public class UsuarioEmpresaController extends DaoManager implements Serializable {

    private static final List<Perfil> list = new ArrayList<Perfil>() {
        {
            add(new Perfil(Constantes.PRF_GERENCIA_EMPRESA, "GERENTE"));
            add(new Perfil(Constantes.PRF_CONSULTOR_INTERNO, "CONSULTOR INTERNO"));
            add(new Perfil(Constantes.PRF_CLIENTE_PROVEEDOR, "CLIENTE/PROVEEDOR"));

        }
    };
    private LoginController login;
    private Usuario model = new Usuario();

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public Usuario getModel() {
        return model;
    }

    public void setModel(Usuario model) {
        this.model = model;
    }

    public void guardar() throws Exception {

        if (model.getUsuIdentificacion().trim().length() == 0) {
            throw new Exception("El número de Identificación no puede estar vacío");
        }

        if (model.getUsuNombre().trim().length() == 0) {
            throw new Exception("El nombre no puede quedar vacío");
        }

        if (model.getUsuNick().trim().length() == 0) {
            throw new Exception("El nick no puede quedar vacío");
        }

        Usuario u = USUARIO_DAO.findUsuarioByNick(model.getUsuNick().trim(),model.getEmpresa());

        if (u != null) {
            if (u.getUsuCodigo() != model.getUsuCodigo()) {
                throw new Exception("El nick ya se halla registrado, favor especifique uno distinto");
            }
        }

        model.setEmpresa(login.getUsuario().getEmpresa());

        u = USUARIO_DAO.personalizedFilter(model.getEmpresa(), model.getUsuIdentificacion());
        if (u != null) {
            if (u.getUsuCodigo() != model.getUsuCodigo()) {
                throw new Exception("El usuario ya se halla registrado");
            }
        }

        if (model.getUsuCodigo() == 0) {
            model.setUsuClave(Crypt.encrypt(model.getEmpresa().getEmpCodigo(), model.getUsuIdentificacion()));
            USUARIO_DAO.insert(model);
        } else {
            USUARIO_DAO.update(model);
        }
    }

    public void restablecerClave() throws Exception {
        model.setUsuClave(Crypt.encrypt(model.getEmpresa().getEmpCodigo(), model.getUsuIdentificacion()));
        USUARIO_DAO.update(model);
    }

    public void editar(int codigo) throws Exception {
        Usuario u = USUARIO_DAO.findUsuarioByPrimaryKey(codigo);
        if (u != null) {
            model = u;
        }
    }

    public void eliminar(int codigo) throws Exception {
        Usuario u = USUARIO_DAO.findUsuarioByPrimaryKey(codigo);
        if (u != null) {
            USUARIO_DAO.delete(u);
        }
    }
    
    public void restablecerClave(int key) throws Exception {
        Usuario usuario=USUARIO_DAO.findUsuarioByPrimaryKey(key);
        String password=Crypt.encrypt(usuario.getEmpresa().getEmpCodigo(), usuario.getUsuIdentificacion());
        usuario.setUsuClave(password);
        USUARIO_DAO.update(usuario);
    }

    public List<Perfil> getListaPerfiles() {
        return list;
    }

    public List<Usuario> getListaUsuariosAdministradorEmpresa() {
        try {
            return USUARIO_DAO.getListaAdministradorEmpresa(login.getUsuario().getEmpresa());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Usuario>();
    }
    
    public List<Usuario> getListaUsuariosAdministradorEmpresa(String txtBusq) {
        try {
            return USUARIO_DAO.getListaAdministradorEmpresa(login.getUsuario().getEmpresa(),txtBusq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Usuario>();
    }

}
