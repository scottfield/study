package com.jackie.mongo.demo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Jackie on 2016/8/17.
 */
public class MongoDbDemo {
    public static void main(String[] args) {
        MongoClient mongoClient;
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://test:test@120.24.84.72/?authSource=tyrz&authMechanism=SCRAM-SHA-1");
        mongoClient = new MongoClient(mongoClientURI);
//			// 获取名为 dbxt 的数据库，不存在的情况下创建
        MongoDatabase db = mongoClient.getDatabase("tyrz");
        MongoCollection<Document> tyrz = db.getCollection("tyrz");
        Document document = new Document();
        document.put("key", "value");
        document.put("jackie", "jackiewang");
        tyrz.insertOne(document);
        System.out.println(db);
    }
}
