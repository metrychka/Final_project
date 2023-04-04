package TestApi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String XAuthToken;
    private static String url;
    private static String login;

    private static String password;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        url =  prop.getProperty("url");
        XAuthToken= prop.getProperty("X-Auth-Token");
        login = prop.getProperty("login");
        password = prop.getProperty("password");

    }

    public static String getXAuthToken() {
        return XAuthToken;
    }

    public static String getUrl() {
        return url;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
