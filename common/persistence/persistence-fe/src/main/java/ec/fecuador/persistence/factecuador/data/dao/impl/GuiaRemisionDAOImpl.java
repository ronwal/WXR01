package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.GuiaRemisionDAO;
import ec.fecuador.persistence.factecuador.data.entities.GuiaRemisionEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.io.Serializable;
import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class GuiaRemisionDAOImpl extends GenericDAOImpl<GuiaRemisionEntity, Serializable> implements GuiaRemisionDAO {
    public GuiaRemisionDAOImpl() {
        super(GuiaRemisionEntity.class);
    }

    @Override
    public List<GuiaRemisionEntity> getAllGuiaRem() {
        return getAll();
    }

    @Override
    public void insertGuiaRem(GuiaRemisionEntity objEntidad) {
        create(objEntidad);
    }

    @Override
    public void eliminarGuiaRem(GuiaRemisionEntity objEntidad) {
        delete(objEntidad);
    }
}
