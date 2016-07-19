/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.xml;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;

/**
 *
 * @author German17
 */
public interface FECParser {
    
    
    
    public DocumentoAutorizado parseXMLFile(String ruc, String nombreArchivo, int tipoRegistro, byte datosXML[])throws Exception;
    
 
    
}
