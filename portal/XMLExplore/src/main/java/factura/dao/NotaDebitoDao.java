package factura.dao;

import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.NotaDebito;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class NotaDebitoDao {




    public void insert(NotaDebito notaDebito)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,notaDebito);
            session.save(notaDebito);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Nota Debito.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, NotaDebito notaDebito)throws DaoException{
        try{
            HibernateUtil.auditInsert(session,notaDebito);
            session.save(notaDebito);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Nota Debito.", e);
        }
    }


    public void update(NotaDebito notaDebito)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,notaDebito);
            session.update(notaDebito);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Nota Debito.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, NotaDebito notaDebito)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,notaDebito);
            session.update(notaDebito);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Nota Debito.", e);
        }
    }


    public void delete(NotaDebito notaDebito)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,notaDebito);
            session.delete(notaDebito);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, NotaDebito notaDebito)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,notaDebito);
            session.delete(notaDebito);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Nota Debito.", e);
        }
    }


    public NotaDebito findNotaDebitoByPrimaryKey(Integer ndeCodigo)throws DaoException{
        NotaDebito loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where ndeCodigo=:pkCode");
            query.setInteger("pkCode", ndeCodigo);
            loaded=(NotaDebito)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<NotaDebito> filterByNdeRazonSocialComprador(String filter, int maxResults)throws DaoException{
        List <NotaDebito> list=new ArrayList<NotaDebito>();
        String checkedFilter=FilterUtil.check("ndeRazonSocialComprador",filter);
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where " + checkedFilter + " order by ndeRazonSocialComprador");
            query.setMaxResults(maxResults);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<NotaDebito> filterByNdeRazonSocialComprador(String filter)throws DaoException{
        return filterByNdeRazonSocialComprador(filter,50);
    }


    public List<NotaDebito> filterByEmpresa(Empresa empresa)throws DaoException{
        List <NotaDebito> list=new ArrayList<NotaDebito>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where empresa.empCodigo=:fkCode order by ndeRazonSocialComprador");
            query.setString("fkCode", empresa.getEmpCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<NotaDebito> filterByEmpresa(String empCodigo)throws DaoException{
        List <NotaDebito> list=new ArrayList<NotaDebito>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where empresa.empCodigo=:fkCode order by ndeRazonSocialComprador");
            query.setString("fkCode", empCodigo);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<NotaDebito> filterByTipo(Tipo tipo)throws DaoException{
        List <NotaDebito> list=new ArrayList<NotaDebito>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where tipo.tipCodigo=:fkCode order by ndeRazonSocialComprador");
            query.setString("fkCode", tipo.getTipCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<NotaDebito> filterByTipo(String tipCodigo)throws DaoException{
        List <NotaDebito> list=new ArrayList<NotaDebito>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where tipo.tipCodigo=:fkCode order by ndeRazonSocialComprador");
            query.setString("fkCode", tipCodigo);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<NotaDebito> personalizedFilter(Empresa empresa, Tipo tipo)throws DaoException{
        List <NotaDebito> list=new ArrayList<NotaDebito>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from NotaDebito where empresa.empCodigo=:prmEmpCodigo and tipo.tipCodigo=:prmTipCodigo order by ndeRazonSocialComprador");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmTipCodigo", tipo.getTipCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Nota Debito.", e);
        }finally{
            session.close();
        }
        return list;
    }


}