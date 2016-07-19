package net.fecuador.persist.model.dao;

import net.fecuador.persist.common.GenericDAO;
import net.fecuador.persist.model.entities.UsuarioEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface UsuarioDAO extends GenericDAO<UsuarioEntity, Integer> {
    public static String BEAN_NAME = "usuarioDAO";

    public List<UsuarioEntity> getAllEntity();

    public void insertEntity(UsuarioEntity objEntidad);

    public void eliminarEntity(UsuarioEntity objEntidad);

}
