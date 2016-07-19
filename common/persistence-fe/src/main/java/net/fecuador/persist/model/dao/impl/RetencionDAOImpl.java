package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.RetencionDAO;
import net.fecuador.persist.model.entities.RetencionEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class RetencionDAOImpl extends GenericDAOImpl<RetencionEntity, Integer> implements RetencionDAO {
    public RetencionDAOImpl() {
        super(RetencionEntity.class);
    }

    public List<RetencionEntity> getAllEntity() {
        List<RetencionEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM RetencionEntity e", RetencionEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(RetencionEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(RetencionDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(RetencionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(RetencionEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(RetencionDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(RetencionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
