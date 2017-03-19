package ec.gob.fecuador.portal.common.navigation;

import ec.gob.fecuador.config.properties.ConfigProp;
import ec.gob.fecuador.portal.controller.login.LoginController;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Map;

/**
 * Created by Walter on 2/3/17.
 */
@ManagedBean
@SessionScoped
public class Util {
    public StreamedContent getStreamImage() throws Exception {
        StreamedContent streamImage = new DefaultStreamedContent();
        try {
            String absPath;
            FileInputStream fis;
            BufferedInputStream bis;

            Map<String, String> param =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            if (param.get("imgparm") != null) {
                String codEmp = param.get("imgparm");
                absPath = ConfigProp.getInstance().getProperty(LoginController.PATH_LOGO) + codEmp.concat(".png");
            } else {
                absPath = ConfigProp.getInstance().getProperty(LoginController.PATH_LOGO) + "logo-cr.png";
            }

            fis = new FileInputStream(absPath);
            bis = new BufferedInputStream(fis);
            streamImage = new DefaultStreamedContent(bis);
        } finally {
            return streamImage;
        }
    }
}
