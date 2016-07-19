/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.ws.controller;

import ec.ste.factura.DaoManager;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.model.FECDocumento;
import ec.ste.factura.xml.ParserManager;
import org.apache.log4j.Logger;

/**
 *
 * @author German17
 */
public class LoaderController extends DaoManager {
    
    private final static Logger log = Logger.getLogger(LoaderController.class);

    private static ParserManager parseManager = new ParserManager();

    public void loadDocument(String ruc, String nick, String clave, String fileName, int registerType, byte[] xmlData) throws Exception {
        System.out.println( ruc+" - "+nick+" - "+clave+" - "+fileName+" - "+registerType+" - "+xmlData.toString());
        if (ruc == null) {
            throw new Exception("Error-01: Debe especificar el ruc");
        }

        if (ruc.trim().length() != 13) {
            throw new Exception("Error-01: El ruc debe contener 13 digitos");
        }

        if (nick == null) {
            throw new Exception("Error-02: Debe especificar el nick o Nombre de Usuario");
        }

        if (nick.trim().length() == 0) {
            throw new Exception("Error-02: Debe especificar el nick o Nombre de Usuario");
        }

        if (clave == null) {
            throw new Exception("Error-03: Debe especificar la clave de acceso");
        }

        if (clave.trim().length() == 0) {
            throw new Exception("Error-03: Debe especificar la clave de acceso");
        }

        if (fileName == null) {
            throw new Exception("Error-04: Debe especificar le nombre del archivo");
        }

        if (fileName.trim().length() == 0) {
            throw new Exception("Error-04: Debe especificar el nombre del archivo");
        }

        if (registerType != FECDocumento.ARCHIVO_ENVIADO & registerType != FECDocumento.ARCHIVO_RECIBIDO) {
            throw new Exception("Error-05: Debe especificar el tipo de registro del archivo (ENVIADO = " + FECDocumento.ARCHIVO_ENVIADO + ");(RECIBIDO = " + FECDocumento.ARCHIVO_RECIBIDO + ")");
        }

        if (xmlData == null) {
            throw new Exception("Error-06: Debe especificar el contenido del archivo xml");
        }

        if (xmlData.length == 0) {
            throw new Exception("Error-06: Debe especificar el contenido del archivo xml");
        }
        Usuario usuario = USUARIO_DAO.findUsuarioByNick(nick,null);
        if (usuario == null) {
            throw new Exception("Error-07: El usuario y/o la clave son incorrectos");
        }

        String enc = Crypt.encrypt(ruc, clave);
        
        log.debug(enc+" == "+usuario.getUsuClave());
        log.debug(clave+" == "+Crypt.decrypt(ruc, usuario.getUsuClave()));

        if (!usuario.getUsuClave().equals(enc)) {
            throw new Exception("Error-07: El usuario y/o la clave son incorrectos");
        }

        if (!"CDE".equals(usuario.getPerfil().getPrfCodigo())) {
            throw new Exception("Error-08: La cuenta suministrada no le permite cargar informacion");
        }

        if (usuario.getEmpresa() == null) {
            throw new Exception("Error-08: La cuenta suministrada no pertenece a la empresa especificada");
        }

        if (!ruc.equals(usuario.getEmpresa().getEmpCodigo())) {
            throw new Exception("Error-09: La cuenta suministrada no pertenece a la empresa especificada");
        }

        parseManager.parseDocument(ruc, fileName, registerType, xmlData);
    }

    public void login(String ruc, String nick, String clave) throws Exception {
        if (ruc == null) {
            throw new Exception("Error-01: Debe especificar el ruc");
        }

        if (ruc.trim().length() != 13) {
            throw new Exception("Error-01: El ruc debe contener 13 digitos");
        }

        if (nick == null) {
            throw new Exception("Error-02: Debe especificar el nick o Nombre de Usuario");
        }

        if (nick.trim().length() == 0) {
            throw new Exception("Error-02: Debe especificar el nick o Nombre de Usuario");
        }

        if (clave == null) {
            throw new Exception("Error-03: Debe especificar la clave de acceso");
        }

        if (clave.trim().length() == 0) {
            throw new Exception("Error-03: Debe especificar la clave de acceso");
        }

        Usuario usuario = USUARIO_DAO.findUsuarioByNick(nick,null);
        if (usuario == null) {
            throw new Exception("Error-07: El usuario y/o la clave son incorrectos");
        }

        String enc = Crypt.encrypt(ruc, clave);
        
        log.debug(enc+" == "+usuario.getUsuClave());
        log.debug(clave+" == "+Crypt.decrypt(ruc, usuario.getUsuClave()));

        if (!usuario.getUsuClave().equals(enc)) {
            throw new Exception("Error-07: El usuario y/o la clave son incorrectos");
        }

        if (!"CDE".equals(usuario.getPerfil().getPrfCodigo())) {
            throw new Exception("Error-08: La cuenta suministrada no le permite cargar informacion");
        }

        if (usuario.getEmpresa() == null) {
            throw new Exception("Error-08: La cuenta suministrada no pertenece a la empresa especificada");
        }

        if (!ruc.equals(usuario.getEmpresa().getEmpCodigo())) {
            throw new Exception("Error-09: La cuenta suministrada no pertenece a la empresa especificada");
        }
    }
}
