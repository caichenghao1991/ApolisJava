<!--page directives-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
FirstName: <%=request.getAttribute("firstname") %><br>
LastName: <%=request.getAttribute("lastname") %><br>
Password:<%=request.getAttribute("password") %><br>
Gender: <%=request.getAttribute("gender") %><br>
Skills:	<% String[] x=(String[])request.getAttribute("skill");
	for(String s:x) out.println(s);
%><br>
City:	<%=request.getAttribute("city") %><br>


</body>
</html>