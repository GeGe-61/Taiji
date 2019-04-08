package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.User;

@RestController
public class LoginController {
	
	@GetMapping("/login")
	public String Login(User user,HttpServletRequest request) {
		HttpSession session=request.getSession();
		System.out.println(user.toString());
		if("user".equals(user.getUsername())) {
			if("user".equals(user.getPassword())) {
				session.setAttribute("user", user);
				return "success";
			}else {
				return "error";
			}
		}else if("admin".equals(user.getUsername())){
			if("admin".equals(user.getPassword())) {
				session.setAttribute("user", user);
				return "success";
			}else {
				return "error";
			}
		}

		return "";
	}
	
	@GetMapping("/demoA")
	public String demoA() {
		return "A";
	}
	@GetMapping("/demoB")
	public String demoB() {
		return "B";
	}

}
