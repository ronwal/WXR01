package comprobantes.administracion.modelo;

import java.math.BigInteger;

public class Comprobante
{
    private String codigo;
    private BigInteger inicioSecuencia;
    
    public Comprobante(final String codigo, final BigInteger inicioSecuencia) {
        super();
        this.codigo = codigo;
        this.inicioSecuencia = inicioSecuencia;
    }
    
    public Comprobante() {
        super();
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }
    
    public BigInteger getInicioSecuencia() {
        return this.inicioSecuencia;
    }
    
    public void setInicioSecuencia(final BigInteger inicioSecuencia) {
        this.inicioSecuencia = inicioSecuencia;
    }
}
