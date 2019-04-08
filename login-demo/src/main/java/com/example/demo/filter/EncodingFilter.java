package com.example.demo.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EncodingFilter implements Filter{
	private static Logger logger=LoggerFactory.getLogger(EncodingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("GBK开了");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
	       request.setCharacterEncoding("gbk");
	       response.setCharacterEncoding("gbk");
	       chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
