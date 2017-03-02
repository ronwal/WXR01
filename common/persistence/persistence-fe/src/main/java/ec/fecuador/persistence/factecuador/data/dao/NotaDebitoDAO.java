package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.NotaDebitoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface NotaDebitoDAO {
    public static String BEAN_NAME = "notaDebitoDAO";

    public List<NotaDebitoEntity> getAllNotaDeb();

    public void insertNotaDeb(NotaDebitoEntity objEntidad);

    public void eliminarNotaDeb(NotaDebitoEntity objEntidad);

}
