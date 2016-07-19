/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.factura.configuracion.DAO;

import ec.factura.configuracion.bean.DetailNoEncript;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Latinus
 */
public class ValidationDAO {

    Session session;

    public ValidationDAO() {
        this.session = HibernateUtil.openSession();
    }

    public long usersNoEMail() {
        try {
            Query query = session.createQuery("Select count(a) from Usuario a where a.usuMail = '' "
                    + "or a.usuMail is null and a.perfil.prfCodigo='CLP'");
            return (Long) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List noEMailDetail() {
        try {

            Query query = session.createQuery("Select count(a.usuIdentificacion), a.empresa.empRazonSocial, a.empresa.empCodigo "
                    + "from Usuario a where a.usuMail = '' or a.usuMail is null and a.perfil.prfCodigo='CLP' "
                    + "Group By a.empresa.empCodigo, a.empresa.empRazonSocial ");
            List list = new ArrayList();
            for (Object object : query.list()) {
                list.add(new DetailNoEncript(Long.parseLong(((Object[]) object)[0].toString()), (String) ((Object[]) object)[1], (String) ((Object[]) object)[2], null));
            }
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

    public long usersNoEncrip() {
        try {
            Query query = session.createQuery("Select count(a) from Usuario a "
                    + "where a.usuClave = a.usuIdentificacion ");
            return (Long) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List noEncripDetail() {
        try {
            Query query = session.createQuery("Select Count(a.usuIdentificacion), a.empresa.empRazonSocial, a.empresa.empCodigo, a.perfil.prfCodigo from Usuario a "
                    + "Where a.usuClave=a.usuIdentificacion Group By a.empresa.empCodigo, a.empresa.empRazonSocial, a.perfil.prfCodigo");
            List list = new ArrayList();
            for (Object object : query.list()) {
                list.add(new DetailNoEncript(Long.parseLong(((Object[]) object)[0].toString()), (String) ((Object[]) object)[1], (String) ((Object[]) object)[2], (String) ((Object[]) object)[3]));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

    public List noEncrip(String ruc) {
        try {
            Query query = session.createQuery("Select a from Usuario a "
                    + " Where a.usuClave=a.usuIdentificacion and a.empresa.empCodigo='" + ruc + "'");
            return query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }
}
