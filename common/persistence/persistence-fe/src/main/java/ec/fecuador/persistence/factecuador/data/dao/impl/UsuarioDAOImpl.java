package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.UsuarioDAO;
import ec.fecuador.persistence.factecuador.data.entities.UsuarioEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class UsuarioDAOImpl extends GenericDAOImpl<UsuarioEntity, Integer> implements UsuarioDAO {
    public UsuarioDAOImpl() {
        super(UsuarioEntity.class);
    }

    public List<UsuarioEntity> getAllUser() {
        return getAll();
    }

    public void insertUser(UsuarioEntity objEntidad) {
        create(objEntidad);
    }

    public void eliminarUser(UsuarioEntity objEntidad) {
        delete(objEntidad);
    }

    @Override
    public UsuarioEntity getAUser(String userName, String userPass, String empCod) {
        UsuarioEntity entity = null;
        try {
            String sql = "SELECT a FROM UsuarioEntity a " +
                    "WHERE a.usuNick=:userName AND a.usuClave=:userPass " +
                    "AND a.empCodigo=:empCod " +
                    "ORDER BY a.empCodigo ASC";

            TypedQuery<UsuarioEntity> query = em.createQuery(sql, UsuarioEntity.class);
            query.setParameter("empCod", empCod);
            query.setParameter("userName", userName);
            query.setParameter("userPass", userPass);

            entity = query.getSingleResult();
        } finally {
            return entity;
        }
    }

    @Override
    public UsuarioEntity getAUser(String userName, String empCod) {
        UsuarioEntity entity = null;
        try {
            String sql = "SELECT a FROM UsuarioEntity a " +
                    "WHERE a.usuNick=:userName AND a.empCodigo=:empCod " +
                    "ORDER BY a.empCodigo ASC";

            TypedQuery<UsuarioEntity> query = em.createQuery(sql, UsuarioEntity.class);
            query.setParameter("empCod", empCod);
            query.setParameter("userName", userName);

            entity = query.getSingleResult();
        } finally {
            return entity;
        }
    }
}
