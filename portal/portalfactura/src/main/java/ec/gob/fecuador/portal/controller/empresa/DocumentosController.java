package ec.gob.fecuador.portal.controller.empresa;

import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Date;

/**
 * Created by Walter on 3/3/17.
 */
@ManagedBean
@SessionScoped
public class DocumentosController {

    private Integer tipoRegistro;
    private Date fechDesde;
    private Date fechHasta;
    private String empresaRazSoc;
    private String secuencialDoc;


    @ManagedProperty("#{facElectOpDAO}")
    private FacElectOpDAO facElectOpDAO;

    @PostConstruct
    public void init() {
        this.tipoRegistro = 0;
    }

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Date getFechDesde() {
        return fechDesde;
    }

    public void setFechDesde(Date fechDesde) {
        this.fechDesde = fechDesde;
    }

    public Date getFechHasta() {
        return fechHasta;
    }

    public void setFechHasta(Date fechHasta) {
        this.fechHasta = fechHasta;
    }

    public String getEmpresaRazSoc() {
        return empresaRazSoc;
    }

    public void setEmpresaRazSoc(String empresaRazSoc) {
        this.empresaRazSoc = empresaRazSoc;
    }

    public String getSecuencialDoc() {
        return secuencialDoc;
    }

    public void setSecuencialDoc(String secuencialDoc) {
        this.secuencialDoc = secuencialDoc;
    }

    public void setFacElectOpDAO(FacElectOpDAO facElectOpDAO) {
        this.facElectOpDAO = facElectOpDAO;
    }
}
