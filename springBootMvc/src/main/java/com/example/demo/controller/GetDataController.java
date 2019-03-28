package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.User;

@RestController
public class GetDataController {
	//pojo
	@GetMapping("/getUser")
	public User getUser(User user) {
		return user;
	}
	//RequestMapping
	@RequestMapping("/getName/{name}")
	public String getName(@PathVariable String name) {	
		return name;
	}
	//直接传参
	@RequestMapping("/getAge")
	public int getAge(int age) {
		return age;	
	}
	//print
	@RequestMapping("/printName")
	public void printName(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String name=request.getParameter("name");
		PrintWriter out=response.getWriter();
		out.print(name);
	}
	//map
	@RequestMapping("/getMap")
	public Map<Object, Object> getMap(@RequestParam("map")Map<Object, Object> map){
		return map;
		
	}
}
