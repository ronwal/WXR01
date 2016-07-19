package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.AuditoriaDAO;
import net.fecuador.persist.model.entities.AuditoriaEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class AuditoriaDAOImpl extends GenericDAOImpl<AuditoriaEntity, Integer> implements AuditoriaDAO {
    public AuditoriaDAOImpl() {
        super(AuditoriaEntity.class);
    }

    public List<AuditoriaEntity> getAllEntity() {
        List<AuditoriaEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM AuditoriaEntity e", AuditoriaEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(AuditoriaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(AuditoriaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(AuditoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(AuditoriaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(AuditoriaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(AuditoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
