/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.factura.configuracion.bean;

/**
 *
 * @author @rw_r
 */
public class DetailNoEncript {
    private long count;
    private String empresa;
    private String ruc;
    private String perfil;

    public DetailNoEncript(long count, String empresa, String ruc, String perfil) {
        this.count=count;
        this.empresa=empresa;
        this.ruc=ruc;
        this.perfil=perfil;
    }
    
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
