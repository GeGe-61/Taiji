package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class thymeleafController {

	@RequestMapping("/getThymeleaf")
	public String getJson(Model model) {
		model.addAttribute("name","gege");
		return "thyme";
	}

}
