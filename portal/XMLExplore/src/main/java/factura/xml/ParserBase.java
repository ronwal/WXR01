/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.xml;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;
import ec.ste.factura.model.FECDocumento;

/**
 *
 * @author German17
 */
public class ParserBase implements FECParser {

    @Override
    public DocumentoAutorizado parseXMLFile(String ruc, String nombreArchivo, int tipoRegistro, byte[] datosXML) throws Exception {

        String data = new String(datosXML);
        datosXML = data.getBytes("UTF-8");


        FECDocumento fecDocumento = new FECDocumento();

        fecDocumento.setArchivo(nombreArchivo);
        fecDocumento.setXmlOriginal(datosXML);
        fecDocumento.setRuc(ruc);
        fecDocumento.setTipoRegistro(tipoRegistro);
        
        DocumentoAutorizado documentoAutorizado=LectorComprobante.extraerInstanciaDocumento(datosXML);

        return documentoAutorizado;
    }
}
