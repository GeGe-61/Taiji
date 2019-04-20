package com.taiji.ge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.taiji.ge.domain.User;
import com.taiji.ge.service.UserService;

@Controller
public class UserLoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	 public String login(Model model) {
		User user=new User();
		model.addAttribute(user);
		 return "Login";
	 }
	@PostMapping("/submitLogin")
	public String loginSuccess(@Validated User user,BindingResult brequest,HttpServletRequest request,Model model) {

		if(userService.findOneUser(user)==null) {
			FieldError error=new FieldError("user", "username", "用户名或密码错误");
			brequest.addError(error);
			return "Login";
		}
		if(brequest.hasErrors()) {
			return "Login";
		}
		List<User> userList=userService.findAllUser();
		model.addAttribute("userList",userList);
		
		
		
		return "LoginSuccess";
	}
}
