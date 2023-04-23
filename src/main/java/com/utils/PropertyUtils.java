package com.utils;


import com.constants.FrameworkConstants;
import com.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    //read once and store it in Map, instead of calling multiple times
    private static final Properties properties = new Properties();
    private static final Map<String,String> Map = new HashMap<>();


    static {
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigPropertyFilePath())) { //closeable
            properties.load(fis);
        }catch (IOException e) {
            System.exit(0);
        }
        properties.entrySet().forEach(e->Map.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
    }

    public static String getValue(PropertiesType key){
        return Map.get(key.name().toLowerCase());
        //name()--> final method
        //toString()---> not final method
    }
}
