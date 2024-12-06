package com.Lending.api.test;

import Lending.jar.Automation.dataModel_S.flowEnable1;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.addUsers;
import static Lending.jar.Automation.Utils.restUtils.postCall1;
import static Lending.jar.Automation.ValidateApi.Validation.CommonValidation;

public class web_Rtf_flowEnable
{
    @Test(description = "enabling the RTF or Webflow for the User")
    public static void enableFlow() throws Exception
    {
       Response response =postCall1(addUsers, HeaderHelper.addingUser(),flowEnable1.objectMap(), HttpStatus.SC_OK);
        CommonValidation(response);
    }
}
