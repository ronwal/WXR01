/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.docusend;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author German17
 */
public class ConfigurationReader {

    public static final String CONFIGURATION_FILE = "config.xml";
    private static Properties properties = new Properties();

    static {
        File url = new File(CONFIGURATION_FILE);
        if (!url.exists()) {
            Logger.getLogger(ConfigurationReader.class).error("No se encuentra archivo de configuracion: config.xml");
        } else {
            Logger.getLogger(ConfigurationReader.class).debug("Archivo de configuracion existente: " + url.getAbsolutePath());
            try {
                read();
            } catch (Exception ex) {
                Logger.getLogger(ConfigurationReader.class).error("No se puede leer el archivo de configuracion", ex);
            }
        }



    }

    public static void read() throws Exception {
        properties.clear();
        File file=new File(CONFIGURATION_FILE);
        InputStream input=new FileInputStream(file);
        properties.loadFromXML(input);
        Logger.getLogger(ConfigurationReader.class).debug("Configuracion para Backup leida desde: " + file.getAbsolutePath());
        Enumeration e = properties.keys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            Logger.getLogger(ConfigurationReader.class).debug(key + " = " + properties.getProperty(key));
        }

    }

    public static void write(Properties properties) throws Exception {
        File file = new File(CONFIGURATION_FILE);
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
