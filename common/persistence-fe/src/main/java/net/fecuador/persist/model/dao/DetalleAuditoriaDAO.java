package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.DetalleAuditoriaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface DetalleAuditoriaDAO extends GenericDAO<DetalleAuditoriaEntity, Integer> {
    public static String BEAN_NAME = "detalleAuditoriaDAO";

    public List<DetalleAuditoriaEntity> getAllEntity();

    public void insertEntity(DetalleAuditoriaEntity objEntidad);

    public void eliminarEntity(DetalleAuditoriaEntity objEntidad);

}
