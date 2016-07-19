package comprobantes.modelo.guia;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoGuiaRemision", "destinatarios", "infoAdicional" })
@XmlRootElement(name = "guiaRemision")
public class GuiaRemision
{
    protected InfoTributaria infoTributaria;
    protected InfoGuiaRemision infoGuiaRemision;
    protected Destinatarios destinatarios;
    protected InfoAdicional infoAdicional;
    protected String id;
    protected String version;
    
    public InfoTributaria getInfoTributaria() {
        return this.infoTributaria;
    }
    
    public void setInfoTributaria(final InfoTributaria value) {
        this.infoTributaria = value;
    }
    
    public InfoGuiaRemision getInfoGuiaRemision() {
        return this.infoGuiaRemision;
    }
    
    public void setInfoGuiaRemision(final InfoGuiaRemision value) {
        this.infoGuiaRemision = value;
    }
    
    public Destinatarios getDestinatarios() {
        return this.destinatarios;
    }
    
    public void setDestinatarios(final Destinatarios value) {
        this.destinatarios = value;
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
    @XmlType(name = "", propOrder = { "destinatario" })
    public static class Destinatarios
    {
        protected List<Destinatario> destinatario;
        
        public List<Destinatario> getDestinatario() {
            if (this.destinatario == null) {
                this.destinatario = new ArrayList<Destinatario>();
            }
            return this.destinatario;
        }
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
    @XmlType(name = "", propOrder = { "dirEstablecimiento", "dirPartida", "razonSocialTransportista", "tipoIdentificacionTransportista", "rucTransportista", "rise", "obligadoContabilidad", "contribuyenteEspecial", "fechaIniTransporte", "fechaFinTransporte", "placa" })
    public static class InfoGuiaRemision
    {
        protected String dirEstablecimiento;
        protected String dirPartida;
        protected String razonSocialTransportista;
        protected String tipoIdentificacionTransportista;
        protected String rucTransportista;
        protected String rise;
        protected String obligadoContabilidad;
        protected String contribuyenteEspecial;
        protected String fechaIniTransporte;
        protected String fechaFinTransporte;
        protected String placa;
        
        public String getDirEstablecimiento() {
            return this.dirEstablecimiento;
        }
        
        public void setDirEstablecimiento(final String value) {
            this.dirEstablecimiento = value;
        }
        
        public String getDirPartida() {
            return this.dirPartida;
        }
        
        public void setDirPartida(final String value) {
            this.dirPartida = value;
        }
        
        public String getRazonSocialTransportista() {
            return this.razonSocialTransportista;
        }
        
        public void setRazonSocialTransportista(final String value) {
            this.razonSocialTransportista = value;
        }
        
        public String getTipoIdentificacionTransportista() {
            return this.tipoIdentificacionTransportista;
        }
        
        public void setTipoIdentificacionTransportista(final String value) {
            this.tipoIdentificacionTransportista = value;
        }
        
        public String getRucTransportista() {
            return this.rucTransportista;
        }
        
        public void setRucTransportista(final String value) {
            this.rucTransportista = value;
        }
        
        public String getRise() {
            return this.rise;
        }
        
        public void setRise(final String value) {
            this.rise = value;
        }
        
        public String getObligadoContabilidad() {
            return this.obligadoContabilidad;
        }
        
        public void setObligadoContabilidad(final String value) {
            this.obligadoContabilidad = value;
        }
        
        public String getContribuyenteEspecial() {
            return this.contribuyenteEspecial;
        }
        
        public void setContribuyenteEspecial(final String value) {
            this.contribuyenteEspecial = value;
        }
        
        public String getFechaIniTransporte() {
            return this.fechaIniTransporte;
        }
        
        public void setFechaIniTransporte(final String value) {
            this.fechaIniTransporte = value;
        }
        
        public String getFechaFinTransporte() {
            return this.fechaFinTransporte;
        }
        
        public void setFechaFinTransporte(final String value) {
            this.fechaFinTransporte = value;
        }
        
        public String getPlaca() {
            return this.placa;
        }
        
        public void setPlaca(final String value) {
            this.placa = value;
        }
    }
}
