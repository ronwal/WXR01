package ec.gob.fecuador.portal.controller.login;

import ec.fecuador.persistence.factecuador.data.entities.DetalleMenuSystemEntity;
import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;
import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;
import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.common.enumerate.TipoDocElect;
import ec.gob.fecuador.portal.common.navigation.NavigationRequest;
import ec.gob.fecuador.portal.common.navigation.SessionCookie;
import ec.gob.fecuador.security.encryption.Crypt;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Walter on 22/2/17.
 */
@ManagedBean
@SessionScoped
public class LoginController {

    public static final String PERFIL_INVITADO = "INV";
    public static final String APP_USER = "userAPP";
    public static final String EMPRESA_USER = "userEMP";
    public static final String PASS_USER = "userTKN";
    public static final String NAV_USER = "userBROW";
    public static final String IP_USER = "userIP";
    public static final String PRFL_USER = "userPRFL";
    public static final String PATH_LOGO = "ec.gob.factura.path.logos";
    public static final String HS_USR = "userHash";

    private HttpSession session;

    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    private int docSearch;

    private String user;
    private String password;
    private String empUsu;
    private String homeUrl = NavigationRequest.getAppURL();

    private EmpresaEntity empSel;

    public List<DetalleMenuSystemEntity> getMemuSystem() {
        List<DetalleMenuSystemEntity> systemEntities = null;
        String sessPRF = (String) SessionCookie.getValCookie(PRFL_USER);
        PerfilEntity perfilEntity;
        if (sessPRF != null) {
            perfilEntity = facElectOpDAO.getPerfilByCodPrf(sessPRF);
        } else {
            perfilEntity = facElectOpDAO.getPerfilByCodPrf(PERFIL_INVITADO);
        }
        perfilEntity = (PerfilEntity) facElectOpDAO.lazyLoad(PerfilEntity.class, perfilEntity);
        systemEntities = perfilEntity.getDetalleMenuSystem();
        return systemEntities;
    }

    public String loginUser() {
        String url = "";
        try {
            UsuarioEntity user_ = facElectOpDAO.getAUser(user, empSel.getEmpCodigo());
            if (user_ != null) {
                String tkn = user_.getEmpresaByEmpCodigo() != null ? user_.getEmpresaByEmpCodigo().getEmpCodigo() : user_.getUsuIdentificacion();
                user_ = facElectOpDAO.getAUser(user, Crypt.encrypt(tkn, password), empSel.getEmpCodigo());
                if (user_ != null)
                    if (user_.getUsuActivo()) {
                        url = "views/empresa/index.xhtml";

                        HttpServletRequest request = (HttpServletRequest) (FacesContext
                                .getCurrentInstance().getExternalContext()
                                .getRequest());
                        ExternalContext externalContext = FacesContext
                                .getCurrentInstance().getExternalContext();
                        String browser = externalContext.getRequestHeaderMap().get(
                                "User-Agent");

                        SessionCookie.setValCookie(APP_USER, user_.getUsuNick());
                        SessionCookie.setValCookie(EMPRESA_USER, user_.getEmpCodigo());
                        SessionCookie.setValCookie(PASS_USER, user_.getUsuClave());
                        SessionCookie.setValCookie(PRFL_USER, user_.getPrfCodigo());
                        SessionCookie.setValCookie(NAV_USER, browser);
                        SessionCookie.setValCookie(IP_USER, request.getRemoteAddr());

                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso Exitoso!!!", ""));

                        try {
                            FacesContext.getCurrentInstance().getExternalContext().redirect(NavigationRequest.getAppURL() + "/" + url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario se encuentra desactivado.", ""));
                    }
            }
            if (user_ == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario no Registrado o Contraseña Incorrecta.", ""));
            }

        } finally {
            return url;
        }

    }

    public String createURL(String urlPath, String content) {
        if (!content.isEmpty())
            return "";
        else
            return homeUrl + "/" + urlPath;
    }

    public List<TipoDocElect> getDocsElect() {
        List<TipoDocElect> somethingList =
                new ArrayList<TipoDocElect>(EnumSet.allOf(TipoDocElect.class));
        somethingList.get(0).name();
        return somethingList;
    }

    public List<EmpresaEntity> getEmpresasFactEcu(String rasSoc) {
        if (rasSoc.isEmpty())
            return null;
        else
            return facElectOpDAO.getEmpbyNomb(rasSoc.trim().toUpperCase());
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public int getDocSearch() {
        return docSearch;
    }

    public void setDocSearch(int docSearch) {
        this.docSearch = docSearch;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpUsu() {
        return empUsu;
    }

    public void setEmpUsu(String empUsu) {
        this.empUsu = empUsu;
    }

    public EmpresaEntity getEmpSel() {
        return empSel;
    }

    public void setEmpSel(EmpresaEntity empSel) {
        this.empSel = empSel;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }

    public String getHomeUrl() {
        return homeUrl;
    }
}