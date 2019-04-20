package com.security.demo.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.security.demo.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;
	//圆形搜索
	@GetMapping("/withinCenter")
	public List<Document> withinCenter(){
		DBObject field=new BasicDBObject();
		int limit=3;

		List<Document> listFinal=testService.withinCenter("location", "loc"
				,field, limit);
		
		for (Document document : listFinal) {
			System.out.println(document);
		}
		return listFinal;
	}

}
