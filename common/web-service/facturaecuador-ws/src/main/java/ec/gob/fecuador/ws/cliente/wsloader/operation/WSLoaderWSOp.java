package ec.gob.fecuador.ws.cliente.wsloader.operation;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.LoggerFactory;

public class WSLoaderWSOp {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(WSLoaderWSOp.class);
    //private AutorizacionComprobantesOffline portType;
    private JaxWsProxyFactoryBean factory;
    //private AutorizacionComprobantesOfflineService service;
    private String URL = "http://www.facturaecuador.com/WSLoader?wsdl";
    private String nameSpaceURI = "http://ec.gob.sri.ws.autorizacion";
    private String localPort = "AutorizacionComprobantesOfflineService";
}
