package ec.ste.docusend;

import ec.ste.backup.shared.crypt.Crypt;
import ec.ste.docusend.wsc.WSLoader_Service;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author German17
 */
public class ConfigurationFrame extends JFrame {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    private final static Logger log = Logger.getLogger(ConfigurationFrame.class);
    private JPanel panel = new JPanel(new GridBagLayout());
    private JPanel control = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JLabel lblService = new JLabel("Dirección de Servicio Web:");
    private JLabel lblRuc = new JLabel("Ruc:");
    private JLabel lblNick = new JLabel("Nick:");
    private JLabel lblPassword = new JLabel("Password:");
    private JLabel lblPath = new JLabel("Directorio de monitoreo:");
    private JLabel lblInterval = new JLabel("Intervalo de monitoreo (minutos):");
    private JLabel lblMaxSize = new JLabel("Tamaño máximo de archivo (Mb):");
    private JTextField txtService = new JTextField();
    private JTextField txtRuc = new JTextField();
    private JTextField txtNick = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private JTextField txtPath = new JTextField();
    private JButton btnPath = new JButton("...");
    private JSlider sldInterval = new JSlider(JSlider.HORIZONTAL, 0, 300, 60);
    private JSlider sldMaxSize = new JSlider(JSlider.HORIZONTAL, 0, 15, 10);
    private JButton btnTestConnection = new JButton("Comprobar Configuración");
    private JButton btnSave = new JButton("Guardar");
    private JButton btnCancel = new JButton("Cancelar");
    private JButton btnDefault = new JButton("Predeterminados");
    private JFileChooser chooser = new JFileChooser();

    public ConfigurationFrame() {
        super("Configuración");
        setLocationByPlatform(true);
        setSize(650, 330);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        prepareComponents();
        prepareListeners();
        loadSavedValues();
    }

