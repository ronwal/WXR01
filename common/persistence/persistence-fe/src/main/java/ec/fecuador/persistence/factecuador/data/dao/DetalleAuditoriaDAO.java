package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.DetalleAuditoriaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface DetalleAuditoriaDAO {
    public static String BEAN_NAME = "detalleAuditoriaDAO";

    public List<DetalleAuditoriaEntity> getAllDetAut();

    public void insertDetAut(DetalleAuditoriaEntity objEntidad);

    public void eliminarDetAut(DetalleAuditoriaEntity objEntidad);

}
