package com.example.demo.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
	@Autowired
	private ConfigBean configBean;
	
	
	
	@RequestMapping("/ge")
	public void index() {
       System.out.println(configBean.getAge());
	}

}
