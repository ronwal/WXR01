package comprobantes.modelo.factura;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoFactura", "detalles", "infoAdicional","id","version" })
@XmlRootElement(name = "factura")
public class Factura
{
    protected InfoTributaria infoTributaria;
    protected InfoFactura infoFactura;
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
    
    public InfoFactura getInfoFactura() {
        return this.infoFactura;
    }
    
    public void setInfoFactura(final InfoFactura value) {
        this.infoFactura = value;
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
        @XmlType(name = "", propOrder = { "codigoPrincipal", "codigoAuxiliar", "descripcion", "cantidad", "precioUnitario", "descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos" })
        public static class Detalle
        {
            protected String codigoPrincipal;
            protected String codigoAuxiliar;
            protected String descripcion;
            protected BigDecimal cantidad;
            protected BigDecimal precioUnitario;
            protected BigDecimal descuento;
            protected BigDecimal precioTotalSinImpuesto;
            protected DetallesAdicionales detallesAdicionales;
            protected Impuestos impuestos;
            
            public String getCodigoPrincipal() {
                return this.codigoPrincipal;
            }
            
            public void setCodigoPrincipal(final String value) {
                this.codigoPrincipal = value;
            }
            
            public String getCodigoAuxiliar() {
                return this.codigoAuxiliar;
            }
            
            public void setCodigoAuxiliar(final String value) {
                this.codigoAuxiliar = value;
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
        @XmlType(name = "", propOrder = { "value","nombre" })
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
    @XmlType(name = "", propOrder = { "fechaEmision", "dirEstablecimiento", "contribuyenteEspecial", "obligadoContabilidad", "tipoIdentificacionComprador", "guiaRemision", "razonSocialComprador", "identificacionComprador", "totalSinImpuestos", "totalDescuento", "totalConImpuestos", "propina", "importeTotal", "moneda" })
    public static class InfoFactura
    {
        protected String fechaEmision;
        protected String dirEstablecimiento;
        protected String contribuyenteEspecial;
        protected String obligadoContabilidad;
        protected String tipoIdentificacionComprador;
        protected String guiaRemision;
        protected String razonSocialComprador;
        protected String identificacionComprador;
        protected BigDecimal totalSinImpuestos;
        protected BigDecimal totalDescuento;
        protected TotalConImpuestos totalConImpuestos;
        protected BigDecimal propina;
        protected BigDecimal importeTotal;
        protected String moneda;
        
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
        
        public String getTipoIdentificacionComprador() {
            return this.tipoIdentificacionComprador;
        }
        
        public void setTipoIdentificacionComprador(final String value) {
            this.tipoIdentificacionComprador = value;
        }
        
        public String getGuiaRemision() {
            return this.guiaRemision;
        }
        
        public void setGuiaRemision(final String value) {
            this.guiaRemision = value;
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
        
        public BigDecimal getTotalSinImpuestos() {
            return this.totalSinImpuestos;
        }
        
        public void setTotalSinImpuestos(final BigDecimal value) {
            this.totalSinImpuestos = value;
        }
        
        public BigDecimal getTotalDescuento() {
            return this.totalDescuento;
        }
        
        public void setTotalDescuento(final BigDecimal value) {
            this.totalDescuento = value;
        }
        
        public TotalConImpuestos getTotalConImpuestos() {
            return this.totalConImpuestos;
        }
        
        public void setTotalConImpuestos(final TotalConImpuestos value) {
            this.totalConImpuestos = value;
        }
        
        public BigDecimal getPropina() {
            return this.propina;
        }
        
        public void setPropina(final BigDecimal value) {
            this.propina = value;
        }
        
        public BigDecimal getImporteTotal() {
            return this.importeTotal;
        }
        
        public void setImporteTotal(final BigDecimal value) {
            this.importeTotal = value;
        }
        
        public String getMoneda() {
            return this.moneda;
        }
        
        public void setMoneda(final String value) {
            this.moneda = value;
        }
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "totalImpuesto" })
        public static class TotalConImpuestos
        {
            protected List<TotalImpuesto> totalImpuesto;
            
            public List<TotalImpuesto> getTotalImpuesto() {
                if (this.totalImpuesto == null) {
                    this.totalImpuesto = new ArrayList<TotalImpuesto>();
                }
                return this.totalImpuesto;
            }
            
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = { "codigo", "codigoPorcentaje", "baseImponible", "tarifa", "valor" })
            public static class TotalImpuesto
            {
                protected String codigo;
                protected String codigoPorcentaje;
                protected BigDecimal baseImponible;
                protected BigDecimal tarifa;
                protected BigDecimal valor;
                
                public String getCodigo() {
                    return this.codigo;
                }
                
                public void setCodigo(final String value) {
                    this.codigo = value;
                }
                
                public String getCodigoPorcentaje() {
                    return this.codigoPorcentaje;
                }
                
                public void setCodigoPorcentaje(final String value) {
                    this.codigoPorcentaje = value;
                }
                
                public BigDecimal getBaseImponible() {
                    return this.baseImponible;
                }
                
                public void setBaseImponible(final BigDecimal value) {
                    this.baseImponible = value;
                }
                
                public BigDecimal getTarifa() {
                    return this.tarifa;
                }
                
                public void setTarifa(final BigDecimal value) {
                    this.tarifa = value;
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
}
