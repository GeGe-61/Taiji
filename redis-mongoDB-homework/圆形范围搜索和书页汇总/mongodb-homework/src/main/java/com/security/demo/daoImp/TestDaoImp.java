package com.security.demo.daoImp;


import com.mongodb.AggregationOptions;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.data.geo.Point;
import com.security.demo.dao.TestDao;
@Component
public class TestDaoImp implements TestDao{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Document> withinCenter(String collection, String locationField, 
			DBObject fields, int limit) {
	
		Bson bsonCenter = Filters.geoWithinCenter(locationField, 10, 10, 30); 
//		FindIterable findIterable = mongoTemplate.getCollection(collection).find(bsonCenter);
//		MongoCursor<Document> mongoCursor1 = findIterable.iterator();
	
		MongoCursor<Document> mongoCursor = mongoTemplate.getCollection(collection).find(bsonCenter).limit(limit).iterator();
		List<Document> result = new ArrayList<Document>();
		while(mongoCursor.hasNext()){
			result.add(mongoCursor.next());
		}
		return result;
	}


}
