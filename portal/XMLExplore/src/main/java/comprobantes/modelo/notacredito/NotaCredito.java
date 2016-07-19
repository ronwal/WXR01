package comprobantes.modelo.notacredito;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoNotaCredito", "detalles", "infoAdicional" })
@XmlRootElement(name = "notaCredito")
public class NotaCredito
{
    protected InfoTributaria infoTributaria;
    protected InfoNotaCredito infoNotaCredito;
    protected Detalles detalles;
    protected InfoAdicional infoAdicional;
    protected String id;
    protected String version;
    
    public InfoTributaria getInfoTributaria() {
        return this.infoTributaria;
    }
    
    public void setInfoTributaria(final InfoTributaria value) {
        this.infoTributaria = value;
    }
    
    public InfoNotaCredito getInfoNotaCredito() {
        return this.infoNotaCredito;
    }
    
    public void setInfoNotaCredito(final InfoNotaCredito value) {
        this.infoNotaCredito = value;
    }
    
    public Detalles getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(final Detalles value) {
        this.detalles = value;
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
    @XmlType(name = "", propOrder = { "detalle" })
    public static class Detalles
    {
        protected List<Detalle> detalle;
        
        public List<Detalle> getDetalle() {
            if (this.detalle == null) {
                this.detalle = new ArrayList<Detalle>();
            }
            return this.detalle;
        }
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "codigoInterno", "codigoAdicional", "descripcion", "cantidad", "precioUnitario", "descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos" })
        public static class Detalle
        {
            protected String codigoInterno;
            protected String codigoAdicional;
            protected String descripcion;
            protected BigDecimal cantidad;
            protected BigDecimal precioUnitario;
            protected BigDecimal descuento;
            protected BigDecimal precioTotalSinImpuesto;
            protected DetallesAdicionales detallesAdicionales;
            protected Impuestos impuestos;
            
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
            
            public BigDecimal getPrecioUnitario() {
                return this.precioUnitario;
            }
            
            public void setPrecioUnitario(final BigDecimal value) {
                this.precioUnitario = value;
            }
            
            public BigDecimal getDescuento() {
                return this.descuento;
            }
            
            public void setDescuento(final BigDecimal value) {
                this.descuento = value;
            }
            
            public BigDecimal getPrecioTotalSinImpuesto() {
                return this.precioTotalSinImpuesto;
            }
            
            public void setPrecioTotalSinImpuesto(final BigDecimal value) {
                this.precioTotalSinImpuesto = value;
            }
            
            public DetallesAdicionales getDetallesAdicionales() {
                return this.detallesAdicionales;
            }
            
            public void setDetallesAdicionales(final DetallesAdicionales value) {
                this.detallesAdicionales = value;
            }
            
            public Impuestos getImpuestos() {
                return this.impuestos;
            }
            
            public void setImpuestos(final Impuestos value) {
                this.impuestos = value;
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
    @XmlType(name = "", propOrder = { "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "valorModificacion", "moneda", "totalConImpuestos", "motivo" })
    public static class InfoNotaCredito
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
        protected BigDecimal valorModificacion;
        protected String moneda;
        protected TotalConImpuestos totalConImpuestos;
        protected String motivo;
        
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
        
        public BigDecimal getValorModificacion() {
            return this.valorModificacion;
        }
        
        public void setValorModificacion(final BigDecimal value) {
            this.valorModificacion = value;
        }
        
        public String getMoneda() {
            return this.moneda;
        }
        
        public void setMoneda(final String value) {
            this.moneda = value;
        }
        
        public TotalConImpuestos getTotalConImpuestos() {
            return this.totalConImpuestos;
        }
        
        public void setTotalConImpuestos(final TotalConImpuestos value) {
            this.totalConImpuestos = value;
        }
        
        public String getMotivo() {
            return this.motivo;
        }
        
        public void setMotivo(final String value) {
            this.motivo = value;
        }
    }
}
