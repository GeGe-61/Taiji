package com.mvc.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInteceptor implements HandlerInterceptor {

	private Long stratTime;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("time preHandle comming");
		stratTime=System.currentTimeMillis();
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	    System.out.println("time postHandle comming");
	
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		  System.out.println("time afterCompletion comming");
		System.out.println(System.currentTimeMillis()-stratTime);
		
	}

}
