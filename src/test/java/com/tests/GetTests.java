package com.tests;


import com.annotations.FrameworkAnnotation;
import com.enums.RequestType;
import com.reports.ExtentLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static com.requestbuilder.RequestBuilder.buildRequestForGetCalls;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTests {

    @Test
    @FrameworkAnnotation(author = {"Mahesh"},category = {"Smoke"})
    public void getEmployeesDetails() {
        RequestSpecification requestSpecification = buildRequestForGetCalls().basePath("/employees");
        Response response=requestSpecification.get();

        ExtentLogger.logRequest(requestSpecification, RequestType.GET);
        ExtentLogger.logResponse(response.prettyPrint());

        if(response.statusCode()==200){
            ExtentLogger.pass("status code is 200");
        }

        assertThat(response.jsonPath().getList("$").size())
                .as("Validating size of employee list").isGreaterThan(30);

    }

    @Test
    @FrameworkAnnotation(author = {"Mahesh"},category = {"Smoke"})
    public void getEmployeeDetails() {
        RequestSpecification requestSpecification = buildRequestForGetCalls()
                                     .basePath("/employees/34");

        Response response=requestSpecification.get();

        ExtentLogger.logRequest(requestSpecification, RequestType.GET);
        ExtentLogger.logResponse(response.prettyPrint());

        if(response.statusCode()==200){
            ExtentLogger.pass("status code is 200");
        }

        assertThat(response.jsonPath().getString("first_name"))
                .isEqualTo("Gerry");


    }
}
