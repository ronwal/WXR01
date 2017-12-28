package ec.gob.fecuador.ws.cliente.aut.offline.test;

import ec.gob.fecuador.ws.cliente.aut.offline.AutorizacionOfflineWS;
import ec.gob.sri.ws.autorizacion.offline.RespuestaComprobante;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class AutorizacionOfflineTest {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AutorizacionOfflineTest.class);

    @Test
    public void testDocument() {
        String claveAcc = "2711201701091112030100120010020000008721234567810";
        AutorizacionOfflineWS offlineWS = new AutorizacionOfflineWS();
        RespuestaComprobante respuestaComprobante = offlineWS.getAutorizacionOfflineDoc(claveAcc);
        LOG.info("Num comprobantes {}", respuestaComprobante.getNumeroComprobantes());
        respuestaComprobante.getAutorizaciones().getAutorizacion().stream().forEach(aut -> {
            LOG.info("Estado {}", aut.getEstado());
            LOG.info("comprobante {}", aut.getComprobante());
        });

    }
}
