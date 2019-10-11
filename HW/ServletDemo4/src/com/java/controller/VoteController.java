package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/vote")
public class VoteController extends HttpServlet {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	HashMap<String, Integer> map=new HashMap<String,Integer>();
	{
		 
		map.put("apple", 0);
		map.put("pear", 0);
		map.put("banana", 0);
		
	}
	Set<String> address=new HashSet<>();
	// url : get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter writer = resp.getWriter();
		int i = 0;
		
		
		
		if (address.contains(req.getRemoteAddr())) {
			writer.println("You can only vote once");	
			
			System.out.println(address.size());
			i++;
		}
		address.add(req.getRemoteAddr());
		
		
		
		if (i == 0) {
			resp.addCookie(new Cookie("d",null));
			String[] fruit = req.getParameterValues("fruit");
			ArrayList<String> info=new ArrayList<String>();
		//System.out.println(fruit.length);
			for(int j=0;j<fruit.length;j++){
				if(fruit[j]!=null) {
					if(!map.containsKey(fruit[j])) {
						map.put(fruit[j], 0);
					}
					map.replace(fruit[j],map.get(fruit[j])+1);
				}else {
					map.put(fruit[j], 0);
				}
			}
			writer.println("<p>Current vote:</p>");
	
			for(String k:map.keySet()) {
				writer.println("<p>"+k+":"+map.get(k)+"</p>");
			}
			
		
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
