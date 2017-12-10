package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.NotaDebitoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface NotaDebitoDAO {
     static String BEAN_NAME = "notaDebitoDAO";

     List<NotaDebitoEntity> getAllNotaDeb();

     void insertNotaDeb(NotaDebitoEntity objEntidad);

     void eliminarNotaDeb(NotaDebitoEntity objEntidad);

}
