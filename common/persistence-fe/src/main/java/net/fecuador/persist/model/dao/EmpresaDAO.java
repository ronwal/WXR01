package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.DetalleRetencionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface EmpresaDAO extends GenericDAO<DetalleRetencionEntity, Integer> {
    public static String BEAN_NAME = "empresaDAO";

    public List<DetalleRetencionEntity> getAllEntity();

    public void insertEntity(DetalleRetencionEntity objEntidad);

    public void eliminarEntity(DetalleRetencionEntity objEntidad);

}
