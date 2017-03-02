package ec.gob.fecuador.portal.common.navigation;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URL;

/**
 * Created by Walter on 16/1/17.
 */
public class NavigationRequest {
    public static String getURL() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        return url;
    }

    public static String getURI() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String uri = request.getRequestURI();
        return uri;
    }

    public static String getAppName() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String uri = request.getContextPath();
        return uri;
    }

    public static String getCurrentURL() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String file = request.getRequestURI();
        if (request.getQueryString() != null) {
            file += '?' + request.getQueryString();
        }
        String url = "";
        try {
            URL reconstructedURL = new URL(request.getScheme(),
                    request.getServerName(),
                    request.getServerPort(),
                    file);
            url = reconstructedURL.toString();
        } finally {
            return url;
        }

    }

    public static String getAppProtol() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String file = "";
        String url = "";
        try {
            URL reconstructedURL = new URL(request.getScheme(),
                    request.getServerName(),
                    request.getServerPort(),
                    file);
            url = reconstructedURL.toString();
        } finally {
            return url;
        }

    }

    public static String getAppURL() {
        return getAppProtol() + getAppName();

    }
}
