package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.DetalleAuditoriaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface DetalleAuditoriaDAO {
     static String BEAN_NAME = "detalleAuditoriaDAO";

     List<DetalleAuditoriaEntity> getAllDetAut();

     void insertDetAut(DetalleAuditoriaEntity objEntidad);

     void eliminarDetAut(DetalleAuditoriaEntity objEntidad);

}
