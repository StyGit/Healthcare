<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Details</title>
<style type="text/css">
table{
border: 1px solid black;
border-collapse: collapse;
}
tr{
height: 30px;
}
a{
color: blue;
text-decoration: none;
}
a:hover {
	text-decoration: none;
}
</style>
</head>
<body>
<h2 style="color:red;text-align:center">Projects Data Page</h2>
<br>
<center><a href="#">Excel Export</a>|<a href="#">Pdf Export</a></center>
<table border="1" align="center" width="80%">
<tr style="color:#ff4d4d;">
<th>ID</th>
<th>ProjectCode</th>
<th>ProjectName</th>
<th>Department</th>
<th colspan="2">Operations</th>
</tr>
<c:forEach items="${list}" var="proj">
<tr align="center">
<td><c:out value="${proj.projId}"/></td>
<td><c:out value="${proj.projCode}"/></td>
<td><c:out value="${proj.projName}"/></td>
<td><c:out value="${proj.projDept}"/></td>
<td><a href="delete?id=${proj.projId}">Delete</a>
<td><a href="edit?id=${proj.projId}">Update</a>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>