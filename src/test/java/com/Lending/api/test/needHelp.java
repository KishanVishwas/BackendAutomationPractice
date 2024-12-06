package com.Lending.api.test;


import Lending.jar.Automation.ValidateApi.Validation;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.uriConstant.getAnswers;
import static Lending.jar.Automation.Utils.restUtils.getCallWithoutBodyPut;
import static Lending.jar.Automation.ValidateApi.Validation.chatBot;


public class needHelp
{

    @Test(description = "Amount+ Emi screen need help chat bot qsn and Answers",priority = 1)
    public void amount_Emiscreen()
    {
        Response response =getCallWithoutBodyPut(getAnswers, HeaderHelper.amountEmi(),HttpStatus.SC_OK);
        chatBot(response);
    }

    @Test(description = "Kyc screens need help chat bot qsn and Answers",priority = 2)
    public void kycScreenAns()
    {
        Response response=getCallWithoutBodyPut(getAnswers, HeaderHelper.aadhaarKyc(),HttpStatus.SC_OK);
        chatBot(response);
    }

}
