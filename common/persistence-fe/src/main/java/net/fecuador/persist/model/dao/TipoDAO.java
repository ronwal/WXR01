package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.TipoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface TipoDAO extends GenericDAO<TipoEntity, Integer> {
    public static String BEAN_NAME = "tipoDAO";

    public List<TipoEntity> getAllEntity();

    public void insertEntity(TipoEntity objEntidad);

    public void eliminarEntity(TipoEntity objEntidad);

}
