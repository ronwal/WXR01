package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Retencion;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RetencionDao {

    public void insert(Retencion retencion) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditInsert(session, retencion);
            session.save(retencion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Retencion.", e);
        } finally {
            session.close();
        }
    }

    public void insert(Session session, Retencion retencion) throws DaoException {
        try {
            HibernateUtil.auditInsert(session, retencion);
            session.save(retencion);
        } catch (Exception e) {
            throw new DaoException("No se pudo registrar la información en Retencion.", e);
        }
    }

    public void update(Retencion retencion) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditUpdate(session, retencion);
            session.update(retencion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Retencion.", e);
        } finally {
            session.close();
        }
    }

    public void update(Session session, Retencion retencion) throws DaoException {
        try {
            HibernateUtil.auditUpdate(session, retencion);
            session.update(retencion);
        } catch (Exception e) {
            throw new DaoException("No se pudo actualizar la información en Retencion.", e);
        }
    }

    public void delete(Retencion retencion) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditDelete(session, retencion);
            session.delete(retencion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo eliminar la información de Retencion.", e);
        } finally {
            session.close();
        }
    }

    public void delete(Session session, Retencion retencion) throws DaoException {
        try {
            HibernateUtil.auditDelete(session, retencion);
            session.delete(retencion);
        } catch (Exception e) {
            throw new DaoException("No se pudo eliminar la información de Retencion.", e);
        }
    }

    public Retencion findRetencionByPrimaryKey(Integer retCodigo) throws DaoException {
        Retencion loaded = null;
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where retCodigo=:pkCode");
            query.setInteger("pkCode", retCodigo);
            loaded = (Retencion) query.uniqueResult();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return loaded;
    }

    public List<Retencion> filterByRetRazonSocialRetenido(String filter, int maxResults) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        String checkedFilter = FilterUtil.check("retRazonSocialRetenido", filter);
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where " + checkedFilter + " order by retRazonSocialRetenido");
            query.setMaxResults(maxResults);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Retencion> filterByRetRazonSocialRetenido(String filter) throws DaoException {
        return filterByRetRazonSocialRetenido(filter, 50);
    }

    public List<Retencion> filterByEmpresa(Empresa empresa) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where empresa.empCodigo=:fkCode order by retRazonSocialRetenido");
            query.setString("fkCode", empresa.getEmpCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Retencion> filterByEmpresa(String empCodigo) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where empresa.empCodigo=:fkCode order by retRazonSocialRetenido");
            query.setString("fkCode", empCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Retencion> filterByTipo(Tipo tipo) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where tipo.tipCodigo=:fkCode order by retRazonSocialRetenido");
            query.setString("fkCode", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Retencion> filterByTipo(String tipCodigo) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where tipo.tipCodigo=:fkCode order by retRazonSocialRetenido");
            query.setString("fkCode", tipCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Retencion> personalizedFilter(Empresa empresa, Tipo tipo) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo order by retRazonSocialRetenido");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public boolean checkIsRegistered(Session session, Retencion r) throws DaoException {

        try {
            Query query = session.createQuery("from Retencion where empresa.empCodigo=:codEmpresa and tipo.tipCodigo=:codTipo and retEstablecimiento=:establecimiento and retPuntoEmision=:ptoEmi and retSecuencial=:secuencial");
            query.setString("codEmpresa", r.getEmpresa().getEmpCodigo());
            query.setString("codTipo", r.getTipo().getTipCodigo());
            query.setString("establecimiento", r.getRetEstablecimiento());
            query.setString("ptoEmi", r.getRetPuntoEmision());
            query.setInteger("secuencial", r.getRetSecuencial());
            query.setMaxResults(1);
            Retencion rr = (Retencion) query.uniqueResult();
            if (rr == null) {
                return false;
            }
            if (rr.getRetCodigo() > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new DaoException("No se pudo verificar la existencia de la factura.", e);
        }
        return false;
    }

    public List<Retencion> personalizedFilter(LoginController login, Empresa empresa, int tipo, Date desde, Date hasta, String filtro, int secuencial, int limit) throws DaoException {
        List<Retencion> list = new ArrayList<Retencion>();
        Session session = HibernateUtil.openSession();
        String checkedFilter = FilterUtil.check("retRazonSocialRetenido", filtro);
        checkedFilter += " or " + FilterUtil.check("retRazonSocialEmisor", filtro);

        String filterSec = "";
        if (secuencial > 0) {
            filterSec = " and retSecuencial=" + secuencial + " ";
        }

        String filterUser = "";
        if (login.isClienteProveedor()) {
            filterUser = " and (retIdentificacionEmisor='" + login.getUsuario().getUsuIdentificacion() + "' or retIdentificacionRetenido='" + login.getUsuario().getUsuIdentificacion() + "') ";
        }

        try {
            if (tipo == 0) {
                Query query = session.createQuery("from Retencion where (" + checkedFilter + ") " + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and retFechaEmision between :desde and :hasta order by tipo.tipNombre,retRazonSocialRetenido,retSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 1) {
                Query query = session.createQuery("from Retencion where (" + checkedFilter + ")" + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and retFechaEmision between :desde and :hasta order by tipo.tipNombre,retRazonSocialRetenido,retSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "ENV");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 2) {
                Query query = session.createQuery("from Retencion where (" + checkedFilter + ")" + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and retFechaEmision between :desde and :hasta order by tipo.tipNombre,retRazonSocialRetenido,retSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "REC");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            }

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public Date getFirstDate(Empresa e) {

        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from Retencion where empresa.empCodigo=:codEmpresa order by retFechaEmision");
            query.setString("codEmpresa", e.getEmpCodigo());
            query.setMaxResults(1);
            Retencion ff = (Retencion) query.uniqueResult();
            if (ff == null) {
                return new Date();
            } else {
                return ff.getRetFechaEmision();
            }
        } catch (Exception ex) {
            return new Date();
        } finally {
            session.close();
        }
    }

    public Retencion findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws DaoException {
        Retencion loaded = null;
        Session session = HibernateUtil.openSession();
        try {

            Query query = session.createQuery("from Retencion where retIdentificacionEmisor=:emisor and retIdentificacionRetenido=:receptor  and retEstablecimiento=:establecimiento and retPuntoEmision=:ptoEmision and retSecuencial=:secuencial ");
            query.setString("emisor", emisor);
            query.setString("receptor", receptor);
            query.setString("establecimiento", establecimiento);
            query.setString("ptoEmision", ptoEmision);
            query.setInteger("secuencial", secuencial);
            query.setMaxResults(1);
            loaded = (Retencion) query.uniqueResult();

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Retencion.", e);
        } finally {
            session.close();
        }
        return loaded;
    }

}
