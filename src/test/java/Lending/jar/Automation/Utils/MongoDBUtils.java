package Lending.jar.Automation.Utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static Lending.jar.Automation.Constant.configConstant.mongoDbUrl_St;

public class MongoDBUtils
{

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getMongoDatabase()
    {
        if (mongoClient==null)
        {
            mongoClient= MongoClients.create(mongoDbUrl_St);
            database=mongoClient.getDatabase("Staging");
        }
        return database;
    }

    public static MongoCollection<Document> getCollection(String collectionName)
    {
        return getMongoDatabase().getCollection(collectionName);
    }
}
