package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.NotaCreditoDAO;
import net.fecuador.persist.model.entities.NotaCreditoEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class NotaCreditoDAOImpl extends GenericDAOImpl<NotaCreditoEntity, Integer> implements NotaCreditoDAO {
    public NotaCreditoDAOImpl() {
        super(NotaCreditoEntity.class);
    }

    public List<NotaCreditoEntity> getAllEntity() {
        List<NotaCreditoEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM NotaCreditoEntity e", NotaCreditoEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(NotaCreditoEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(NotaCreditoDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(NotaCreditoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(NotaCreditoEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(NotaCreditoDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(NotaCreditoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
