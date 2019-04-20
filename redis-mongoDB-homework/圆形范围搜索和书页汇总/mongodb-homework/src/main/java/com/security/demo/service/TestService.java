package com.security.demo.service;

import java.util.List;

import org.bson.Document;

import com.mongodb.DBObject;

public interface TestService {
	
	List<Document> withinCenter(String collection, String locationField,
			  DBObject fields, int limit);

}
