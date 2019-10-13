<%@ page language="java" contentType="text/html" import="java.util.*"  errorPage = "error2.jsp"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	
	<form action="Bill_Info.jsp" method="post">
    Consumer Number: <input id="1" type="number" name="custId"   value="<%=session.getAttribute("custId") %>" />
	<br>          
	Last Month Meter Reading: <input id="2" type="text" name="lastRead" required="required" value="" onblur="check2()"  />
	<br>
	Current Month Meter Reading: <input id="3" type="text" name="curRead" required="required" value="" onblur="check3()"/>
	<br>
	<input id="4" type="submit" value="Calculate Bill" onclick="check4()" />
	
	
	<script type="text/javascript">
	
	
	
	function check2(){
        var a = document.getElementById("2");
	     if(a.value.match(/^([1-9][0-9]*)+(.[0-9]{1,2})?$/)==null){  
	             document.getElementById("2").innerText="Wrong Format";
            document.getElementById("2").style.color="red";            
            document.getElementById("2").focus();
         }else{
        	 document.getElementById("2").style.color="black";  
        	
        
	      }
    }
	
	function check3(){
	        var a = document.getElementById("3");
		        if(a.value.match(/^([1-9][0-9]*)+(.[0-9]{1,2})?$/)==null){  
		             document.getElementById("3").innerText="Wrong Format";
	            document.getElementById("3").style.color="red";   
	            document.getElementById("3").focus();
	         }else{
	        	 document.getElementById("3").style.color="black";  	       	        	 
		      }
	    }
	
	function check4(){	
		var a = document.getElementById("2");  
        var b = document.getElementById("3");	
        if(b.value<a.value){        	       	
        	event.preventDefault();
	      }
        
    }
	
</script>



</form>
</body>
</html>