package com.constants;

import lombok.Getter;

public final class FrameworkConstants {

    //For non-static variables;@Getter is applicable at class level
    //For static variable;@Getter should be declared as shown below

    private FrameworkConstants(){}

    private static @Getter final String requestJsonFolderPath = System.getProperty("user.dir") + "/src/test/resources/requests/";
    private static @Getter final String responseJsonFolderPath = System.getProperty("user.dir")+"/output/";
    private static @Getter final String configPropertyFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    private static @Getter final String extentReportFolderPath = System.getProperty("user.dir")+"/output/";
}
