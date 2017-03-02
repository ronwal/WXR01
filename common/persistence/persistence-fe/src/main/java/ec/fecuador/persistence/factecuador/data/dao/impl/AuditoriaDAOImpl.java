package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.AuditoriaDAO;
import ec.fecuador.persistence.factecuador.data.entities.AuditoriaEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class AuditoriaDAOImpl extends GenericDAOImpl<AuditoriaEntity, Integer> implements AuditoriaDAO {
    public AuditoriaDAOImpl() {
        super(AuditoriaEntity.class);
    }

    public List<AuditoriaEntity> getAllAuditEnt() {
        return getAllAuditEnt();
    }

    public void insertAuditEnt(AuditoriaEntity objEntidad) {
        create(objEntidad);
    }


    public void eliminarAuditEnt(AuditoriaEntity objEntidad) {
        delete(objEntidad);
    }
}
