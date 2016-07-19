/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.controllers;

import ec.ste.factura.Constantes;
import ec.ste.factura.DaoManager;
import ec.ste.factura.captcha.CaptchaServiceSingleton;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.Auditoria;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.exception.DaoException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German17
 */
public class LoginController extends DaoManager implements Serializable {

    private Empresa empresa;
    private boolean identificado = false;
    private String nick = new String();
    private String clave = new String();
    private String nuevaClave = new String();
    private String confirmacionClave = new String();
    private String captcha = new String();
    private Usuario usuario;
    
    private Auditoria auditoria;

    private boolean cambioClave = false;

    public LoginController() {
    }

    public boolean isIdentificado() {
        return identificado;
    }

    public void setIdentificado(boolean identificado) {
        this.identificado = identificado;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCaptcha() {
        return captcha;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
    
    

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        if (usuario == null) {
            return null;
        }
        return usuario.getPerfil();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public String getConfirmacionClave() {
        return confirmacionClave;
    }

    public void setConfirmacionClave(String confirmacionClave) {
        this.confirmacionClave = confirmacionClave;
    }

    public void definirEmpresa(String empCodigo) {
        try {
            Empresa buffer = EMPRESA_DAO.findEmpresaByPrimaryKey(empCodigo);
                    
            if (buffer != null) {
                empresa = buffer;
            }
        } catch (DaoException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar() throws Exception {
        if (nick.trim().length() == 0) {
            throw new Exception("Debe especificar el nombre de usuario");
        }
        if (clave.trim().length() == 0) {
            throw new Exception("Debe especificar la clave de acceso");
        }

        if (captcha.trim().length() == 0) {
            throw new Exception("Debe especificar el código de verificación");
        }

        if (!isValidCaptcha()) {
            throw new Exception("Por favor ingrese el código de verificación correcto");
        }

        Usuario buffer = USUARIO_DAO.findUsuarioByNick(nick,empresa);
        if (buffer == null) {
            throw new Exception("Por favor verifique su nombre de usuario y clave de acceso");
        }
        
        String pass="";
        if(buffer.getEmpresa()==null){
            pass=buffer.getUsuIdentificacion();
        }else{
            pass=buffer.getEmpresa().getEmpCodigo();
        }

        String enc = Crypt.encrypt(pass, clave);
        if (!buffer.getUsuClave().equals(enc)) {
            throw new Exception("Por favor verifique su nombre de usuario y clave de acceso");
        }

        if (!buffer.isUsuActivo()) {
            throw new Exception("El usuario no se encuentra activo");
        }

        if (buffer.getPerfil().getPrfCodigo().equals(Constantes.PRF_CARGA_DATOS_EMPRESA)) {
            throw new Exception("La cuenta especificada no le permite conectarse desde este ámbito");
        }

        if (!buffer.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR) & !buffer.getPerfil().getPrfCodigo().equals(Constantes.PRF_SUPER_ADMINISTRADOR)) {
            if (empresa != null) {
                if (!empresa.getEmpCodigo().equals(buffer.getEmpresa().getEmpCodigo())) {
                    throw new Exception("La cuenta especificada no le permite conectarse desde este ámbito");
                }
            }
        }

        usuario = buffer;
        empresa = usuario.getEmpresa();
        identificado = true;
        
        auditoria=new Auditoria();
        auditoria.setAudFecha(new Date());
        auditoria.setUsuario(usuario);
        AUDITORIA_DAO.insert(auditoria);

        enc = Crypt.encrypt(pass, usuario.getUsuIdentificacion());
        if (enc.equals(usuario.getUsuClave())) {
            cambioClave = true;
        }
    }

    public void desconectar() {
        identificado = false;
        usuario = null;
        nick = null;
        clave = null;
        empresa = null;
        captcha = null;
    }

    public boolean isCambioClave() {
        return cambioClave;
    }

    public void setCambioClave(boolean cambioClave) {
        this.cambioClave = cambioClave;
    }

    public void cambiarClave() throws Exception {
        
        String pass="";
        if(usuario.getEmpresa()==null){
            pass=usuario.getUsuIdentificacion();
        }else{
            pass=usuario.getEmpresa().getEmpCodigo();
        }
        
        String enc = Crypt.encrypt(pass, clave);
        if (!usuario.getUsuClave().equals(enc)) {
            throw new Exception("La clave anterior no es la correcta");
        }
        
        

        if (nuevaClave.trim().length() < 8) {
            throw new Exception("La nueva clave de contener por lo menos 8 caracteres, sin espacios en blanco en el inicio y final");
        }
        if (nuevaClave.trim().length() > 20) {
            throw new Exception("La longitud máxima de la clave es 20 caracteres");
        }
        if (!nuevaClave.equals(confirmacionClave)) {
            throw new Exception("La nueva clave y su confirmación no son iguales");
        }
        enc = Crypt.encrypt(pass, nuevaClave);
        
        if(enc.equals(usuario.getUsuClave())){
            throw new Exception("La nueva clave no puede ser la misma anterior");
        }
        
        usuario.setUsuClave(enc);
        USUARIO_DAO.update(usuario);
    }

    public boolean isAdministradorSistema() {
        if (!identificado) {
            return false;
        }
        if (usuario == null) {
            return false;
        }
        if (usuario.getPerfil() == null) {
            return false;
        }
        if (usuario.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        return usuario.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR) | usuario.getPerfil().getPrfCodigo().equals(Constantes.PRF_SUPER_ADMINISTRADOR);
    }

    public boolean isAdministradorEmpresa() {
        if (!identificado) {
            return false;
        }
        if (usuario == null) {
            return false;
        }
        if (usuario.getPerfil() == null) {
            return false;
        }
        if (usuario.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        return usuario.getPerfil().getPrfCodigo().equals(Constantes.PRF_ADMINISTRADOR_EMPRESA);
    }

    public boolean isConsultorInterno() {
        if (!identificado) {
            return false;
        }
        if (usuario == null) {
            return false;
        }
        if (usuario.getPerfil() == null) {
            return false;
        }
        if (usuario.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        return usuario.getPerfil().getPrfCodigo().equalsIgnoreCase(Constantes.PRF_CONSULTOR_INTERNO);
    }

    public boolean isClienteProveedor() {
        if (!identificado) {
            return false;
        }
        if (usuario == null) {
            return false;
        }
        if (usuario.getPerfil() == null) {
            return false;
        }
        if (usuario.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        return usuario.getPerfil().getPrfCodigo().equalsIgnoreCase(Constantes.PRF_CLIENTE_PROVEEDOR);
    }

    public boolean isGerenteEmpresa() {
        if (!identificado) {
            return false;
        }
        if (usuario == null) {
            return false;
        }
        if (usuario.getPerfil() == null) {
            return false;
        }
        if (usuario.getPerfil().getPrfCodigo() == null) {
            return false;
        }
        return usuario.getPerfil().getPrfCodigo().equalsIgnoreCase(Constantes.PRF_GERENCIA_EMPRESA);
    }

    private boolean isValidCaptcha() {
        Object o = FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (!(o instanceof HttpSession)) {
            return false;
        }
        HttpSession session = (HttpSession) o;
        try {
            return CaptchaServiceSingleton.getInstance().validateResponseForID(session.getId(), captcha);
        } catch (Exception e) {
            return false;
        }
    }
}
