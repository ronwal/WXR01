/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.ste.factura.controllers;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author German17
 */
public class ResumenInformacionController extends DaoManager implements Serializable{
    
    /**
     * 0=mensual
     * 1=trimestral
     * 2=semestral
     * 3=anual
     */
    
    private int tipo=0;
    
    private Date desde;
    private Date hasta;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
    
    
    
    
    
    class Periodo{
        private Date inicio;
        private Date fin;

        public Date getInicio() {
            return inicio;
        }

        public void setInicio(Date inicio) {
            this.inicio = inicio;
        }

        public Date getFin() {
            return fin;
        }

        public void setFin(Date fin) {
            this.fin = fin;
        }
        
        
    }
}
