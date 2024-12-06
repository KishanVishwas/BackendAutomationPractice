package com.Lending.api.test;

import Lending.jar.Automation.Utils.restUtils;

import Lending.jar.Automation.dataModel_S.OtpLimit;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.loanOtpreset;
import static Lending.jar.Automation.ValidateApi.Validation.CommonValidation;


public class loanOtpReset
{
    @Test(description = "Loan agreement Otp reset ",priority = 1)
    public static void resetLoanOtp() throws Exception {
        Response response = restUtils.postCall1(loanOtpreset, HeaderHelper.loanOtp(), OtpLimit.objectMap1(), HttpStatus.SC_OK);
        System.out.println(response.jsonPath().prettyPrint());
        CommonValidation(response);
    }
}
