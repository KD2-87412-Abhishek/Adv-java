<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user Registration</title>
</head>
<body>
	<h2>user Registration</h2>
	<form method="post" action="Register.jsp">
		first_name:<input type="text" name="firstname"/> <br/><br/>
		last_name:<input type="text" name="lastname"/> <br/><br/>
		Email: <input type="text" name="email"/> <br/><br/>
		Password: <input type="password" name="password"/> <br/><br/>
		dob:<input type="date" name="dob"/> <br/><br/>
		Status:<input type="number" name="status"/> <br/><br/>
		Role:<input type="text" name="role"/> <br/><br/>
		<input type="submit" value="Register"/>

	</form>
</body>
</html>
    