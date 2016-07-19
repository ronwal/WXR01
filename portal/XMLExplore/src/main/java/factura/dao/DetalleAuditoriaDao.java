package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Auditoria;
import ec.ste.factura.entities.DetalleAuditoria;
import ec.ste.factura.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class DetalleAuditoriaDao {




    public void insert(DetalleAuditoria detalleAuditoria)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,detalleAuditoria);
            session.save(detalleAuditoria);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Detalle Auditoria.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, DetalleAuditoria detalleAuditoria)throws DaoException{
        try{
            HibernateUtil.auditInsert(session,detalleAuditoria);
            session.save(detalleAuditoria);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Detalle Auditoria.", e);
        }
    }


    public void update(DetalleAuditoria detalleAuditoria)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,detalleAuditoria);
            session.update(detalleAuditoria);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Detalle Auditoria.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, DetalleAuditoria detalleAuditoria)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,detalleAuditoria);
            session.update(detalleAuditoria);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Detalle Auditoria.", e);
        }
    }


    public void delete(DetalleAuditoria detalleAuditoria)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,detalleAuditoria);
            session.delete(detalleAuditoria);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Detalle Auditoria.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, DetalleAuditoria detalleAuditoria)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,detalleAuditoria);
            session.delete(detalleAuditoria);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Detalle Auditoria.", e);
        }
    }


    public DetalleAuditoria findDetalleAuditoriaByPrimaryKey(Integer dauCodigo)throws DaoException{
        DetalleAuditoria loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from DetalleAuditoria where dauCodigo=:pkCode");
            query.setInteger("pkCode", dauCodigo);
            loaded=(DetalleAuditoria)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Detalle Auditoria.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<DetalleAuditoria> filterByAuditoria(Auditoria auditoria)throws DaoException{
        List <DetalleAuditoria> list=new ArrayList<DetalleAuditoria>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from DetalleAuditoria where auditoria.audCodigo=:fkCode ");
            query.setInteger("fkCode", auditoria.getAudCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Detalle Auditoria.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<DetalleAuditoria> filterByAuditoria(Integer audCodigo)throws DaoException{
        List <DetalleAuditoria> list=new ArrayList<DetalleAuditoria>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from DetalleAuditoria where auditoria.audCodigo=:fkCode ");
            query.setInteger("fkCode", audCodigo);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Detalle Auditoria.", e);
        }finally{
            session.close();
        }
        return list;
    }


}