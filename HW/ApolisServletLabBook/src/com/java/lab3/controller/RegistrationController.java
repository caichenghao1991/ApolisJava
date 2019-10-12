package com.java.lab3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.lab3.dto.User;
import com.java.lab3.service.RegisterServiceImpl;

/**
 * Servlet implementation class Solution
 */
@WebServlet("/Lab3")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterServiceImpl serviceImpl=new RegisterServiceImpl();
		PrintWriter writer = response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String password=request.getParameter("password");
		String gend=request.getParameter("gender");
		Character gender;
		if("Male".equals(gend)) {
			gender='M';
		}else {
			gender='F';
		}
		String[] skills = request.getParameterValues("skill");
		String skill="";
		for(int i=0;i<skills.length;i++) {
			if(i!=skills.length-1) {
				skill=skill+skills[i]+",";
			}else {
				skill=skill+skills[i];
			}		
		}
		String city=request.getParameter("city");
		
		User user=new User(firstname, lastname, password, gender, skill, city);
		System.out.println(user.toString());
		boolean flag=serviceImpl.createUser(user);
		if(flag) {
			response.sendRedirect("lab3/success.html");
		}else {
			response.sendRedirect("lab3/failure.html");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
