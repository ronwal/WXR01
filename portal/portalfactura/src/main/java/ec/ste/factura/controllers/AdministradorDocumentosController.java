/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.controllers;

import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.GuiaRemision;
import ec.ste.factura.entities.NotaCredito;
import ec.ste.factura.entities.Retencion;
import ec.ste.factura.exception.DaoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German17
 */
public class AdministradorDocumentosController extends DaoManager implements Serializable {

    private LoginController login;

    private int tipo;
    private String filtro;
    private String secuencial="0";
    private Date desde;
    private Date hasta;
    private int limit = 100;

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
        Date d1 = FACTURA_DAO.getFirstDate(login.getEmpresa());
        Date d2 = RETENCION_DAO.getFirstDate(login.getEmpresa());
        desde = d1.after(d2) ? d2 : d1;
        hasta = new Date();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit <= 0) {
            limit = 100;
        }
        this.limit = limit;
    }

    public List<Factura> getFacturas() {

        try {
            if (desde == null | hasta == null) {
                Date d1 = FACTURA_DAO.getFirstDate(login.getEmpresa());
                Date d2 = RETENCION_DAO.getFirstDate(login.getEmpresa());
                desde = d1.after(d2) ? d2 : d1;
                hasta = new Date();
            }
            return FACTURA_DAO.personalizedFilter(login, login.getEmpresa(), tipo, desde, hasta, filtro, secuencial, limit);
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Factura>();
    }

    public List<Retencion> getRetenciones() {
        try {
            return RETENCION_DAO.personalizedFilter(login, login.getEmpresa(), tipo, desde, hasta, filtro, secuencial, limit);
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Retencion>();
    }

    public List<NotaCredito> getNotasCredito() {
        try {
            return NOTA_CREDITO_DAO.personalizedFilter(login, login.getEmpresa(), tipo, desde, hasta, filtro, secuencial, limit);
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<NotaCredito>();
    }
    
    public List<GuiaRemision> getGuiasRemision() {
        try {
            return GUIA_REMISION_DAO.personalizedFilter(login, login.getEmpresa(), tipo, desde, hasta, filtro, secuencial, limit);
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<GuiaRemision>();
    }
    
    
    

}
