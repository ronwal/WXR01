/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.ste.factura.beans;

import java.util.Date;

/**
 *
 * @author German17
 */
public class Intervalo {
    
    private String nombre;
    private Date inicio;
    private Date fin;


    public Intervalo() {
    }
    
    

    public Intervalo(String nombre, Date inicio, Date fin) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
    }
    
     
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
