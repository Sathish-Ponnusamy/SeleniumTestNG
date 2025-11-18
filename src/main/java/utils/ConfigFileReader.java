package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath= "configs//configuration.properties";
    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }

    }

    public String getReportConfigPath()
    {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");

    }

    public String getReportOutPath()
    {
        String reportOutPath = properties.getProperty("reportOutPath");
        if(reportOutPath!= null) return reportOutPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");

    }

    public String getbaseURL() {
        String baseURL = properties.getProperty("baseURL");
        if(baseURL != null) {
        }
        else throw new RuntimeException("baseURL not specified in the Configuration.properties file.");
        return baseURL;
    }

    public String getBSURL()
    {
        String BSURL1 = properties.getProperty("BSURL");
        if(BSURL1!= null) return BSURL1;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");

    }

}
