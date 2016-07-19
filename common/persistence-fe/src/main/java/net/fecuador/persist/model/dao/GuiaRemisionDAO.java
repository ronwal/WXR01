package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.GuiaRemisionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface GuiaRemisionDAO extends GenericDAO<GuiaRemisionEntity, Integer> {
    public static String BEAN_NAME = "guiaRemisionDAO";

    public List<GuiaRemisionEntity> getAllEntity();

    public void insertEntity(GuiaRemisionEntity objEntidad);

    public void eliminarEntity(GuiaRemisionEntity objEntidad);

}
