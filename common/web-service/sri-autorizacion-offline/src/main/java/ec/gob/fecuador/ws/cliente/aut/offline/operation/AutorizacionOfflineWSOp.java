package ec.gob.fecuador.ws.cliente.aut.offline.operation;

import ec.gob.fecuador.ws.cliente.aut.offline.AutorizacionOfflineWS;
import ec.gob.sri.ws.autorizacion.offline.AutorizacionComprobantesOffline;
import ec.gob.sri.ws.autorizacion.offline.AutorizacionComprobantesOfflineService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.LoggerFactory;

import javax.xml.ws.BindingProvider;

public class AutorizacionOfflineWSOp {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AutorizacionOfflineWS.class);
    private AutorizacionComprobantesOffline portType;
    private JaxWsProxyFactoryBean factory;
    private AutorizacionComprobantesOfflineService service;
    private String URL = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
    private String nameSpaceURI = "http://ec.gob.sri.ws.autorizacion";
    private String localPort = "AutorizacionComprobantesOfflineService";

    public AutorizacionOfflineWSOp() {
        try {
            factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(AutorizacionComprobantesOffline.class);
            factory.setAddress(URL);
            //factory.setEndpointName(new QName(nameSpaceURI, localPort));

            portType = (AutorizacionComprobantesOffline) factory.create();

            /*this.service = new AutorizacionComprobantesOfflineService(new URL(URL), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflineService"));
            portType = this.service.getAutorizacionComprobantesOfflinePort();*/
        } catch (Exception e) {
            LOG.error("Error al llamar al WS", e);
        }
    }

    public AutorizacionComprobantesOffline getPortType() {
        BindingProvider prov = (BindingProvider) portType;
        //prov.getRequestContext().put("set-jaxb-validation-event-handler", "false");
        return portType;
    }
}