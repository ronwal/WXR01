package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.DetalleRetencionEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface DetalleRetencionDAO {
     static String BEAN_NAME = "detalleRetencionDAO";

     List<DetalleRetencionEntity> getAllDetRet();

     void insertDetRet(DetalleRetencionEntity objEntidad);

     void eliminarDetRet(DetalleRetencionEntity objEntidad);

}
