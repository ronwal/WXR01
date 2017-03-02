package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.TipoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface TipoDAO {
    public static String BEAN_NAME = "tipoDAO";

    public List<TipoEntity> getAllTipo();

    public void insertTipo(TipoEntity objEntidad);

    public void eliminarTipo(TipoEntity objEntidad);

}
