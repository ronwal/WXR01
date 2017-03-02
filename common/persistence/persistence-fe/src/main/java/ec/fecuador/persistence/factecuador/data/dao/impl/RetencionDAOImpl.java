package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.RetencionDAO;
import ec.fecuador.persistence.factecuador.data.entities.RetencionEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class RetencionDAOImpl extends GenericDAOImpl<RetencionEntity, Integer> implements RetencionDAO {
    public RetencionDAOImpl() {
        super(RetencionEntity.class);
    }

    public List<RetencionEntity> getAllRetenc() {
        return getAll();
    }

    public void insertRetenc(RetencionEntity objEntidad) {
        create(objEntidad);
    }


    public void eliminarRetenc(RetencionEntity objEntidad) {
        delete(objEntidad);
    }
}
