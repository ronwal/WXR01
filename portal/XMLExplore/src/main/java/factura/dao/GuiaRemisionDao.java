package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.controllers.LoginController;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.GuiaRemision;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuiaRemisionDao {

    public void insert(GuiaRemision guiaRemision) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditInsert(session, guiaRemision);
            session.save(guiaRemision);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Guia Remision.", e);
        } finally {
            session.close();
        }
    }

    public void insert(Session session, GuiaRemision guiaRemision) throws DaoException {
        try {
            HibernateUtil.auditInsert(session, guiaRemision);
            session.save(guiaRemision);
        } catch (Exception e) {
            throw new DaoException("No se pudo registrar la información en Guia Remision.", e);
        }
    }

    public void update(GuiaRemision guiaRemision) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditUpdate(session, guiaRemision);
            session.update(guiaRemision);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Guia Remision.", e);
        } finally {
            session.close();
        }
    }

    public void update(Session session, GuiaRemision guiaRemision) throws DaoException {
        try {
            HibernateUtil.auditUpdate(session, guiaRemision);
            session.update(guiaRemision);
        } catch (Exception e) {
            throw new DaoException("No se pudo actualizar la información en Guia Remision.", e);
        }
    }

    public void delete(GuiaRemision guiaRemision) throws DaoException {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.auditDelete(session, guiaRemision);
            session.delete(guiaRemision);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException("No se pudo eliminar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
    }

    public void delete(Session session, GuiaRemision guiaRemision) throws DaoException {
        try {
            HibernateUtil.auditDelete(session, guiaRemision);
            session.delete(guiaRemision);
        } catch (Exception e) {
            throw new DaoException("No se pudo eliminar la información de Guia Remision.", e);
        }
    }

    public GuiaRemision findGuiaRemisionByPrimaryKey(Integer greCodigo) throws DaoException {
        GuiaRemision loaded = null;
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where greCodigo=:pkCode");
            query.setInteger("pkCode", greCodigo);
            loaded = (GuiaRemision) query.uniqueResult();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return loaded;
    }

    public List<GuiaRemision> filterByGreRazonSocialComprador(String filter, int maxResults) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        String checkedFilter = FilterUtil.check("greRazonSocialComprador", filter);
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where " + checkedFilter + " order by greRazonSocialComprador");
            query.setMaxResults(maxResults);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<GuiaRemision> filterByGreRazonSocialComprador(String filter) throws DaoException {
        return filterByGreRazonSocialComprador(filter, 50);
    }

    public List<GuiaRemision> filterByEmpresa(Empresa empresa) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where empresa.empCodigo=:fkCode order by greRazonSocialComprador");
            query.setString("fkCode", empresa.getEmpCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<GuiaRemision> filterByEmpresa(String empCodigo) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where empresa.empCodigo=:fkCode order by greRazonSocialComprador");
            query.setString("fkCode", empCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<GuiaRemision> filterByTipo(Tipo tipo) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where tipo.tipCodigo=:fkCode order by greRazonSocialComprador");
            query.setString("fkCode", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<GuiaRemision> filterByTipo(String tipCodigo) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where tipo.tipCodigo=:fkCode order by greRazonSocialComprador");
            query.setString("fkCode", tipCodigo);
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public List<GuiaRemision> personalizedFilter(Empresa empresa, Tipo tipo) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo order by greRazonSocialComprador");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", tipo.getTipCodigo());
            list = query.list();
        } catch (Exception e) {
            throw new DaoException("No se pudo cargar la información de Guia Remision.", e);
        } finally {
            session.close();
        }
        return list;
    }

    public boolean checkIsRegistered(GuiaRemision gr) throws DaoException {

        Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from GuiaRemision where empresa.empCodigo=:codEmpresa and tipo.tipCodigo=:codTipo and greEstablecimiento=:establecimiento and grePuntoEmision=:ptoEmi and greSecuencial=:secuencial");
            query.setString("codEmpresa", gr.getEmpresa().getEmpCodigo());
            query.setString("codTipo", gr.getTipo().getTipCodigo());
            query.setString("establecimiento", gr.getGreEstablecimiento());
            query.setString("ptoEmi", gr.getGrePuntoEmision());
            query.setInteger("secuencial", gr.getGreSecuencial());
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
    
    
    public List<GuiaRemision> personalizedFilter(LoginController login, Empresa empresa, int tipo, Date desde, Date hasta, String filtro, int secuencial, int limit) throws DaoException {
        List<GuiaRemision> list = new ArrayList<GuiaRemision>();
        Session session = HibernateUtil.openSession();
        String checkedFilter = FilterUtil.check("greRazonSocialComprador", filtro);
        checkedFilter += " or " + FilterUtil.check("greRazonSocialVendedor", filtro);
        String filterSec = "";
        if (secuencial > 0) {
            filterSec = " and greSecuencial=" + secuencial + " ";
        }

        String filterUser = "";
        if (login.isClienteProveedor()) {
            filterUser = " and (greIdentificacionVendedor='" + login.getUsuario().getUsuIdentificacion() + "' or greIdentificacionComprador='" + login.getUsuario().getUsuIdentificacion() + "') ";
        }

        try {
            if (tipo == 0) {
                Query query = session.createQuery("from GuiaRemision where (" + checkedFilter + ") " + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and greFechaEmision between :desde and :hasta order by tipo.tipNombre,greRazonSocialVendedor,greRazonSocialComprador,greSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 1) {
                Query query = session.createQuery("from GuiaRemision where (" + checkedFilter + ")" + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and greFechaEmision between :desde and :hasta order by tipo.tipNombre,greRazonSocialVendedor,greRazonSocialComprador,greSecuencial");
                query.setString("prmEmpCodigo", empresa.getEmpCodigo());
                query.setString("tipo", "ENV");
                query.setDate("desde", desde);
                query.setDate("hasta", hasta);
                query.setMaxResults(limit);
                return query.list();
            } else if (tipo == 2) {
                Query query = session.createQuery("from GuiaRemision where (" + checkedFilter + ")" + filterSec + filterUser + " and empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:tipo and greFechaEmision between :desde and :hasta order by tipo.tipNombre,greRazonSocialVendedor,greRazonSocialComprador,greSecuencial");
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
