package comprobantes.util.xml;

import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.ws.aut.*;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class XML2Java
{
    public static Factura unmarshalFactura(final String pathArchivo) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Factura item = (Factura)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
        return item;
    }
    
    public static Factura unmarshalFactura(Node node) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Factura item = (Factura)unmarshaller.unmarshal(node);
        return item;
    }
    
    public static NotaDebito unmarshalNotaDebito(final String pathArchivo) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notadebito");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final NotaDebito item = (NotaDebito)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
        return item;
    }
    
    public static NotaDebito unmarshalNotaDebito(Node node) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notadebito");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final NotaDebito item = (NotaDebito)unmarshaller.unmarshal(node);
        return item;
    }
    
    public static NotaCredito unmarshalNotaCredito(final String pathArchivo) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notacredito");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final NotaCredito item = (NotaCredito)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
        return item;
    }
    
    public static NotaCredito unmarshalNotaCredito(Node node) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notacredito");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final NotaCredito item = (NotaCredito)unmarshaller.unmarshal(node);
        return item;
    }
    
    public static GuiaRemision unmarshalGuiaRemision(final String pathArchivo) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.guia");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final GuiaRemision item = (GuiaRemision)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
        return item;
    }
    
    public static GuiaRemision unmarshalGuiaRemision(Node node) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.guia");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final GuiaRemision item = (GuiaRemision)unmarshaller.unmarshal(node);
        return item;
    }
    
    public static ComprobanteRetencion unmarshalComprobanteRetencion(final String pathArchivo) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final ComprobanteRetencion item = (ComprobanteRetencion)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
        return item;
    }
    
    public static ComprobanteRetencion unmarshalComprobanteRetencion(Node node) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final ComprobanteRetencion item = (ComprobanteRetencion)unmarshaller.unmarshal(node);
        return item;
    }
    
    public static Autorizacion unmarshalAutorizacion(final String pathArchivo) throws Exception {
        final JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.ws.aut.Autorizacion");
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Autorizacion item = (Autorizacion)unmarshaller.unmarshal(new FileReader(pathArchivo));
        return item;
    }
    
    
   
}
