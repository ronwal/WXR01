package ec.gob.sri.comprobantes.modelo;

import java.util.*;

public class LoteXml
{
    private String version;
    private String claveAcceso;
    private String ruc;
    private List<ComprobanteXml> comprobantes;
    
    public LoteXml() {
        super();
        this.comprobantes = new ArrayList<ComprobanteXml>();
    }
    
    public String getClaveAcceso() {
        return this.claveAcceso;
    }
    
    public void setClaveAcceso(final String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
    
    public List<ComprobanteXml> getComprobantes() {
        return this.comprobantes;
    }
    
    public void setComprobantes(final List<ComprobanteXml> comprobantes) {
        this.comprobantes = comprobantes;
    }
    
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(final String ruc) {
        this.ruc = ruc;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
}
