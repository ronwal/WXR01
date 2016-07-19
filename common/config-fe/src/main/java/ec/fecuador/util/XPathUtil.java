/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.util;

import ec.ste.factura.model.FECDocumento;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.apache.log4j.Logger;

/**
 *
 * @author German17
 */
public class XPathUtil {
    
    private Logger log = Logger.getLogger(XPathUtil.class);
    
    private XPath xPathRoot = XPathFactory.newInstance().newXPath();
    private FECDocumento document;

    public XPathUtil(FECDocumento document) {
        this.document = document;
    }
    
    

    public String evaluateFromChild(String expression) throws Exception {
        log.trace("Evaluating: "+expression);
        String value=xPathRoot.compile(expression).evaluate(document.getDocumentoComprobante());
        log.trace("result: "+expression+" = "+value);
        return value;
    }
    
    public String evaluateFromRoot(String expression) throws Exception {
        log.trace("Evaluating: "+expression);
        String value=xPathRoot.compile(expression).evaluate(document.getDocumentoOriginal());
        log.trace("result: "+expression+" = "+value);
        return value;
    }
}
