package comprobantes.modelo.guia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalle", propOrder = { "codigoInterno", "codigoAdicional", "descripcion", "cantidad", "detallesAdicionales" })
public class Detalle
{
    protected String codigoInterno;
    protected String codigoAdicional;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected DetallesAdicionales detallesAdicionales;
    
    public String getCodigoInterno() {
        return this.codigoInterno;
    }
    
    public void setCodigoInterno(final String value) {
        this.codigoInterno = value;
    }
    
    public String getCodigoAdicional() {
        return this.codigoAdicional;
    }
    
    public void setCodigoAdicional(final String value) {
        this.codigoAdicional = value;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String value) {
        this.descripcion = value;
    }
    
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(final BigDecimal value) {
        this.cantidad = value;
    }
    
    public DetallesAdicionales getDetallesAdicionales() {
        return this.detallesAdicionales;
    }
    
    public void setDetallesAdicionales(final DetallesAdicionales value) {
        this.detallesAdicionales = value;
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "detAdicional" })
    public static class DetallesAdicionales
    {
        protected List<DetAdicional> detAdicional;
        
        public List<DetAdicional> getDetAdicional() {
            if (this.detAdicional == null) {
                this.detAdicional = new ArrayList<DetAdicional>();
            }
            return this.detAdicional;
        }
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DetAdicional
        {
            protected String nombre;
            protected String valor;
            
            public String getNombre() {
                return this.nombre;
            }
            
            public void setNombre(final String value) {
                this.nombre = value;
            }
            
            public String getValor() {
                return this.valor;
            }
            
            public void setValor(final String value) {
                this.valor = value;
            }
        }
    }
}
