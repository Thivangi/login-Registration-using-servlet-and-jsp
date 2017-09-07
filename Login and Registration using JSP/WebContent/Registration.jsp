<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;background-color:white">
<fieldset>
<legend>Registration</legend>
<form action="insert" method="post">
<br><br>
<table align="center">
<tr>
<th>
Name:</th>
<th>

<input type="text" name="name" placeholder="Enter Your Name" required><br>
</th>
</tr><tr>
<th>
Email:

</th>
<th>
<input type="text" name="email" placeholder="Enter your Email id " required><br>
</th>
</tr>
<tr>
<th>

Mobile:
</th>
<th>
<input type="text" name="mobile" placeholder="Enter your Mobile Number" required><br>
</th>
</tr>

<tr>
<th>

Password:
</th>
<th>
<input type="password" name="password" placeholder="Enter your Password" required><br>
</th>
</tr>


<tr>
<th>

Address:
</th>
<th>
<input type="text" name="address" placeholder="Enter your Address" required><br>
</th>
</tr>
</table>
<button type="submit">Submit</button>
</form>
</fieldset>
</body>
</html>