package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.AuditoriaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface AuditoriaDAO {
     static String BEAN_NAME = "auditoriaDAO";

     List<AuditoriaEntity> getAllAuditEnt();

     void insertAuditEnt(AuditoriaEntity objEntidad);

     void eliminarAuditEnt(AuditoriaEntity objEntidad);

}
