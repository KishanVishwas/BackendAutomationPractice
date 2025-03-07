package Lending.jar.Automation.ValidateApi;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Validation
{
    public static void resetOtpvalidate(Response response)
    {
        String status = response.jsonPath().getString("success");
        Assert.assertEquals(status, "true");

    }

    public static void resetValidate(Response response)
    {

        String success=response.jsonPath().getString("success");
        String data=response.jsonPath().getString("data");
        Assert.assertEquals(success, "true");
        Assert.assertEquals(data, "true");


    }

    public static void chatBot(Response response)
    {
        String status=response.jsonPath().getString("success");
        Assert.assertEquals(status, "true");

    }

    public static void CommonValidation(Response response)
    {
        String status = response.jsonPath().getString("success");
        Assert.assertEquals(status, "true");
    }

    public static void loginOtpValidate(Response response)
    {
        String status = response.jsonPath().getString("success");
        Assert.assertEquals(status, "true");
    }

    public static void cardValidation(Response response)
    {

        String success=response.jsonPath().getString("success");
        String data=response.jsonPath().getString("data");
        Assert.assertEquals(success, "true");
        Assert.assertEquals(data, "Credit card offers added successfully");

    }

    public static void CardflowValidation(Response response)
    {

        String success=response.jsonPath().getString("success");
        String data=response.jsonPath().getString("data");
        Assert.assertEquals(success, "true");
        Assert.assertEquals(data, "Application mis status is processed successfully");


    }

}
