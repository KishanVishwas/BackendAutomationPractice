package Lending.jar.Automation.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class restUtils {

    // Post Call
    public static Response postCall(String url, Map<String, String> headers, Map<String, Object> body,int statusCode) {

        return RestAssured.given().headers(headers).body(body).expect().statusCode(statusCode).then().log().ifError().when().post(url);

    }
    // Post Call
    public static Response postCall1(String url, RequestSpecification headers, Map<String, Object> body,int statusCode) {

        return given(headers).body(body).log().all().expect().statusCode(statusCode).then().log().ifError().when().post(url);

    }

    // Post Call without a body
    public static Response postCallWithoutBody(String url, RequestSpecification headers, int statusCode) {
        return given(headers).log().all().expect().statusCode(statusCode).then().log().all().when().post(url);
    }


//    Get call

    public static Response getCallWithoutBodyPut(String url, RequestSpecification headers, int statusCode) {
        return given(headers).log().all().expect().statusCode(statusCode).then().log().all().when().get(url);
    }


//    Put call

    public static Response putcall(String url,int statusCode,String inputBody,Map<String,String> headers)
    {
        return given().headers(headers).contentType(ContentType.JSON).body(inputBody).log().everything().expect().statusCode(statusCode).then().log().ifError().when().put(url);
    }

//    Delete Call

    public static Response deleteCall(String url,int statusCode , Map<String, String> headers, Map<String, String> pathParams){
        return given().headers(headers).pathParams(pathParams).contentType(ContentType.JSON).expect().statusCode(statusCode).log().everything().then().log().ifError().when().delete(url);
    }

//get call with body
    public static Response getCall(String url, Map<String, String> headers, Map<String, String> pathParams, int statusCode) {
        return RestAssured.given().contentType(ContentType.JSON).headers(headers).pathParams(pathParams).log().everything().expect().statusCode(statusCode).log().ifError().when().get(url, new Object[0]);


}


}
