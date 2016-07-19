package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.NotaDebitoEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface NotaDebitoDAO extends GenericDAO<NotaDebitoEntity, Integer> {
    public static String BEAN_NAME = "notaDebitoDAO";

    public List<NotaDebitoEntity> getAllEntity();

    public void insertEntity(NotaDebitoEntity objEntidad);

    public void eliminarEntity(NotaDebitoEntity objEntidad);

}
