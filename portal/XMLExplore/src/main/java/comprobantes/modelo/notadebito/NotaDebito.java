package comprobantes.modelo.notadebito;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoNotaDebito", "motivos", "infoAdicional" })
@XmlRootElement(name = "notaDebito")
public class NotaDebito
{
    protected InfoTributaria infoTributaria;
    protected InfoNotaDebito infoNotaDebito;
    protected Motivos motivos;
    protected InfoAdicional infoAdicional;
    protected String id;
    protected String version;
    
    public InfoTributaria getInfoTributaria() {
        return this.infoTributaria;
    }
    
    public void setInfoTributaria(final InfoTributaria value) {
        this.infoTributaria = value;
    }
    
    public InfoNotaDebito getInfoNotaDebito() {
        return this.infoNotaDebito;
    }
    
    public void setInfoNotaDebito(final InfoNotaDebito value) {
        this.infoNotaDebito = value;
    }
    
    public Motivos getMotivos() {
        return this.motivos;
    }
    
    public void setMotivos(final Motivos value) {
        this.motivos = value;
    }
    
    public InfoAdicional getInfoAdicional() {
        return this.infoAdicional;
    }
    
    public void setInfoAdicional(final InfoAdicional value) {
        this.infoAdicional = value;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String value) {
        this.id = value;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(final String value) {
        this.version = value;
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "campoAdicional" })
    public static class InfoAdicional
    {
        protected List<CampoAdicional> campoAdicional;
        
        public List<CampoAdicional> getCampoAdicional() {
            if (this.campoAdicional == null) {
                this.campoAdicional = new ArrayList<CampoAdicional>();
            }
            return this.campoAdicional;
        }
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "value" })
        public static class CampoAdicional
        {
            protected String value;
            protected String nombre;
            
            public String getValue() {
                return this.value;
            }
            
            public void setValue(final String value) {
                this.value = value;
            }
            
            public String getNombre() {
                return this.nombre;
            }
            
            public void setNombre(final String value) {
                this.nombre = value;
            }
        }
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "impuestos", "valorTotal" })
    public static class InfoNotaDebito
    {
        protected String fechaEmision;
        protected String dirEstablecimiento;
        protected String tipoIdentificacionComprador;
        protected String razonSocialComprador;
        protected String identificacionComprador;
        protected String contribuyenteEspecial;
        protected String obligadoContabilidad;
        protected String rise;
        protected String codDocModificado;
        protected String numDocModificado;
        protected String fechaEmisionDocSustento;
        protected BigDecimal totalSinImpuestos;
        protected Impuestos impuestos;
        protected BigDecimal valorTotal;
        
        public String getFechaEmision() {
            return this.fechaEmision;
        }
        
        public void setFechaEmision(final String value) {
            this.fechaEmision = value;
        }
        
        public String getDirEstablecimiento() {
            return this.dirEstablecimiento;
        }
        
        public void setDirEstablecimiento(final String value) {
            this.dirEstablecimiento = value;
        }
        
        public String getTipoIdentificacionComprador() {
            return this.tipoIdentificacionComprador;
        }
        
        public void setTipoIdentificacionComprador(final String value) {
            this.tipoIdentificacionComprador = value;
        }
        
        public String getRazonSocialComprador() {
            return this.razonSocialComprador;
        }
        
        public void setRazonSocialComprador(final String value) {
            this.razonSocialComprador = value;
        }
        
        public String getIdentificacionComprador() {
            return this.identificacionComprador;
        }
        
        public void setIdentificacionComprador(final String value) {
            this.identificacionComprador = value;
        }
        
        public String getContribuyenteEspecial() {
            return this.contribuyenteEspecial;
        }
        
        public void setContribuyenteEspecial(final String value) {
            this.contribuyenteEspecial = value;
        }
        
        public String getObligadoContabilidad() {
            return this.obligadoContabilidad;
        }
        
        public void setObligadoContabilidad(final String value) {
            this.obligadoContabilidad = value;
        }
        
        public String getRise() {
            return this.rise;
        }
        
        public void setRise(final String value) {
            this.rise = value;
        }
        
        public String getCodDocModificado() {
            return this.codDocModificado;
        }
        
        public void setCodDocModificado(final String value) {
            this.codDocModificado = value;
        }
        
        public String getNumDocModificado() {
            return this.numDocModificado;
        }
        
        public void setNumDocModificado(final String value) {
            this.numDocModificado = value;
        }
        
        public String getFechaEmisionDocSustento() {
            return this.fechaEmisionDocSustento;
        }
        
        public void setFechaEmisionDocSustento(final String value) {
            this.fechaEmisionDocSustento = value;
        }
        
        public BigDecimal getTotalSinImpuestos() {
            return this.totalSinImpuestos;
        }
        
        public void setTotalSinImpuestos(final BigDecimal value) {
            this.totalSinImpuestos = value;
        }
        
        public Impuestos getImpuestos() {
            return this.impuestos;
        }
        
        public void setImpuestos(final Impuestos value) {
            this.impuestos = value;
        }
        
        public BigDecimal getValorTotal() {
            return this.valorTotal;
        }
        
        public void setValorTotal(final BigDecimal value) {
            this.valorTotal = value;
        }
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "impuesto" })
        public static class Impuestos
        {
            protected List<Impuesto> impuesto;
            
            public List<Impuesto> getImpuesto() {
                if (this.impuesto == null) {
                    this.impuesto = new ArrayList<Impuesto>();
                }
                return this.impuesto;
            }
        }
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "motivo" })
    public static class Motivos
    {
        protected List<Motivo> motivo;
        
        public List<Motivo> getMotivo() {
            if (this.motivo == null) {
                this.motivo = new ArrayList<Motivo>();
            }
            return this.motivo;
        }
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "razon", "valor" })
        public static class Motivo
        {
            protected String razon;
            protected BigDecimal valor;
            
            public String getRazon() {
                return this.razon;
            }
            
            public void setRazon(final String value) {
                this.razon = value;
            }
            
            public BigDecimal getValor() {
                return this.valor;
            }
            
            public void setValor(final BigDecimal value) {
                this.valor = value;
            }
        }
    }
}
