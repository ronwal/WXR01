/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.xml;

/**
 *
 * @author German17
 */
public interface FECParser {

    public DocumentoAutorizado parseXMLFile(byte datosXML[]) throws Exception;

}
