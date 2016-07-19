package net.fecuador.persist.model.dao.impl;

import ec.fecuador.util.FilterUtil;
import net.fecuador.persist.common.GenericDAOImpl;
import net.fecuador.persist.model.dao.FacturaDAO;
import net.fecuador.persist.model.entities.EmpresaEntity;
import net.fecuador.persist.model.entities.FacturaEntity;
import net.fecuador.persist.model.entities.TipoEntity;
import org.apache.openjpa.persistence.PersistenceException;

import javax.jms.Session;
import javax.persistence.Query;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @rw_r on 25/2/16.
 */
public class FacturaDAOImpl extends GenericDAOImpl<FacturaEntity, Integer> implements FacturaDAO {
    public FacturaDAOImpl() {
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
            Logger.getLogger(FacturaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Insertar Objeto");
            Logger.getLogger(FacturaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void eliminarEntity(FacturaEntity objEntidad) {
        try {
            em.getTransaction().begin();
            delete(objEntidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(FacturaDAOImpl.class.getName()).log(Level.INFO, null, "Error al Eliminar Objeto");
            Logger.getLogger(FacturaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FacturaEntity findFacturaByPrimaryKey(Integer facCodigo) throws Exception {
        try {
            Query query = em.createQuery("from Factura where facCodigo=:pkCode");
            query.setParameter("pkCode", facCodigo);
            return (FacturaEntity) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public FacturaEntity findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws Exception {
        try {
            Query query = em.createQuery("from Factura where facIdentificacionVendedor=:emisor and facIdentificacionComprador=:receptor  and facEstablecimiento=:establecimiento and facPuntoEmision=:ptoEmision and facSecuencial=:secuencial ");
            query.setParameter("emisor", emisor);
            query.setParameter("receptor", receptor);
            query.setParameter("establecimiento", establecimiento);
            query.setParameter("ptoEmision", ptoEmision);
            query.setParameter("secuencial", secuencial);
            query.setMaxResults(1);

            return (FacturaEntity) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter, int maxResults) throws Exception {

        String checkedFilter = FilterUtil.check("facRazonSocialComprador", filter);
        try {
            Query query = em.createQuery("from Factura where " + checkedFilter + " order by facRazonSocialComprador");
            query.setMaxResults(maxResults);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter) throws Exception {
        return filterByFacRazonSocialComprador(filter, 50);
    }

    public List<FacturaEntity> filterByEmpresa(EmpresaEntity empresa) throws Exception {
        try {
            Query query = em.createQuery("from Factura where empresa.empCodigo=:fkCode order by facRazonSocialComprador");
            query.setParameter("fkCode", empresa.getEmpCodigo());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public List<FacturaEntity> filterByEmpresa(String empCodigo) throws Exception {
        try {
            Query query = em.createQuery("from Factura where empresa.empCodigo=:fkCode order by facRazonSocialComprador");
            query.setParameter("fkCode", empCodigo);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public List<FacturaEntity> filterByTipo(TipoEntity tipo) throws Exception {
        try {
            Query query = em.createQuery("from Factura where tipo.tipCodigo=:fkCode order by facRazonSocialComprador");
            query.setParameter("fkCode", tipo.getTipCodigo());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public List<FacturaEntity> filterByTipo(String tipCodigo) throws Exception {
        try {
            Query query = em.createQuery("from Factura where tipo.tipCodigo=:fkCode order by facRazonSocialComprador");
            query.setParameter("fkCode", tipCodigo);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public List<FacturaEntity> personalizedFilter(EmpresaEntity empresa, TipoEntity tipo) throws Exception {
        try {
            Query query = em.createQuery("from Factura where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo order by facRazonSocialComprador");
            query.setParameter("prmEmpCodigo", empresa.getEmpCodigo());
            query.setParameter("prmTipCodigo", tipo.getTipCodigo());
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }

    public boolean checkIsRegistered(FacturaEntity f) throws Exception {
        try {
            Query query = em.createQuery("from Factura where empresa.empCodigo=:codEmpresa and tipo.tipCodigo=:codTipo and facEstablecimiento=:establecimiento and facPuntoEmision=:ptoEmi and facSecuencial=:secuencial");
            query.setParameter("codEmpresa", f.getEmpCodigo());
            query.setParameter("codTipo", f.getTipCodigo());
            query.setParameter("establecimiento", f.getFacEstablecimiento());
            query.setParameter("ptoEmi", f.getFacPuntoEmision());
            query.setParameter("secuencial", f.getFacSecuencial());
            query.setMaxResults(1);
            FacturaEntity ff = (FacturaEntity) query.getSingleResult();
            return ff != null;
        } catch (Exception e) {
            throw new Exception("No se pudo verificar la existencia de la factura.", e);
        }
    }

    public Date getFirstDate(EmpresaEntity e) {
        try {
            Query query = em.createQuery("from Factura where empresa.empCodigo=:codEmpresa order by facFechaEmision");
            query.setParameter("codEmpresa", e.getEmpCodigo());
            query.setMaxResults(1);
            FacturaEntity ff = (FacturaEntity) query.getSingleResult();

            return ff == null ? new Date() : ff.getFacFechaEmision();

        } catch (Exception ex) {
            return new Date();
        }
    }

    public double getResumeData(EmpresaEntity empresa, TipoEntity tipo, Date inicio, Date fin) throws Exception {
        try {
            Query query = em.createQuery("select sum(facTotalSinImpuestos) as total from Factura where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo and facFechaEmision between :desde and :hasta");
            query.setParameter("prmEmpCodigo", empresa.getEmpCodigo());
            query.setParameter("prmTipCodigo", tipo.getTipCodigo());
            query.setParameter("desde", inicio);
            query.setParameter("hasta", fin);
            Object o = query.getSingleResult();
            if (o == null) {
                return 0.0;
            }
            if (!(o instanceof Number)) {
                return 0.0;
            }
            return ((Number) o).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo cargar la información de Factura.", e);
        }
    }
}
