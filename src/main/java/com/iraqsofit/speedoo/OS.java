package com.iraqsofit.speedoo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class OS {
    @Autowired
    private Environment env;

    public static  String  getOsName(){
        String os_name= System.getProperty("os.name");
        if (os_name.contains("Mac") || os_name.contains("mac")){
            return "mac";
        }else if (os_name.contains("Windows") || os_name.contains("windows")){
            return "windows";
        }else {
            return "windows";
        }
    }

    public void ChangeProperties(String key, String value)  {

    }
}
