/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author German17
 */
public class ConfigurationReader {

    public static final String CONFIGURATION_FILE = "/config.xml";
    private static Properties properties = new Properties();

    static {
        URL url = ConfigurationReader.class.getResource(CONFIGURATION_FILE);
        if (url == null) {
            Logger.getLogger(ConfigurationReader.class).error("No se encuentra archivo de configuracion: configuration.xml");
        } else {
            Logger.getLogger(ConfigurationReader.class).debug("Archivo de configuracion existente: " + url.getFile());
            try {
                read();
            } catch (Exception ex) {
                Logger.getLogger(ConfigurationReader.class).error("No se puede leer el archivo de configuracion", ex);
            }
        }



    }

    public static void read() throws Exception {
        URL url = ConfigurationReader.class.getResource(CONFIGURATION_FILE);

        properties.clear();
        File file=new File(url.getFile());
        InputStream input=new FileInputStream(file);
        properties.loadFromXML(input);
        Logger.getLogger(ConfigurationReader.class).debug("Configuracion para sistema leida desde: " + url.getFile());
        Enumeration e = properties.keys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            Logger.getLogger(ConfigurationReader.class).debug(key + " = " + properties.getProperty(key));
        }

    }

    public static void write(Properties properties) throws Exception {
        URL url = ConfigurationReader.class.getResource(CONFIGURATION_FILE);
        File file = new File(url.getFile());
        FileOutputStream outputStream = new FileOutputStream(file);
        properties.storeToXML(outputStream, "Configuration File");
    }
    
    

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    
}
