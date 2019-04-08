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


import com.example.demo.po.User;

public class UserFilter implements Filter{
	private static Logger logger= LoggerFactory.getLogger(UserFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	logger.info("userFilter启动");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest re=(HttpServletRequest) request;
		User user=(User) re.getSession().getAttribute("user");
		if("admin".equals(user.getUsername())){
			chain.doFilter(request, response);

		}else if("user".equals(user.getUsername())){
//			response.setCharacterEncoding("GBK");
			response.getWriter().write("你不是admin");
			logger.info("你不是admin");
		}
		
	}

	@Override
	public void destroy() {
		logger.info("userFilter关了");
		
	}

}
