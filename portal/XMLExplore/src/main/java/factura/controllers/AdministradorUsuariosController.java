/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.controllers;

import ec.ste.factura.Constantes;
import ec.ste.factura.DaoManager;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.exception.DaoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ec.ste.factura.DaoManager.USUARIO_DAO;

/**
 *
 * @author German17
 */
public class AdministradorUsuariosController extends DaoManager implements Serializable {

    private static final List<Perfil> list = new ArrayList<Perfil>() {
        {
            add(new Perfil(Constantes.PRF_ADMINISTRADOR, "ADMINISTRADOR DE SISTEMA"));
            add(new Perfil(Constantes.PRF_ADMINISTRADOR_EMPRESA, "ADMINISTRADOR DE EMPRESA"));
            add(new Perfil(Constantes.PRF_CARGA_DATOS_EMPRESA, "CARGA DE DATOS"));
        }
    };
    private LoginController login;
    private Usuario model = new Usuario();
    private boolean cambiarClave = false;

    public AdministradorUsuariosController() {
        model.setEmpresa(new Empresa());
    }

    public LoginController getLogin() {
        return login;
    }

    public boolean isCambiarClave() {
        return cambiarClave;
    }

    public void setCambiarClave(boolean cambiarClave) {
        this.cambiarClave = cambiarClave;
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

    public boolean isAdministradorSistema() {
        if (model.getPerfil() == null) {
            return false;
        }
        if (model.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        if (model.getPerfil().getPrfCodigo().trim().length() == 0) {
            return false;
        }
        return model.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR);
    }

    public boolean isCargadorDatos() {
        if (model.getPerfil() == null) {
            return false;
        }
        if (model.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        if (model.getPerfil().getPrfCodigo().trim().length() == 0) {
            return false;
        }
        return model.getPerfil().getPrfCodigo().equals(Constantes.PRF_CARGA_DATOS_EMPRESA);
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

        if (isAdministradorSistema()) {
            model.setEmpresa(null);
        } else {
            u = USUARIO_DAO.personalizedFilter(model.getEmpresa(), model.getUsuIdentificacion());
            if (u != null) {
                if (u.getUsuCodigo() != model.getUsuCodigo()) {
                    throw new Exception("El usuario ya se halla registrado");
                }
            }
        }

        String pass = "";
        if (model.getEmpresa() == null) {
            pass = model.getUsuIdentificacion();
        } else {
            pass = model.getEmpresa().getEmpCodigo();
        }

        if (model.getUsuCodigo() == 0) {
            if (isCargadorDatos()) {
                if (model.getUsuClave().trim().length() < 8) {
                    throw new Exception("Debe especificar la clave de acceso de la cuenta");
                } else {
                    model.setUsuClave(Crypt.encrypt(pass, model.getUsuClave()));
                }
            } else {
                model.setUsuClave(Crypt.encrypt(pass, model.getUsuIdentificacion()));
            }
            USUARIO_DAO.insert(model);
        } else {
            if (isCambiarClave()) {
                if (model.getUsuClave().trim().length() < 8) {
                    throw new Exception("Debe especificar la clave de acceso de la cuenta");
                } else {
                    model.setUsuClave(Crypt.encrypt(pass, model.getUsuClave()));
                }
            }
            USUARIO_DAO.update(model);
        }
    }

    public void restablecerClave(int key) throws Exception {
        Usuario usuario = USUARIO_DAO.findUsuarioByPrimaryKey(key);
        String pass = "";
        if (model.getEmpresa() == null) {
            pass = usuario.getUsuIdentificacion();
        } else {
            pass = usuario.getEmpresa().getEmpCodigo();
        }
        String password = Crypt.encrypt(pass, usuario.getUsuIdentificacion());
        usuario.setUsuClave(password);
        USUARIO_DAO.update(usuario);
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

    public List<Perfil> getListaPerfiles() {
        return list;
    }

    public List<Empresa> getListaEmpresas() {
        try {
            return EMPRESA_DAO.filterByEmpRazonSocial(null);
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Empresa>();
    }

    public List<Usuario> getListaUsuariosAdministradorSistema() {
        try {
            return USUARIO_DAO.getListaAdministradorSistema();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Usuario>();
    }

}
