package Lending.jar.Automation.Helper;

import Lending.jar.Automation.Constant.configConstant;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Dbhelper {

    private static MongoClient mongoClient;

    public static Document document;

    // initialising the Mongo client and Connecting to the Mongo server

    @BeforeClass(groups = "Group1")
    public static void initializeMongoClient() {
        // Connecting to the MongoDB instance
        mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(configConstant.mongoDbUrl_St))
                .applyToSocketSettings(builder -> builder.connectTimeout(60, SECONDS))
                .build());
        System.out.println("DB connected");
    }

    // Utils for to get the response from sending the request

    public static Document fetchDataFromDB (String collection, String filterKey, String value, String sortField){
        initializeMongoClient();
        // Selecting the database
        MongoDatabase db = mongoClient.getDatabase(configConstant.DB_NAME);
        // Selecting the collection
        MongoCollection<Document> dbCollection = db.getCollection(collection);
        // Query to get the exact object that we are searching from the DB
        Document query = new Document(filterKey, value);
        // Sort the result in descending order based on the specified field
        Document sort = new Document(sortField, -1);
        // Execute the query and get the result set
        try (MongoCursor<Document> cursor = dbCollection.find(query).sort(sort).limit(2).iterator()) {
            while (cursor.hasNext()) {
                document = cursor.next();
                return document;
                // Accessing data from the retrieved document
//                data = document.getString(key);
//                System.out.println(data);
            }
        } catch (Exception e) {
            // Print any exceptions that might occur
            e.printStackTrace();
        }
        return query;
    }

    // Utils for to get the response from sending the request

    public static Document fetchObjectDataFromDB (String collection, String filterKey, Object value, String sortField){
        initializeMongoClient();
        // Selecting the database
        MongoDatabase db = mongoClient.getDatabase(configConstant.DB_NAME);
        // Selecting the collection
        MongoCollection<Document> dbCollection = db.getCollection(collection);
        // Query to get the exact object that we are searching from the DB
        Document query = new Document(filterKey, value);
        // Sort the result in descending order based on the specified field
        Document sort = new Document(sortField, -1);
        // Execute the query and get the result set
        try (MongoCursor<Document> cursor = dbCollection.find(query).sort(sort).limit(1).iterator()) {
            while (cursor.hasNext()) {
                document = cursor.next();
                return document;
                // Accessing data from the retrieved document
//                data = document.getString(key);
//                System.out.println(data);
            }
        } catch (Exception e) {
            // Print any exceptions that might occur
            e.printStackTrace();
        }
        return query;
    }


    // Utils for to get the response from sending the request , taking the otp from the Auth table
    public static Document fetchDataFromAuth(String collection, String filterKey, String value, String sortField)
    {
        initializeMongoClient();
        // Selecting the database
        MongoDatabase db = mongoClient.getDatabase(configConstant.OTP_DB_NAME);
        // Selecting the collection
        MongoCollection<Document> dbCollection = db.getCollection(collection);
        // Query to get the exact object that we are searching from the DB
        Document query = new Document(filterKey, value);
        // Sort the result in descending order based on the specified field
        Document sort = new Document(sortField, -1);
// db.getCollection('renewals').find({"userId":"660b10b7ff22c21113c41d05"})
        // Execute the query and get the result set
        try (MongoCursor<Document> cursor = dbCollection.find(query).sort(sort).limit(1).iterator()) {
            while (cursor.hasNext()) {
                document = cursor.next();
                return document;
                // Accessing data from the retrieved document
//                data = document.getString(key);
//                System.out.println(data);
            }
        } catch (Exception e) {
            // Print any exceptions that might occur
            e.printStackTrace();
        }
        return query;
    }

    // this is for reference

   /* public static Document fetchSecondDataFromDB (String collection, String filterKey, String value, String
        sortField){
            initializeMongoClient();
            // Selecting the database
            MongoDatabase db = mongoClient.getDatabase(ConfigConstants.DB_NAME);
            // Selecting the collection
            MongoCollection<Document> dbCollection = db.getCollection(collection);
            Document query = new Document(filterKey, value);
            // Sort the result in descending order based on the specified field
            Document sort = new Document(sortField, -1);
            // Execute the query and get the result set
            try (MongoCursor<Document> cursor = dbCollection.find(query).sort(sort).limit(2).iterator()) {
                cursor.tryNext();
                while (cursor.hasNext()) {
                    document = cursor.next();
                    Document secondDocument = cursor.next();
                    return secondDocument;
                    // Accessing data from the retrieved document
//                data = document.getString(key);
//                System.out.println(data);
                }
            } catch (Exception e) {
                // Print any exceptions that might occur
                e.printStackTrace();
            }
            return query;
        }*/
}
