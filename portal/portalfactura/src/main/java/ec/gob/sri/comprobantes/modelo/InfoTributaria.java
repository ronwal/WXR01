package ec.gob.sri.comprobantes.modelo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoTributaria", propOrder = { "ambiente", "tipoEmision", "razonSocial", "nombreComercial", "ruc", "claveAcceso", "codDoc", "estab", "ptoEmi", "secuencial", "dirMatriz" })
public class InfoTributaria
{
    protected String ambiente;
    protected String tipoEmision;
    protected String razonSocial;
    protected String nombreComercial;
    protected String ruc;
    protected String claveAcceso;
    protected String codDoc;
    protected String estab;
    protected String ptoEmi;
    protected String secuencial;
    protected String dirMatriz;
    
    public String getAmbiente() {
        return this.ambiente;
    }
    
    public void setAmbiente(final String value) {
        this.ambiente = value;
    }
    
    public String getTipoEmision() {
        return this.tipoEmision;
    }
    
    public void setTipoEmision(final String value) {
        this.tipoEmision = value;
    }
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(final String value) {
        this.razonSocial = value;
    }
    
    public String getNombreComercial() {
        return this.nombreComercial;
    }
    
    public void setNombreComercial(final String value) {
        this.nombreComercial = value;
    }
    
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(final String value) {
        this.ruc = value;
    }
    
    public String getClaveAcceso() {
        return this.claveAcceso;
    }
    
    public void setClaveAcceso(final String value) {
        this.claveAcceso = value;
    }
    
    public String getCodDoc() {
        return this.codDoc;
    }
    
    public void setCodDoc(final String value) {
        this.codDoc = value;
    }
    
    public String getEstab() {
        return this.estab;
    }
    
    public void setEstab(final String value) {
        this.estab = value;
    }
    
    public String getPtoEmi() {
        return this.ptoEmi;
    }
    
    public void setPtoEmi(final String value) {
        this.ptoEmi = value;
    }
    
    public String getSecuencial() {
        return this.secuencial;
    }
    
    public void setSecuencial(final String value) {
        this.secuencial = value;
    }
    
    public String getDirMatriz() {
        return this.dirMatriz;
    }
    
    public void setDirMatriz(final String value) {
        this.dirMatriz = value;
    }
}
