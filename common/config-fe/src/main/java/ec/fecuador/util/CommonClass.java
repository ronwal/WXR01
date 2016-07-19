/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Walter
 */
public class CommonClass {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
    /**
	 * Validacion con expreciones regulares, son reemplazadas con "" <b>(Limpiar
	 * cadenas de texto)</b>
	 * 
	 * @param textImput
	 *            {@link String} (Contenido a validar)
	 * @param REGEX
	 *            {@link String} (Expresion Regular)
	 * 
	 * @author @rw_r
	 */
	public static boolean isRegex(String textImput, String REGEX) {
		try {
			Pattern pattern = null;
			Matcher matcher = null;
			pattern = Pattern.compile(REGEX);
			matcher = pattern.matcher(textImput);
			return matcher.matches();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Validate hex with regular expression
	 * 
	 * @param email
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean emailRgexvalidate(final String email) {
		try {
			for (String _email : email.split(";")) {
				if (!_email.isEmpty())
					if (!isRegex(_email, EMAIL_PATTERN))
						return false;
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}
        
        public static boolean isEmpty(Object objEval){
            if(objEval==null)
                return true;
            else if(String.valueOf(objEval).isEmpty())
                return true;
            return false;
        }
}
