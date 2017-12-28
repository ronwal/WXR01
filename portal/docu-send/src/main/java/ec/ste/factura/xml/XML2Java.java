/*     */ package ec.ste.factura.xml;
/*     */ 
/*     */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ 
/*     */ public class XML2Java
/*     */ {
/*     */   public static Factura unmarshalFactura(String pathArchivo) throws Exception
/*     */   {
/*  17 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
/*  18 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  19 */     Factura item = (Factura)unmarshaller.unmarshal(new java.io.InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/*  20 */     return item;
/*     */   }
/*     */   
/*     */   public static Factura unmarshalFactura(org.w3c.dom.Document document) throws Exception {
/*  24 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
/*  25 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  26 */     Factura item = (Factura)unmarshaller.unmarshal(document);
/*  27 */     return item;
/*     */   }
/*     */   
/*     */   public static Factura unmarshalFactura(InputStream in) throws Exception {
/*  31 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
/*  32 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  33 */     Factura item = (Factura)unmarshaller.unmarshal(in);
/*  34 */     return item;
/*     */   }
/*     */   
/*     */   public static NotaDebito unmarshalNotaDebito(String pathArchivo) throws Exception {
/*  38 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notadebito");
/*  39 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  40 */     NotaDebito item = (NotaDebito)unmarshaller.unmarshal(new java.io.InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/*  41 */     return item;
/*     */   }
/*     */   
/*     */   public static NotaDebito unmarshalNotaDebito(InputStream in) throws Exception {
/*  45 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notadebito");
/*  46 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  47 */     NotaDebito item = (NotaDebito)unmarshaller.unmarshal(in);
/*  48 */     return item;
/*     */   }
/*     */   
/*     */   public static NotaCredito unmarshalNotaCredito(String pathArchivo) throws Exception {
/*  52 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notacredito");
/*  53 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  54 */     NotaCredito item = (NotaCredito)unmarshaller.unmarshal(new java.io.InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/*  55 */     return item;
/*     */   }
/*     */   
/*     */   public static NotaCredito unmarshalNotaCredito(InputStream in) throws Exception {
/*  59 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notacredito");
/*  60 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  61 */     NotaCredito item = (NotaCredito)unmarshaller.unmarshal(in);
/*  62 */     return item;
/*     */   }
/*     */   
/*     */   public static GuiaRemision unmarshalGuiaRemision(String pathArchivo) throws Exception {
/*  66 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.guia");
/*  67 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  68 */     GuiaRemision item = (GuiaRemision)unmarshaller.unmarshal(new java.io.InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/*  69 */     return item;
/*     */   }
/*     */   
/*     */   public static GuiaRemision unmarshalGuiaRemision(InputStream in) throws Exception {
/*  73 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.guia");
/*  74 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  75 */     GuiaRemision item = (GuiaRemision)unmarshaller.unmarshal(in);
/*  76 */     return item;
/*     */   }
/*     */   
/*     */   public static ComprobanteRetencion unmarshalComprobanteRetencion(String pathArchivo) throws Exception {
/*  80 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
/*  81 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  82 */     ComprobanteRetencion item = (ComprobanteRetencion)unmarshaller.unmarshal(new java.io.InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/*  83 */     return item;
/*     */   }
/*     */   
/*     */   public static ComprobanteRetencion unmarshalComprobanteRetencion(InputStream in) throws Exception {
/*  87 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
/*  88 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  89 */     ComprobanteRetencion item = (ComprobanteRetencion)unmarshaller.unmarshal(in);
/*  90 */     return item;
/*     */   }
/*     */   
/*     */   public static ComprobanteRetencion unmarshalComprobanteRetencion(org.w3c.dom.Node node) throws Exception {
/*  94 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
/*  95 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/*  96 */     ComprobanteRetencion item = (ComprobanteRetencion)unmarshaller.unmarshal(node);
/*  97 */     return item;
/*     */   }
/*     */ }


/* Location:              /Users/Latinus/Google Drive/Proyecto/SRIComprobantesElectronicos/sri copia.jar!/ec/gob/sri/comprobantes/util/xml/XML2Java.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */