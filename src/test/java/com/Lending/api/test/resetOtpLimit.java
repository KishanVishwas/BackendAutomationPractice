package com.Lending.api.test;
import Lending.jar.Automation.ValidateApi.Validation;
import Lending.jar.Automation.dataModel_S.OtpLimit;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.resetOtp;
import static Lending.jar.Automation.Constant.uriConstant.resetOtpVerifyLimit;
import static Lending.jar.Automation.Utils.restUtils.postCall1;


public class resetOtpLimit
{
    @Test(description = "Resetting the OTP limit ",priority = 1)
    public void resetOtp1() throws Exception
    {
       Response response= postCall1(resetOtp, HeaderHelper.OtpLimit(), OtpLimit.objectMap(),HttpStatus.SC_OK);
        System.out.println(response.jsonPath().prettyPrint());
        Validation.resetOtpvalidate(response);
    }

    @Test(description = "Verifying the OTP limit reset",priority = 2)
    public static void resetOtp2() throws Exception {
        Response response=postCall1(resetOtpVerifyLimit,HeaderHelper.OtpLimit(),OtpLimit.objectMap(),HttpStatus.SC_OK);
        System.out.println(response.jsonPath().prettyPrint());
        Validation.resetValidate(response);
    }
}

