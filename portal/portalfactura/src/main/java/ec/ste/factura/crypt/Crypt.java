/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ste.factura.crypt;

import java.nio.charset.Charset;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author German17
 */
public class Crypt {

    private static transient Cipher cipher;
    private static transient SecretKey key;
    private static transient AlgorithmParameterSpec paramSpec;

    static {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized String encrypt(String password,String data) {
        try {
            
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), CryptParams.getSaltBytes(), CryptParams.getIterationCount());
            key = SecretKeyFactory.getInstance(CryptParams.getAlgorithm()).generateSecret(keySpec);
            cipher = Cipher.getInstance(key.getAlgorithm());
            // Prepare the parameters to the cipthers
            paramSpec = new PBEParameterSpec(CryptParams.getSaltBytes(), CryptParams.getIterationCount());
            
            cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            byte[] utf8 = data.getBytes(Charset.forName("UTF-8"));
            byte[] enc = cipher.doFinal(utf8);
            return Base64.encodeBase64String(enc);
        } catch (Exception e) {
            
        }
        return null;
    }

    public static synchronized String decrypt(String password,String encrypted) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), CryptParams.getSaltBytes(), CryptParams.getIterationCount());
            key = SecretKeyFactory.getInstance(CryptParams.getAlgorithm()).generateSecret(keySpec);
            cipher = Cipher.getInstance(key.getAlgorithm());
            // Prepare the parameters to the cipthers
            paramSpec = new PBEParameterSpec(CryptParams.getSaltBytes(), CryptParams.getIterationCount());
            
            cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            byte[] dec = Base64.decodeBase64(encrypted);
            byte[] utf8 = cipher.doFinal(dec);
            return new String(utf8, Charset.forName("UTF-8"));
        } catch (Exception e) {
            
        }
        return null;
    }
}
