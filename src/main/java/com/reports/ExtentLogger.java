package com.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.enums.RequestType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void info(String message){
        ExtentManager.getTest().info(message);
    }


    public static void logResponse(String message){
        ExtentManager.getTest().info(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));

    }

    public static void logRequest(RequestSpecification requestSpecification, RequestType requestType){
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        info("--------Request---------");
        info("EndPoint URL : " + query.getBaseUri() + query.getBasePath());

        if(requestType.name().equalsIgnoreCase("GET")) {

       }
       else if(requestType.name().equalsIgnoreCase("POST")){
            info("--------Response---------");
           logResponse(query.getBody());
            Headers headers = query.getHeaders();
            for(Header header:headers){
                info(header.getName()+" : "+header.getValue());
            }

        }




    }
}
