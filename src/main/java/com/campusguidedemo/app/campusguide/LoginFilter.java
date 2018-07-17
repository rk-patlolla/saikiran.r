package com.campusguidedemo.app.campusguide;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class LoginFilter implements Filter {
	public static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {HttpServletRequest req = (HttpServletRequest) request;	
			logger.info(
			         "Starting a transaction for req : {}",
			         req.getRequestURI());
			 
			       chain.doFilter(request, response);
			       logger.info(
			         "Committing a transaction for req : {}",
			         req.getRequestURI());
		}catch(Exception e){
			e.printStackTrace();
		} 
	
	}

}
