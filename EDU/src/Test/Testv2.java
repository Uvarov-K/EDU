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

public class Testv2 {
    private static final String SECRET_KEY = "/home/mosbot/project/.bot.secret";
    private static final String SALT = "/home/mosbot/project/.salt";
    private static final String BOT_PROPERTIES = "D:\\Win\\Java\\bot_config.txt";
    private static final String MOS_PROPERTIES = "/home/mosbot/project/.mos.properties";

    public String GetProperties(String propertyFile, String propertyName) throws IOException {

        Properties credentials = new Properties();
        try (FileReader propertyFiles = new FileReader(propertyFile)) {
            credentials.load(propertyFiles);
        }


        return credentials.getProperty(propertyName);

    }

    public void tst() throws IOException {
       String s =  GetProperties(BOT_PROPERTIES,"bot_name");
        System.out.println(s);

    }

    public static void main(String[] args) throws IOException {
        Testv2 t = new Testv2();
        t.tst();
    }


}