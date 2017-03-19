package ec.gob.fecuador.portal.common.session;

import ec.gob.fecuador.portal.common.navigation.NavigationRequest;
import ec.gob.fecuador.portal.controller.login.LoginController;
import ec.gob.fecuador.portal.controller.login.LogoutController;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyPhaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

    private static final String homePage = "/views/index.xhtml";
    private static final String publicPage = "/public";
    private static final String privatePage = "/empresa";
    private static final String homeDashBoard = "/views/empresa/index.xhtml";
    private static String homeURL = "/views/index.xhtml";
    private HttpSession session = null;

    @Override
    public void afterPhase(PhaseEvent event) {

        homeURL = NavigationRequest.getAppURL();

        FacesContext context = event.getFacesContext();
        String currentPage = context.getViewRoot().getViewId();

        boolean isLoginPage = (currentPage.lastIndexOf(homePage) > -1);
        boolean isPublicPage = (currentPage.lastIndexOf(publicPage) > -1);
        boolean isPrivate = (currentPage.lastIndexOf(privatePage) > -1);

        session = (HttpSession) context.getExternalContext().getSession(Boolean.FALSE);

        Object autSess = null;
        Object currentUser = null;
        Object closeMode = null;

        if (session == null) {
            session = (HttpSession) context.getExternalContext()
                    .getSession(Boolean.TRUE);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(homeURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            currentUser = session.getAttribute(LoginController.APP_USER);
            autSess = session.getAttribute(CheckInSession.CLOSE_AUT);
            closeMode = session.getAttribute(LogoutController.CLOSE_MODE);

            if (isPrivate && (currentUser == null || currentUser == "")) {
                try {
                    if (autSess == null) {
                        session.invalidate();
                    }
                    FacesContext.getCurrentInstance().getExternalContext().redirect(homeURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (isLoginPage && (currentUser != null && !currentUser.toString().isEmpty())) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(homeURL + homeDashBoard);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (autSess != null) {
            if (autSess.equals(LogoutController.AUTOMATIC_CLOSE)) {
            /*Flash flash = facesContext.getExternalContext().getFlash();
            flash.setKeepMessages(true);
            flash.setRedirect(true);*/
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, CheckInSession.msjAut, ""));
                session.setAttribute(CheckInSession.CLOSE_AUT, null);
            } else if (autSess.equals(LogoutController.MULTISESS_CLOSE)) {
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, CheckInSession.msjMulti, ""));
            }
            session.setAttribute(CheckInSession.CLOSE_AUT, null);
            facesContext.getExternalContext().getSessionMap().replace(CheckInSession.CLOSE_AUT, null);
            facesContext.getExternalContext().getSessionMap().remove(CheckInSession.CLOSE_AUT);
        }

        if (closeMode == LogoutController.ONDEMAND_CLOSE) {
            session = (HttpSession) context.getExternalContext().getSession(Boolean.FALSE);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            session.invalidate();
        }

        //session = (HttpSession) context.getExternalContext().getSession(false);
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }


}
