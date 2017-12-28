package ec.ste.docusend;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author German17
 */
public class BackupTray implements ActionListener {

    private static BackupTray backupTray = new BackupTray();
    private boolean backupTaskRunning = false;
   
    private LoginDialog loginDialog=new LoginDialog();
    private PopupMenu popup = new PopupMenu();
    private MenuItem miBackupNow = new MenuItem("Respaldar ahora");
    private MenuItem miConfig = new MenuItem("Configuración");
    private MenuItem miExit = new MenuItem("Salir");
    private SystemTray tray;
    private TrayIcon icon;
    private DaemonThread daemonThread;

    public BackupTray() {
    }

    public void install() {
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();
            Image image;
            try {
                image = ImageIO.read(BackupTray.class.getResourceAsStream("/icons/tray.png"));
                icon = new TrayIcon(image, "Asistente de Respaldos", popup);
                icon.setImageAutoSize(true);
                tray.add(icon);

                popup.add(miBackupNow);
                popup.add(miConfig);
                popup.addSeparator();
                popup.add(miExit);

                miBackupNow.addActionListener(this);
                miConfig.addActionListener(this);
                miExit.addActionListener(this);

                daemonThread = new DaemonThread();
                daemonThread.startDaemon();

            } catch (Exception ex) {
                Logger.getLogger(BackupTray.class).error(ex.getMessage(), ex);
            }

        }
    }

    public DaemonThread getDaemonThread() {
        return daemonThread;
    }

    public void setDaemonThread(DaemonThread daemonThread) {
        this.daemonThread = daemonThread;
    }

    public boolean isBackupTaskRunning() {
        synchronized (this) {
            return backupTaskRunning;
        }

    }

    public void setBackupTaskRunning(boolean backupTaskRunning) {
        synchronized (this) {
            this.backupTaskRunning = backupTaskRunning;
            miBackupNow.setEnabled(!backupTaskRunning);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(miExit)) {
            int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir del asistente de Respaldos?", "Confirmación de cierre", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource().equals(miConfig)) {
            loginDialog.setVisible(true);
        } else if (e.getSource().equals(miBackupNow)) {
            new BackupThread().startBackup();
        }
    }

    public static BackupTray getBackupTray() {
        return backupTray;
    }
}
