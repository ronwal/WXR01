package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class EmpresaDao {




    public void insert(Empresa empresa)throws DaoException{
        Session session=HibernateUtil.openSession();
        Empresa buffer=findEmpresaByPrimaryKey(empresa.getEmpCodigo());
        if(buffer!=null){
            throw new DaoException ("El código "+empresa.getEmpCodigo()+" ya se encuentra registrado.");
        }
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,empresa);
            session.save(empresa);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Empresa.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, Empresa empresa)throws DaoException{
        Empresa buffer=findEmpresaByPrimaryKey(empresa.getEmpCodigo());
        if(buffer!=null){
            throw new DaoException ("El código "+empresa.getEmpCodigo()+" ya se encuentra registrado.");
        }
        try{
            HibernateUtil.auditInsert(session,empresa);
            session.save(empresa);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Empresa.", e);
        }
    }


    public void update(Empresa empresa)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,empresa);
            session.update(empresa);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Empresa.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, Empresa empresa)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,empresa);
            session.update(empresa);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Empresa.", e);
        }
    }


    public void delete(Empresa empresa)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,empresa);
            session.delete(empresa);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Empresa.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, Empresa empresa)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,empresa);
            session.delete(empresa);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Empresa.", e);
        }
    }


    public Empresa findEmpresaByPrimaryKey(String empCodigo)throws DaoException{
        Empresa loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Empresa where empCodigo=:pkCode");
            query.setString("pkCode", empCodigo.trim());
            loaded=(Empresa)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Empresa.", e);
        }finally{
            session.close();
        }
        return loaded;
    }
    
    public Empresa findEmpresaByUrl(String url)throws DaoException{
        Empresa loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Empresa where empUrl=:url");
            query.setString("url", url.trim());
            query.setMaxResults(1);
            loaded=(Empresa)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Empresa.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<Empresa> filterByEmpRazonSocial(String filter, int maxResults)throws DaoException{
        List <Empresa> list=new ArrayList<Empresa>();
        String checkedFilter=FilterUtil.check("empRazonSocial",filter);
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Empresa where " + checkedFilter + " order by empRazonSocial");
            query.setMaxResults(maxResults);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Empresa.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Empresa> filterByEmpRazonSocial(String filter)throws DaoException{
        return filterByEmpRazonSocial(filter,50);
    }


}