package ec.gob.fecuador.portal.controller.login;

import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.common.navigation.NavigationRequest;
import ec.gob.fecuador.portal.common.navigation.SessionCookie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Walter on 2/3/17.
 */
@ManagedBean
@SessionScoped
public class LogoutController {

    public static final Integer ONDEMAND_CLOSE = 0;
    public static final Integer AUTOMATIC_CLOSE = 1;
    public static final Integer MULTISESS_CLOSE = 2;

    public static final String CLOSE_MODE = "closeMode";

    private HttpSession session;

    @ManagedProperty(value = "#{loginController}")
    private LoginController loginController;
    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    public LogoutController() {
    }

    /**
     * METODO: CANCELAR LOGIN
     * Permite salir del sistema, realiza el logout.
     *
     * @return url
     */
    public void cancelarLogin() {

        closeOut(ONDEMAND_CLOSE);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(NavigationRequest.getAppURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeOut(int closeParam) {
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
        if (null != this.loginController.getUser()) {
            session.setAttribute(LoginController.APP_USER, null);
            SessionCookie.remValCookie(LoginController.APP_USER);
            SessionCookie.remValCookie(LoginController.EMPRESA_USER);
            SessionCookie.remValCookie(LoginController.PASS_USER);
            SessionCookie.remValCookie(LoginController.PRFL_USER);
            SessionCookie.remValCookie(LoginController.NAV_USER);
            SessionCookie.remValCookie(LoginController.IP_USER);
        }
        if (closeParam == ONDEMAND_CLOSE) {
            session.setAttribute(CLOSE_MODE, ONDEMAND_CLOSE);
        } else if (closeParam == AUTOMATIC_CLOSE) {
            session.setAttribute(CLOSE_MODE, AUTOMATIC_CLOSE);
        }
    }

    //GETTERS Y SETTERS

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
