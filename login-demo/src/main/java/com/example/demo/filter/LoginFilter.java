package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


public class LoginFilter implements Filter{
	private static Logger logger= LoggerFactory.getLogger(LoginFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	logger.info("loginFilter启动");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest re=(HttpServletRequest) request;
		if(!StringUtils.isEmpty(re.getSession().getAttribute("user"))){
			chain.doFilter(request, response);
			
		}else {
//			response.setCharacterEncoding("GBK");
			response.getWriter().write("没登录老弟");
			logger.info("没登录");
		}
		
	}

	@Override
	public void destroy() {
		logger.info("loginFilter关了");
		
	}

}
