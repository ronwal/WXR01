package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.GuiaRemisionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface GuiaRemisionDAO {
     static String BEAN_NAME = "guiaRemisionDAO";

     List<GuiaRemisionEntity> getAllGuiaRem();

     void insertGuiaRem(GuiaRemisionEntity objEntidad);

     void eliminarGuiaRem(GuiaRemisionEntity objEntidad);

}
