/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.ws.load;

import ec.ste.factura.ws.controller.LoaderController;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.log4j.Logger;

/**
 *
 * @author German17
 */
@WebService(serviceName = "WSLoader")
public class WSLoader {

    private static final Logger log = Logger.getLogger(WSLoader.class);
    private final LoaderController controller = new LoaderController();

    /**
     * Web service operation
     *
     * @param rucEmpresa
     * @param nick
     * @param clave
     * @param fileName
     * @param registerType
     * @param xmlData
     * @return
     */
    @WebMethod(operationName = "documentLoader")
    public String documentLoader(@WebParam(name = "rucEmpresa") String rucEmpresa, @WebParam(name = "nick") String nick, @WebParam(name = "clave") String clave, @WebParam(name = "fileName") String fileName, @WebParam(name = "registerType") int registerType, @WebParam(name = "xmlData") byte[] xmlData) {
        try {
            controller.loadDocument(rucEmpresa, nick, clave, fileName, registerType, xmlData);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ex.getMessage();

        }
        return "Se ha cargado el archivo " + fileName + " exitosamente.";
    }

    /**
     * Web service operation
     *
     * @param ruc
     * @param nick
     * @param password
     * @return
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "ruc") String ruc, @WebParam(name = "nick") String nick, @WebParam(name = "password") String password) {
        try {
            controller.login(ruc, nick, password);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return ex.getMessage();

        }
        return "Se ha conectado exitosamente.";
    }
}
