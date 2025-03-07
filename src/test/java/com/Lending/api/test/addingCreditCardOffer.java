package com.Lending.api.test;

import Lending.jar.Automation.dataModel_S.creditCardFlow;
import Lending.jar.Automation.dataModel_S.creditCardMisStatus_I;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.*;
import static Lending.jar.Automation.Utils.restUtils.postCall1;
import static Lending.jar.Automation.Utils.restUtils.postCallWithoutBody;
import static Lending.jar.Automation.ValidateApi.Validation.CardflowValidation;
import static Lending.jar.Automation.ValidateApi.Validation.cardValidation;
import static com.Lending.api.test.authGeneration.triggerOtp;

public class addingCreditCardOffer
{
//    public static String authtoken;
//
//
//    @BeforeTest
//    public void validToken() throws Exception {
//        Response response=postCall1(verify_otp,HeaderHelper.verifyOtp1(), verifyOtp_I.objectMap(triggerOtp()),HttpStatus.SC_OK);
//        System.out.println(response.jsonPath().prettyPrint());
//        authtoken=response.jsonPath().getString("data.accessToken");
//    }


    @Test(priority = 1,description = "Adding the Offer to user")
    public void addOffer()
    {
//        Response response =postCallWithoutBody(addingOffer, HeaderHelper.cardOffer(), HttpStatus.SC_OK);
//        cardValidation(response);
        Response response = postCallWithoutBody(addingOffer, HeaderHelper.cardOffer(), HttpStatus.SC_OK);
        cardValidation(response);
    }

    @Test(priority = 2,description = "Vkyc pending and other status")
    public void vKycCompleting() throws Exception {
        Response response = postCall1(misStatus, HeaderHelper.MisStatus(), creditCardFlow.objectMapvkyc(), HttpStatus.SC_OK);
        CardflowValidation(response);
    }

    @Test(priority = 3,description = "Pushing the user to Bkyc after vkyc completion")
    public void pushedToBkyc() throws Exception {
        Response response = postCall1(misStatus, HeaderHelper.MisStatus(), creditCardMisStatus_I.objectMapBkyc(), HttpStatus.SC_OK);
        CardflowValidation(response);
    }

    @Test(priority = 4,description = "Review With Underwriter")
    public void Underwriter() throws Exception {
        Response response = postCall1(misStatus, HeaderHelper.MisStatus(), creditCardMisStatus_I.objectMapUnderwriter(), HttpStatus.SC_OK);
        CardflowValidation(response);
    }

    @Test(priority = 5,description = "In Process - DIP,In Process RCC,In Process-Risk")
    public void inProgressFlow() throws Exception {
        Response response = postCall1(misStatus, HeaderHelper.MisStatus(), creditCardMisStatus_I.objectMapinProcessFlow(), HttpStatus.SC_OK);
        CardflowValidation(response);
    }

    @Test(priority = 6,description = "Approved")
    public void approvedFlow() throws Exception {
        Response response = postCall1(misStatus, HeaderHelper.MisStatus(), creditCardMisStatus_I.objectMapinapprovedFlow(), HttpStatus.SC_OK);
        CardflowValidation(response);
    }

}
