package ec.ste.factura.exception;
/**
 * @author German17
 */
public class DaoException extends Exception{

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
    
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    

}
