package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.GuiaRemisionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface GuiaRemisionDAO {
    public static String BEAN_NAME = "guiaRemisionDAO";

    public List<GuiaRemisionEntity> getAllGuiaRem();

    public void insertGuiaRem(GuiaRemisionEntity objEntidad);

    public void eliminarGuiaRem(GuiaRemisionEntity objEntidad);

}
