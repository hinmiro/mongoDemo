package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class MongoService {
    private final String DATABASE_NAME = "db name";
    private final String COLLECTION_NAME = "collection";
    private final String CONNECTION_URI = "mongodb+srv://mongoDB url"; // Replace to actual url

    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    public MongoService() {
        mongoClient = MongoClients.create(CONNECTION_URI);
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    public void add(String id, String name, String age, String city) {
        Document document = new Document("id", id)
                .append("name", name)
                .append("age", age)
                .append("city", city);
        collection.insertOne(document);
        System.out.println("Document inserted: " + document.toJson());
    }

    public void delete(String id) {
        collection.deleteOne(Filters.eq("id", id));
        System.out.println("Document with ID " + id + " deleted.");
    }

    public void update(String id, String name, String age, String city) {
        collection.updateOne(Filters.eq("id", id),
                Updates.combine(
                        Updates.set("name", name),
                        Updates.set("age", age),
                        Updates.set("city", city)
                ));
        System.out.println("Document with ID " + id + " updated.");
    }

    public String read(String id) {
        Document document = collection.find(Filters.eq("id", id)).first();
        if (document != null) {
            System.out.println("Document found: " + document.toJson());
            return document.toString();
        } else {
            System.out.println("Document with ID " + id + " not found.");
            return null;
        }
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }
}

