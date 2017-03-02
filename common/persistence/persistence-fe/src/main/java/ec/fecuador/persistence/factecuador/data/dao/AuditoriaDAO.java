package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.AuditoriaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface AuditoriaDAO {
    public static String BEAN_NAME = "auditoriaDAO";

    public List<AuditoriaEntity> getAllAuditEnt();

    public void insertAuditEnt(AuditoriaEntity objEntidad);

    public void eliminarAuditEnt(AuditoriaEntity objEntidad);

}
