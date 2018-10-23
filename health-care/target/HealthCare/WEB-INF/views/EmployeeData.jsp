<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeData</title>
</head>
<body>
	<h2>Welcome To Employee Data Page</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>GENDER</th>
			<th>ADDRESS</th>
			<th>COUNTRY</th>
			<th>LANGUAGES</th>
			<th colspan="2">OPERATION</th>
		</tr>

		<c:forEach items="${list}" var="emp">
		<tr>
			<td><c:out value="${emp.empId}" /></td>
			<td><c:out value="${emp.empName}" /></td>
			<td><c:out value="${emp.empGen}" /></td>
			<td><c:out value="${emp.empAddr}" /></td>
			<td><c:out value="${emp.empCntry}" /></td>
			<td><c:out value="${emp.empLangs}" /></td>
			<td><a href="delete?id=${emp.empId}">DELETE</a></td>
			<td><a href="edit?id=${emp.empId}">EDIT</a></td>
		</tr>
		</c:forEach>
	${message}
	</table>
	</body>
</html>