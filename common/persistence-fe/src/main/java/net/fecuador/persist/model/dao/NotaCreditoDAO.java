package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.NotaCreditoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface NotaCreditoDAO extends GenericDAO<NotaCreditoEntity, Integer> {
    public static String BEAN_NAME = "notaCreditoDAO";

    public List<NotaCreditoEntity> getAllEntity();

    public void insertEntity(NotaCreditoEntity objEntidad);

    public void eliminarEntity(NotaCreditoEntity objEntidad);

}
