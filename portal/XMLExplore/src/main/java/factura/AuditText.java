/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author German17
 */
public class AuditText {
    private List<String> patterns=new ArrayList<String>();
    private List<String> values=new ArrayList<String>();

    public AuditText() {
    }

    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    public void addPattern(String text){
        patterns.add(text);
    }
    
    public String getPatternAt(int index){
        if(index>=patterns.size()){
            return " ";
        }
        return patterns.get(index);
    }

    
    public void addText(String text){
        values.add(text);
    }
    
    public String getValueAt(int index){
        if(index>=values.size()){
            return " ";
        }
        return values.get(index);
    }
    
}
