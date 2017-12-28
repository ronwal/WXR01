package ec.ste.docusend;

import ec.gob.fecuador.ws.cliente.aut.offline.AutorizacionOfflineWS;
import ec.gob.sri.ws.autorizacion.offline.RespuestaComprobante;
import ec.ste.backup.shared.BackupFile;
import ec.ste.backup.shared.crypt.Crypt;
import ec.ste.docusend.bean.Autorizacion;
import ec.ste.docusend.utill.FileUtil;
import ec.ste.factura.xml.ParserManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author German17
 */
public class BackupThread implements Runnable {

    private final static Logger log = Logger.getLogger(BackupThread.class);

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    private final Thread thread;

    public BackupThread() {
        thread = new Thread(this);
    }

    private static String login(String ruc, String nick, String password) {
        ec.ste.docusend.wsc.WSLoader_Service service = null;
        try {
            service = new ec.ste.docusend.wsc.WSLoader_Service(new URL("http://www.facturaecuador.com/WSLoader?wsdl"));
            ec.ste.docusend.wsc.WSLoader port = service.getWSLoaderPort();
            return port.login(ruc, nick, password);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String documentLoader(String rucEmpresa, String nick, String clave, String fileName, int registerType, byte[] xmlData) {
        ec.ste.docusend.wsc.WSLoader_Service service = new ec.ste.docusend.wsc.WSLoader_Service();
        ec.ste.docusend.wsc.WSLoader port = service.getWSLoaderPort();
        return port.documentLoader(rucEmpresa, nick, clave, fileName, registerType, xmlData);
    }

    public void startBackup() {
        log.debug("start backup");
        BackupTray.getBackupTray().setBackupTaskRunning(true);
        thread.start();
    }

    @Override
    public void run() {
        try {
            log.debug("thread start");
            ConfigurationManager cfm = ConfigurationManager.getInstance();
            try {
                cfm.loadValuesFromConfigurationFile();
            } catch (Exception ex) {
                Logger.getLogger(BackupThread.class).error(ex.getMessage(), ex);
            }

            log.debug("check login");

            String loginResult = login(cfm.getRuc(), cfm.getNick(), Crypt.decrypt(cfm.getRuc(), cfm.getPassword()));

            if (loginResult.startsWith("Error")) {
                log.error(loginResult);
                return;
            } else {
                log.info("successful login: " + cfm.getNick());
            }

            String basePath = cfm.getPath();
            if (!basePath.endsWith(FILE_SEPARATOR)) {
                basePath += FILE_SEPARATOR;
            }

            String currentDir = basePath + cfm.getIssuedDir() + FILE_SEPARATOR;

            backupDir(currentDir, 1, cfm);

            currentDir = basePath + cfm.getReceivedDir() + FILE_SEPARATOR;

            backupDir(currentDir, 2, cfm);

        } finally {
            BackupTray.getBackupTray().setBackupTaskRunning(false);
        }

    }

    private void backupDir(String path, int type, ConfigurationManager cfm) {
        List<BackupFile> filestToBackup = new ArrayList<BackupFile>();

        File file = new File(path);
        log.debug("loading local list: " + file.getAbsolutePath());
        File localFileList[] = file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return false;
                }
                String name = pathname.getName().toLowerCase();
                return name.endsWith(".xml");
            }
        });

        if (localFileList == null) {
            log.debug("The files is not found to send");
            return;
        }

        log.debug("filtering files to upload");
        for (File f : localFileList) {
            if (f.isDirectory()) {
                continue;
            }
            if (f.length() > (cfm.getMaxSize() * 1024 * 1024)) {
                log.warn("file too long (maximum " + cfm.getMaxSize() + "mb): " + f.getAbsolutePath());
                continue;
            }
            BackupFile bf = new BackupFile();
            bf.setDate(f.lastModified());
            bf.setName(f.getAbsolutePath());
            bf.setSize(f.length());
            filestToBackup.add(bf);
        }

        if (!filestToBackup.isEmpty()) {
            log.debug("uploading");
        }
        for (BackupFile bf : filestToBackup) {
            log.debug("upload file: " + bf.getName());

            try {
                byte data[] = FileUtil.openFile(new File(bf.getName()));
                data = chekOffline(data);
                String loadResult = documentLoader(cfm.getRuc(), cfm.getNick(), Crypt.decrypt(cfm.getRuc(), cfm.getPassword()), bf.getName().replace(path, ""), type, data);

                if (loadResult.startsWith("Error")) {
                    log.error(loadResult);
                    if (loadResult.contains("Error-11")) {
                        if (moveFile(new File(bf.getName()), "archivos_procesados")) {
                            log.info("file moved: " + bf.getName());
                        } else {
                            log.warn("file move not allowed: " + bf.getName());
                        }
                    } else {
                        File errorDir = new File(path + "archivos_con_errores" + FILE_SEPARATOR);
                        if (!errorDir.exists()) {
                            errorDir.mkdirs();
                        }
                        File errorFile = new File(path + "archivos_con_errores" + FILE_SEPARATOR + bf.getName().replace(path, "") + "-error.txt");
                        FileUtil.writeFile(errorFile, loadResult.getBytes());
                        if (moveFile(new File(bf.getName()), "archivos_con_errores")) {
                            log.info("unsuccessfull send: " + bf.getName());
                        } else {
                            log.warn("unsuccessfull send and not moved to processed files: " + bf.getName());
                        }
                    }
                } else {
                    log.info("result: " + loadResult);
                    if (moveFile(new File(bf.getName()), "archivos_procesados")) {
                        log.info("successfull send: " + bf.getName());
                    } else {
                        log.warn("successfull send but not moved to processed files: " + bf.getName());
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(BackupThread.class).error(ex.getMessage(), ex);
            } finally {

            }
        }

    }

    private byte[] chekOffline(byte data[]) {
        try {
            String clavAcc = new ParserManager().getClaveAcceso(data);
            AutorizacionOfflineWS offlineWS = new AutorizacionOfflineWS();
            RespuestaComprobante respuestaComprobante = offlineWS.getAutorizacionOfflineDoc(clavAcc);

            JAXBContext jaxbContext = JAXBContext.newInstance(Autorizacion.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ByteArrayOutputStream out_ = new ByteArrayOutputStream();
            ec.gob.sri.ws.autorizacion.offline.Autorizacion autorizacion_ = respuestaComprobante.getAutorizaciones().getAutorizacion().get(0);
            Autorizacion autorizacion = new Autorizacion(autorizacion_.getEstado(), autorizacion_.getNumeroAutorizacion(), autorizacion_.getFechaAutorizacion(), autorizacion_.getAmbiente(), autorizacion_.getComprobante(), autorizacion_.getMensajes());
            jaxbMarshaller.marshal(autorizacion, out_);
            System.out.println(respuestaComprobante.getAutorizaciones().getAutorizacion().get(0));
            data = out_.toByteArray();
        } catch (Exception ex) {
            Logger.getLogger(BackupThread.class).error(ex.getMessage(), ex);
        }
        return data;
    }

    private boolean moveFile(File file, String folder) {
        String destPath = file.getParent();
        if (!destPath.endsWith(FILE_SEPARATOR)) {
            destPath += FILE_SEPARATOR;
        }
        destPath += folder + FILE_SEPARATOR;
        File destFile = new File(destPath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        destPath += file.getName();
        String buffer = destPath;
        destFile = new File(destPath);
        if (destFile.exists()) {
            int count = 1;
            do {
                destPath = buffer + "." + count;
                destFile = new File(destPath);
                count++;
            } while (destFile.exists());
        }
        return file.renameTo(destFile);
    }

}
