package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.NotaDebitoDAO;
import ec.fecuador.persistence.factecuador.data.entities.NotaDebitoEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class NotaDebitoDAOImpl extends GenericDAOImpl<NotaDebitoEntity, Integer> implements NotaDebitoDAO {
    public NotaDebitoDAOImpl() {
        super(NotaDebitoEntity.class);
    }

    @Override
    public List<NotaDebitoEntity> getAllNotaDeb() {
        return getAll();
    }

    @Override
    public void insertNotaDeb(NotaDebitoEntity objEntidad) {
        create(objEntidad);
    }

    @Override
    public void eliminarNotaDeb(NotaDebitoEntity objEntidad) {
        delete(objEntidad);
    }
}
