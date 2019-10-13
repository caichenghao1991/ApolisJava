package com.java.lab1.controller;

import java.io.IOException;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.lab1.dto.User;
import com.java.lab1.repository.UserRepository;
import com.java.lab1.repository.UserRepositoryImpl;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Lab1")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		int custId= Integer.valueOf(request.getParameter("custId"));
		
		Optional<User> user=rep.getUserByUsername(name,custId);
		
		if(!user.isPresent() || !user.get().getUsername().equals(name)) {
			//writer.println("Invalid credentials!");
			request.setAttribute("message", "Invalid Credentials");		     
			request.getRequestDispatcher("lab1c/failure.html").forward(request, response);
			//response.sendRedirect("success.jsp");
		}else {
			request.getSession().setAttribute("user",user.get());
			response.sendRedirect("lab1c/user_info.jsp");	
		}


	}

}
