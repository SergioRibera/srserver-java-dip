package com.sergioribera.rs;

public class PProvider {

    public static final String PROVIDER_FILE = "src/main/resources/configs.properties";

    Properties properties;

    PProvider() {
        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/configs.properties"));
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
    
}
