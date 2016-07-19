package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.FacturaDAO;
import net.fecuador.persist.model.entities.FacturaEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class GuiaRemisionDAOImpl extends GenericDAOImpl<FacturaEntity, Integer> implements FacturaDAO {
    public GuiaRemisionDAOImpl() {
        super(FacturaEntity.class);
    }

    public List<FacturaEntity> getAllEntity() {
        List<FacturaEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM FacturaEntity e", FacturaEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(FacturaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(GuiaRemisionDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(GuiaRemisionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(FacturaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(GuiaRemisionDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(GuiaRemisionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
