package Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestEnv {
    public static void main(String[] args) throws IOException {
        Properties login = new Properties();
        try (FileReader in = new FileReader("/home/mosbot/login.properties")) {
            login.load(in);
        }
        String username = login.getProperty("username");
        String password = login.getProperty("password");

        System.out.println(username);
        System.out.println(password);

    }
}
