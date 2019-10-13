<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.java.lab2.service.EBillServiceImpl,com.java.lab2.dto.Bill,
	com.java.lab2.dto.User,com.java.lab2.repository.UserRepositoryImpl,java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./Show_Consumer.jsp" method="post">
    Enter Consumer Number: <input id="1" type="number" name="custId"   onblur="check1()" />          	
	<input  type="submit" value="Search" />
</form>
<script type="text/javascript">	
	function check1(){
        var a = document.getElementById("1");
		if(a.value!=""&&a.value.match(/^[1-9][0-9]*?$/)==null){  
	             document.getElementById("1").innerText="Wrong Format";
            document.getElementById("1").style.color="red";            
            document.getElementById("1").focus();
         }else{
        	 document.getElementById("1").style.color="black";        			
	      }
    }
</script>
</body>
</html>