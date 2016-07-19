package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Auditoria;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class AuditoriaDao {




    public void insert(Auditoria auditoria)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,auditoria);
            session.save(auditoria);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Auditoria.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, Auditoria auditoria)throws DaoException{
        try{
            HibernateUtil.auditInsert(session,auditoria);
            session.save(auditoria);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Auditoria.", e);
        }
    }


    public void update(Auditoria auditoria)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,auditoria);
            session.update(auditoria);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Auditoria.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, Auditoria auditoria)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,auditoria);
            session.update(auditoria);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Auditoria.", e);
        }
    }


    public void delete(Auditoria auditoria)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,auditoria);
            session.delete(auditoria);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Auditoria.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, Auditoria auditoria)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,auditoria);
            session.delete(auditoria);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Auditoria.", e);
        }
    }


    public Auditoria findAuditoriaByPrimaryKey(Integer audCodigo)throws DaoException{
        Auditoria loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Auditoria where audCodigo=:pkCode");
            query.setInteger("pkCode", audCodigo);
            loaded=(Auditoria)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Auditoria.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<Auditoria> filterByUsuario(Usuario usuario)throws DaoException{
        List <Auditoria> list=new ArrayList<Auditoria>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Auditoria where usuario.usuCodigo=:fkCode ");
            query.setInteger("fkCode", usuario.getUsuCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Auditoria.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Auditoria> filterByUsuario(Integer usuCodigo)throws DaoException{
        List <Auditoria> list=new ArrayList<Auditoria>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Auditoria where usuario.usuCodigo=:fkCode ");
            query.setInteger("fkCode", usuCodigo);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Auditoria.", e);
        }finally{
            session.close();
        }
        return list;
    }


}