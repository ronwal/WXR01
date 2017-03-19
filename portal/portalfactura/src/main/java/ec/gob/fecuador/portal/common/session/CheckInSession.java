package ec.gob.fecuador.portal.common.session;

import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.controller.login.LoginController;
import ec.gob.fecuador.portal.controller.login.LogoutController;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Walter on 8/2/17.
 */
@ManagedBean
@SessionScoped
@RemoteProxy
public class CheckInSession {

    public static final String CLOSE_AUT = "closeAutomatic";
    public static final String msjCont = "Saliendo del Sistema";
    public static final String msjAut = "Su sesion ha sido cerrada en otra pestaña/ventana";
    public static final String msjMulti = "Usuario no habilitado para multiples sesiones, contacte al ADMIN.";
    private static final String homePage = "/views/login/index.xhtml";
    private HttpSession session;

    @ManagedProperty("#{logoutController}")
    private LogoutController logoutController;
    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    public static String getMsjCont() {
        return msjCont;
    }

    public static String getMsjAut() {
        return msjAut;
    }

    public static String getMsjMulti() {
        return msjMulti;
    }

    @RemoteMethod
    public boolean getActiveSession() {
        boolean bn = false;
        try {
            if (getHttpSession() != null) {
                String appUser = (String) getHttpSession().getAttribute(LoginController.APP_USER);
                if (appUser != null) {
                    if (!appUser.isEmpty())
                        bn = true;
                    else if (appUser.isEmpty())
                        getHttpSession().setAttribute(CLOSE_AUT, LogoutController.AUTOMATIC_CLOSE);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CheckInSession.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            return bn;
        }
    }

    public String closeOutSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            logoutController.closeOut(LogoutController.AUTOMATIC_CLOSE);
            //"Su session a expirado"
            //CustomerUtils.msgFacesDialogBox("Saliendo de Sistema", "Usuario no habilitado para varias sesiones, por favor contacte al administrador.", FacesMessage.SEVERITY_WARN);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msjCont, msjMulti));
            context.getExternalContext().getFlash().setKeepMessages(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("OK ==> " + context.getMessageList().size());

        NavigationHandler nh = context.getApplication().getNavigationHandler();
        nh.handleNavigation(context, null, homePage + "");

        return homePage;
    }

    public HttpSession getHttpSession() {
        return WebContextFactory.get().getSession();
    }

    public LogoutController getLogoutController() {
        return logoutController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}