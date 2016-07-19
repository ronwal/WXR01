/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;
import ec.ste.factura.entities.Retencion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author German17
 */
public class Main extends DaoManager {
    

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Retencion r = RETENCION_DAO.findRetencionByPrimaryKey(2);
        if (r != null) {
            ReporteUtil rptUtil=new ReporteUtil();
            String fileName = "C:\\var\\factura-ecuador\\1719853432001\\retenciones\\RET-REC_0990293244001_001-003-482_2013-10-23.xml";
            DocumentoAutorizado daut=LectorComprobante.extraerInstanciaDocumento(new File(fileName));
            ComprobanteRetencion fact = (ComprobanteRetencion)daut.getDocumento();
            r.setRetNumAutorizacion(daut.getNumeroAutorizacion());
            r.setRetFechaAutorizacion(daut.getFechaAutorizacion());
            //rptUtil.generarReporte("c:/var/factura-ecuador/reportes/comprobanteRetencion.jasper",new ComprobanteRetencionReporte(fact), r.getRetNumAutorizacion(), r.getRetFechaAutorizacion(), out);
            FileOutputStream fout=new FileOutputStream("rep.pdf");
            fout.write(out.toByteArray());
            fout.flush();
            fout.close();
        }
        
    }

}
