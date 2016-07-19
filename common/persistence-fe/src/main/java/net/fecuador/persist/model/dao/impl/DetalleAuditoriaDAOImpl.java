package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.DetalleAuditoriaDAO;
import net.fecuador.persist.model.entities.DetalleAuditoriaEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class DetalleAuditoriaDAOImpl extends GenericDAOImpl<DetalleAuditoriaEntity, Integer> implements DetalleAuditoriaDAO {
    public DetalleAuditoriaDAOImpl() {
        super(DetalleAuditoriaEntity.class);
    }

    public List<DetalleAuditoriaEntity> getAllEntity() {
        List<DetalleAuditoriaEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM DetalleAuditoriaEntity e", DetalleAuditoriaEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(DetalleAuditoriaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(DetalleAuditoriaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(DetalleAuditoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(DetalleAuditoriaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(DetalleAuditoriaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(DetalleAuditoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
