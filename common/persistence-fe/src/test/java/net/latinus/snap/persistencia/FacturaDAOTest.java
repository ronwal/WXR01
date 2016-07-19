/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.snap.persistencia;

import net.fecuador.persist.model.dao.FacturaDAO;
import net.fecuador.persist.model.dao.NotaCreditoDAO;
import net.fecuador.persist.model.entities.FacturaEntity;
import net.fecuador.persist.model.entities.NotaCreditoEntity;
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
        List<FacturaEntity> lista = factura.getAllEntity();
        for (FacturaEntity obj : lista) {
            System.out.println("FacturaDAO : " + obj.getFacRazonSocialComprador());
        }
        System.out.println("FacturaDAO tamaño : " + lista.size());
    }

    @Test
    //@Ignore
    public void testNotaCredito() {
        NotaCreditoDAO credito = (NotaCreditoDAO) getBean(NotaCreditoDAO.BEAN_NAME);
        List<NotaCreditoEntity> lista = credito.getAllEntity();
        for (NotaCreditoEntity obj : lista) {
            System.out.println("NotaCredito : " + obj.getNcrRazonSocialComprador());
        }
        System.out.println("NotaCredito tamaño : " + lista.size());

    }

}
