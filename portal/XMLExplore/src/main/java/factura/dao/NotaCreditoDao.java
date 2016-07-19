package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.NotaCredito;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaCreditoDao {

    public void insert(NotaCredito notaCredito) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditInsert(session, notaCredito);
            session.save(notaCredito);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Nota Credito.", e);
        } finally {
            session.close();
        }
    }

    public void insert(Session session, NotaCredito notaCredito) throws DaoException {
        try {
            HibernateUtil.auditInsert(session, notaCredito);
            session.save(notaCredito);
        } catch (Exception e) {
            throw new DaoException("No se pudo registrar la información en Nota Credito.", e);
        }
    }

    public void update(NotaCredito notaCredito) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditUpdate(session, notaCredito);
            session.update(notaCredito);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Nota Credito.", e);
        } finally {
            session.close();
        }
    }

    public void update(Session session, NotaCredito notaCredito) throws DaoException {
        try {
            HibernateUtil.auditUpdate(session, notaCredito);
            session.update(notaCredito);
        } catch (Exception e) {
            throw new DaoException("No se pudo actualizar la información en Nota Credito.", e);
        }
    }

    public void delete(NotaCredito notaCredito) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditDelete(session, notaCredito);
            session.delete(notaCredito);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo eliminar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
    }

    public void delete(Session session, NotaCredito notaCredito) throws DaoException {
        try {
            HibernateUtil.auditDelete(session, notaCredito);
            session.delete(notaCredito);
        } catch (Exception e) {
            throw new DaoException("No se pudo eliminar la información de Nota Credito.", e);
        }
    }

    public NotaCredito findNotaCreditoByPrimaryKey(Integer ncrCodigo) throws DaoException {
        NotaCredito loaded = null;
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where ncrCodigo=:pkCode");
            query.setInteger("pkCode", ncrCodigo);
            loaded = (NotaCredito) query.uniqueResult();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return loaded;
    }

    public List<NotaCredito> filterByNcrRazonSocialComprador(String filter, int maxResults) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        String checkedFilter = FilterUtil.check("ncrRazonSocialComprador", filter);
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where " + checkedFilter + " order by ncrRazonSocialComprador");
            query.setMaxResults(maxResults);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaCredito> filterByNcrRazonSocialComprador(String filter) throws DaoException {
        return filterByNcrRazonSocialComprador(filter, 50);
    }

    public List<NotaCredito> filterByEmpresa(Empresa empresa) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where empresa.empCodigo=:fkCode order by ncrRazonSocialComprador");
            query.setString("fkCode", empresa.getEmpCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaCredito> filterByEmpresa(String empCodigo) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where empresa.empCodigo=:fkCode order by ncrRazonSocialComprador");
            query.setString("fkCode", empCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaCredito> filterByTipo(Tipo tipo) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where tipo.tipCodigo=:fkCode order by ncrRazonSocialComprador");
            query.setString("fkCode", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaCredito> filterByTipo(String tipCodigo) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where tipo.tipCodigo=:fkCode order by ncrRazonSocialComprador");
            query.setString("fkCode", tipCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaCredito> personalizedFilter(Empresa empresa, Tipo tipo) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo order by ncrRazonSocialComprador");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Nota Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public boolean checkIsRegistered(NotaCredito nc) throws DaoException {

        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from NotaCredito where empresa.empCodigo=:codEmpresa and tipo.tipCodigo=:codTipo and ncrEstablecimiento=:establecimiento and ncrPuntoEmision=:ptoEmi and ncrSecuencial=:secuencial");
            query.setString("codEmpresa", nc.getEmpresa().getEmpCodigo());
            query.setString("codTipo", nc.getTipo().getTipCodigo());
            query.setString("establecimiento", nc.getNcrEstablecimiento());
            query.setString("ptoEmi", nc.getNcrPuntoEmision());
            query.setInteger("secuencial", Integer.parseInt(nc.getNcrSecuencial()));
            query.setMaxResults(1);
            Factura ff = (Factura) query.uniqueResult();
            if (ff == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new DaoException("No se pudo verificar la existencia de la nota de credito.", e);
        } finally {
            session.close();
        }
    }

    public List<NotaCredito> personalizedFilter(LoginController login, Empresa empresa, int tipo, Date desde, Date hasta, String filtro, int secuencial, int limit) throws DaoException {
        List<NotaCredito> list = new ArrayList<NotaCredito>();
        Session session = HibernateUtil.openSession();
        String checkedFilter = FilterUtil.check("ncrRazonSocialComprador", filtro);
        checkedFilter += " or " + FilterUtil.check("ncrRazonSocialVendedor", filtro);
        String filterSec = "";
        if (secuencial > 0) {
            filterSec = " and ncrSecuencial=" + secuencial + " ";
        }

        String filterUser = "";
        if (login.isClienteProveedor()) {
            filterUser = " and (ncrIdentificacionVendedor='" + login.getUsuario().getUsuIdentificacion() + "' or ncrIdentificacionComprador='" + login.getUsuario().getUsuIdentificacion() + "') ";
        }

        try {
            if (tipo == 0) {
                Query query = session.createQuery("from NotaCredito where (" + checkedFilter + ") " + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and ncrFechaEmision between :desde and :hasta order by tipo.tipNombre,ncrIdentificacionVendedor,ncrIdentificacionComprador,ncrSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 1) {
                Query query = session.createQuery("from NotaCredito where (" + checkedFilter + ")" + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and ncrFechaEmision between :desde and :hasta order by tipo.tipNombre,ncrIdentificacionVendedor,ncrIdentificacionComprador,ncrSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "ENV");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 2) {
                Query query = session.createQuery("from NotaCredito where (" + checkedFilter + ")" + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and ncrFechaEmision between :desde and :hasta order by tipo.tipNombre,ncrIdentificacionVendedor,ncrIdentificacionComprador,ncrSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "REC");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            }

        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de la Nota de Credito.", e);
        } finally {
            session.close();
        }
        return list;
    }

}
