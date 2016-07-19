/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factura.util;

/**
 *
 * @author German17
 */
public class Attach {
    
    private String name;
    private byte content[];
    private String mime;

    public Attach(String name, byte[] content, String mime) {
        this.name = name;
        this.content = content;
        this.mime=mime;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
    
    
    
    
}
