package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static FileInputStream input;  // to read a file we need to use  input
    private static Properties properties;  // to load the properties we use properties

    static{
        String path = "/Users/andreigonta/IdeaProjects/MindtekTestNG/src/test/resources/configurations/Configuration.properties";
        try {
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties file is invalid");
        } catch (IOException e) {
            System.out.println("Failed to load the properties file");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Exception occured while closing input object");
            }
        }
    }
    // the only purpose to ConfigReader class is to read the Configuration.properties and to get the beneath

    public static String getProperty(String key){     // takes key as parameter and returns value
        return properties.getProperty(key);           // Configuration.properties => value => url
    }
}
