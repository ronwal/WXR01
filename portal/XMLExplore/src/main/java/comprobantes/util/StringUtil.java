package comprobantes.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
    public static boolean validateEmail(final String email) {
        final Pattern p = Pattern.compile("[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$");
        final Matcher m = p.matcher(email);
        return m.matches();
    }
    
    public static String getTipoIdentificacion(final String tipoIddentificacion) {
        if (tipoIddentificacion.equals("CEDULA")) {
            return "C";
        }
        if (tipoIddentificacion.equals("RUC")) {
            return "R";
        }
        if (tipoIddentificacion.equals("PASAPORTE")) {
            return "P";
        }
        if (tipoIddentificacion.equals("PASAPORTE")) {
            return null;
        }
        return null;
    }
    
    public static String getSlectedItem(final String tipoIddentificacion) {
        if (tipoIddentificacion.equals("C")) {
            return "CEDULA";
        }
        if (tipoIddentificacion.equals("R")) {
            return "RUC";
        }
        if (tipoIddentificacion.equals("P")) {
            return "PASAPORTE";
        }
        if (tipoIddentificacion.equals("")) {
            return "SELECCIONE";
        }
        return null;
    }
    
    public static String getSlectedItemTipoProducto(final String tipoIddentificacion) {
        if (tipoIddentificacion.equals("B")) {
            return "BIEN";
        }
        if (tipoIddentificacion.equals("S")) {
            return "SERVICIO";
        }
        return null;
    }
    
    public static String getSelectedTipoAmbiente(final String tipoIddentificacion) {
        if (tipoIddentificacion.equals("2")) {
            return "PRODUCCION";
        }
        if (tipoIddentificacion.equals("1")) {
            return "PRUEBAS";
        }
        return null;
    }
    
  
    
    public static String obtenerTipoEmision(final String valorCombo) {
        if (valorCombo.equalsIgnoreCase("NORMAL")) {
            return "1";
        }
        if (valorCombo.equalsIgnoreCase("INDISPONIBILIDAD DE SISTEMA")) {
            return "2";
        }
        return null;
    }
    
    public static String obtenerNumeroTipoEmision(final String tipoEmision) {
        if (tipoEmision.equalsIgnoreCase("1")) {
            return "NORMAL";
        }
        if (tipoEmision.equalsIgnoreCase("3")) {
            return "BAJA CONECTIVIDAD";
        }
        if (tipoEmision.equalsIgnoreCase("2")) {
            return "INDISPONIBILIDAD DE SISTEMA";
        }
        return null;
    }
    
    public static String quitarEnters(final String cadenConEnters) {
        String cadenaSinEnters = null;
        for (int x = 0; x < cadenConEnters.length(); ++x) {
            if (cadenConEnters.charAt(x) == '\t') {
                cadenaSinEnters += cadenConEnters.charAt(x);
            }
        }
        return cadenaSinEnters;
    }
    
    public static boolean validarExpresionRegular(final String patron, final String valor) {
        if (patron != null && valor != null) {
            final Pattern pattern = Pattern.compile(patron);
            final Matcher matcher = pattern.matcher(valor);
            return matcher.matches();
        }
        return false;
    }
    
    public static String obtenerDocumentoModificado(final String codDoc) {
        if ("01".equals(codDoc)) {
            return "FACTURA";
        }
        if ("04".equals(codDoc)) {
            return "NOTA DE CR\u00c9DITO";
        }
        if ("05".equals(codDoc)) {
            return "NOTA DE D\u00c9BITO";
        }
        if ("06".equals(codDoc)) {
            return "GU\u00cdA REMISI\u00d3N";
        }
        if ("07".equals(codDoc)) {
            return "COMPROBANTE DE RETENCI\u00d3N";
        }
        return null;
    }
}
