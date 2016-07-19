/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.beans;

import ec.ste.factura.Constantes;
import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.util.FacesUtil;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private final static Logger log = Logger.getLogger(Login.class);

    private final LoginController controller = new LoginController();

    /**
     * Creates a new instance of Login
     */
    public Login() {
    }

    public LoginController getController() {
        return controller;
    }

    public boolean isIdentificado() {

        if (!controller.isIdentificado()) {
            String empresa = (String) FacesUtil.getSessionContextBean("empCodigo");
            if (empresa != null) {
                controller.definirEmpresa(empresa);
            }
        }

        return controller.isIdentificado();
    }
    
    public String getCodigoEmpresaLogin(){
        Object o=FacesUtil.getHttpSession().getAttribute("empCodigo");
        if(o!=null)
            return (String)o;
        return "no-logo";
    }

    public boolean isEmpresaDefinida() {
        return controller.getEmpresa() != null;
    }

    public Empresa getEmpresaTrabajo() {
        return controller.getEmpresa();
    }

    public void setIdentificado(boolean identificado) {
        controller.setIdentificado(identificado);
    }

    public String getNick() {
        return controller.getNick();
    }

    public void setNick(String nick) {
        controller.setNick(nick);
    }

    public String getClave() {
        return controller.getClave();
    }

    public void setClave(String clave) {
        controller.setClave(clave);
    }

    public String getCaptcha() {
        return controller.getCaptcha();
    }

    public void setCaptcha(String captcha) {
        controller.setCaptcha(captcha);
    }

    public Usuario getUsuario() {
        return controller.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        controller.setUsuario(usuario);
    }

    public Perfil getPerfil() {
        return controller.getPerfil();
    }

    public void conectar(ActionEvent e) {
        try {
            if (!getCodigoEmpresaLogin().equals("no-logo")) {
                controller.definirEmpresa(getCodigoEmpresaLogin());
            }
            controller.conectar();

            FacesUtil.redirect("index.jsf");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    public void desconectar(ActionEvent e) {
        controller.desconectar();
    }

    public boolean isAdministradorSistema() {
        return controller.isAdministradorSistema();
    }

    public boolean isAdministradorEmpresa() {
        return controller.isAdministradorEmpresa();
    }

    public boolean isConsultorInterno() {
        return controller.isConsultorInterno();
    }

    public boolean isClienteProveedor() {
        return controller.isClienteProveedor();
    }

    public boolean isGerenteEmpresa() {
        return controller.isGerenteEmpresa();
    }

    public String getCaptchaUrl() {
        return "image.cap?id=" + (int) (5000000.0 * Math.random());
    }

    public void captchaListener(AjaxBehaviorEvent event) {
    }

    public void checkLogin() {
        if (!controller.isIdentificado()) {
            FacesUtil.redirect("index.jsf");
        }
        if (controller.getPerfil() != null) {
            if (controller.getPerfil().getPrfCodigo() != null) {
                if (!controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR) & !controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_SUPER_ADMINISTRADOR)) {
                    desconectar(null);
                    FacesUtil.redirect("index.jsf");
                }
            }
        }
    }

    public void checkLoginEmpresa() {
        if (!controller.isIdentificado()) {
            FacesUtil.redirect("login.jsf");
        }
        if (controller.getPerfil() != null) {
            if (controller.getPerfil().getPrfCodigo() != null) {
                if (controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR) | controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_SUPER_ADMINISTRADOR)) {
                    desconectar(null);
                    FacesUtil.redirect("login.jsf");
                }
            }
        }

    }

    public void checkValidLoginStatus() {
        if (controller.isIdentificado()) {
            FacesUtil.redirect("index.jsf");
        }
    }

    public void checkAdministradorSistemaLogin() {
        if (controller.isIdentificado()) {
            if (!controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR) & !controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_SUPER_ADMINISTRADOR)) {
                desconectar(null);
                FacesUtil.redirect("login.jsf");
            }
        } else {
            FacesUtil.redirect("login.jsf");
        }
    }

    public void checkAdministradorEmpresaLogin() {
        if (controller.isIdentificado()) {
            if (!controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR_EMPRESA)) {
                FacesUtil.redirect("index.jsf");
            }
        } else {
            FacesUtil.redirect("index.jsf");
        }
    }

    public void checkClienteLogin() {
        if (controller.isIdentificado()) {
            if (!controller.getPerfil().getPrfCodigo().equals(Constantes.PRF_CLIENTE_PROVEEDOR)) {
                FacesUtil.redirect("index.jsf");
            }
        } else {
            FacesUtil.redirect("index.jsf");
        }
    }

    public String getNuevaClave() {
        return controller.getNuevaClave();
    }

    public void setNuevaClave(String nuevaClave) {
        controller.setNuevaClave(nuevaClave);
    }

    public String getConfirmacionClave() {
        return controller.getConfirmacionClave();
    }

    public void setConfirmacionClave(String confirmacionClave) {
        controller.setConfirmacionClave(confirmacionClave);
    }

    public boolean isCambioClave() {
        return controller.isCambioClave();
    }

    public void setCambioClave(boolean cambioClave) {
        controller.setCambioClave(cambioClave);
    }

    public void cambiarClave(ActionEvent e) {
        try {
            controller.cambiarClave();
            setCambioClave(false);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelarCambioClave(ActionEvent e) {
        try {
            setCambioClave(false);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
