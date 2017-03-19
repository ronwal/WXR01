package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.FacturaDAO;
import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;
import ec.fecuador.persistence.factecuador.data.entities.FacturaEntity;
import ec.fecuador.persistence.factecuador.data.entities.TipoEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;
import ec.fecuador.persistence.factecuador.generic.util.FilterUtil;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class FacturaDAOImpl extends GenericDAOImpl<FacturaEntity, Integer> implements FacturaDAO {
    public FacturaDAOImpl() {
        super(FacturaEntity.class);
    }

    public List<FacturaEntity> getAllFact() {
        return getAllFact();
    }

    @Override
    public List<FacturaEntity> getFactPaging(Integer firstResult, Integer maxResult) {
        return getPaging(firstResult, maxResult);
    }

    public void insertFact(FacturaEntity objEntidad) {
        create(objEntidad);
    }

    public void eliminarFact(FacturaEntity objEntidad) {
        delete(objEntidad);
    }

    public FacturaEntity findFacturaByPrimaryKey(Integer facCodigo) throws Exception {
        FacturaEntity facturaEntity = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a WHERE a.facCodigo=:facCodigo";
            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("facCodigo", facCodigo);
            facturaEntity = query.getSingleResult();
        } finally {
            return facturaEntity;
        }
    }

    public FacturaEntity findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws Exception {
        FacturaEntity facturaEntity = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.facIdentificacionVendedor=:emisor " +
                    "AND a.facIdentificacionComprador=:receptor " +
                    "AND a.facEstablecimiento=:establecimiento " +
                    "AND a.facPuntoEmision=:ptoEmision " +
                    "AND a.facSecuencial=:secuencial " +
                    "ORDER BY a.facEstablecimiento ASC, a.facSecuencial ASC";
            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("emisor", emisor);
            query.setParameter("receptor", receptor);
            query.setParameter("establecimiento", establecimiento);
            query.setParameter("ptoEmision", ptoEmision);
            query.setParameter("secuencial", secuencial);
            query.setFirstResult(0).setMaxResults(1);

            facturaEntity = query.getSingleResult();
        } finally {
            return facturaEntity;
        }
    }

    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter, int maxResults) throws Exception {
        List<FacturaEntity> facturaEntities = null;
        try {
            String checkedFilter = FilterUtil.check("facRazonSocialComprador", filter);
            String sql = "SELECT a " +
                    "FROM FacturaEntity a " +
                    "WHERE " + checkedFilter + " ORDER BY a.facRazonSocialComprador ASC ";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setMaxResults(maxResults);
            facturaEntities = query.getResultList();
        } finally {
            return facturaEntities;
        }
    }

    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter) throws Exception {
        return filterByFacRazonSocialComprador(filter, 50);
    }

    public List<FacturaEntity> filterByEmpresa(EmpresaEntity empresa) throws Exception {
        List<FacturaEntity> facturaEntities = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.empCodigo=:fkCode " +
                    "ORDER BY a.facRazonSocialComprador";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("fkCode", empresa.getEmpCodigo());
            facturaEntities = query.getResultList();
        } finally {
            return facturaEntities;
        }
    }

    public List<FacturaEntity> filterByEmpresa(String empCodigo) throws Exception {
        List<FacturaEntity> facturaEntities = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.empCodigo=:fkCode " +
                    "ORDER BY a.facRazonSocialComprador ASC ";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("fkCode", empCodigo);
            facturaEntities = query.getResultList();
        } finally {
            return facturaEntities;
        }
    }

    public List<FacturaEntity> filterByTipo(TipoEntity tipo) throws Exception {
        List<FacturaEntity> facturaEntities = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.tipCodigo=:fkCode " +
                    "ORDER BY a.facRazonSocialComprador ASC";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("fkCode", tipo.getTipCodigo());
            facturaEntities = query.getResultList();
        } finally {
            return facturaEntities;
        }
    }

    public List<FacturaEntity> filterByTipo(String tipCodigo) throws Exception {
        List<FacturaEntity> facturaEntities = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.tipCodigo=:fkCode " +
                    "ORDER BY a.facRazonSocialComprador";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("fkCode", tipCodigo);
            facturaEntities = query.getResultList();
        } finally {
            return facturaEntities;
        }
    }

    public List<FacturaEntity> personalizedFilter(EmpresaEntity empresa, TipoEntity tipo) throws Exception {
        List<FacturaEntity> facturaEntities = null;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.empCodigo=:prmEmpCodigo AND a.tipCodigo=:prmTipCodigo " +
                    "ORDER BY a.facRazonSocialComprador ASC";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);

            query.setParameter("prmEmpCodigo", empresa.getEmpCodigo());
            query.setParameter("prmTipCodigo", tipo.getTipCodigo());
            facturaEntities = query.getResultList();
        } finally {
            return facturaEntities;
        }
    }

    public boolean checkIsRegistered(FacturaEntity factEnt) throws Exception {
        boolean bn_ = false;
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.empCodigo=:codEmpresa and a.tipCodigo=:codTipo and a.facEstablecimiento=:establecimiento " +
                    "and a.facPuntoEmision=:ptoEmi and a.facSecuencial=:secuencial ";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("codEmpresa", factEnt.getEmpCodigo());
            query.setParameter("codTipo", factEnt.getTipCodigo());
            query.setParameter("establecimiento", factEnt.getFacEstablecimiento());
            query.setParameter("ptoEmi", factEnt.getFacPuntoEmision());
            query.setParameter("secuencial", factEnt.getFacSecuencial());
            query.setMaxResults(1);

            FacturaEntity ff = query.getSingleResult();
            bn_ = (ff != null);
        } finally {
            return bn_;
        }
    }

    public Date getFirstDate(EmpresaEntity e) {
        Date date_ = new Date();
        try {
            String sql = "SELECT a FROM FacturaEntity a " +
                    "WHERE a.empCodigo=:codEmpresa order by a.facFechaEmision ASC ";

            TypedQuery<FacturaEntity> query = em.createQuery(sql, FacturaEntity.class);
            query.setParameter("codEmpresa", e.getEmpCodigo());
            query.setFirstResult(0).setMaxResults(1);

            FacturaEntity ff = query.getSingleResult();

            date_ = ff.getFacFechaEmision();

        } finally {
            return date_;
        }
    }

    public double getResumeData(EmpresaEntity empresa, TipoEntity tipo, Date inicio, Date fin) throws Exception {
        try {
            String sql = "SELECT SUM(a.facTotalSinImpuestos) as total " +
                    "FROM FacturaEntity a " +
                    "WHERE a.empCodigo=:prmEmpCodigo AND a.tipCodigo=:prmTipCodigo " +
                    "AND a.facFechaEmision BETWEEN :desde AND :hasta ";

            TypedQuery<Number> query = em.createQuery(sql, Number.class);

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
