package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.PerfilEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface PerfilDAO extends GenericDAO<PerfilEntity, Integer> {
    public static String BEAN_NAME = "perfilDAO";

    public List<PerfilEntity> getAllEntity();

    public void insertEntity(PerfilEntity objEntidad);

    public void eliminarEntity(PerfilEntity objEntidad);

}
