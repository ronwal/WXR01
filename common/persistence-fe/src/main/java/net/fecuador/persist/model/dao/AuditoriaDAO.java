package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.AuditoriaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface AuditoriaDAO extends GenericDAO<AuditoriaEntity, Integer> {
    public static String BEAN_NAME = "auditoriaDAO";

    public List<AuditoriaEntity> getAllEntity();

    public void insertEntity(AuditoriaEntity objEntidad);

    public void eliminarEntity(AuditoriaEntity objEntidad);

}
