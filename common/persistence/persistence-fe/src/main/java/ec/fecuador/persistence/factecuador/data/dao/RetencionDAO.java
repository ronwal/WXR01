package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.RetencionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface RetencionDAO {
    public static String BEAN_NAME = "retencionDAO";

    public List<RetencionEntity> getAllRetenc();

    public void insertRetenc(RetencionEntity objEntidad);

    public void eliminarRetenc(RetencionEntity objEntidad);

}
