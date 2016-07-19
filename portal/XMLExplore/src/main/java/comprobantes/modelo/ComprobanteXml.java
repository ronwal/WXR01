package comprobantes.modelo;

public class ComprobanteXml
{
    private String tipo;
    private String version;
    private String fileXML;
    
    public String getFileXML() {
        return this.fileXML;
    }
    
    public void setFileXML(final String fileXML) {
        this.fileXML = "<![CDATA[" + fileXML + "]]>";
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
}
