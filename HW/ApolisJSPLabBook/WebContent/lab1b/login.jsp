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

Log in page
        <form action="info.jsp" method="post">
	Enter Username: <input type="text" name="username" required="required" min=3/>
	<br>
	Enter Password: <input type="password" name="password" required="required" min=3/>
	<br>
	<input type="submit" value="sign in"/>
</form>
<%  if(request.getParameter("username")!=null && request.getParameter("password")!=null 
	&& map.containsKey(request.getParameter("username"))){
		if(map.get(request.getParameter("username")).equals(request.getParameter("password"))){
			request.getSession().setAttribute("msg","Successful Login");
			System.out.println("1");
		}else{
			request.getSession().setAttribute("msg","Login Failure");	
			System.out.println("2");
		}
	}


%> 
</body>
</html>