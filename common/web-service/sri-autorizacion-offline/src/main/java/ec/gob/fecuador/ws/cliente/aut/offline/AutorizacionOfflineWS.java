package ec.gob.fecuador.ws.cliente.aut.offline;

import ec.gob.fecuador.ws.cliente.aut.offline.operation.AutorizacionOfflineWSOp;
import ec.gob.sri.ws.autorizacion.offline.RespuestaComprobante;
import ec.gob.sri.ws.autorizacion.offline.RespuestaLote;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class AutorizacionOfflineWS extends AutorizacionOfflineWSOp implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AutorizacionOfflineWS.class);

    public RespuestaComprobante getAutorizacionOfflineDoc(String claveAcceso) {
        return getPortType().autorizacionComprobante(claveAcceso);
    }

    public RespuestaLote getAutorizacionOfflineDocLote(String claveAcceso) {
        return getPortType().autorizacionComprobanteLote(claveAcceso);
    }
}