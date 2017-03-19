package ec.gob.fecuador.portal.controller.empresa;

import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by Walter on 3/3/17.
 */
@ManagedBean
@SessionScoped
public class CargaController {

    private Integer tipoRegistro;

    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    @PostConstruct
    public void init() {

    }

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
