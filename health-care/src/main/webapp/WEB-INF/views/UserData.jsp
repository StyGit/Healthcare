<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<h2>Welcome To User Data Page</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Password</th>
			<th>Address</th>
			<th colspan="2">OPERATION</th>
		</tr>

		<c:forEach items="${list}" var="user">
		<tr>
			<td><c:out value="${user.userId}" /></td>
			<td><c:out value="${user.userName}" /></td>
			<td><c:out value="${user.userEmail}" /></td>
			<td><c:out value="${user.userContact}" /></td>
			<td><c:out value="${user.userPwd}" /></td>
			<td><c:out value="${user.userAddr}" /></td>
			<td><a href="delete?id=${user.userId}">DELETE</a></td>
			<td><a href="edit?id=${user.userId}">EDIT</a></td>
		</tr>
		</c:forEach>
	${message}
	</table>
	<a href="excel">Excel Export</a>|<a href="pdf">Pdf Export</a>
	</body>
</html>