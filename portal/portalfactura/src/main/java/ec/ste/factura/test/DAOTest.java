/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.test;

import ec.ste.factura.Constantes;
import ec.ste.factura.crypt.Crypt;
import ec.ste.factura.entities.Empresa;
import ec.ste.factura.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author German17
 */
public class DAOTest extends DaoManager {

    public static void main(String args[]) {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        try {
            //Empresa e = new Empresa("0911120301001", "ANDRADE MENESES VIOLETA ELIZABETH", "gerencia@elconstructorcayambe.com", "022364632", "Cayambe, Av. Natalia S6-32 y Venezuela","violeta.com");
            Empresa e=EMPRESA_DAO.findEmpresaByPrimaryKey("0911120301001");
            //EMPRESA_DAO.insert(session, e);
            Usuario u = new Usuario();
            u.setEmpresa(e);
            u.setPerfil(PERFIL_DAO.findPerfilByPrimaryKey(Constantes.PRF_ADMINISTRADOR_EMPRESA));
            u.setUsuActivo(true);
            u.setUsuIdentificacion("0911120301001");
            u.setUsuClave(Crypt.encrypt(u.getUsuIdentificacion(), "german"));
            u.setUsuMail("contabilidad@elconstructorcayambe.com");
            u.setUsuNick("german");
            u.setUsuNombre("German Morocho");
            USUARIO_DAO.insert(session,u);
            
            
            
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();

        } finally {
            session.close();
        }
    }
}
