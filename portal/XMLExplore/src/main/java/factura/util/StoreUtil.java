/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.util;

import ec.ste.factura.ConfigurationManager;
import ec.ste.factura.DatabaseEntity;
import ec.ste.factura.entities.Factura;
import ec.ste.factura.entities.GuiaRemision;
import ec.ste.factura.entities.NotaCredito;
import ec.ste.factura.entities.Retencion;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author German17
 */
public class StoreUtil {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void storeFile(String empresa, String tipo, String name, byte data[]) throws Exception {
        String base = ConfigurationManager.getInstance().getStorePath();
        if (!base.endsWith("/")) {
            base += "/";
        }
        String path = base + empresa;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        path += "/" + tipo;
        file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        path += "/" + name;
        file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new Exception("Error de permisos en el directorio al guardar archivo físico");
            }
        }

        if (file.exists()) {
            FileOutputStream out = new FileOutputStream(file);
            out.write(data);
            out.flush();
            out.close();
        } else {
            throw new Exception("Error de permisos en el directorio al guardar archivo físico");
        }
    }

    public static InputStream openFile(String empresa, String tipo, String name) throws IOException {
        String base = ConfigurationManager.getInstance().getStorePath();
        if (!base.endsWith("/")) {
            base += "/";
        }
        String path = base + empresa + "/" + tipo + "/" + name;
        File file = new File(path);
        System.out.println(path);
        if (!file.exists())
             if(name.split("-").length>4){
                //FACT-ENV_001-002-2637_2015-04-08
                 //C:\var\factura-ecuador\0992275367001\facturas\FACT-ENV_001-002-1127_2015-03-02.xml
                String sec=name.split("-")[3].split("_")[0];
                name=name.replaceAll(sec, Integer.parseInt(sec)+"");
                path = base + empresa + "/" + tipo + "/" + name;
                System.out.println(path);
                file = new File(path);
            }
        
        if (file.exists()) {
            return new FileInputStream(file);
        }
        return null;
    }
    
     public static byte[] openFileAsBytes(String empresa, String tipo, String name) throws IOException {
        String base = ConfigurationManager.getInstance().getStorePath();
        if (!base.endsWith("/")) {
            base += "/";
        }
        String path = base + empresa + "/" + tipo + "/" + name;
        File file = new File(path);
        System.out.println(path);
        if (!file.exists())
             if(name.split("-").length>4){
                //FACT-ENV_001-002-2637_2015-04-08
                 //C:\var\factura-ecuador\0992275367001\facturas\FACT-ENV_001-002-1127_2015-03-02.xml
                String sec=name.split("-")[3].split("_")[0];
                name=name.replaceAll(sec, Integer.parseInt(sec)+"");
                path = base + empresa + "/" + tipo + "/" + name;
                System.out.println(path);
                file = new File(path);
            }
        
        if (file.exists()) {
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            FileInputStream in=new FileInputStream(file);
            byte buffer[]=new byte[1024*100];
            int read;
            while((read=in.read(buffer))>0){
                out.write(buffer,0,read);
            }
            out.flush();
            in.close();
            return out.toByteArray();
        }
        return null;
    }

    /**
     * Factura........................01 Nota de Credito................04 Nota
     * de Débito.................05 Guia de Remision ..............06
     * Comprobante de retencion ......07
     *
     * @param de
     * @return
     */
    public static String getFileName(DatabaseEntity de) {
        if (de instanceof Factura) {
            Factura f = (Factura) de;
            if (f.getTipo().getTipCodigo().equalsIgnoreCase("ENV")) {
                return "FACT-" + f.getTipo().getTipCodigo() + "_" + f.getFacEstablecimiento() + "-" + f.getFacPuntoEmision() + "-" + f.getFacSecuencial() + "_" + format.format(f.getFacFechaEmision()) + ".xml";
            } else {
                return "FACT-" + f.getTipo().getTipCodigo() + "_" + f.getFacIdentificacionVendedor() + "_" + f.getFacEstablecimiento() + "-" + f.getFacPuntoEmision() + "-" + f.getFacSecuencial() + "_" + format.format(f.getFacFechaEmision()) + ".xml";
            }
        } else if (de instanceof Retencion) {
            Retencion r = (Retencion) de;
            if (r.getTipo().getTipCodigo().equalsIgnoreCase("ENV")) {
                return "RET-" + r.getTipo().getTipCodigo() + "_" + r.getRetEstablecimiento() + "-" + r.getRetPuntoEmision() + "-" + r.getRetSecuencial() + "_" + format.format(r.getRetFechaEmision()) + ".xml";
            } else {
                return "RET-" + r.getTipo().getTipCodigo() + "_" + r.getRetIdentificacionEmisor() + "_" + r.getRetEstablecimiento() + "-" + r.getRetPuntoEmision() + "-" + r.getRetSecuencial() + "_" + format.format(r.getRetFechaEmision()) + ".xml";
            }
        }else if (de instanceof NotaCredito) {
            NotaCredito r = (NotaCredito) de;
            if (r.getTipo().getTipCodigo().equalsIgnoreCase("ENV")) {
                return "NC-" + r.getTipo().getTipCodigo() + "_" + r.getNcrEstablecimiento() + "-" + r.getNcrPuntoEmision() + "-" + r.getNcrSecuencial() + "_" + format.format(r.getNcrFechaEmision()) + ".xml";
            } else {
                return "NC-" + r.getTipo().getTipCodigo() + "_" + r.getNcrIdentificacionVendedor()+ "_" + r.getNcrEstablecimiento() + "-" + r.getNcrPuntoEmision() + "-" + r.getNcrSecuencial() + "_" + format.format(r.getNcrFechaEmision()) + ".xml";
            }
        }else if (de instanceof GuiaRemision) {
            GuiaRemision r = (GuiaRemision) de;
            if (r.getTipo().getTipCodigo().equalsIgnoreCase("ENV")) {
                return "GR-" + r.getTipo().getTipCodigo() + "_" + r.getGreEstablecimiento()+ "-" + r.getGrePuntoEmision() + "-" + r.getGreSecuencial() + "_" + format.format(r.getGreFechaEmision()) + ".xml";
            } else {
                return "GR-" + r.getTipo().getTipCodigo() + "_" + r.getGreIdentificacionVendedor()+ "_" + r.getGreEstablecimiento() + "-" + r.getGrePuntoEmision() + "-" + r.getGreSecuencial() + "_" + format.format(r.getGreFechaEmision()) + ".xml";
            }
        }
        return null;
    }

    

}
