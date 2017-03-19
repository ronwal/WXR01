package ec.gob.fecuador.portal.model.converter;

import ec.fecuador.persistence.factecuador.data.dao.UsuarioDAO;
import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Walter on 26/2/17.
 */
@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {
    @ManagedProperty("#{usuarioDAO}")
    UsuarioDAO usuarioDAO;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return usuarioDAO.getUserById(Integer.valueOf(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Entity."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((UsuarioEntity) object).getUsuCodigo());
        } else {
            return null;
        }
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
