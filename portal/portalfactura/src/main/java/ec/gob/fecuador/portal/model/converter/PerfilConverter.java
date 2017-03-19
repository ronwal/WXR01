package ec.gob.fecuador.portal.model.converter;

import ec.fecuador.persistence.factecuador.data.dao.PerfilDAO;
import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Walter on 26/2/17.
 */
@FacesConverter("perfilConverter")
@ManagedBean
@SessionScoped
public class PerfilConverter implements Converter {
    @ManagedProperty("#{perfilDAO}")
    PerfilDAO perfilDAO;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return perfilDAO.getPerfilByCodPrf(value);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Entity."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((PerfilEntity) object).getPrfCodigo());
        } else {
            return null;
        }
    }

    public void setPerfilDAO(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }
}
