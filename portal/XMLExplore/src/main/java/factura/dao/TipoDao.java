package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class TipoDao {




    public void insert(Tipo tipo)throws DaoException{
        Session session=HibernateUtil.openSession();
        Tipo buffer=findTipoByPrimaryKey(tipo.getTipCodigo());
        if(buffer!=null){
            throw new DaoException ("El código "+tipo.getTipCodigo()+" ya se encuentra registrado.");
        }
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,tipo);
            session.save(tipo);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Tipo.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, Tipo tipo)throws DaoException{
        Tipo buffer=findTipoByPrimaryKey(tipo.getTipCodigo());
        if(buffer!=null){
            throw new DaoException ("El código "+tipo.getTipCodigo()+" ya se encuentra registrado.");
        }
        try{
            HibernateUtil.auditInsert(session,tipo);
            session.save(tipo);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Tipo.", e);
        }
    }


    public void update(Tipo tipo)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,tipo);
            session.update(tipo);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Tipo.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, Tipo tipo)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,tipo);
            session.update(tipo);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Tipo.", e);
        }
    }


    public void delete(Tipo tipo)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,tipo);
            session.delete(tipo);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Tipo.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, Tipo tipo)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,tipo);
            session.delete(tipo);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Tipo.", e);
        }
    }


    public Tipo findTipoByPrimaryKey(String tipCodigo)throws DaoException{
        Tipo loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Tipo where tipCodigo=:pkCode");
            query.setString("pkCode", tipCodigo);
            loaded=(Tipo)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Tipo.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<Tipo> filterByTipNombre(String filter, int maxResults)throws DaoException{
        List <Tipo> list=new ArrayList<Tipo>();
        String checkedFilter=FilterUtil.check("tipNombre",filter);
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Tipo where " + checkedFilter + " order by tipNombre");
            query.setMaxResults(maxResults);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Tipo.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Tipo> filterByTipNombre(String filter)throws DaoException{
        return filterByTipNombre(filter,50);
    }


}