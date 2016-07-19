package ec.gob.sri.comprobantes.util;

import java.util.logging.*;
import java.io.*;

public class ArchivoUtils
{
    public static String archivoToString(final String rutaArchivo) {
        final StringBuffer buffer = new StringBuffer();
        try {
            final FileInputStream fis = new FileInputStream(rutaArchivo);
            final InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            final Reader in = new BufferedReader(isr);
            int ch;
            while ((ch = in.read()) > -1) {
                buffer.append((char)ch);
            }
            in.close();
            return buffer.toString();
        }
        catch (IOException e) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public static File stringToArchivo(final String rutaArchivo, final String contenidoArchivo) {
        FileOutputStream fos = null;
        File archivoCreado = null;
        try {
            fos = new FileOutputStream(rutaArchivo);
            final OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            for (int i = 0; i < contenidoArchivo.length(); ++i) {
                out.write(contenidoArchivo.charAt(i));
            }
            out.close();
            archivoCreado = new File(rutaArchivo);
        }
        catch (Exception ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            }
            catch (Exception ex2) {
                Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
        return archivoCreado;
    }
    
    public static byte[] archivoToByte(final File file) throws IOException {
        final byte[] buffer = new byte[(int)file.length()];
        InputStream ios = null;
        try {
            ios = new FileInputStream(file);
            if (ios.read(buffer) == -1) {
                throw new IOException("EOF reached while trying to read the whole file");
            }
        }
        finally {
            try {
                if (ios != null) {
                    ios.close();
                }
            }
            catch (IOException e) {
                Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return buffer;
    }
    
    public static boolean byteToFile(final byte[] arrayBytes, final String rutaArchivo) {
        boolean respuesta = false;
        try {
            final File file = new File(rutaArchivo);
            file.createNewFile();
            final FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayBytes);
            final OutputStream outputStream = new FileOutputStream(rutaArchivo);
            int data;
            while ((data = byteArrayInputStream.read()) != -1) {
                outputStream.write(data);
            }
            fileInputStream.close();
            outputStream.close();
            respuesta = true;
        }
        catch (IOException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
   
}
