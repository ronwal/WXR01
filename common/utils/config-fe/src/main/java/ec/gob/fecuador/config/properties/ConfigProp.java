package ec.gob.fecuador.config.properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by Walter on 1/2/17.
 */
public class ConfigProp {

    public static final String CONFIG_FILE = "config.properties";
    private static final Logger LOG = LoggerFactory
            .getLogger(ConfigProp.class);

    private static final String envProp = "com.factura.ecuador";

    private Properties properties = null;

    public ConfigProp() {
        InputStream is = null;
        String str = System.getProperties().getProperty(envProp);
        if (str == null) {
            is = ConfigProp.class.getResourceAsStream("/" + CONFIG_FILE);
            LOG.warn("Property " + envProp + " is not set.");
            LOG.info("Obteniendo Propiedades del classpath");
        } else {
            try {
                File localFile = new File(str, CONFIG_FILE);
                is = new FileInputStream(localFile);
                LOG.info("Property " + envProp + " is set.");
            } catch (FileNotFoundException ex) {
                LOG.error("Archivo no encotrado", ex);
            }
        }
        this.properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException ex) {
            LOG.error("Propiedad no disponible", ex);
        }
    }

    public static ConfigProp getInstance() {
        return ConfigHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    private static class ConfigHolder {
        private static final ConfigProp INSTANCE = new ConfigProp();
    }
}
