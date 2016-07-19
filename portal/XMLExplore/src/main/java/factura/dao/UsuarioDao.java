package factura.dao;

import ec.ste.factura.Constantes;
import ec.ste.factura.HibernateUtil;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Usuario;
import ec.ste.factura.exception.DaoException;
import ec.ste.factura.util.FilterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class UsuarioDao {




    public void insert(Usuario usuario)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditInsert(session,usuario);
            session.save(usuario);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo registrar la información en Usuario.", e);
        }finally{
            session.close();
        }
    }


    public void insert(Session session, Usuario usuario)throws DaoException{
        try{
            HibernateUtil.auditInsert(session,usuario);
            session.save(usuario);
        }catch(Exception e){
            throw new DaoException("No se pudo registrar la información en Usuario.", e);
        }
    }


    public void update(Usuario usuario)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditUpdate(session,usuario);
            session.update(usuario);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException("No se pudo actualizar la información en Usuario.", e);
        }finally{
            session.close();
        }
    }


    public void update(Session session, Usuario usuario)throws DaoException{
        try{
            HibernateUtil.auditUpdate(session,usuario);
            session.update(usuario);
        }catch(Exception e){
            throw new DaoException ("No se pudo actualizar la información en Usuario.", e);
        }
    }


    public void delete(Usuario usuario)throws DaoException{
        Session session=HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            HibernateUtil.auditDelete(session,usuario);
            session.delete(usuario);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new DaoException ("No se pudo eliminar la información de Usuario.", e);
        }finally{
            session.close();
        }
    }


    public void delete(Session session, Usuario usuario)throws DaoException{
        try{
            HibernateUtil.auditDelete(session,usuario);
            session.delete(usuario);
        }catch(Exception e){
            throw new DaoException ("No se pudo eliminar la información de Usuario.", e);
        }
    }


    public Usuario findUsuarioByPrimaryKey(Integer usuCodigo)throws DaoException{
        Usuario loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where usuCodigo=:pkCode");
            query.setInteger("pkCode", usuCodigo);
            loaded=(Usuario)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<Usuario> filterByUsuNombre(String filter, int maxResults)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        String checkedFilter=FilterUtil.check("usuNombre",filter);
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where " + checkedFilter + " order by usuNombre");
            query.setMaxResults(maxResults);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Usuario> filterByUsuNombre(String filter)throws DaoException{
        return filterByUsuNombre(filter,50);
    }
    
     public Usuario findUsuarioByNick(String usuNick, Empresa empcod)throws DaoException{
        Usuario loaded=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query;
            if (empcod != null) {
                query = session.createQuery("from Usuario where usuNick=:pkCode And empresa.empCodigo=:fkCode ");
                query.setString("pkCode", usuNick.trim());
                query.setString("fkCode", empcod.getEmpCodigo().trim());
            } else {
                query = session.createQuery("from Usuario where usuNick=:pkCode ");
                query.setString("pkCode", usuNick.trim());
            }
            System.out.println(query.getQueryString()+" .::. "+usuNick);
            loaded=(Usuario)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return loaded;
    }


    public List<Usuario> filterByEmpresa(Empresa empresa)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where empresa.empCodigo=:fkCode order by usuNombre");
            query.setString("fkCode", empresa.getEmpCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Usuario> filterByEmpresa(String empCodigo)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where empresa.empCodigo=:fkCode order by usuNombre");
            query.setString("fkCode", empCodigo);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Usuario> filterByPerfil(Perfil perfil)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where perfil.prfCodigo=:fkCode order by usuNombre");
            query.setString("fkCode", perfil.getPrfCodigo());
            list=query.list();
        }catch(Exception e){
            throw new DaoException("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public List<Usuario> filterByPerfil(String prfCodigo)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where perfil.prfCodigo=:fkCode order by usuNombre");
            query.setString("fkCode", prfCodigo);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }


    public Usuario personalizedFilter(Empresa empresa, String identificacion)throws DaoException{
        Usuario usuario=null;
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where empresa.empCodigo=:prmEmpCodigo and usuIdentificacion=:prmUsuIdentificacion order by usuNombre");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prmUsuIdentificacion", identificacion);
            query.setMaxResults(1);
            usuario=(Usuario)query.uniqueResult();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return usuario;
    }
    
    public List<Usuario> getListaAdministradorEmpresa(Empresa empresa)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where empresa.empCodigo=:prmEmpCodigo and perfil.prfCodigo in(:prm1, :prm2, :prm3) order by usuNombre");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prm1", Constantes.PRF_CLIENTE_PROVEEDOR);
            query.setString("prm2", Constantes.PRF_CONSULTOR_INTERNO);
            query.setString("prm3", Constantes.PRF_GERENCIA_EMPRESA);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }
    
    public List<Usuario> getListaAdministradorEmpresa(Empresa empresa, String criteria)throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query = session.createQuery("from Usuario where empresa.empCodigo=:prmEmpCodigo "
                    + "and perfil.prfCodigo in(:prm1, :prm2, :prm3) "
                    + "and (usuIdentificacion like '" + criteria + "%' or usuNombre like'" + criteria + "%' or usuMail like '" +
                    criteria + "%' or usuNick like '" + criteria + "%') "
                    + "order by usuNombre");
            query.setString("prmEmpCodigo", empresa.getEmpCodigo());
            query.setString("prm1", Constantes.PRF_CLIENTE_PROVEEDOR);
            query.setString("prm2", Constantes.PRF_CONSULTOR_INTERNO);
            query.setString("prm3", Constantes.PRF_GERENCIA_EMPRESA);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }
    
     public List<Usuario> getListaAdministradorSistema()throws DaoException{
        List <Usuario> list=new ArrayList<Usuario>();
        Session session=HibernateUtil.openSession();
        try{
            Query query=session.createQuery("from Usuario where perfil.prfCodigo in(:prm1, :prm2, :prm3) order by usuNombre");
            query.setString("prm1", Constantes.PRF_ADMINISTRADOR);
            query.setString("prm2", Constantes.PRF_ADMINISTRADOR_EMPRESA);
            query.setString("prm3", Constantes.PRF_CARGA_DATOS_EMPRESA);
            list=query.list();
        }catch(Exception e){
            throw new DaoException ("No se pudo cargar la información de Usuario.", e);
        }finally{
            session.close();
        }
        return list;
    }


}