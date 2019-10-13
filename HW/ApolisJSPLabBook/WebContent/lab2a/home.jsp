<%@page import="org.apache.catalina.core.ApplicationContext"%>
<%@page import="sun.awt.AppContext"%>
<%@ page language="java" contentType="text/html" import="java.util.*" 
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"> 
ul{
display: flex; 
justify-content: space-around;
}
li{
	list-style:none;
	border:1px solid black;
	padding:0px 20px;
}
</style>


<%@ include file="header.jsp" %>

</head>

<body>

<h1>Home page</h1>
    <p>Enter sections want to see in menu:</p>
<form action="" method="post">
	Menu Item 1: <input type="text" name="section1" required="required" placeholder="section1"/><br>
	Menu Item 2: <input type="text" name="section2" required="required" placeholder="section2"/><br>
	Menu Item 3: <input type="text" name="section3" required="required" placeholder="section3"/><br>
	Menu Item 4: <input type="text" name="section4" required="required" placeholder="section4"/><br>
	Menu Item 5: <input type="text" name="section5" required="required" placeholder="section5"/><br>
	Menu Item 6: <input type="text" name="section6" required="required" placeholder="section6"/><br>
	<input type="submit" value="change header"/>
</form>

</body>
</html>