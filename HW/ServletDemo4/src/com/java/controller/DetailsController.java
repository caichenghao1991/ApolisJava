package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class DetailsController extends HttpServlet{

	private static final long serialVersionUID = -3236321237138001935L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer=resp.getWriter();
		
	    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
	    resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        resp.setDateHeader("Expires", 0);
		writer.println( "<a href='./logout'>Logout</a><br/>");
		writer.println( "<a href='./login.html'>Home Page</a><br/>");
		Cookie[] cookies=req.getCookies();
		String username= "";
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("username")) {
				username=cookie.getValue();
			}
		}
		writer.println("Hello "+ username+"<br/>");
		writer.println("Your details are:<br/>");
		writer.println( "Date of birth: "+ req.getParameter("dob")+"<br/>");
		writer.println( "Address: "+ req.getParameter("address")+"<br/>");
		writer.println( "Phone Number: "+ req.getParameter("phNo")+"<br/>");
		writer.println( "Gender: "+ req.getParameter("gender")+"<br/>");
		
	}
	
}
