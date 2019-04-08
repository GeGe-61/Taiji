package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.example.demo.filter.EncodingFilter;
import com.example.demo.filter.LoginFilter;
import com.example.demo.filter.LogoutFilter;
import com.example.demo.filter.UserFilter;

@SpringBootApplication
public class LoginDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginDemoApplication.class, args);
	}
	@Bean
	@Order(1)
	public FilterRegistrationBean encodingFilter() {
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new EncodingFilter());
		bean.addUrlPatterns("/*");
		bean.setName("encodingFilter");
	
		return bean;
				
	}
	@Bean
	@Order(3)
	public FilterRegistrationBean loginFilter() {
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new LoginFilter());
		bean.addUrlPatterns("/demoA","/demoB");
		bean.setName("loginFilter");
	
		return bean;
				
	}
	@Bean
	@Order(4)
	public FilterRegistrationBean userFilter() {
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new UserFilter());
		bean.addUrlPatterns("/demoB");
		bean.setName("userFilter");
	
		return bean;
				
	}
	@Bean
	@Order(2)
	public FilterRegistrationBean logoutFilter() {
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new LogoutFilter());
		bean.addUrlPatterns("/*");
		return bean;
				
	}
	
}
