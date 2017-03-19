package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface UsuarioDAO {
    public static String BEAN_NAME = "usuarioDAO";

    public List<UsuarioEntity> getAllUser();

    public void insertUser(UsuarioEntity objEntidad);

    public void eliminarUser(UsuarioEntity objEntidad);

    public void actualizarUser(UsuarioEntity objEntidad);

    public UsuarioEntity getAUser(String userName, String userPass, String empCod);

    public UsuarioEntity getUserById(Integer idUser);

    public UsuarioEntity getAUser(String userName, String empCod);

    public List<UsuarioEntity> getAllUserLazyPag(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters);

    public Long getUserCount(Map<String, Object> filters);
}
