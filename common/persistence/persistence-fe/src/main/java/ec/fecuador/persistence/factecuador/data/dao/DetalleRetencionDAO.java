package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.DetalleRetencionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface DetalleRetencionDAO {
    public static String BEAN_NAME = "detalleRetencionDAO";

    public List<DetalleRetencionEntity> getAllDetRet();

    public void insertDetRet(DetalleRetencionEntity objEntidad);

    public void eliminarDetRet(DetalleRetencionEntity objEntidad);

}
