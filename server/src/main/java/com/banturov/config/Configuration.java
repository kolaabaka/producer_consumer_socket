package com.banturov.config;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

    public Properties properties;

    public Configuration() throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
    }
}
