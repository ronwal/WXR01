package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.NotaDebitoDAO;
import net.fecuador.persist.model.entities.NotaDebitoEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class NotaDebitoDAOImpl extends GenericDAOImpl<NotaDebitoEntity, Integer> implements NotaDebitoDAO {
    public NotaDebitoDAOImpl() {
        super(NotaDebitoEntity.class);
    }

    public List<NotaDebitoEntity> getAllEntity() {
        List<NotaDebitoEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM NotaDebitoEntity e", NotaDebitoEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(NotaDebitoEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(NotaDebitoDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(NotaDebitoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(NotaDebitoEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(NotaDebitoDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(NotaDebitoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
