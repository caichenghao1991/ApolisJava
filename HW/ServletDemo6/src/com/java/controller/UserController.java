package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.repository.UserRepository;
import com.java.repository.UserRepositoryImpl;
import com.java.dto.Gender;
import com.java.dto.User;
/**
 * Servlet implementation class LoginController2
 */
//@WebServlet("/User")   
@WebServlet(urlPatterns= {"/login","/logout","/register"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository rep= (UserRepository) new UserRepositoryImpl();
	public static HashSet<String> loginCount=new HashSet<String>();
	public static HashSet<String> loginCount2=new HashSet<String>();
	public static int visitorsCount;
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getRequestURI();
		System.out.println(operation);
		request.setCharacterEncoding("UTF-8");
	
		PrintWriter writer=response.getWriter();
		if (operation.indexOf("login")!=-1) { 
			
			String name=request.getParameter("username");
			String password= request.getParameter("password");
			Optional<User> user=rep.getUserByUsername(name);
			if(!user.isPresent() || !user.get().getPassword().equals(password)) {
				request.setAttribute("message", "Invalid Credentials");
				//request.getRequestDispatcher("/register.html").forward(request, response);				
				response.sendRedirect("register.html");			
			}else {
				request.setAttribute("user", user);
				request.getSession().setAttribute("user", user.get());
				//System.out.println(user.get().getUsername());
				response.addCookie(new Cookie("username", user.get().getUsername()));
					
				request.getRequestDispatcher("/addItem.html").forward(request, response);
				
				
			}
			
		} else if (operation.indexOf("register")!=-1) {
			String name=request.getParameter("username");
			String password= request.getParameter("password");
			Optional<User> user=rep.getUserByUsername(name);
			if(!user.isPresent() ) {
				//writer.println("Invalid credentials!");
				UserRepository repo=new UserRepositoryImpl();
				User user2=new User(name, password);
				repo.createUser(user2);
				request.setAttribute("user", user2);
				request.getSession().setAttribute("user", user2);
				request.getRequestDispatcher("/login.html").forward(request, response);
				
				
			}else {
				writer.println("already exist "+ name);
			}
		
		}else if (operation.indexOf("logout")!=-1) {
			request.getSession().invalidate();
			response.sendRedirect("login.html");			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}


}


