<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Candidate List</h2>
	<jsp:useBean id="rb" class="com.sunbeam.beans.Result"/>
	${rb.fetchCandidate()}
	<form method="post" action="vote.jsp">
		<c:forEach var="c" items="${rb.candlist}">
			<input type="radio" name="candidate" value="${c.id}"/> 
			${c.name} - ${c.party} <br/>
		</c:forEach>	
		<br/>
<input type="submit" value="Vote"/>
	</form>
</body>
</html>