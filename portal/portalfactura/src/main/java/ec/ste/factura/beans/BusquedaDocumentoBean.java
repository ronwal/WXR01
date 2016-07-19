/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.beans;

import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.dao.RetencionDao;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.Retencion;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FacesUtil;
import net.fecuador.persist.model.dao.FacturaDAO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author @rw_r
 */
@ManagedBean
@SessionScoped
public class BusquedaDocumentoBean {

    private String tipo;
    private String emisor;
    private String receptor;
    private String serie;
    private String puntoEmision;
    private int secuencial;
    private boolean cargado = false;
    private int key;
    private String password;

    /**
     * Creates a new instance of BusquedaDocumentoBean
     */
    public BusquedaDocumentoBean() {

    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getPuntoEmision() {
        return puntoEmision;
    }

    public void setPuntoEmision(String puntoEmision) {
        this.puntoEmision = puntoEmision;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    public boolean isCargado() {
        return cargado;
    }
    
    
    
    public String getPdfUrl(){
        try {
            return  "document.rpt?t=" + tipo + "&k=" + key + "&v=" + URLEncoder.encode(password, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BusquedaDocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String getXmlUrl(){
        try {
            return "document.dde?t="+tipo+"&k="+key+"&v="+URLEncoder.encode(password, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BusquedaDocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void buscar(ActionEvent e) {
        cargado = false;
        try {
            if (tipo.equals("F")) {
                FacturaDAO f = facturaDao.findFacturaByInfo(emisor, receptor, serie, puntoEmision, secuencial);
                if (f != null) {

                    String current = Long.toHexString(System.currentTimeMillis());
                    HttpSession session = FacesUtil.getHttpSession();
                    if (session != null) {
                        key=f.getFacCodigo();
                        password = Crypt.encrypt("downloadPassword", current);
                        session.setAttribute("validacionBusqueda", password);
                        cargado = true;
                    }
                } else {
                    cargado=false;
                    FacesUtil.addErrorMessage("No se encuentra el documento");
                }
            } else if (tipo.equals("R")) {
                Retencion r = retencionDao.findFacturaByInfo(emisor, receptor, serie, puntoEmision, secuencial);
                if (r != null) {

                    String current = Long.toHexString(System.currentTimeMillis());
                    HttpSession session = FacesUtil.getHttpSession();
                    if (session != null) {
                        key=r.getRetCodigo();
                        password = Crypt.encrypt("downloadPassword", current);
                        session.setAttribute("validacionBusqueda", password);
                        cargado = true;
                    }
                } else {
                    cargado=false;
                    FacesUtil.addErrorMessage("No se encuentra el documento");
                }
            }

        } catch (DaoException ex) {
            Logger.getLogger(BusquedaDocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.addErrorMessage("No se encuentra el documento");
        }

    }

}
