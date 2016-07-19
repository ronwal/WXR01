/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

/**
 *
 * @author German17
 */
public interface EntityInfo {
    
    
    public String getPkAttributeName();
    
    public String getFilterAttributeName();
    
    public String getPkFinderMethod();
    
    public String getFilterMethod();
    
    public String getFilterLabel();
    
    public Class getDaoClass();
    
    public Class getEntityClass();
}
