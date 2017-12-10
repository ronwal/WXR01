package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.TipoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface TipoDAO {
     static String BEAN_NAME = "tipoDAO";

     List<TipoEntity> getAllTipo();

     void insertTipo(TipoEntity objEntidad);

     void eliminarTipo(TipoEntity objEntidad);

}
