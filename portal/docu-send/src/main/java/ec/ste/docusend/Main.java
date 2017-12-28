/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.docusend;

import org.apache.log4j.xml.DOMConfigurator;

import javax.swing.*;

/**
 *
 * @author German17
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DOMConfigurator.configure("log4j.xml");
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        BackupTray.getBackupTray().install();
    }
}
