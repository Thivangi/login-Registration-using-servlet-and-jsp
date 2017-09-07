<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login&Reg</title>
</head>
<body style="text-align: center; background-color: white">
	<fieldset>
		<legend>Login</legend>
		<form action="login" method="post">
			<br>
			<br>
			<table align="center">
				<tr>
					<th>Email:</th>
					<th><input type="text" name="email"
						placeholder="Enter Your Email id " required><br></th>
				</tr>
				<tr>
					<th>Password:</th>
					<th><input type="text" name="password"
						placeholder="Enter your Password" required><br></th>
				</tr>
			</table>
			<button type="submit">Submit</button>
		</form>
	</fieldset>
</body>
</html>



