package com.Lending.api.test;

import Lending.jar.Automation.Utils.MongoDBUtils;
import Lending.jar.Automation.dataModel_S.deviceDetails_I;
import Lending.jar.Automation.headerHelper.HeaderHelper;
import com.mongodb.client.MongoCollection;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.bson.Document;
import org.testng.annotations.Test;

import static Lending.jar.Automation.Constant.headerConstants.userId;
import static Lending.jar.Automation.Constant.uriConstant.userDeviceDetails;
import static Lending.jar.Automation.Utils.restUtils.postCall1;


public class UserDeviceDetailsMongoDb
{
    @Test(description = "DB validation for UserDevice details ",priority = 1)
    public static void mongoDbUserDevice() throws Exception {

        Response response = postCall1(userDeviceDetails, HeaderHelper.mongoDbUserdeviceDetails(), deviceDetails_I.objectMap(), HttpStatus.SC_OK);

        String apiUserId = response.jsonPath().getString("userId");
        String apiDeviceId = response.jsonPath().getString("deviceDetails.deviceId");
        String apiAdvertisingId = response.jsonPath().getString("deviceDetails.advertisingId");
        String apiAppsFlyerId = response.jsonPath().getString("appsFlyerId");

        System.out.println(apiDeviceId);
        System.out.println(apiAdvertisingId);
        System.out.println(apiUserId);
        System.out.println(apiAppsFlyerId);


        MongoCollection<Document> collection = MongoDBUtils.getCollection("userDeviceDetails");
        Document query = new Document("userId", userId);
        Document dbRecord = collection.find(query).first();


        boolean recordFoundInDb = false;
        String dbUserId;
        String dbDeviceId;
        String dbAdvertisingId;
        String dbAppsFlyerId;
        if (dbRecord != null) {
            dbUserId = dbRecord.getString("userId");
            Document dbDeviceDetails = (Document) dbRecord.get("deviceDetails");
            dbAdvertisingId = dbDeviceDetails.getString("advertisingId");
            dbDeviceId = dbDeviceDetails.getString("deviceId");
            dbAppsFlyerId=dbRecord.getString("appsFlyerId");

            System.out.println(dbUserId);
            System.out.println(dbDeviceId);
            System.out.println(dbAdvertisingId);
            System.out.println(dbDeviceDetails);

        if (apiUserId.equals(dbUserId) && apiDeviceId.equals(dbDeviceId) && apiAdvertisingId.equals(dbAdvertisingId) &&
                apiAppsFlyerId.equals(dbAppsFlyerId))
        {

            recordFoundInDb=true;
        }


        }

    }
}
