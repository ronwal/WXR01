/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.ste.factura.beans;

import java.io.Serializable;

/**
 *
 * @author German17
 */
public class TopConsulta implements Serializable{
    
    private String nombre;
    private double valor;

    public TopConsulta(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
    

    public String getNombre() {
        if(nombre.length()>15){
            return nombre.substring(0, 12)+"...";
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
