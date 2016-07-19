/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.ste.factura.controllers;

import java.io.Serializable;

/**
 *
 * @author German17
 */
public class ConfiguracionUsuarioController extends DaoManager implements Serializable{
    
    private String claveAnterior;
    private String nuevaClave;
    private String confirmacion;
    
    private LoginController login;

    public String getClaveAnterior() {
        return claveAnterior;
    }

    public void setClaveAnterior(String claveAnterior) {
        this.claveAnterior = claveAnterior;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
    public void cambiarClave()throws Exception{
        if(claveAnterior.trim().length()==0){
            throw new Exception("Por favor especifique la clave anterior");
        }
    }
    
}
