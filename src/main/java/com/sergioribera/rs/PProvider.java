package com.sergioribera.rs;

import java.util.Properties;
import java.io.*;

public class PProvider {

    public static final String PROVIDER_FILE = "configs.properties";

    Properties properties;

    PProvider() {
        properties = new Properties();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROVIDER_FILE);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
}
