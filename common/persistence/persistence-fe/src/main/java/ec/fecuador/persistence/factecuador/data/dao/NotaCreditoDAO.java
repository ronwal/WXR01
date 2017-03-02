package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.NotaCreditoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface NotaCreditoDAO {
    public static String BEAN_NAME = "notaCreditoDAO";

    public List<NotaCreditoEntity> getAllNotaCred();

    public void insertNotaCred(NotaCreditoEntity objEntidad);

    public void eliminarNotaCred(NotaCreditoEntity objEntidad);

}
