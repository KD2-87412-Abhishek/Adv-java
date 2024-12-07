<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h2>Register Bean</h2>
<div>
// Property - class name, param  - browser
<jsp:useBean id="rb1" class="com.sunbeam.beans.Registeration" scope="page"/>
<jsp:setProperty name="rb1" property="firstName" param="firstname"/>
<jsp:setProperty name="rb1" property="lastName" param="lastname"/>
<jsp:setProperty name="rb1" property="email" param="email"/>
<jsp:setProperty name="rb1" property="password" param="password"/>
<jsp:setProperty name="rb1" property="dob" param="dob"/>
<jsp:setProperty name="rb1" property="status" param="status"/>
<jsp:setProperty name="rb1" property="role" param="role"/>

<% int result = rb1.registerUser(); rb1.setResult(result);%>
 <c:choose>
		<c:when test= "${rb1.result== 1}">
				<c:redirect url="sucess.jsp"/>
		</c:when>
		<c:otherwise>
			<c:redirect url="failure.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>

<p>Result: ${rb1.result}   </p>


</div>
</body>
</html>
