package ec.gob.fecuador.portal.common.converter;

import ec.fecuador.persistence.factecuador.data.dao.EmpresaDAO;
import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;

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
@FacesConverter("empresaConverter")
public class EmpresaConverter implements Converter {
    @ManagedProperty("#{empresaDAO}")
    EmpresaDAO empresaDAO;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return empresaDAO.getEmpbyId(value);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((EmpresaEntity) object).getEmpCodigo());
        } else {
            return null;
        }
    }

    public void setEmpresaDAO(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }
}
