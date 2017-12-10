package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface PerfilDAO {
     static String BEAN_NAME = "perfilDAO";

     List<PerfilEntity> getAllPerfil();

     void insertPerfil(PerfilEntity objEntidad);

     void eliminarPerfil(PerfilEntity objEntidad);

     PerfilEntity getPerfilByCodPrf(String codPerfil);

     Object lazyLoad(Class<?> clazz, Object entity);

}
