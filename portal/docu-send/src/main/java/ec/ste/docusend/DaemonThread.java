package ec.ste.docusend;

import org.apache.log4j.Logger;

/**
 * @author German17
 */
public class DaemonThread implements Runnable {

    private final static Logger log = Logger.getLogger(DaemonThread.class);
    private Thread thread;
    private long interval;

    public DaemonThread() {
        thread = new Thread(this);
    }

    public void startDaemon() {
        thread.start();
    }

    public long getInterval() {
        synchronized (this) {
            return interval;
        }
    }

    public void setInterval(long interval) {
        synchronized (this) {
            this.interval = interval;
        }
    }

    @Override
    public void run() {
        
        ConfigurationManager cfm = ConfigurationManager.getInstance();
        try {
            cfm.loadValuesFromConfigurationFile();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }

        setInterval(cfm.getInterval() > 0 ? cfm.getInterval() * 60 * 1000 : 10 * 60 * 1000);

        log.debug("Daemon interval: " + interval + "ms.");

        while (true) {

            if (!BackupTray.getBackupTray().isBackupTaskRunning()) {
                log.debug("Daemon check files");
                new BackupThread().startBackup();
            }
            try {
                log.debug("Daemon sleep " + interval + "ms.");
                Thread.sleep(getInterval());
            } catch (InterruptedException ex) {
                Logger.getLogger(DaemonThread.class).error(ex);
            }
        }
    }
}
