package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface PerfilDAO {
    public static String BEAN_NAME = "perfilDAO";

    public List<PerfilEntity> getAllPerfil();

    public void insertPerfil(PerfilEntity objEntidad);

    public void eliminarPerfil(PerfilEntity objEntidad);

    public PerfilEntity getPerfilByCodPrf(String codPerfil);

    public Object lazyLoad(Class<?> clazz, Object entity);

}
