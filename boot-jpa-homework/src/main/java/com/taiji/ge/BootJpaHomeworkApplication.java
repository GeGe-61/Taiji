package com.taiji.ge;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.taiji.ge.filter.SignupFilter;
@SpringBootApplication
public class BootJpaHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJpaHomeworkApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean  signupFilter() {
		FilterRegistrationBean bean=new FilterRegistrationBean();
		
		bean.setFilter(new SignupFilter());
		//设置拦截路径
		bean.addUrlPatterns("/submitSignUp");
		return bean;
	}
//
//	@Bean
//	public InternalResourceViewResolver setupViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		/** 设置视图路径的前缀 */
//		resolver.setPrefix("/");
//		/** 设置视图路径的后缀 */
//		resolver.setSuffix(".html");
//		return resolver;
//
//	}
}
