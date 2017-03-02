package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.TipoDAO;
import ec.fecuador.persistence.factecuador.data.entities.TipoEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class TipoDAOImpl extends GenericDAOImpl<TipoEntity, Integer> implements TipoDAO {
    public TipoDAOImpl() {
        super(TipoEntity.class);
    }

    @Override
    public List<TipoEntity> getAllTipo() {
        return getAll();
    }

    @Override
    public void insertTipo(TipoEntity objEntidad) {
        create(objEntidad
        );
    }

    @Override
    public void eliminarTipo(TipoEntity objEntidad) {
        delete(objEntidad);
    }
}
