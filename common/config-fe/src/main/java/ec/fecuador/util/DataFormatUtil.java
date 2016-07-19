package ec.fecuador.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author German17
 */
public class DataFormatUtil {
    
    private static final SimpleDateFormat ddMMyyyyFormat=new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat yyyyMMddFormat=new SimpleDateFormat("yyyy/MM/dd");
    private static final DecimalFormat decimalFormat=new DecimalFormat("### ##0.000");
    
    public static String getDateFormat(Date date){
        return ddMMyyyyFormat.format(date);
    }
    
    
    public static String getDecimalFormat(double value){
        return decimalFormat.format(value);
    }

    public static SimpleDateFormat getDdMMyyyyFormat() {
        return ddMMyyyyFormat;
    }

    public static SimpleDateFormat getYyyyMMddFormat() {
        return yyyyMMddFormat;
    }
    
    

}
