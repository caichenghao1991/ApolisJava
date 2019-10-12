package com.java.lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page1
 */
@WebServlet("/NextPage")
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
		System.out.println("get");
		String status=request.getParameter("remember");
		if(status!=null) {
			Cookie cookie=new Cookie("remeber","yes");
			cookie.setMaxAge(20);
			response.addCookie(cookie);

			
		}
		response.sendRedirect("lab6/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
	
		System.out.println("post");
		if(cookies==null) {
			response.sendRedirect("lab6/welcome.html");
		}else {
			boolean flag=false;
			for(Cookie cookie: cookies) {
				if("remember".equals(cookie.getName())) {
					if("yes".equals(cookie.getValue()))
						flag=true;
					}
			}
			if(flag) {
				response.sendRedirect("lab6/login.html");
			}
		}
		
		
	}

}
