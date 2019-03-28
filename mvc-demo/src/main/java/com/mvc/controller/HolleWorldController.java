package com.mvc.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HolleWorldController {
	
	@RequestMapping("/world")
	 public String holleWorld() {
		System.out.println("helloworld");
		 return "helloWorld";
	 }
	

}
