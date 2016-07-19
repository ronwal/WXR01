package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.PerfilDAO;
import net.fecuador.persist.model.entities.PerfilEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class PerfilDAOImpl extends GenericDAOImpl<PerfilEntity, Integer> implements PerfilDAO {
    public PerfilDAOImpl() {
        super(PerfilEntity.class);
    }

    public List<PerfilEntity> getAllEntity() {
        List<PerfilEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM PerfilEntity e", PerfilEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(PerfilEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(PerfilDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(PerfilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(PerfilEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(PerfilDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(PerfilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
