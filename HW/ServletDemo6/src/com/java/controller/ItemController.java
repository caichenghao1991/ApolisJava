package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class BookController
 */
@WebServlet(urlPatterns= {"/addItem","/removeItem","/moveToDeleteItem"})
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] item= {"apple","banana","pear"};
		String operation=request.getRequestURI();
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		PrintWriter writer=response.getWriter();
		if (operation.indexOf("addItem")!=-1) { 
		
			String[] fruit = request.getParameterValues("fruit");
			ArrayList<String> info=new ArrayList<String>();
			if(fruit!=null) {
				for(int j=0;j<fruit.length;j++){
				if(fruit[j]!=null) {
					if(session.getAttribute(fruit[j])!=null) {
						session.setAttribute(fruit[j], (int)session.getAttribute(fruit[j])+1);
					}else {
						session.setAttribute(fruit[j], 1);
					}				
				}
				}
			}
			
			//request.getRequestDispatcher("/viewItem.html").forward(request, response);
			writer.write("<p>Your current inventory:</p>");
			for(String s:item) {
				if(session.getAttribute(s)!=null) {
					writer.write("<p>"+s+":"+session.getAttribute(s)+"</p>");
				}
			}
			writer.write("<p><form action='logout' method='post'><input type='submit' value='log out'/></form></p>");
			writer.write("<p><form action='moveToDeleteItem' method='post'> <input type='submit' value='remove my Item'/></form></p>");
			operation=request.getRequestURI();
		}else if (operation.indexOf("moveToDeleteItem")!=-1) { 
			request.getRequestDispatcher("/removeItem.html").forward(request, response);
			
		}else if (operation.indexOf("removeItem")!=-1) { 
			String[] fruit = request.getParameterValues("fruit");
			ArrayList<String> info=new ArrayList<String>();
			if(fruit!=null) {
				for(int j=0;j<fruit.length;j++){
				if(fruit[j]!=null) {
					if(session.getAttribute(fruit[j])!=null && (int)session.getAttribute(fruit[j])>=1) {
						session.setAttribute(fruit[j], (int)session.getAttribute(fruit[j])-1);
					}else {
						session.setAttribute(fruit[j], 0);
					}				
				}
				}
			}
			request.getRequestDispatcher("/addItem.html").forward(request, response);
			
			
		}
		
		
	}

}
