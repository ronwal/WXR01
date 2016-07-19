package ec.gob.sri.comprobantes.util.reportes;

import net.sf.jasperreports.view.*;
import java.io.*;
import net.sf.jasperreports.engine.*;
import java.util.*;
import java.awt.event.*;

public class JasperViwerSRI extends JRViewer
{
    public JasperViwerSRI(final JasperPrint jrPrint) {
        super(jrPrint);
    }
    
    public JasperViwerSRI(final JasperPrint jrPrint, final Locale locale) {
        super(jrPrint, locale);
    }
    
    public JasperViwerSRI(final InputStream is, final boolean isXML) throws JRException {
        super(is, isXML);
    }
    
    public JasperViwerSRI(final String fileName, final boolean isXML, final Locale locale) throws JRException {
        super(fileName, isXML, locale);
    }
    
    public JasperViwerSRI(final JasperPrint jrPrint, final Locale locale, final ResourceBundle resBundle) {
        super(jrPrint, locale, resBundle);
    }
    
    void btnNextActionPerformed(final ActionEvent evt) {
        throw new RuntimeException("Compiled Code");
    }
}
