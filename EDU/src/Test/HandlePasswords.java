package Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Properties;

public class HandlePasswords {
    private static final String SECRET_KEY = "/home/mosbot/project/.bot.secret";
    private static final String SALT = "/home/mosbot/project/.salt";
    private static final String BOT_PROPERTIES = "/home/mosbot/project/.bot.properties";
    private static final String MOS_PROPERTIES = "/home/mosbot/project/.mos.properties";

    public static String GetProperties(String propertyFile, String propertyName) throws IOException {

        Properties credentials = new Properties();
        try (FileReader secretFile = new FileReader(propertyFile)) {
            credentials.load(secretFile);
        }
        return credentials.getProperty(propertyName);
    }



    public static String encrypt(String strToEncrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            //  KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            KeySpec spec = new PBEKeySpec(GetProperties(SECRET_KEY,"secret_key").toCharArray(), GetProperties(SALT, "salt").getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }


    public static String decrypt(String strToDecrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            //KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            KeySpec spec = new PBEKeySpec(GetProperties(SECRET_KEY,"secret_key").toCharArray(), GetProperties(SALT, "salt").getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }


    public static void HashPasswords() throws IOException {

        String botNameOriginal=GetProperties(BOT_PROPERTIES, "bot_name");
        String botNameEncrypted=encrypt(botNameOriginal);
        String botNameDecrypted=decrypt(botNameEncrypted);

        String botTokenOriginal=GetProperties(BOT_PROPERTIES, "bot_token");
        String botTokenEncrypted=encrypt(botTokenOriginal);
        String botTokenDecrypted=decrypt(botTokenEncrypted);

        String mosLoginOriginal=GetProperties(MOS_PROPERTIES,"username");
        String mosLoginEncrypted=encrypt(mosLoginOriginal);
        String mosLoginDecrypted=decrypt(mosLoginEncrypted);

        String mosPasswordOriginal=GetProperties(MOS_PROPERTIES,"password");
        String mosPasswordEncrypted=encrypt(mosPasswordOriginal);
        String mosPasswordDecrypted=decrypt(mosPasswordEncrypted);

        System.out.println("botNameOriginal " + botNameOriginal);
        System.out.println("botNameEncrypted " + botNameEncrypted);
        System.out.println("botNameDecrypted " + botNameDecrypted);

        System.out.println("botTokenOriginal " + botTokenOriginal);
        System.out.println("botTokenEncrypted " + botTokenEncrypted);
        System.out.println("botTokenDecrypted " + botTokenDecrypted);

        System.out.println("mosLoginOriginal " + mosLoginOriginal);
        System.out.println("mosLoginEncrypted " + mosLoginEncrypted);
        System.out.println("mosLoginDecrypted " + mosLoginDecrypted);

        System.out.println("mosPasswordOriginal " + mosPasswordOriginal);
        System.out.println("mosPasswordEncrypted " + mosPasswordEncrypted);
        System.out.println("mosPasswordDecrypted " + mosPasswordDecrypted);


    }

    public static void main(String[] args) throws IOException {
        HandlePasswords hp = new HandlePasswords();
        hp.HashPasswords();
    }
}