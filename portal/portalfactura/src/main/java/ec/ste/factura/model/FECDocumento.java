/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.model;

import ec.ste.factura.DatabaseEntity;
import org.w3c.dom.Document;

/**
 *
 * @author German17
 */
public class FECDocumento {

    public static final int DESCONOCIDO = 0;
    public static final int FACTURA = 1;
    public static final int COMPROBANTE_RETENCION = 2;
    public static final int NOTA_CREDITO = 3;
    public static final int NOTA_DEBITO = 4;
    public static final int GUIA_REMISION = 5;
    public static final int ARCHIVO_ENVIADO = 1;
    public static final int ARCHIVO_RECIBIDO = 2;
    private String ruc;
    private String archivo;
    private int tipoDocumento = DESCONOCIDO;
    private int tipoRegistro = DESCONOCIDO;
    private byte xmlOriginal[];
    private String xmlComprobante;
    private Document documentoOriginal;
    private Document documentoComprobante;
    private DatabaseEntity databaseEntity;

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public byte[] getXmlOriginal() {
        return xmlOriginal;
    }

    public void setXmlOriginal(byte[] xmlOriginal) {
        this.xmlOriginal = xmlOriginal;
    }

    public String getXmlComprobante() {
        return xmlComprobante;
    }

    public void setXmlComprobante(String xmlComprobante) {
        this.xmlComprobante = xmlComprobante;
    }

    public Document getDocumentoOriginal() {
        return documentoOriginal;
    }

    public void setDocumentoOriginal(Document documentoOriginal) {
        this.documentoOriginal = documentoOriginal;
    }
    
    

    public Document getDocumentoComprobante() {
        return documentoComprobante;
    }

    public void setDocumentoComprobante(Document documentoComprobante) {
        this.documentoComprobante = documentoComprobante;
    }

    public DatabaseEntity getDatabaseEntity() {
        return databaseEntity;
    }

    public void setDatabaseEntity(DatabaseEntity databaseEntity) {
        this.databaseEntity = databaseEntity;
    }
}
