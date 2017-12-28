/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.xml;

import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;

/**
 * @author German17
 */
public class ParserManager {

    private final Logger log = Logger.getLogger(ParserManager.class);

    public String parseDocument(byte xmlData[]) throws Exception {
        ParserBase base = new ParserBase();

        log.trace("Recibiendo archivo: " + xmlData);

        DocumentoAutorizado doc = base.parseXMLFile(xmlData);

        log.trace("Archivo base interpretado");

        DatabaseEntity entity = null;

        if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.factura.Factura) {
            log.trace("Archivo reconocido como Factura");
            ec.gob.sri.comprobantes.modelo.factura.Factura fact = (ec.gob.sri.comprobantes.modelo.factura.Factura) doc.getDocumento();
            return fact.getInfoTributaria().getClaveAcceso();
        } else if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion) {
            log.trace("Archivo reconocido como Comprobante de Retencion");
            ComprobanteRetencion ret = (ComprobanteRetencion) doc.getDocumento();
            return ret.getInfoTributaria().getClaveAcceso();
        } else if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito) {
            log.trace("Archivo reconocido como Nota de Credito");
            NotaCredito not = (NotaCredito) doc.getDocumento();
            return not.getInfoTributaria().getClaveAcceso();
        } else if (doc.getDocumento() instanceof ec.gob.sri.comprobantes.modelo.guia.GuiaRemision) {
            log.trace("Archivo reconocido como Guia Remision");
            GuiaRemision gr = (GuiaRemision) doc.getDocumento();
            return gr.getInfoTributaria().getClaveAcceso();
        }
        return "";
    }

    public String getClaveAcceso(byte xmlData[]) throws Exception {
        String data = new String(xmlData);
        xmlData = data.getBytes("UTF-8");
        log.trace("Recibiendo archivo: " + xmlData);

        data = LectorComprobante.getClaveAcc(new ByteArrayInputStream(xmlData));

        log.trace("Archivo base interpretado");

        return data;
    }

}
