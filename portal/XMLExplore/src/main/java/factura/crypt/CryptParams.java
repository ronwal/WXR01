/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.crypt;

/**
 *
 * @author German17
 */
public class CryptParams {

    private static final byte[] saltBytes = new byte[]{
        (byte) 0x17, (byte) 0x79, (byte) 0x85, (byte) 0xBE,
        (byte) 0xA7, (byte) 0xAF, (byte) 0x2E, (byte) 0x90
    };
    private static final int iterationCount = 0xCA;
    
    private static final String algorithm = new String(new char[]{
                (char) 0x50, (char) 0x42, (char) 0x45, (char) 0x57,
                (char) 0x69, (char) 0x74, (char) 0x68, (char) 0x4D,
                (char) 0x44, (char) 0x35, (char) 0x41, (char) 0x6E,
                (char) 0x64, (char) 0x44, (char) 0x45, (char) 0x53
            });

    public static byte[] getSaltBytes() {
        return saltBytes;
    }

    

    public static int getIterationCount() {
        return iterationCount;
    }

    public static String getAlgorithm() {
        return algorithm;
    }
}
