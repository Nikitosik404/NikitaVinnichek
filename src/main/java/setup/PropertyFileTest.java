package setup;

import enums.mobile.PropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileTest {

    private String propertyFileName;
    private Properties testProperties = new Properties();

    protected void setPropertyFileName(PropertiesFile propertyFileName)  {
        this.propertyFileName = propertyFileName.getName();
    }

    private Properties getTestProperties() throws IOException {
        try (FileInputStream inputStream = new FileInputStream( "src/main/resources/mobile/" + propertyFileName)) {
            testProperties.load(inputStream);
            return testProperties;
        }
    }

    public String getProp(String keyProperty) throws IOException {
        if (!testProperties.contains(keyProperty)) {
            testProperties = getTestProperties();
        }
        return testProperties.getProperty(keyProperty, null);
    }
}