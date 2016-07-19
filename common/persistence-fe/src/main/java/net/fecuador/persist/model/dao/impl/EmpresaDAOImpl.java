package net.fecuador.persist.model.dao.impl;

import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.DetalleRetencionDAO;
import net.fecuador.persist.model.entities.DetalleRetencionEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class EmpresaDAOImpl extends GenericDAOImpl<DetalleRetencionEntity, Integer> implements DetalleRetencionDAO {
    public EmpresaDAOImpl() {
        super(DetalleRetencionEntity.class);
    }

    public List<DetalleRetencionEntity> getAllEntity() {
        List<DetalleRetencionEntity> listaEntidades = null;
        Query query;

        query = em.createQuery("SELECT e FROM DetalleRetencionEntity e", DetalleRetencionEntity.class);

        listaEntidades = query.getResultList();

        return listaEntidades;
    }

    public void insertEntity(DetalleRetencionEntity objEntidad) {
        try {
            em.getTransaction().begin();
            create(objEntidad);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(DetalleRetencionEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(EmpresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
