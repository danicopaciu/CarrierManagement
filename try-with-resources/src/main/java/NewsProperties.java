import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Daniel Copaciu on 7/3/2016.
 * dani.copaciu@gmail.com
 */
public class NewsProperties {

    private static final String PROPERTY_FILE = "local.properties";

    public static String getProperty(String key) {
        if (key == null || key.length() <= 0) {
            return null;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PROPERTY_FILE))) {
            String property;
            while ((property = bufferedReader.readLine()) != null) {
                String[] propertyLine = property.split("=");
                if (propertyLine.length != 2) {
                    return null;
                }
                if (propertyLine[0].equals(key)) {
                    return propertyLine[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
