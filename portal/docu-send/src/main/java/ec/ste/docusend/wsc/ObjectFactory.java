
package ec.ste.docusend.wsc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.ste.docusend.wsc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DocumentLoader_QNAME = new QName("http://load.ws.factura.ste.ec/", "documentLoader");
    private final static QName _DocumentLoaderResponse_QNAME = new QName("http://load.ws.factura.ste.ec/", "documentLoaderResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://load.ws.factura.ste.ec/", "loginResponse");
    private final static QName _Login_QNAME = new QName("http://load.ws.factura.ste.ec/", "login");
    private final static QName _DocumentLoaderXmlData_QNAME = new QName("", "xmlData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.ste.docusend.wsc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link DocumentLoaderResponse }
     * 
     */
    public DocumentLoaderResponse createDocumentLoaderResponse() {
        return new DocumentLoaderResponse();
    }

    /**
     * Create an instance of {@link DocumentLoader }
     * 
     */
    public DocumentLoader createDocumentLoader() {
        return new DocumentLoader();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentLoader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://load.ws.factura.ste.ec/", name = "documentLoader")
    public JAXBElement<DocumentLoader> createDocumentLoader(DocumentLoader value) {
        return new JAXBElement<DocumentLoader>(_DocumentLoader_QNAME, DocumentLoader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentLoaderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://load.ws.factura.ste.ec/", name = "documentLoaderResponse")
    public JAXBElement<DocumentLoaderResponse> createDocumentLoaderResponse(DocumentLoaderResponse value) {
        return new JAXBElement<DocumentLoaderResponse>(_DocumentLoaderResponse_QNAME, DocumentLoaderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://load.ws.factura.ste.ec/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://load.ws.factura.ste.ec/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "xmlData", scope = DocumentLoader.class)
    public JAXBElement<byte[]> createDocumentLoaderXmlData(byte[] value) {
        return new JAXBElement<byte[]>(_DocumentLoaderXmlData_QNAME, byte[].class, DocumentLoader.class, ((byte[]) value));
    }

}
