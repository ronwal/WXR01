/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.beans;

import ec.ste.factura.controllers.CargaDocumentoController;
import ec.ste.factura.util.FacesUtil;
import ec.ste.factura.util.FileUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;

/**
 *
 * @author German17
 */
@ManagedBean
@ViewScoped
public class CargaDocumentoBean implements Serializable {
    private final static Logger log = Logger.getLogger(CargaDocumentoBean.class);
    private final CargaDocumentoController controller=new CargaDocumentoController();
    
    @ManagedProperty(value = "#{login}")
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
        controller.setLogin(login.getController());
    }

    public int getTipoRegistro() {
        return controller.getTipoRegistro();
    }

    public void setTipoRegistro(int tipoRegistro) {
        controller.setTipoRegistro(tipoRegistro);
    }
    
    
    

    public void formListener(FileEntryEvent e) {
        FileEntry fe = (FileEntry) e.getComponent();
        
        FileEntryResults results = fe.getResults();
        
        ArrayList<FileEntryResults.FileInfo> files = results.getFiles();
        try {
            for (FileEntryResults.FileInfo f : files) {
                System.out.println(f.getFile().getAbsolutePath());
                controller.cargarDocumento(f.getFile());
            }
            FacesUtil.addInfoMessage("Se ha cargado el archivo exitosamente.");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage(ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

}
