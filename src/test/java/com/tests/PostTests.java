package com.tests;

import com.annotations.FrameworkAnnotation;
import com.constants.FrameworkConstants;
import com.enums.RequestType;
import com.pojo.Employee;
import com.reports.ExtentLogger;
import com.utils.ApiUtils;
import com.utils.RandomUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.requestbuilder.RequestBuilder.buildRequestForPostCalls;
import static org.assertj.core.api.Assertions.assertThat;

public class PostTests {
    
    @Test
    @FrameworkAnnotation(author = {"Mahesh"},category = {"Smoke"})
    public void postCallTest(){
        //create an employee using post call
        //Construct using Pojo and lombok builder annotation

        Employee employee = Employee
                .builder()
                .setId(RandomUtils.getId())
                .setFname(RandomUtils.getFirstName())
                .setLname(RandomUtils.getLastName())
                .build();

        RequestSpecification requestSpecification = buildRequestForPostCalls()
                .basePath("/employees")
                .body(employee);

        Response response = requestSpecification.post();

        ExtentLogger.logRequest(requestSpecification, RequestType.POST);
        ExtentLogger.logResponse(response.prettyPrint());

        assertThat(response.statusCode())
                .as("Validate status code is 201")
                .isEqualTo(201);

    }

    @Test
    @FrameworkAnnotation(author = {"Mahesh"},category = {"Smoke"})
    public void postRequestUsingExternalFile(Method method){

        String json = ApiUtils.readJsonAsString(FrameworkConstants.getRequestJsonFolderPath()+"employee.json")
                .replace("number",String.valueOf(RandomUtils.getId()))
                .replace("fname",RandomUtils.getFirstName())
                .replace("lname",RandomUtils.getLastName());

        RequestSpecification requestSpecification = buildRequestForPostCalls()
                .body(json)
                .basePath("/employees");

        Response response = requestSpecification.post();

        ExtentLogger.logRequest(requestSpecification, RequestType.POST);
        ExtentLogger.logResponse(response.prettyPrint());

        ApiUtils.writeJsonToFile(FrameworkConstants.getResponseJsonFolderPath()+method.getName()+".json",response);

    }
}
