package com.java.lab5.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.lab5.dto.Bill;
import com.java.lab5.dto.User;
import com.java.lab5.service.EBillServiceImpl;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/Lab5Bill")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillController() {
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
		
		EBillServiceImpl service=new EBillServiceImpl();
		PrintWriter writer = response.getWriter();
		User user=(User)request.getSession().getAttribute("user");
		int custId2=user.getCustId();
		int custId=Integer.valueOf(request.getParameter("custId"));
		double currentReading= Double.valueOf(request.getParameter("curRead"));
		double lastReading= Double.valueOf(request.getParameter("lastRead"));
		double unitConsumed=currentReading-lastReading;
		double netAmount = unitConsumed * 1.15 + 100; 
		boolean flag=false;
		if(custId!=custId2) {
			response.sendRedirect("lab5/failure.html");
		}else {
			Bill bill=new Bill(custId, currentReading, unitConsumed, netAmount);
			System.out.println(bill.toString());
			flag=service.createBill(bill);
			if(flag) {
				writer.println("Welcome"+user.getUsername()+"<br>");
				writer.println("Electricity Bill for Consumber Numer - "+custId+" is<br>");
				writer.println("Unit Consumed::"+unitConsumed+"<br>");
				writer.println("Net Amount::"+netAmount+"<br>");
			}else {
				response.sendRedirect("lab5/failure.html");
			}
		}
		
		
		
	}

}
