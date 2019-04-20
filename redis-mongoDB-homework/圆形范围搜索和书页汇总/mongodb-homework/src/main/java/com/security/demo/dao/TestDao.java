package com.security.demo.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.DBObject;

public interface TestDao {
	
	List<Document> withinCenter(String collection, String locationField,
			  DBObject fields, int limit);
	
}
