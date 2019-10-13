<%@ page language="java" contentType="text/html" import="java.util.*" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%! public static HashMap<String,String> map=new HashMap<String,String>();
	{map.put("admin","admin");}
%>
<%  
System.out.println(request.getParameter("username"));
if(request.getParameter("username")!=null && request.getParameter("password")!=null 
	&& map.containsKey(request.getParameter("username"))){
	System.out.println(request.getParameter("username"));
		if(map.get(request.getParameter("username")).equals(request.getParameter("password"))){
			request.setAttribute("msg","Successful Login");
		}else{
			request.setAttribute("msg","Login Failure");	
			System.out.println("2");
		}
	}else{
		request.setAttribute("msg","Login Failure");	
	}
%>
<%=request.getAttribute("msg") %>
</body>
</html>