package com.Lending.api.test;

import Lending.jar.Automation.dataModel_S.practicePost1;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.configConstant.exampleUrl;
import static Lending.jar.Automation.Constant.uriConstant.practiceUri;
import static Lending.jar.Automation.Utils.restUtils.postCall1;

public class testNestedandArray
{
    @Test(description = "body of the Nested and Array in the post request ")
    public static void nestandArray()
    {
        Response response = postCall1(practiceUri, HeaderHelper.nestedandArray(), practicePost1.postRequest(), HttpStatus.SC_CREATED);
        System.out.println(response.jsonPath().prettyPrint());
        System.out.println(exampleUrl + practiceUri );
    }
}