    private void prepareComponents() {
        setContentPane(panel);
        int x = 0;
        int y = 0;
        panel.add(lblService, new GridBagConstraints(x, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(txtService, new GridBagConstraints(++x, y, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        panel.add(lblRuc, new GridBagConstraints(x = 0, ++y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(txtRuc, new GridBagConstraints(++x, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        panel.add(lblNick, new GridBagConstraints(x = 0, ++y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(txtNick, new GridBagConstraints(++x, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(lblPassword, new GridBagConstraints(x = 0, ++y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(txtPassword, new GridBagConstraints(++x, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(lblPath, new GridBagConstraints(x = 0, ++y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(txtPath, new GridBagConstraints(++x, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(btnPath, new GridBagConstraints(++x, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(lblInterval, new GridBagConstraints(x = 0, ++y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(sldInterval, new GridBagConstraints(++x, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(lblMaxSize, new GridBagConstraints(x = 0, ++y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        panel.add(sldMaxSize, new GridBagConstraints(++x, y, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        panel.add(control, new GridBagConstraints(0, ++y, 3, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        control.add(btnDefault);
        control.add(btnTestConnection);
        control.add(btnSave);
        control.add(btnCancel);

        txtPath.setEditable(false);

        sldInterval.setPaintLabels(true);
        sldInterval.setPaintTicks(true);
        sldInterval.setPaintTrack(true);
        sldInterval.setMajorTickSpacing(30);
        sldInterval.setMinorTickSpacing(10);

        sldMaxSize.setPaintLabels(true);
        sldMaxSize.setPaintTicks(true);
        sldMaxSize.setPaintTrack(true);
        sldMaxSize.setMajorTickSpacing(5);
        sldMaxSize.setMinorTickSpacing(1);

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

    }

    private void prepareListeners() {
        btnPath.addActionListener(actionListener);
        btnDefault.addActionListener(actionListener);
        btnTestConnection.addActionListener(actionListener);
        btnSave.addActionListener(actionListener);
        btnCancel.addActionListener(actionListener);

        sldInterval.addChangeListener(changeListener);
        sldMaxSize.addChangeListener(changeListener);

    }
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(btnCancel)) {
                loadSavedValues();
                dispose();
            } else if (e.getSource().equals(btnDefault)) {
                setDefaultValues();
            } else if (e.getSource().equals(btnPath)) {
                changePath();
            } else if (e.getSource().equals(btnSave)) {
                saveValues();
            } else if (e.getSource().equals(btnTestConnection)) {
                testConnection();
            }
        }
    };
    private ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource().equals(sldInterval)) {
                int value = sldInterval.getValue();
                if (value == 0) {
                    sldInterval.setValue(1);
                }
            } else if (e.getSource().equals(sldMaxSize)) {
                int value = sldMaxSize.getValue();
                if (value == 0) {
                    sldMaxSize.setValue(1);
                }
            }
        }
    };

    private void loadSavedValues() {
        ConfigurationManager cfm = ConfigurationManager.getInstance();
        try {
            cfm.loadValuesFromConfigurationFile();
        } catch (Exception ex) {
            log.error(ex, ex);
            JOptionPane.showMessageDialog(this, "No se puede cargar la configuración actual", "Configuración", JOptionPane.ERROR_MESSAGE);
        }
        loadValues();
    }

    private void setDefaultValues() {
        ConfigurationManager cfm = ConfigurationManager.getInstance();
        cfm.setDefaultValues();
        loadValues();
    }

    private void loadValues() {
        ConfigurationManager cfm = ConfigurationManager.getInstance();
        WSLoader_Service.setWsdlLocation(cfm.getService());
        txtService.setText(cfm.getService());
        txtRuc.setText(cfm.getRuc());
        txtNick.setText(cfm.getNick());
        txtPassword.setText(Crypt.decrypt(cfm.getRuc(), cfm.getPassword()));
        txtPath.setText(cfm.getPath());
        sldInterval.setValue(cfm.getInterval());
        sldMaxSize.setValue(cfm.getMaxSize());
        chooser.setCurrentDirectory(new File(cfm.getPath()));
    }

    private void saveValues() {
        ConfigurationManager cfm = ConfigurationManager.getInstance();
        WSLoader_Service.setWsdlLocation(txtService.getText());
        cfm.setService(txtService.getText());
        cfm.setRuc(txtRuc.getText().trim());
        cfm.setNick(txtNick.getText());
        cfm.setPassword(Crypt.encrypt(cfm.getRuc(), new String(txtPassword.getPassword())));
        cfm.setPath(txtPath.getText());
        cfm.setInterval(sldInterval.getValue());
        cfm.setMaxSize(sldMaxSize.getValue());
        BackupTray.getBackupTray().getDaemonThread().setInterval(cfm.getInterval() * 60 * 1000);
        try {
            cfm.saveValues();

            String basePath = cfm.getPath();
            if (!basePath.endsWith(FILE_SEPARATOR)) {
                basePath += FILE_SEPARATOR;
            }

            String currentDir = basePath + cfm.getIssuedDir() + FILE_SEPARATOR;
            File file = new File(currentDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            
            currentDir = basePath + cfm.getReceivedDir() + FILE_SEPARATOR;
            file = new File(currentDir);
            if (!file.exists()) {
                file.mkdirs();
            }

            dispose();
        } catch (Exception ex) {
            log.error(ex, ex);
            JOptionPane.showMessageDialog(this, "No se puede guardar la configuración actual", "Configuración", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changePath() {
        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            txtPath.setText(file.getAbsolutePath());
        }
    }

    private void testConnection() {

        String address = txtService.getText();
        WSLoader_Service.setWsdlLocation(address);
        String ruc = txtRuc.getText();
        String nick = txtNick.getText();
        String password = new String(txtPassword.getPassword());

        String loginResult = login(ruc, nick, password);

        if (loginResult.startsWith("Error")) {
            JOptionPane.showMessageDialog(this, loginResult, "Configuración", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Conexión exitosa con el servidor", "Configuración", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static String login(String ruc, String nick, String password) {
        WSLoader_Service service = new WSLoader_Service();
        ec.ste.docusend.wsc.WSLoader port = service.getWSLoaderPort();
        return port.login(ruc, nick, password);
    }
}
