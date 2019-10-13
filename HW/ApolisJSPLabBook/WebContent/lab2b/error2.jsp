<%@ page language="java" contentType="text/html" import="java.util.*" 
    pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp" %>
</head>
<body>
<p><h1>Error occured:</h1></p>
<p><h2>No bill details for customer number: <%=session.getAttribute("err") %></h2></p>
<p><a href="<%=request.getContextPath()%>/lab2b/User_Info.jsp">Click here to generate next bill</a> </p>
<p><a href="./Index.html">Home</a></p>
</body>
</html>