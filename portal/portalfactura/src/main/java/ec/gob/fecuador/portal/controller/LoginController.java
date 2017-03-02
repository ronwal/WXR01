package ec.gob.fecuador.portal.controller;

import ec.fecuador.persistence.factecuador.data.entities.DetalleMenuSystemEntity;
import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;
import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;
import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.config.properties.ConfigProp;
import ec.gob.fecuador.portal.common.enumerate.TipoDocElect;
import ec.gob.fecuador.portal.common.navigation.NavigationRequest;
import ec.gob.fecuador.security.encryption.Crypt;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Walter on 22/2/17.
 */
@ManagedBean
@SessionScoped
public class LoginController {

    private static final String PERFIL_INVITADO = "INV";
    private static final String APP_USER = "userAPP";
    private static final String PATH_LOGO = "ec.gob.factura.path.logos";
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
        if (session != null) {
        } else {
            PerfilEntity perfilEntity = facElectOpDAO.getPerfilByCodPrf(PERFIL_INVITADO);
            perfilEntity = (PerfilEntity) facElectOpDAO.lazyLoad(PerfilEntity.class, perfilEntity);
            systemEntities = perfilEntity.getDetalleMenuSystem();
        }
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
                        url = "inicio.html";
                        FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap()
                                .put(APP_USER, user_.getUsuNick());
                        FacesContext.getCurrentInstance().getExternalContext()
                                .getSessionMap()
                                .put(APP_USER, user_.getUsuNick());

                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso Exitoso!!!", ""));
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario se encuentra desactivado.", ""));
                    }
            }
            if (user_ == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario no Registrado o Contraseña Incorrecta.", ""));
            }

        } finally {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(NavigationRequest.getAppURL() + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                absPath = ConfigProp.getInstance().getProperty(PATH_LOGO) + codEmp.concat(".png");
            } else {
                absPath = ConfigProp.getInstance().getProperty(PATH_LOGO) + "logo-cr.png";
            }

            fis = new FileInputStream(absPath);
            bis = new BufferedInputStream(fis);
            streamImage = new DefaultStreamedContent(bis);
        } finally {
            return streamImage;
        }
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