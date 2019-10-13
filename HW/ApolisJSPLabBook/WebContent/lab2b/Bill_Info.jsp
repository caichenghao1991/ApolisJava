<%@page import="com.java.lab2.repository.UserRepositoryImpl" errorPage = "error2.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.java.lab2.service.EBillServiceImpl,com.java.lab2.dto.Bill,com.java.lab2.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<% 
//


if(request.getParameter("custId")==null|| request.getParameter("custId")==""){
	session.setAttribute("err", request.getParameter("custId"));
	throw new EBillException("custom number is empty");
}
%>
<%
	UserRepositoryImpl impl=new UserRepositoryImpl();
	EBillServiceImpl service=new EBillServiceImpl();	
	int custId2=(int)session.getAttribute("custId");
	int custId=Integer.valueOf(request.getParameter("custId"));
	double currentReading= Double.valueOf(request.getParameter("curRead"));
	double lastReading= Double.valueOf(request.getParameter("lastRead"));
	double unitConsumed=currentReading-lastReading;
	double netAmount = unitConsumed * 1.15 + 100; 
	boolean flag=false;
	if(custId!=custId2) {
		session.setAttribute("err", request.getParameter("custId"));
		throw new EBillException("custom number mismatch");
	}else {
	Bill bill=new Bill(custId, currentReading, unitConsumed, netAmount);
	System.out.println(bill.toString());
	flag=service.createBill(bill);
	if(flag) {
		out.println("Welcome"+impl.getUserById(custId).get().getUsername()+"<br>");
		out.println("Electricity Bill for Consumber Numer - "+custId+" is<br>");
		out.println("Unit Consumed::"+unitConsumed+"<br>");
		out.println("Net Amount::"+netAmount+"<br>");
	}else {
		throw new EBillException("data incorrect");
	}
}
%>



<%!
public class EBillException extends Exception {

    private String message;

    public EBillException(String message){
        super(message);
        this.message = message;
    } 
	public String getMessage(){
    	return message;
	}
}

%>
<a href="./Index.html">Home</a>

</body>
</html>