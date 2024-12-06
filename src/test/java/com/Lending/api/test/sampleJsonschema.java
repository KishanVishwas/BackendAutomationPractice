package com.Lending.api.test;

import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.exampleUri;
import static Lending.jar.Automation.Utils.restUtils.getCallWithoutBodyPut;

public class sampleJsonschema {

    @Test(description = "basic json schema validation")
    public static void jsonSchema() {

        Response response = getCallWithoutBodyPut(exampleUri, HeaderHelper.jsonSchemaValidator(), HttpStatus.SC_OK);
        System.out.println(response.jsonPath().prettyPrint());
       response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user-schema.json"));

    }
}
