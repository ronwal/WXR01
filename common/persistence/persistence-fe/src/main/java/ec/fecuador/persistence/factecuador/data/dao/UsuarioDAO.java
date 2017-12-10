package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface UsuarioDAO {
     static String BEAN_NAME = "usuarioDAO";

     List<UsuarioEntity> getAllUser();

     void insertUser(UsuarioEntity objEntidad);

     void eliminarUser(UsuarioEntity objEntidad);

     void actualizarUser(UsuarioEntity objEntidad);

     UsuarioEntity getAUser(String userName, String userPass, String empCod);

     UsuarioEntity getUserById(Integer idUser);

     UsuarioEntity getAUser(String userName, String empCod);

     List<UsuarioEntity> getAllUserLazyPag(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters);

     Long getUserCount(Map<String, Object> filters);
}
