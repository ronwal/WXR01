package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.UsuarioDAO;
import net.fecuador.persist.model.entities.UsuarioEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class UsuarioDAOImpl extends GenericDAOImpl<UsuarioEntity, Integer> implements UsuarioDAO {
    public UsuarioDAOImpl() {
        super(UsuarioEntity.class);
    }

    public List<UsuarioEntity> getAllEntity() {
        List<UsuarioEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM UsuarioEntity e", UsuarioEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(UsuarioEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(UsuarioEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
