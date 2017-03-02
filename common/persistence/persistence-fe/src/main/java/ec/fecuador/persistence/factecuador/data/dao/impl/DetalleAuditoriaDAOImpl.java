package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.DetalleAuditoriaDAO;
import ec.fecuador.persistence.factecuador.data.entities.DetalleAuditoriaEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class DetalleAuditoriaDAOImpl extends GenericDAOImpl<DetalleAuditoriaEntity, Integer> implements DetalleAuditoriaDAO {
    public DetalleAuditoriaDAOImpl() {
        super(DetalleAuditoriaEntity.class);
    }

    public List<DetalleAuditoriaEntity> getAllDetAut() {
        return getAll();
    }

    public void insertDetAut(DetalleAuditoriaEntity objEntidad) {
        create(objEntidad);
    }


    public void eliminarDetAut(DetalleAuditoriaEntity objEntidad) {
        delete(objEntidad);
    }
}
