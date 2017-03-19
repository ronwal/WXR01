package ec.gob.fecuador.portal.model.lazy;

import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;
import ec.gob.fecuador.portal.common.navigation.SessionCookie;
import ec.gob.fecuador.portal.controller.login.LoginController;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Walter on 2/3/17.
 */
@ManagedBean
@ViewScoped
public class DataUserLazy extends LazyDataModel<UsuarioEntity> implements Serializable {

    private static final long serialVersionUID = -1201944101993687165L;

    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    private LazyDataModel<UsuarioEntity> model;

    private javax.swing.SortOrder toSortOrder(SortOrder order) {
        if (SortOrder.ASCENDING.equals(order))
            return javax.swing.SortOrder.ASCENDING;
        else if (SortOrder.DESCENDING.equals(order))
            return javax.swing.SortOrder.DESCENDING;
        else if (SortOrder.UNSORTED.equals(order))
            return javax.swing.SortOrder.UNSORTED;
        else
            return javax.swing.SortOrder.UNSORTED;
    }

    @PostConstruct
    public void init() {
        try {
            this.model = new LazyDataModel<UsuarioEntity>() {
                private static final long serialVersionUID = 1L;

                @Override
                public List<UsuarioEntity> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    if (sortField == null)
                        sortField = "usuCodigo";
                    {
                        String codEmp = (String) SessionCookie.getValCookie(LoginController.EMPRESA_USER);
                        filters.put("empCodigo", codEmp);
                    }
                    List<UsuarioEntity> result = facElectOpDAO.getAllUserLazyPag(first, pageSize, sortField, toSortOrder(sortOrder), filters);
                    model.setRowCount(facElectOpDAO.getCountUserLazyPag(filters).intValue());
                    return result;
                }

                @Override
                public UsuarioEntity getRowData(String rowKey) {
                    return facElectOpDAO.getUserById(Integer.valueOf(rowKey));
                }

                @Override
                public Object getRowKey(UsuarioEntity user) {
                    return user.getUsuCodigo();
                }

            };
        } catch (Exception e) {
        }
    }

    public boolean filterByName(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        String carName = value.toString().toUpperCase();
        filterText = filterText.toUpperCase();

        if (carName.contains(filterText)) {
            return true;
        } else {
            return false;
        }
    }

    public LazyDataModel<UsuarioEntity> getModel() {
        return model;
    }

    public void setModel(LazyDataModel<UsuarioEntity> model) {
        this.model = model;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
