<%@page import="com.akash.UserBean"%>
<%@page import="java.sql.ResultSet"%> 
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>Personal Details</legend>
<form>
<table>
<% 

UserBean user;
user=(UserBean)request.getAttribute("user");
//user=(UserBean)session.getAttribute("user");

//System.out.println("address "+user.getAddress());


%>


<tr><td>Name 	:<% out.println(user.getName());%></td></tr>
<tr><td>Email 	:<% out.println(user.getEmail());%></td></tr>
<tr><td>Mobile 	:<% out.println(user.getMobile());%></td></tr>
<tr><td>Address	:<% out.println(user.getAddress());%></td></tr>

</table>
</form>
</fieldset>


<br><br>
<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>




