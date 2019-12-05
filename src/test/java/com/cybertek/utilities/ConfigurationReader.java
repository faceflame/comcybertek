package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //this class will be responsible for loading properties file and provide access
    //to values based on key names
    //we use Properties (this class) to load custom .properties files
        private static Properties properties;

        static {

            try {
                // what file to read
                String path = "configuration.properties";
                // read the file into java, finds the file using the string path
                FileInputStream input = new FileInputStream(path);
                // properties --> class that store properties in key / value format
                properties = new Properties();
                // the values from the file input is loaded / fed in to the properties object
                properties.load(input);
                input.close();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        public static String get(String keyName) {
            return properties.getProperty(keyName);
        }

}
