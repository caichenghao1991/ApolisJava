<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage = "error.jsp"%>
<%@ page import="com.java.lab2.service.EBillServiceImpl,com.java.lab2.dto.Bill,
	com.java.lab2.dto.User,com.java.lab2.repository.UserRepositoryImpl,java.util.* "%>
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
Consumer details
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
<% 

	Integer custId=Integer.valueOf(request.getParameter("custId"));
if(custId==null){
	throw new EBillException("custom number is empty");
}
	UserRepositoryImpl impl= new UserRepositoryImpl();
  Optional<User> user=impl.getUserById(custId);

%>

<table>
<tr><td> Consumer Number</td><td><%=user.get().getCustId() %></td></tr>
<tr><td> Consumer Name</td><td><%=user.get().getUsername() %></td></tr>
<tr><td> Consumer Name</td><td><%=user.get().getAddress() %></td></tr>
<tr><td> <a href="<%=request.getContextPath()%>/lab2b/Show_Bills.jsp?id=<%=user.get().getCustId()%>">Show bill details</a> </td></tr>
</table>
<a href="./Index.html">Home</a>
</body>
</html>