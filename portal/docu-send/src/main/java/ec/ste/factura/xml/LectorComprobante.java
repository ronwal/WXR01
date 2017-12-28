package ec.ste.factura.xml;

import org.w3c.dom.CharacterData;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;


public class LectorComprobante {
    private static DocumentoAutorizado extraerDocumento(InputStream in)
            throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(in);
        NodeList list = doc.getElementsByTagName("*");

        String docu = null;
        String numeroAut = "";
        String fechaAutorizacion = "";
        String estado = "";
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            if (element.getNodeName().equals("comprobante")) {
                NodeList nodeList = element.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node child = nodeList.item(j);
                    if ((child instanceof CharacterData)) {
                        CharacterData cd = (CharacterData) child;
                        String val = cd.getData();
                        if (val != null) {

                            if (val.trim().length() != 0) {

                                docu = cd.getData().trim();
                            }
                        }
                    }
                }
            }
            if (element.getNodeName().equals("estado")) {
                estado = element.getChildNodes().item(0).getNodeValue();
            }

            if (element.getNodeName().equals("numeroAutorizacion")) {
                numeroAut = element.getChildNodes().item(0).getNodeValue();
            }
            if (element.getNodeName().equals("fechaAutorizacion")) {
                fechaAutorizacion = fechaAutorizacion + element.getChildNodes().item(0).getNodeValue();
            }
        }


        if ("AUTORIZADO".equalsIgnoreCase(estado)) {
            return new DocumentoAutorizado(numeroAut, fechaAutorizacion, docu);
        }
        throw new Exception("El archivo seleccionado no es un comprobante autorizado.");
    }

    public static String getClaveAcc(InputStream in)
            throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(in);
        NodeList list = doc.getElementsByTagName("*");

        String docu = null;
        String claveAcceso = "";
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);

            if (element.getNodeName().equals("infoTributaria")) {
                NodeList nodeList = element.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node node_ = nodeList.item(j);
                    if (node_.getNodeName().equals("claveAcceso")) {
                        claveAcceso = node_.getFirstChild().getNodeValue();
                        break;
                    }
                }
                break;
            }
        }


        if (!claveAcceso.isEmpty()) {
            return claveAcceso;
        }
        throw new Exception("El archivo seleccionado no es un comprobante autorizado.");
    }

    public static DocumentoAutorizado extraerInstanciaDocumento(File file)
            throws Exception {
        return extraerInstanciaDocumento(new FileInputStream(file));
    }

    public static DocumentoAutorizado extraerInstanciaDocumento(byte[] xmlData) throws Exception {
        return extraerInstanciaDocumento(new ByteArrayInputStream(xmlData));
    }

    public static DocumentoAutorizado extraerInstanciaDocumento(InputStream file) throws Exception {
        DocumentoAutorizado doc = extraerDocumento(file);
        if (doc.getDocumentoXML() == null) {
            throw new Exception("El contenido del documento no es adecuado");
        }
        if (doc.getDocumentoXML().contains("<factura")) {
            doc.setDocumento(XML2Java.unmarshalFactura(new ByteArrayInputStream(doc.getDocumentoXML().getBytes(Charset.forName("UTF-8")))));
            return doc;
        }
        if (doc.getDocumentoXML().contains("<comprobanteRetencion")) {
            doc.setDocumento(XML2Java.unmarshalComprobanteRetencion(new ByteArrayInputStream(doc.getDocumentoXML().getBytes(Charset.forName("UTF-8")))));
            return doc;
        }
        if (doc.getDocumentoXML().contains("<notaCredito")) {
            doc.setDocumento(XML2Java.unmarshalNotaCredito(new ByteArrayInputStream(doc.getDocumentoXML().getBytes(Charset.forName("UTF-8")))));
            return doc;
        }
        if (doc.getDocumentoXML().contains("<notaDebito")) {
            doc.setDocumento(XML2Java.unmarshalNotaDebito(new ByteArrayInputStream(doc.getDocumentoXML().getBytes(Charset.forName("UTF-8")))));
            return doc;
        }
        if (doc.getDocumentoXML().contains("<guiaRemision")) {
            doc.setDocumento(XML2Java.unmarshalGuiaRemision(new ByteArrayInputStream(doc.getDocumentoXML().getBytes(Charset.forName("UTF-8")))));
            return doc;
        }
        throw new Exception("El documento especificado no es un documento válido");
    }
}


/* Location:              /Users/Latinus/Google Drive/Proyecto/SRIComprobantesElectronicos/sri copia.jar!/ec/gob/sri/comprobantes/util/xml/LectorComprobante.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */