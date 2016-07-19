package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.RetencionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface RetencionDAO extends GenericDAO<RetencionEntity, Integer> {
    public static String BEAN_NAME = "retencionDAO";

    public List<RetencionEntity> getAllEntity();

    public void insertEntity(RetencionEntity objEntidad);

    public void eliminarEntity(RetencionEntity objEntidad);

}
