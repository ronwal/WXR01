/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.util;

import com.icesoft.faces.context.effects.JavascriptContext;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FactoryFinder;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FacesUtil {

    // Getters -----------------------------------------------------------------------------------
    public static FacesContext getFacesContext(HttpServletRequest request, HttpServletResponse response) {
        // Get current FacesContext.
        FacesContext facesContext = FacesContext.getCurrentInstance();

        // Check current FacesContext.
        if (facesContext == null) {

            // Create new Lifecycle.
            LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
            Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

            // Create new FacesContext.
            FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
            facesContext = contextFactory.getFacesContext(
                    request.getSession().getServletContext(), request, response, lifecycle);

            // Create new View.
            UIViewRoot view = facesContext.getApplication().getViewHandler().createView(
                    facesContext, "");
            facesContext.setViewRoot(view);

            // Set current FacesContext.
            FacesContextWrapper.setCurrentInstance(facesContext);
        }

        return facesContext;
    }

    public static synchronized FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static synchronized ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    public static synchronized Object getSessionContextBean(String nombreBean) {
        HttpSession session = (HttpSession) getExternalContext().getSession(true);
        return session.getAttribute(nombreBean);
    }

    public static synchronized String getRemoteIpAddress() {
        Object o = getFacesContext().getExternalContext().getRequest();
        if (o instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) o;
            String ip = request.getRemoteAddr();
            if (ip != null) {
                return ip;
            } else {
                ip = request.getRemoteHost();
                if (ip != null) {
                    return ip;
                }
            }
            return "0.0.0.0";
        } else {
            return "0.0.0.0";
        }

    }

    public static synchronized String getSessionId() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        String sessionId = session.getId();
        return sessionId;
    }

    public static synchronized HttpSession getHttpSession() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        return session;
    }

    public static void redirect(String url) {

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        if (url.startsWith("/")) {
            url = externalContext.getRequestContextPath() + url;
        }
        try {
            externalContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(FacesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void openUrl(String url) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        if (!url.startsWith("/")) {
            url = "/" + url;
        }
        url = externalContext.getRequestContextPath() + url;
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open(\"" + url + "\",\"_self\");");
    }

    @SuppressWarnings("unchecked")
    public static <T> T findBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }

    @SuppressWarnings("unchecked")
    public static <T> T findBean(HttpServletRequest request, HttpServletResponse response, String beanName) {
        FacesContext context = getFacesContext(request, response);
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }

    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "messageDialog.show();");
    }

    public static void addWarnMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "messageDialog.show();");
    }

    public static void addInfoMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "messageDialog.show();");
    }

    // Helpers -----------------------------------------------------------------------------------
    // Wrap the protected FacesContext.setCurrentInstance() in a inner class.
    private static abstract class FacesContextWrapper extends FacesContext {

        protected static void setCurrentInstance(FacesContext facesContext) {
            FacesContext.setCurrentInstance(facesContext);
        }
    }
}
