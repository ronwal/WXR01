package comprobantes.modelo.notadebito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalle", propOrder = { "motivoModificacion" })
public class Detalle
{
    protected String motivoModificacion;
    
    public String getMotivoModificacion() {
        return this.motivoModificacion;
    }
    
    public void setMotivoModificacion(final String value) {
        this.motivoModificacion = value;
    }
}
