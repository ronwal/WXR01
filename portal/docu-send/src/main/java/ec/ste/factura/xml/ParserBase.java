/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.xml;
/**
 *
 * @author German17
 */
public class ParserBase implements FECParser {

    @Override
    public DocumentoAutorizado parseXMLFile(byte[] datosXML) throws Exception {

        String data = new String(datosXML);
        datosXML = data.getBytes("UTF-8");


        FECDocumento fecDocumento = new FECDocumento();
        
        fecDocumento.setXmlOriginal(datosXML);
        
        DocumentoAutorizado documentoAutorizado=LectorComprobante.extraerInstanciaDocumento(datosXML);

        return documentoAutorizado;
    }
}
