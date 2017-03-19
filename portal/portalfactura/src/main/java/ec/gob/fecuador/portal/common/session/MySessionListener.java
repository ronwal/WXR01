package ec.gob.fecuador.portal.common.session;

import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.controller.login.LoginController;
import org.springframework.web.context.ContextLoaderListener;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener extends ContextLoaderListener implements HttpSessionListener {

    static int users = 0;

    private UsuarioEntity user;
    private FacesContext facesContext;
    @ManagedProperty(value = "#{loginControlador}")
    private LoginController loginControlador;

    //ManagedProperties
    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    public static int getUsers() {
        return users;
    }

    /**
     * METODO: SESSION CREATED Se dispara (trigger) cuando se crea una nueva
     * sesion en el sistema.
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {

        try {
            users++;
        } catch (Exception e) {

        }
    }

    /**
     * METODO: SESSION DESTROYED Se dispara (trigger) cuando se destruye o
     * caduca una nueva sesion en el sistema.
     */

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        try {
            users--;
            this.user = null;
            if (null != event.getSession().getAttribute("app_user")) {

                event.getSession().invalidate();

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al destuir la sesion del sistema", ""));
        }

    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
