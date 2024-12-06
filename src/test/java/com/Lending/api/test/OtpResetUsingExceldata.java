package com.Lending.api.test;

import Lending.jar.Automation.dataModel_S.fetchNumberinExcel;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static Lending.jar.Automation.Constant.uriConstant.resetOtp;
import static Lending.jar.Automation.Constant.uriConstant.resetOtpVerifyLimit;
import static Lending.jar.Automation.Utils.restUtils.postCall1;
import static Lending.jar.Automation.ValidateApi.Validation.resetOtpvalidate;
import static Lending.jar.Automation.ValidateApi.Validation.resetValidate;

public class OtpResetUsingExceldata
{
    @Test(description = "Resetting the Otp limit using the Excel data",priority = 1)
    public static void resetOtp() throws IOException {

        Response response = postCall1(resetOtp, HeaderHelper.OtpLimit(), fetchNumberinExcel.main(), HttpStatus.SC_OK);
        resetOtpvalidate(response);
    }

    @Test(description = "Verifying the Otp for limit reach ", priority = 2)
    public static void resetOtpVerifyLimit() throws Exception
    {
        Response response = postCall1(resetOtpVerifyLimit, HeaderHelper.OtpLimit(), fetchNumberinExcel.main(), HttpStatus.SC_OK);
        resetValidate(response);
    }
}
