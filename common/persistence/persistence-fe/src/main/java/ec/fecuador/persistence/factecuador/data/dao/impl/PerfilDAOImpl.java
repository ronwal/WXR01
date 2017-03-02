package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.PerfilDAO;
import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class PerfilDAOImpl extends GenericDAOImpl<PerfilEntity, Integer> implements PerfilDAO {
    public PerfilDAOImpl() {
        super(PerfilEntity.class);
    }

    public List<PerfilEntity> getAllPerfil() {
        return getAll();
    }

    public void insertPerfil(PerfilEntity objEntidad) {
        create(objEntidad);
    }

    public void eliminarPerfil(PerfilEntity objEntidad) {
        delete(objEntidad);
    }

    public PerfilEntity getPerfilByCodPrf(String codPerfil) {
        PerfilEntity entityList = null;
        try {
            String sql = "SELECT td " +
                    "FROM PerfilEntity td " +
                    "WHERE td.prfCodigo=:estado " +
                    "ORDER BY td.prfNombre ";

            TypedQuery<PerfilEntity> query = em.createQuery(sql, PerfilEntity.class);
            query.setParameter("estado", codPerfil);
            entityList = query.getSingleResult();
        } finally {
            return entityList;
        }
    }

    public Object lazyLoad(Class<?> clazz, Object entity) {
        return refreshEager(clazz, entity);
    }
}
