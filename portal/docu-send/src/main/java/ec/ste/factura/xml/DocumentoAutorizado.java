/*    */ package ec.ste.factura.xml;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocumentoAutorizado
/*    */ {
/*    */   private String numeroAutorizacion;
/*    */   
/*    */ 
/*    */   private String fechaAutorizacion;
/*    */   
/*    */ 
/*    */   private String documentoXML;
/*    */   
/*    */ 
/*    */   private Object documento;
/*    */   
/*    */ 
/*    */ /*    */   
/*    */ 
/*    */ 
/*    */   public DocumentoAutorizado() {}
/*    */   
/*    */ 
/*    */ /*    */   
/*    */ 
/*    */ 
/*    */   public DocumentoAutorizado(String numeroAutorizacion, String fechaAutorizacion, String documentoXML)
/*    */   {
/* 26 */     this.numeroAutorizacion = numeroAutorizacion;
/* 27 */     this.fechaAutorizacion = fechaAutorizacion;
/* 28 */     this.documentoXML = documentoXML;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getNumeroAutorizacion()
/*    */   {
/* 34 */     return this.numeroAutorizacion;
/*    */   }
/*    */   
/*    */   public void setNumeroAutorizacion(String numeroAutorizacion) {
/* 38 */     this.numeroAutorizacion = numeroAutorizacion;
/*    */   }
/*    */   
/*    */   public String getFechaAutorizacion() {
/* 42 */     return this.fechaAutorizacion;
/*    */   }
/*    */   
/*    */   public void setFechaAutorizacion(String fechaAutorizacion) {
/* 46 */     this.fechaAutorizacion = fechaAutorizacion;
/*    */   }
/*    */   
/*    */   public String getDocumentoXML() {
/* 50 */     return this.documentoXML;
/*    */   }
/*    */   
/*    */   public void setDocumentoXML(String documentoXML) {
/* 54 */     this.documentoXML = documentoXML;
/*    */   }
/*    */   
/*    */   public Object getDocumento() {
/* 58 */     return this.documento;
/*    */   }
/*    */   
/*    */   public void setDocumento(Object documento) {
/* 62 */     this.documento = documento;
/*    */   }
/*    */ }


/* Location:              /Users/Latinus/Google Drive/Proyecto/SRIComprobantesElectronicos/sri copia.jar!/ec/gob/sri/comprobantes/modelo/DocumentoAutorizado.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */