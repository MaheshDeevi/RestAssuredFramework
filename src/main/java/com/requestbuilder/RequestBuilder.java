package com.requestbuilder;

import com.enums.PropertiesType;
import com.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    private RequestBuilder(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                .log()
                .all()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURI));
    }

    public static RequestSpecification buildRequestForPostCalls(){
        return buildRequestForGetCalls()
                .contentType(ContentType.JSON);
    }
}
