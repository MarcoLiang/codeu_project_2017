package codeu.chat.util;

import codeu.chat.server.Controller;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;

/**
 * Created by jeaniewu on 2017-04-23.
 */
public class Security {

    private final static Logger.Log LOG = Logger.newLog(Controller.class);

    private static final String ALGO = "AES/ECB/PKCS5Padding";
    private static final byte[] key = "MyDifficultPassw".getBytes();

    public static byte[] encrypt(byte[] dataToSend){

        System.out.println("ENCRYPTING --> Plain Text:");
        for (byte b : dataToSend) {
            System.out.format("%d", b);
        }
        System.out.println("\n");

        byte[] encryptedData = null;

        try {
            Cipher c = Cipher.getInstance(ALGO);
            SecretKeySpec k = new SecretKeySpec(key, "AES");
            c.init(Cipher.ENCRYPT_MODE, k);
            encryptedData = c.doFinal(dataToSend);
        } catch (Exception ex){
            LOG.error(ex, "Failed to encrypt plain text.");
        }

        System.out.println("RESULT --> Cipher Text:");
        for (byte b : encryptedData) {
            System.out.format("0x%x ", b);
        }
        System.out.println("\n");
        System.out.println("\n");

        return encryptedData;
    }

    public static byte[] decrypt(byte[] encryptedData){

        System.out.println("DECRYPTING --> Cipher Text:");
        for (byte b : encryptedData) {
            System.out.format("0x%x ", b);
        }
        System.out.println("\n");

        byte[] plainText = null;

        try{
            Cipher c = Cipher.getInstance(ALGO);
            SecretKeySpec k = new SecretKeySpec(key, "AES");
            c.init(Cipher.DECRYPT_MODE, k);
            plainText = c.doFinal(encryptedData);
        }catch (Exception ex){
            LOG.error(ex, "Failed to decrypt cipher text.");
        }

        System.out.println("RESULT --> Plain Text:");
        for (byte b : plainText) {
            System.out.format("%d", b);
        }
        System.out.println("\n");
        System.out.println("\n");

        return plainText;
    }

}
