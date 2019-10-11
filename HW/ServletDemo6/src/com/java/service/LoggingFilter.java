package com.java.service;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebFilter(urlPatterns= {"/addItem","/removeItem","/moveToDeleteItem"})
public class LoggingFilter implements Filter{

/*	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		HttpSession session=req.getSession();
		if(session.getAttribute("user")==null) {
			res.sendRedirect("login.html");
			System.out.println("Login first");
		}
		
		chain.doFilter(request, response);//go to the other filter/controller
		
		
		
		
	}

	/*@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}*/
}
