package com.Lending.api.test;

import Lending.jar.Automation.Helper.Dbhelper;
import Lending.jar.Automation.dataModel_S.verifyOtp_I;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.configConstant.*;
import static Lending.jar.Automation.Constant.headerConstants.phoneNumber;
import static Lending.jar.Automation.Constant.uriConstant.loginOtp;
import static Lending.jar.Automation.Constant.uriConstant.verify_otp;
import static Lending.jar.Automation.Helper.Dbhelper.document;
import static Lending.jar.Automation.Utils.restUtils.postCall1;
import static Lending.jar.Automation.Utils.restUtils.postCallWithoutBody;


public class authGeneration
{


   //@org.jetbrains.annotations.NotNull
   @Test(description = "triggering the OTP to requested number", priority = 1)
    public static String triggerOtp() throws Exception {
        Response response = postCallWithoutBody(loginOtp, HeaderHelper.sendOtp(), HttpStatus.SC_OK);

        Dbhelper.fetchDataFromAuth(Otp_collectionName,"number",countryCode+phoneNumber,sortField);
        String message = document.getString("content");
        String otp = message.replaceAll("\\D+", "").substring(0, 6);
        System.out.println("Verification code: " + otp);
        System.out.println(otp);
        System.out.println(document);
        return otp;

    }

    @Test(description = "generating Auth token and storing in a variable",priority = 2)
    public static void generateToken() throws Exception
    {
        Response response=postCall1(verify_otp,HeaderHelper.verifyOtp1(), verifyOtp_I.objectMap(triggerOtp()),HttpStatus.SC_OK);
        System.out.println(response.jsonPath().prettyPrint());


    }
}
