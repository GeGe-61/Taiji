package com.mvc.controller;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.mvc.po.User;

@Controller
//@SessionAttributes(value="username")
public class LoginController {

	
	@RequestMapping("/login")
	@ResponseBody
	public User login(User user)  {
	 
	return user;
	}

	@RequestMapping("/index")
	public String index() {
		System.out.println("index");
		return "login";
	}
	@GetMapping("/One")
	public String findOne(Model model,HttpServletRequest request) {
//		Locale currentLocale=RequestContextUtils.getLocale(request);
////		
////	String lang=currentLocale.getLanguage();
//		
//		ResourceBundle resourceBundle=ResourceBundle.getBundle("message",currentLocale);
//		
//		String name=resourceBundle.getString(key);
//		
//		model.addAttribute(name);
		return "success";
		}
	}
