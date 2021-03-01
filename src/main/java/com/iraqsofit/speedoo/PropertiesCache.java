package com.iraqsofit.speedoo;


import java.io.*;
import java.util.Properties;
import java.util.Set;


public class PropertiesCache{

    private final Properties configProp = new Properties();

    private PropertiesCache()  {
        try {
            InputStream in = new FileInputStream("config/application.properties");
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class LazyHolder
    {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key){
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames(){
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key){
        return configProp.containsKey(key);
    }
    public void setProperty(String key, String value){
        configProp.setProperty(key, value);
        try {
           flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void flush() throws FileNotFoundException, IOException {


        try (final OutputStream outputstream
                     = new FileOutputStream("config/application.properties");) {
            configProp.store(outputstream,"File Updated");
            outputstream.close();
        }
    }

}