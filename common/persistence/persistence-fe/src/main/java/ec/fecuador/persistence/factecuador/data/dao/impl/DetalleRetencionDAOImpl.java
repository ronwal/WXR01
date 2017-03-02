package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.DetalleRetencionDAO;
import ec.fecuador.persistence.factecuador.data.entities.DetalleRetencionEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class DetalleRetencionDAOImpl extends GenericDAOImpl<DetalleRetencionEntity, Integer> implements DetalleRetencionDAO {
    public DetalleRetencionDAOImpl() {
        super(DetalleRetencionEntity.class);
    }

    public List<DetalleRetencionEntity> getAllDetRet() {
        return getAllDetRet();
    }

    public void insertDetRet(DetalleRetencionEntity objEntidad) {
        create(objEntidad);
    }


    public void eliminarDetRet(DetalleRetencionEntity objEntidad) {
        delete(objEntidad);
    }
}
