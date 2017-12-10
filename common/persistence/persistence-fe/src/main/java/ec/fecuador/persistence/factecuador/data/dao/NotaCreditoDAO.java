package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.NotaCreditoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface NotaCreditoDAO {
     static String BEAN_NAME = "notaCreditoDAO";

     List<NotaCreditoEntity> getAllNotaCred();

     void insertNotaCred(NotaCreditoEntity objEntidad);

     void eliminarNotaCred(NotaCreditoEntity objEntidad);

}
