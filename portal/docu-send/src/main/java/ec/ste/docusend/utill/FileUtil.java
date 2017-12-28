/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.docusend.utill;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author German17
 */
public class FileUtil {
    
    //10KB
    private static final int BUFFER_SIZE=1024*10;
    
    public static byte[] openFile(File file)throws Exception{
        FileInputStream in=new FileInputStream(file);
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        
        byte buffer[]=new byte[BUFFER_SIZE];
        int readed;
        
        while((readed=in.read(buffer))>0){
            out.write(buffer, 0, readed);
        }
        out.flush();
        out.close();
        in.close();
        
        return out.toByteArray();
    }
    
    public static void writeFile(File file, byte data[])throws Exception{
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out=new FileOutputStream(file);
        out.write(data);
        out.flush();
        out.close();
    }
    
}