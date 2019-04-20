package com.taiji.ge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taiji.ge.domain.User;
import com.taiji.ge.service.UserService;

@Controller
public class UserSignUpController {
	
	@Autowired
	private UserService userService;
	//返回注册页面
	@GetMapping("/signUp")
	public String signUp(@ModelAttribute("user")User user) {
		System.out.println("进来了");
		
		return "SignUp";
	}
	
	//提交表单
	@PostMapping("/submitSignUp")
	public String submitSignUp(@Validated User user,BindingResult result,Model model,HttpServletRequest request) {
  
		if(!(user.getEmail().contains(user.getUsername()))) {
			FieldError error=new FieldError("user", "email", "Email必须包含用户名");
			result.addError(error);
			return "signup";
		}
		if(result.hasErrors()) {
			return "signup";
		}
		
      
		if(userService.saveUser(user)==null) {
			return "signup";
		}else {
			System.out.println(user.toString());
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
		
		}
		
		return "UpSuccess";
	}
	
	@GetMapping("/signupFilter")
	public String registered() {
		
		return "Inteceptor";
	}

}
