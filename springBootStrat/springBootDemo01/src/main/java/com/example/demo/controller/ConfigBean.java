package com.example.demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix="my")
//@PropertySource(value = "classpath:application.properties")
@Data
@ToString
public class ConfigBean {

	private String name;
	private int age;
	
	

}
