<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Documents</title>
<style>
h2{
text-align: center;
}
table{
text-align: center;
border: 1px solid black;
border-collapse: collapse;
}
a{
color: #33cc33;
text-decoration: none;
}
</style>
</head>
<body style="align:center;">
<h2>Welcome to Documents Page!!</h2>
<center>
<form action="upload" method="post" enctype="multipart/form-data">
<pre>
File: <input type="file" name="file"><br>
<input type="submit" value="Upload">
</pre>
</form>
${message}
<table border="1" width="50%">
<tr>
<th>ID</th>
<th>NAME</th>
<th>LINK</th>
</tr>
<c:forEach items="${docs}" var="doc">
<tr>
<td><c:out value="${doc[0]}"></c:out></td>
<td><c:out value="${doc[1]}"></c:out></td>
<td><a href="download?docId=${doc[0]}">DOWNLOAD</a></td>
</tr>
</c:forEach>
</table></center>
</body>
</html>