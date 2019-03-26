package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@Autowired
	private ConfigBean configBean;
	
	
	@RequestMapping("/ge")
	public String index() {
//		System.out.println(configBean.getName());
		return configBean.toString();
//		return "hi!"+configBean.getName()+configBean.getAge();
	}

}
