package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class PerfilDao {




    public void insert(Perfil perfil)throws DaoException{
        Session session=HibernateUtil.openSession();
        Perfil buffer=findPerfilByPrimaryKey(perfil.getPrfCodigo());
        if(buffer!=null){
            throw new DaoException ("El código "+perfil.getPrfCodigo()+" ya se encuentra registrado.");
        }
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,perfil);
            session.save(perfil);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Perfil.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, Perfil perfil)throws DaoException{
        Perfil buffer=findPerfilByPrimaryKey(perfil.getPrfCodigo());
        if(buffer!=null){
            throw new DaoException ("El código "+perfil.getPrfCodigo()+" ya se encuentra registrado.");
        }
        try{
            HibernateUtil.auditInsert(session,perfil);
            session.save(perfil);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Perfil.", e);
        }
    }


    public void update(Perfil perfil)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,perfil);
            session.update(perfil);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Perfil.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, Perfil perfil)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,perfil);
            session.update(perfil);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Perfil.", e);
        }
    }


    public void delete(Perfil perfil)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,perfil);
            session.delete(perfil);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Perfil.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, Perfil perfil)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,perfil);
            session.delete(perfil);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Perfil.", e);
        }
    }


    public Perfil findPerfilByPrimaryKey(String prfCodigo)throws DaoException{
        Perfil loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Perfil where prfCodigo=:pkCode");
            query.setString("pkCode", prfCodigo);
            loaded=(Perfil)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Perfil.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<Perfil> filterByPrfNombre(String filter, int maxResults)throws DaoException{
        List <Perfil> list=new ArrayList<Perfil>();
        String checkedFilter=FilterUtil.check("prfNombre",filter);
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Perfil where " + checkedFilter + " order by prfNombre");
            query.setMaxResults(maxResults);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Perfil.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Perfil> filterByPrfNombre(String filter)throws DaoException{
        return filterByPrfNombre(filter,50);
    }


}