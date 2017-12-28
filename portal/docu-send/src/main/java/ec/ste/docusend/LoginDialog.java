package ec.ste.docusend;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * @author German17
 */
public class LoginDialog extends JDialog implements ActionListener {

    private String ADMIN_PASSWORD = "%Ta-R6bK!4ea09";
    private JPasswordField txtPassword = new JPasswordField();
    private JButton btnAccept = new JButton("Aceptar");
    private JButton btnCancel = new JButton("Cancelar");
    private JPanel pnlContainer = new JPanel(new GridBagLayout());
    private JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private ConfigurationFrame configurationFrame = new ConfigurationFrame();

    public LoginDialog() {
        super((Frame) null, "Identificación", true);

        setSize(300, 135);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        prepareComponents();
    }

    private void prepareComponents() {
        setContentPane(pnlContainer);
        int x = 0, y = 0;
        pnlContainer.add(new JLabel("Clave de cambio de configuración:"), new GridBagConstraints(x, y++, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        pnlContainer.add(txtPassword, new GridBagConstraints(x, y++, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        pnlContainer.add(pnlButtons, new GridBagConstraints(x, y++, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        pnlButtons.add(btnAccept);
        pnlButtons.add(btnCancel);

        btnAccept.addActionListener(this);
        btnCancel.addActionListener(this);
        txtPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAccept) | e.getSource().equals(txtPassword)) {
            String password = new String(txtPassword.getPassword());
            if (ADMIN_PASSWORD.equals(password)) {
                dispose();
                configurationFrame.setState(Frame.NORMAL);
                configurationFrame.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "La clave es incorrecta", "Error de identificación", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            dispose();
        }
    }
}
