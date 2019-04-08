package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutFilter implements Filter{
	private static Logger logger= LoggerFactory.getLogger(LogoutFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("logout开了");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		
		HttpSession session=req.getSession(false);
		
		String path=req.getServletPath();
		if("/logout".equals(path)) {
			if(session==null&&session.getAttribute("user")==null) {
				response.getWriter().write("null");
			}else {
				response.getWriter().write("登出成功");
				req.getSession().removeAttribute("user");
			}
			
		}else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
