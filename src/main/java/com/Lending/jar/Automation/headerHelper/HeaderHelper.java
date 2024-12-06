package Lending.jar.Automation.headerHelper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static Lending.jar.Automation.Constant.configConstant.*;
import static Lending.jar.Automation.Constant.headerConstants.*;



public class HeaderHelper
{
//    headerHelper for getting Amount+Emi screen queries and Answers
    public static RequestSpecification amountEmi()
    {

        return new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .addQueryParam("screenType", "DRAW_DOWN")
                .addHeader("Authorization", "Bearer "+ authToken)
                .build();
    }

//    headerHelper for getting Aadhaar KYC screen queries and Answers
    public static RequestSpecification aadhaarKyc()
    {
        return new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .addQueryParam("screenType","AADHAAR")
                .addHeader("Authorization","Bearer "+authToken)
                .build();
    }

//    headerHelper for Resetting the Otp limit reach for login
    public static RequestSpecification OtpLimit()
    {
        return  new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .addHeader("Authorization",basicAuth)
                .build();
    }

//    headerHelper for Resetting the Otp limit reach for loan Agreement
    public static RequestSpecification loanOtp()
    {
        return new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .addHeader("Authorization",basicAuth)
                .addQueryParam("type","LOAN_AGREEMENT")
                .build();
    }

//    headerHelper for valiadtion of Mongo Db

    public static RequestSpecification mongoDbUserdeviceDetails()
    {
        return new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .addHeader("Authorization","Bearer " +authToken)
                .build();

    }

//    headerHelper for Sending the Otp

    public static RequestSpecification sendOtp()
    {
        return new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .addQueryParam("phoneNumber","9611055312")
                .addQueryParam("countryCode","91")
                .build();

    }

//     headerHelper for Verification of Otp sent to the Number

    public static RequestSpecification verifyOtp1()
    {
        return new RequestSpecBuilder()
                .setBaseUri(StagingBaseUri)
                .setContentType(contentType)
                .build();

    }

// Json schema validator for example api
    public static RequestSpecification jsonSchemaValidator(){
        return new RequestSpecBuilder()
                .setBaseUri(exampleUrl)
                .build();
    }

//  json schema validator for rule engine Api
    public static RequestSpecification jsonSchemaRuleEngine(){
         return new RequestSpecBuilder()
                 .setBaseUri(edgeStageUrl)
                 .setContentType(contentType)
                 .build();
    }

//    adding user to Webflow or Real time flow
    public static RequestSpecification addingUser()
    {
        return new RequestSpecBuilder()
                .setBaseUri(PRbaseUrl)
                .setContentType(contentType)
                .addHeader("Authorization",prod_AuthToken)
                .build();
    }

//    practice nested and Array post API
    public static RequestSpecification nestedandArray()
    {
        return new RequestSpecBuilder()
                .setBaseUri(practiceUrl)
                .setContentType(contentType)
                .build();
    }

}



