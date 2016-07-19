/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.beans;

import ec.ste.factura.controllers.AdministradorDocumentosController;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.GuiaRemision;
import ec.ste.factura.entities.NotaCredito;
import ec.ste.factura.entities.Retencion;
import ec.ste.factura.util.FacesUtil;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author German17
 */
@ManagedBean
@ViewScoped
public class AdministradorDocumentosBean implements Serializable{

    private final AdministradorDocumentosController controller = new AdministradorDocumentosController();
    @ManagedProperty(value = "#{login}")
    private Login login;

    private static final TimeZone timezone = TimeZone.getDefault();

    /**
     * Creates a new instance of AdministradorDocumentosBean
     */
    public AdministradorDocumentosBean() {
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
        controller.setLogin(login.getController());
    }

    public int getTipo() {
        return controller.getTipo();
    }

    public void setTipo(int tipo) {
        controller.setTipo(tipo);
    }

    public String getFiltro() {
        return controller.getFiltro();
    }

    public void setFiltro(String filtro) {
        controller.setFiltro(filtro);
    }

    public Date getDesde() {
        return controller.getDesde();
    }

    public void setDesde(Date desde) {
        controller.setDesde(desde);
    }

    public Date getHasta() {
        return controller.getHasta();
    }

    public void setHasta(Date hasta) {
        controller.setHasta(hasta);
    }

    public int getSecuencial() {
        return controller.getSecuencial();
    }

    public void setSecuencial(int secuencial) {
        controller.setSecuencial(secuencial);
    }

    public int getLimit() {
        return controller.getLimit();
    }

    public void setLimit(int limit) {
        controller.setLimit(limit);
    }
    
    

    public List<Factura> getFacturas() {
        return controller.getFacturas();
    }

    public List<Retencion> getRetenciones() {
        return controller.getRetenciones();
    }
    
    public List<NotaCredito> getNotasCredito() {
        return controller.getNotasCredito();
    }
    
    public List<GuiaRemision> getGuiasRemision() {
        return controller.getGuiasRemision();
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void actualizar(ActionEvent e) {

    }

    public void descargar(ActionEvent e) {

        //t, k, v
        String tipo = (String) e.getComponent().getAttributes().get("tipo");
        String codigo = ((Integer) e.getComponent().getAttributes().get("codigo")).toString();
        String current = Long.toHexString(System.currentTimeMillis());
        HttpSession session = FacesUtil.getHttpSession();
        if (session != null) {
            try {
                String v = Crypt.encrypt("downloadPassword", current);
                session.setAttribute("validacionSesion", v);
                String url="document.dde?t="+tipo+"&k="+codigo+"&v="+URLEncoder.encode(v, "UTF-8");
                FacesUtil.openUrl(url);
            } catch (UnsupportedEncodingException ex) {
                
            }
        }
    }
    
    public void reportePdf(ActionEvent e) {
        

        //t, k, v
        String tipo = (String) e.getComponent().getAttributes().get("tipo");
        String codigo = ((Integer) e.getComponent().getAttributes().get("codigo")).toString();
        String current = Long.toHexString(System.currentTimeMillis());
        HttpSession session = FacesUtil.getHttpSession();
        if (session != null) {
            try {
                String v = Crypt.encrypt("downloadPassword", current);
                session.setAttribute("validacionDescarga", v);
                String url="document.rpt?t="+tipo+"&k="+codigo+"&v="+URLEncoder.encode(v, "UTF-8");
                System.out.println(url);
                FacesUtil.openUrl(url);
                
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AdministradorDocumentosBean.class).error(ex.getMessage(), ex);
            }
        }
    }
    
    public String wrapText(String text){
        return text.substring(0, 9)+" "+text.substring(10, 19)+" "+text.substring(20, 29)+" "+text.substring(30, text.length());
        
    }

}
