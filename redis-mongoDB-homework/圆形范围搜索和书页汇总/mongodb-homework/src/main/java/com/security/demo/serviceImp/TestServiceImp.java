package com.security.demo.serviceImp;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.security.demo.dao.TestDao;
import com.security.demo.service.TestService;
@Service
public class TestServiceImp implements TestService {
	@Autowired
	private TestDao testDao;

	@Override
	public List<Document> withinCenter(String collection, String locationField, DBObject fields,
			int limit) {
		return testDao.withinCenter(collection, locationField, fields,limit);
	}



	

}
