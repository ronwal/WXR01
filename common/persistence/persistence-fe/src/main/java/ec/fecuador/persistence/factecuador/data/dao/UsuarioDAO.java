package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface UsuarioDAO {
    public static String BEAN_NAME = "usuarioDAO";

    public List<UsuarioEntity> getAllUser();

    public void insertUser(UsuarioEntity objEntidad);

    public void eliminarUser(UsuarioEntity objEntidad);

    public UsuarioEntity getAUser(String userName, String userPass, String empCod);
    public UsuarioEntity getAUser(String userName, String empCod);
}
