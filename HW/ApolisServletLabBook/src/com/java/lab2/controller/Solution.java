package com.java.lab2.controller;

import java.io.IOException;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.lab2.dto.User;
import com.java.lab2.repository.UserRepository;
import com.java.lab2.repository.UserRepositoryImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Lab2")
public class Solution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Solution() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserRepository rep= (UserRepository) new UserRepositoryImpl();
		String name=request.getParameter("username");
		String password= request.getParameter("password");
		Optional<User> user=rep.getUserByUsername(name);
		
		String mimeType = request.getContentType();
		System.out.println("get Content Type = "+ mimeType);
		System.out.println("Locale setting = "+ request.getLocale().toString());
	
			int len = request.getContentLength();
			ServletInputStream is=request.getInputStream();
			byte[] buffer = new byte[len];
			System.out.println(is.read(buffer, 0, len));
			
		
		if(!user.isPresent() || !user.get().getPassword().equals(password)) {
			//writer.println("Invalid credentials!");
			request.setAttribute("message", "Invalid Credentials");
			 
		     
	
		     
			request.getRequestDispatcher("/lab2/failure.html").forward(request, response);
			//response.sendRedirect("success.jsp");
		}else {
			response.sendRedirect("lab2/success.html");
	
		}


	}

}
