package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.RetencionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface RetencionDAO {
     static String BEAN_NAME = "retencionDAO";

     List<RetencionEntity> getAllRetenc();

     void insertRetenc(RetencionEntity objEntidad);

     void eliminarRetenc(RetencionEntity objEntidad);

}
