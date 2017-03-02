package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.NotaCreditoDAO;
import ec.fecuador.persistence.factecuador.data.entities.NotaCreditoEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class NotaCreditoDAOImpl extends GenericDAOImpl<NotaCreditoEntity, Integer> implements NotaCreditoDAO {
    public NotaCreditoDAOImpl() {
        super(NotaCreditoEntity.class);
    }

    public List<NotaCreditoEntity> getAllNotaCred() {
        return getAll();
    }

    public void insertNotaCred(NotaCreditoEntity objEntidad) {
        create(objEntidad);
    }


    public void eliminarNotaCred(NotaCreditoEntity objEntidad) {
        delete(objEntidad);
    }
}
