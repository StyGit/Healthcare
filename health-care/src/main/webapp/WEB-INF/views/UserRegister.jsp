<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
<h2 style="color:red; text-align:center">User Registration Page</h2>
<form:form action="insert" method="POST" modelAttribute="user">
<pre>
Name 	 :	<form:input path="userName"/><br>
Email 	 :	<form:input path="userEmail"/><br>
Contact  :	<form:input path="userContact"/><br>
Password :	<form:input path="userPwd"/><br>
ADDRESS	 :<form:textarea path="userAddr"/>
</pre>
<input type="submit" value="Register">
</form:form>
${message}
</body>
</html>