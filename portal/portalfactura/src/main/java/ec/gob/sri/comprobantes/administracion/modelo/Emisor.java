package ec.gob.sri.comprobantes.administracion.modelo;

public class Emisor
{
    private Integer codigo;
    private Integer tiempoEspera;
    private String ruc;
    private String razonSocial;
    private String nombreComercial;
    private String dirEstablecimiento;
    private String codigoEstablecimiento;
    private String numeroResolusion;
    private String contribuyenteEspecial;
    private String llevaContabilidad;
    private String pathLogo;
    private String tipoEmision;
    private String codPuntoEmision;
    private String tipoAmbiente;
    private String claveInterna;
    private String direccionMatriz;
    private String token;
    
    public String getTipoAmbiente() {
        return this.tipoAmbiente;
    }
    
    public void setTipoAmbiente(final String tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }
    
    public String getClaveInterna() {
        return this.claveInterna;
    }
    
    public void setClaveInterna(final String claveInterna) {
        this.claveInterna = claveInterna;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(final String ruc) {
        this.ruc = ruc;
    }
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getNombreComercial() {
        return this.nombreComercial;
    }
    
    public void setNombreComercial(final String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    
    public String getDirEstablecimiento() {
        return this.dirEstablecimiento;
    }
    
    public void setDirEstablecimiento(final String dirEstablecimiento) {
        this.dirEstablecimiento = dirEstablecimiento;
    }
    
    public String getCodigoEstablecimiento() {
        return this.codigoEstablecimiento;
    }
    
    public void setCodigoEstablecimiento(final String codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }
    
    public String getNumeroResolusion() {
        return this.numeroResolusion;
    }
    
    public void setNumeroResolusion(final String numeroResolusion) {
        this.numeroResolusion = numeroResolusion;
    }
    
    public String getContribuyenteEspecial() {
        return this.contribuyenteEspecial;
    }
    
    public void setContribuyenteEspecial(final String contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
    }
    
    public String getLlevaContabilidad() {
        return this.llevaContabilidad;
    }
    
    public void setLlevaContabilidad(final String llevaContabilidad) {
        this.llevaContabilidad = llevaContabilidad;
    }
    
    public String getPathLogo() {
        return this.pathLogo;
    }
    
    public void setPathLogo(final String pathLogo) {
        this.pathLogo = pathLogo;
    }
    
    public String getTipoEmision() {
        return this.tipoEmision;
    }
    
    public void setTipoEmision(final String tipoEmision) {
        this.tipoEmision = tipoEmision;
    }
    
    public Integer getTiempoEspera() {
        return this.tiempoEspera;
    }
    
    public void setTiempoEspera(final Integer tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
    
    public String getCodPuntoEmision() {
        return this.codPuntoEmision;
    }
    
    public void setCodPuntoEmision(final String codPuntoEmision) {
        this.codPuntoEmision = codPuntoEmision;
    }
    
    public String getDireccionMatriz() {
        return this.direccionMatriz;
    }
    
    public void setDireccionMatriz(final String direccionMatriz) {
        this.direccionMatriz = direccionMatriz;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
}
