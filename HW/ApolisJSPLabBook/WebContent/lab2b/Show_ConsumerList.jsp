<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.java.lab2.service.EBillServiceImpl,com.java.lab2.dto.Bill,
	com.java.lab2.dto.User,com.java.lab2.repository.UserRepositoryImpl,java.util.* "   isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css"> 
table{
border:3px solid black;
}
</style>
</head>
<body>
<table>
<thead><tr>
<th>User Id</th><th>User Name</th><th>Address</th><th></th>
</tr></thead>
<tbody>
<% 
	UserRepositoryImpl impl= new UserRepositoryImpl();
   ArrayList<User> list=impl.getAllUsers();
  for(User u:list){
	  
	  %><tr><td><%=u.getCustId() %></td>
	  <td><%=u.getUsername() %></td>
	  <td><%=u.getAddress() %></td>
	  <!--  <a href="" onclick="javascript:windowOpen('${pageContext.request.contextPath}'+'/lab2b/Show_Bills.jsp?id=')">Show bill details</a><td>-->
	  <td><a href="<%=request.getContextPath()%>/lab2b/Show_Bills.jsp?id=<%=u.getCustId()%>">Show bill details</a></td>
	  <% 
  }
%>
</tbody>
</table>
<a href="./Index.html">Home</a>

</body>
</html>