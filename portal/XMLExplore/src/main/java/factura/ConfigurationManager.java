/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import ec.ste.factura.crypt.Crypt;

import java.util.Properties;

/**
 *
 * @author German17
 */
public class ConfigurationManager {

    private static final ConfigurationManager manager = new ConfigurationManager();

    public static final String PROPERTY_NAME_PRELOAD_DATA = "ec.ste.factura.database.preload";
    public static final String PROPERTY_NAME_ROOT_VERIFY = "ec.ste.factura.root.verify";
    public static final String PROPERTY_NAME_STORE_PATH = "ec.ste.factura.store.path";
    public static final String PROPERTY_NAME_REPORTS_PATH = "ec.ste.factura.reports.path";
    public static final String PROPERTY_NAME_LOGOS_PATH = "ec.ste.factura.logos.path";
    public static final String PROPERTY_NAME_BANNERS_PATH = "ec.ste.factura.banners.path";

    public static final String DEFAULT_PRELOAD_DATA = "true";
    public static final String DEFAULT_ROOT_VERIFY = "true";
    public static final String DEFAULT_STORE_PATH = "facturaEcuador";
    public static final String DEFAULT_REPORTS_PATH = "reportes";
    public static final String DEFAULT_LOGOS_PATH = "logos";
    public static final String DEFAULT_BANNERS_PATH = "banners";

    private boolean preloadData;
    private boolean rootVerify;
    private String storePath;
    private String reportsPath;
    private String logosPath;
    private String bannersPath;

    public boolean isPreloadData() {
        return preloadData;
    }

    public void setPreloadData(boolean preloadData) {
        this.preloadData = preloadData;
    }

    public boolean isRootVerify() {
        return rootVerify;
    }

    public void setRootVerify(boolean rootVerify) {
        this.rootVerify = rootVerify;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    public String getReportsPath() {
        return reportsPath;
    }

    public void setReportsPath(String reportsPath) {
        this.reportsPath = reportsPath;
    }

    public String getLogosPath() {
        return logosPath;
    }

    public void setLogosPath(String logosPath) {
        this.logosPath = logosPath;
    }

    public String getBannersPath() {
        return bannersPath;
    }

    public void setBannersPath(String bannersPath) {
        this.bannersPath = bannersPath;
    }
    
    

    public void setDefaultValues() {
        this.preloadData = Boolean.parseBoolean(DEFAULT_PRELOAD_DATA);
        this.rootVerify = Boolean.parseBoolean(DEFAULT_ROOT_VERIFY);
        this.storePath = DEFAULT_STORE_PATH;
        this.reportsPath = DEFAULT_REPORTS_PATH;
        this.logosPath = DEFAULT_LOGOS_PATH;
        this.bannersPath = DEFAULT_BANNERS_PATH;
    }

    public void loadValuesFromConfigurationFile() throws Exception {
        ConfigurationReader.read();
        preloadData = Boolean.parseBoolean(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_PRELOAD_DATA, ConfigurationManager.DEFAULT_PRELOAD_DATA));
        rootVerify = Boolean.parseBoolean(ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_ROOT_VERIFY, ConfigurationManager.DEFAULT_ROOT_VERIFY));
        storePath = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_STORE_PATH, ConfigurationManager.DEFAULT_STORE_PATH);
        reportsPath = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_REPORTS_PATH, ConfigurationManager.DEFAULT_REPORTS_PATH);
        bannersPath = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_BANNERS_PATH, ConfigurationManager.DEFAULT_BANNERS_PATH);
        logosPath = ConfigurationReader.getProperty(ConfigurationManager.PROPERTY_NAME_LOGOS_PATH, ConfigurationManager.DEFAULT_LOGOS_PATH);
    }

    public void saveValues() throws Exception {
        Properties properties = new Properties();
        properties.put(ConfigurationManager.PROPERTY_NAME_PRELOAD_DATA, Boolean.toString(preloadData));
        properties.put(ConfigurationManager.PROPERTY_NAME_ROOT_VERIFY, Boolean.toString(rootVerify));
        properties.put(ConfigurationManager.PROPERTY_NAME_STORE_PATH, storePath);
        properties.put(ConfigurationManager.PROPERTY_NAME_REPORTS_PATH, reportsPath);
        properties.put(ConfigurationManager.PROPERTY_NAME_BANNERS_PATH, bannersPath);
        properties.put(ConfigurationManager.PROPERTY_NAME_LOGOS_PATH, logosPath);
        ConfigurationReader.write(properties);
    }

    public static ConfigurationManager getInstance() {
        return manager;
    }

    public String getRootUserIdentification() {
        return "1719853432001";
    }

    public String getRootUserName() {
        return "Germán Morocho";
    }

    public String getRootMail() {
        return "g17ecu@gmail.com";
    }

    public String getRootNick() {
        return "superAdmin";
    }

    public String getRootUserPassword() {
        return Crypt.encrypt(getRootUserIdentification(), "mcfgdidb");
    }
}
