package com.Lending.api.test;

import Lending.jar.Automation.dataModel_S.schemaRuleEngine1;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.ruleEngine;
import static Lending.jar.Automation.Utils.restUtils.postCall1;

public class ruleEngineSchema {

    @Test(description = "validating the json schema for rule engine for webflow ",priority = 1)
    public static void validateSchema() throws Exception {
        Response response = postCall1(ruleEngine, HeaderHelper.jsonSchemaRuleEngine(), schemaRuleEngine1.objectMap(), HttpStatus.SC_OK);
        System.out.println(response.jsonPath().prettyPrint());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ruleEngine.json"));
        System.out.println(schemaRuleEngine1.objectMap());
    }
}