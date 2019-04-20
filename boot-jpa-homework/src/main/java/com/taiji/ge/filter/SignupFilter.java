package com.taiji.ge.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignupFilter implements Filter {
	
	private static Logger logger=LoggerFactory.getLogger(SignupFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("up启动");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		//获取session
		HttpSession session=req.getSession();

		
			if(session.getAttribute("user")!=null) {

			resp.sendRedirect(req.getContextPath()+"/signupFilter");
				return;
			}
			
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("up关了");
		
	}

}
