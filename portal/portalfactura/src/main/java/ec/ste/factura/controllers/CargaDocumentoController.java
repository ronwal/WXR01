/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.controllers;

import ec.ste.factura.util.FileUtil;
import ec.ste.factura.xml.ParserManager;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author German17
 */
public class CargaDocumentoController implements Serializable {

   

    private LoginController login;
    private final ParserManager parser = new ParserManager();

    private int tipoRegistro;

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public void cargarDocumento(File file) throws Exception {
        parser.parseDocument(login.getEmpresa().getEmpCodigo(), file.getName(), tipoRegistro, FileUtil.openFile(file));
    }

}
