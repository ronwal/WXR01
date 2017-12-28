/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.docusend;

import java.util.Properties;

/**
 *
 * @author German17
 */
public class ConfigurationManager {

    private static final ConfigurationManager manager = new ConfigurationManager();
    public static final String PROPERTY_NAME_SERVICE = "ec.ste.docusend.service";
    public static final String PROPERTY_NAME_NICK = "ec.ste.docusend.nick";
    public static final String PROPERTY_NAME_PASSWORD = "ec.ste.docusend.password";
    public static final String PROPERTY_NAME_PATH = "ec.ste.docusend.path";
    public static final String PROPERTY_NAME_INTERVAL = "ec.ste.docusend.interval";
    public static final String PROPERTY_NAME_MAX_SIZE = "ec.ste.docusend.maxSize";
    public static final String PROPERTY_NAME_RUC = "ec.ste.docusend.ruc";
    public static final String PROPERTY_NAME_RECEIVED_DIR = "ec.ste.docusend.received.dir";
    public static final String PROPERTY_NAME_ISSUED_DIR = "ec.ste.docusend.issued.dir";

    public static final String DEFAULT_SERVICE = "http://localhost/BackupAssistantServer/UploadWebService?wsdl";
    public static final String DEFAULT_NICK = "admin";
    public static final String DEFAULT_PASSWORD = "ZHM1jnSZSGs=";
    public static final String DEFAULT_PATH = ".";
    public static final String DEFAULT_INTERVAL = "5";
    public static final String DEFAULT_MAX_SIZE = "10";
    public static final String DEFAULT_RUC = "1719853432001";
    public static final String DEFAULT_RECEIVED_DIR = "Documentos_Recibidos";
    public static final String DEFAULT_ISSUED_DIR = "Documentos_Emitidos";

    private String service;
    private String ruc;
    private String nick;
    private String password;
    private String path;
    private int interval;
    private int maxSize;
    private String receivedDir;
    private String issuedDir;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getReceivedDir() {
        return receivedDir;
    }

    public void setReceivedDir(String receivedDir) {
        this.receivedDir = receivedDir;
    }

    public String getIssuedDir() {
        return issuedDir;
    }

    public void setIssuedDir(String issuedDir) {
        this.issuedDir = issuedDir;
    }

    public void setDefaultValues() {
        service = DEFAULT_SERVICE;
        nick = DEFAULT_NICK;
        password = DEFAULT_PASSWORD;
        path = DEFAULT_PATH;
        ruc = DEFAULT_RUC;
        receivedDir = DEFAULT_RECEIVED_DIR;
        issuedDir = DEFAULT_ISSUED_DIR;
        interval = Integer.parseInt(DEFAULT_INTERVAL);
        maxSize = Integer.parseInt(DEFAULT_MAX_SIZE);

    }

    public void loadValuesFromConfigurationFile() throws Exception {
        ConfigurationReader.read();
        service = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_SERVICE, ConfigurationManager.DEFAULT_SERVICE);
        ruc = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_RUC, ConfigurationManager.DEFAULT_RUC);
        nick = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_NICK, ConfigurationManager.DEFAULT_NICK);
        password = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_PASSWORD, ConfigurationManager.DEFAULT_PASSWORD);
        path = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_PATH, ConfigurationManager.DEFAULT_PATH);
        interval = Integer.parseInt(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_INTERVAL, ConfigurationManager.DEFAULT_INTERVAL));
        maxSize = Integer.parseInt(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_MAX_SIZE, ConfigurationManager.DEFAULT_MAX_SIZE));
        receivedDir = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_RECEIVED_DIR, ConfigurationManager.DEFAULT_RECEIVED_DIR);
        issuedDir = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_ISSUED_DIR, ConfigurationManager.DEFAULT_ISSUED_DIR);

    }

    public void saveValues() throws Exception {
        Properties properties = new Properties();
        properties.put(ConfigurationManager.PROPERTY_NAME_SERVICE, service);
        properties.put(ConfigurationManager.PROPERTY_NAME_RUC, ruc);
        properties.put(ConfigurationManager.PROPERTY_NAME_NICK, nick);
        properties.put(ConfigurationManager.PROPERTY_NAME_PASSWORD, password);
        properties.put(ConfigurationManager.PROPERTY_NAME_PATH, path);
        properties.put(ConfigurationManager.PROPERTY_NAME_INTERVAL, Integer.toString(interval));
        properties.put(ConfigurationManager.PROPERTY_NAME_MAX_SIZE, Integer.toString(maxSize));
        properties.put(ConfigurationManager.PROPERTY_NAME_RECEIVED_DIR, receivedDir);
        properties.put(ConfigurationManager.PROPERTY_NAME_ISSUED_DIR, issuedDir);
        ConfigurationReader.write(properties);
    }

    public static ConfigurationManager getInstance() {
        return manager;
    }
}
