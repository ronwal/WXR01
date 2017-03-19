/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.persistence.test;

import ec.fecuador.persistence.factecuador.data.dao.FacturaDAO;
import ec.fecuador.persistence.factecuador.data.dao.NotaCreditoDAO;
import ec.fecuador.persistence.factecuador.data.dao.PerfilDAO;
import ec.fecuador.persistence.factecuador.data.entities.DetalleMenuSystemEntity;
import ec.fecuador.persistence.factecuador.data.entities.FacturaEntity;
import ec.fecuador.persistence.factecuador.data.entities.NotaCreditoEntity;
import ec.fecuador.persistence.factecuador.data.entities.PerfilEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author mauriciochilan
 */
public class FacturaDAOTest extends TestBase {

    private static final Logger LOG = LoggerFactory.getLogger(FacturaDAOTest.class);

    @Test
    //@Ignore
    public void testFactura() {
        FacturaDAO factura = (FacturaDAO) getBean(FacturaDAO.BEAN_NAME);
        List<FacturaEntity> lista = factura.getFactPaging(0, 100);
        for (FacturaEntity obj : lista) {
            System.out.println("FacturaDAO : " + obj.getFacRazonSocialComprador());
        }
        System.out.println("FacturaDAO tamaño : " + lista.size());
    }

    @Test
    //@Ignore
    public void getMenuPerfil() {
        PerfilDAO perfil = (PerfilDAO) getBean(PerfilDAO.BEAN_NAME);
        PerfilEntity perfilEntity = perfil.getPerfilByCodPrf("INV");
        perfilEntity = (PerfilEntity) perfil.lazyLoad(PerfilEntity.class, perfilEntity);
        List<DetalleMenuSystemEntity> entities = perfilEntity.getDetalleMenuSystem();
        entities.
                forEach(item -> System.out.println(item.getMenuSystemByIdMenu().getNombreMenu()));
        System.out.println("FacturaDAO tamaño : " + entities.size());
    }

    @Test
    //@Ignore
    public void testNotaCredito() {
        NotaCreditoDAO credito = (NotaCreditoDAO) getBean(NotaCreditoDAO.BEAN_NAME);
        List<NotaCreditoEntity> lista = credito.getAllNotaCred();
        for (NotaCreditoEntity obj : lista) {
            System.out.println("NotaCredito : " + obj.getNcrRazonSocialComprador());
        }
        System.out.println("NotaCredito tamaño : " + lista.size());

    }
    @Test
    public void testDecript(){
        Security sec= null;
        try {
            sec = new Security();
            System.out.println(sec.decrypt("f74b6decaf92a9544f87b99e3259f66983282a91"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sec.decrypt(""));
    }

}
