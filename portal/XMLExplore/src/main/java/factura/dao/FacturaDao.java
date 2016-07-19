package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.beans.TopConsulta;
import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaDao {

    public void insert(Factura factura) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditInsert(session, factura);
            session.save(factura);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Factura.", e);
        } finally {
            session.close();
        }
    }

    public void insert(Session session, Factura factura) throws DaoException {
        try {
            HibernateUtil.auditInsert(session, factura);
            session.save(factura);
        } catch (Exception e) {
            throw new DaoException("No se pudo registrar la información en Factura.", e);
        }
    }

    public void update(Factura factura) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditUpdate(session, factura);
            session.update(factura);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Factura.", e);
        } finally {
            session.close();
        }
    }

    public void update(Session session, Factura factura) throws DaoException {
        try {
            HibernateUtil.auditUpdate(session, factura);
            session.update(factura);
        } catch (Exception e) {
            throw new DaoException("No se pudo actualizar la información en Factura.", e);
        }
    }

    public void delete(Factura factura) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditDelete(session, factura);
            session.delete(factura);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo eliminar la información de Factura.", e);
        } finally {
            session.close();
        }
    }

    public void delete(Session session, Factura factura) throws DaoException {
        try {
            HibernateUtil.auditDelete(session, factura);
            session.delete(factura);
        } catch (Exception e) {
            throw new DaoException("No se pudo eliminar la información de Factura.", e);
        }
    }

    public Factura findFacturaByPrimaryKey(Integer facCodigo) throws DaoException {
        Factura loaded = null;
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where facCodigo=:pkCode");
            query.setInteger("pkCode", facCodigo);
            loaded = (Factura) query.uniqueResult();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return loaded;
    }

    public Factura findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws DaoException {
        Factura loaded = null;
        Session session = HibernateUtil.openSession();
        try {

            Query query = session.createQuery("from Factura where facIdentificacionVendedor=:emisor and facIdentificacionComprador=:receptor  and facEstablecimiento=:establecimiento and facPuntoEmision=:ptoEmision and facSecuencial=:secuencial ");
            query.setString("emisor", emisor);
            query.setString("receptor", receptor);
            query.setString("establecimiento", establecimiento);
            query.setString("ptoEmision", ptoEmision);
            query.setInteger("secuencial", secuencial);
            query.setMaxResults(1);
            loaded = (Factura) query.uniqueResult();

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return loaded;
    }

    public List<Factura> filterByFacRazonSocialComprador(String filter, int maxResults) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        String checkedFilter = FilterUtil.check("facRazonSocialComprador", filter);
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where " + checkedFilter + " order by facRazonSocialComprador");
            query.setMaxResults(maxResults);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Factura> filterByFacRazonSocialComprador(String filter) throws DaoException {
        return filterByFacRazonSocialComprador(filter, 50);
    }

    public List<Factura> filterByEmpresa(Empresa empresa) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where empresa.empCodigo=:fkCode order by facRazonSocialComprador");
            query.setString("fkCode", empresa.getEmpCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Factura> filterByEmpresa(String empCodigo) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where empresa.empCodigo=:fkCode order by facRazonSocialComprador");
            query.setString("fkCode", empCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Factura> filterByTipo(Tipo tipo) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where tipo.tipCodigo=:fkCode order by facRazonSocialComprador");
            query.setString("fkCode", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Factura> filterByTipo(String tipCodigo) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where tipo.tipCodigo=:fkCode order by facRazonSocialComprador");
            query.setString("fkCode", tipCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Factura> personalizedFilter(Empresa empresa, Tipo tipo) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo order by facRazonSocialComprador");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public boolean checkIsRegistered(Factura f) throws DaoException {

        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where empresa.empCodigo=:codEmpresa and tipo.tipCodigo=:codTipo and facEstablecimiento=:establecimiento and facPuntoEmision=:ptoEmi and facSecuencial=:secuencial");
            query.setString("codEmpresa", f.getEmpresa().getEmpCodigo());
            query.setString("codTipo", f.getTipo().getTipCodigo());
            query.setString("establecimiento", f.getFacEstablecimiento());
            query.setString("ptoEmi", f.getFacPuntoEmision());
            query.setInteger("secuencial", Integer.parseInt(f.getFacSecuencial()));
            query.setMaxResults(1);
            Factura ff = (Factura) query.uniqueResult();
            if (ff == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new DaoException("No se pudo verificar la existencia de la factura.", e);
        } finally {
            session.close();
        }
    }

    public Date getFirstDate(Empresa e) {

        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Factura where empresa.empCodigo=:codEmpresa order by facFechaEmision");
            query.setString("codEmpresa", e.getEmpCodigo());
            query.setMaxResults(1);
            Factura ff = (Factura) query.uniqueResult();
            if (ff == null) {
                return new Date();
            } else {
                return ff.getFacFechaEmision();
            }
        } catch (Exception ex) {
            return new Date();
        } finally {
            session.close();
        }
    }

    public List<Factura> personalizedFilter(LoginController login, Empresa empresa, int tipo, Date desde, Date hasta, String filtro, int secuencial, int limit) throws DaoException {
        List<Factura> list = new ArrayList<Factura>();
        Session session = HibernateUtil.openSession();
        String checkedFilter1 = FilterUtil.check("facRazonSocialVendedor", filtro);
        String checkedFilter2 = FilterUtil.check("facRazonSocialComprador", filtro);

        String filterSec = "";
        if (secuencial > 0) {
            filterSec = " and facSecuencial=" + secuencial + " ";
        }

        String filterUser = "";
        if (login.isClienteProveedor()) {
            filterUser = " and (facIdentificacionVendedor='" + login.getUsuario().getUsuIdentificacion() + "' or facIdentificacionComprador='" + login.getUsuario().getUsuIdentificacion() + "') ";
        }

        try {
            if (tipo == 0) {
                Query query = session.createQuery("from Factura where ((facIdentificacionVendedor like (:rucVendedor)) or (facIdentificacionComprador like (:rucComprador)) or (" + checkedFilter1 + ") or (" + checkedFilter2 + ") ) " + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and facFechaEmision between :desde and :hasta order by tipo.tipNombre,facRazonSocialComprador,facSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("rucVendedor", "%" + filtro + "%");
                query.setString("rucComprador", "%" + filtro + "%");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 1) {
                Query query = session.createQuery("from Factura where ((facIdentificacionVendedor like (:rucVendedor)) or (facIdentificacionComprador like (:rucComprador)) or (" + checkedFilter1 + ") or (" + checkedFilter2 + ")  ) " + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and facFechaEmision between :desde and :hasta order by tipo.tipNombre,facRazonSocialComprador,facSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "ENV");
                query.setString("rucVendedor", "%" + filtro + "%");
                query.setString("rucComprador", "%" + filtro + "%");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 2) {
                Query query = session.createQuery("from Factura where ((facIdentificacionVendedor like (:rucVendedor)) or (facIdentificacionComprador like (:rucComprador)) or (" + checkedFilter1 + ") or (" + checkedFilter2 + ")  ) " + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and facFechaEmision between :desde and :hasta order by tipo.tipNombre,facRazonSocialComprador,facSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "REC");
                query.setString("rucVendedor", "%" + filtro + "%");
                query.setString("rucComprador", "%" + filtro + "%");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            }

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public double getResumeData(Empresa empresa, Tipo tipo, Date inicio, Date fin) throws DaoException {

        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("select sum(facTotalSinImpuestos) as total from Factura where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo and facFechaEmision between :desde and :hasta");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", tipo.getTipCodigo());
            query.setDate("desde", inicio);
            query.setDate("hasta", fin);
            Object o = query.uniqueResult();
            if (o == null) {
                return 0.0;
            }
            if (!(o instanceof Number)) {
                return 0.0;
            }
            return ((Number) o).doubleValue();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
    }

    public List<TopConsulta> getTopCompras(Empresa empresa, Date inicio, Date fin) throws DaoException {
        List<TopConsulta> tops = new ArrayList<TopConsulta>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("select facRazonSocialVendedor,sum(facTotalSinImpuestos) as total from Factura where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo and facFechaEmision between :desde and :hasta group by facRazonSocialVendedor order by sum(facTotalSinImpuestos) desc");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", "REC");
            query.setDate("desde", inicio);
            query.setDate("hasta", fin);
            query.setMaxResults(10);
            List list = query.list();
            for (Object o : list) {
                Object row[] = (Object[]) o;
                tops.add(new TopConsulta((String) row[0], ((Number) row[1]).doubleValue()));
            }

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return tops;
    }

    public List<TopConsulta> getTopVentas(Empresa empresa, Date inicio, Date fin) throws DaoException {
        List<TopConsulta> tops = new ArrayList<TopConsulta>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("select facRazonSocialComprador,sum(facTotalSinImpuestos) as total from Factura where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo and facFechaEmision between :desde and :hasta group by facRazonSocialComprador order by sum(facTotalSinImpuestos) desc");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", "ENV");
            query.setDate("desde", inicio);
            query.setDate("hasta", fin);
            query.setMaxResults(10);
            List list = query.list();
            for (Object o : list) {
                Object row[] = (Object[]) o;
                tops.add(new TopConsulta((String) row[0], ((Number) row[1]).doubleValue()));
            }

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Factura.", e);
        } finally {
            session.close();
        }
        return tops;
    }
}
