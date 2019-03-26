package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ActuatorDemoController {
	private static final Logger logger=LoggerFactory.getLogger(ActuatorDemoController.class);
	
	@RequestMapping("/log")
	public String loggerDemo() {
	   getLogger();
	   return "logger test";
	}
	
	private static void getLogger() {
		logger.info("info");
		logger.warn("warn");
		logger.debug("debug");
	}
	
	

}
