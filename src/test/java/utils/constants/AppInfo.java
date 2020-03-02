package utils.constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppInfo {

    public static final String BASE_PATH = "/v2";
    public static final Properties GENERAL_ENVIRONMENT_DATA;
    public static final String ENV = System.getProperty("environment");
    private static final String FOLDER = "environments/";
    private static final String GENERAL_PROPERTIES_FILE_NAME = ".properties";

    public static void main(String[] args) {
    }

    static {
        try {
            System.out.println("folder - " + FOLDER + ENV + GENERAL_PROPERTIES_FILE_NAME);
            GENERAL_ENVIRONMENT_DATA = readProperties(FOLDER + ENV + GENERAL_PROPERTIES_FILE_NAME);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Properties readProperties(String filename) throws IOException {
        Properties properties;

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
            properties = new Properties();
            if (inputStream == null) {
                // throw new TestFrameworkConfigurationException("filename should point to reachable %s file", filename);
            }
            properties.load(inputStream);
        }
        return properties;
    }
}