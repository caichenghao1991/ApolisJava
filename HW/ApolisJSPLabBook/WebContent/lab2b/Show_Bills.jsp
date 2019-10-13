<%@page import="com.java.lab2.service.EBillServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ page import="com.java.lab2.service.EBillServiceImpl,com.java.lab2.dto.Bill,com.java.lab2.dto.User, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"> 
table{
border:3px solid black;
}
</style>
</head>
<body>
Bill details for ${param.id}
<table>
<thead><tr>
<th>Bill Number</th><th>Bill Month</th><th>Meter Reading</th><th>Unit Consumed</th><th>Bill Amount</th>
</tr></thead>
<tbody>
<% 
	EBillServiceImpl impl= new EBillServiceImpl();
	int	custId=Integer.valueOf(request.getParameter("id"));
   ArrayList<Bill> list=impl.searchBill(custId);
  for(Bill b:list){
	  
	  %><tr><td><%=b.getBill_num() %></td>
	  <td><%=b.getMonth()%></td>
	  <td><%=b.getCurrentReading() %></td>
	  <td><%=b.getUnitConsumed() %></td>
	  <td><%=b.getNetAmount() %></td>	 
	  <% 
  }
  session.setAttribute("custId", custId);
%>

<tr><td><a href="<%=request.getContextPath()%>/lab2b/User_Info.jsp">Generate next bill</a> </td></tr>

</tbody>
</table>
<a href="./Index.html">Home</a>
</body>
</html>