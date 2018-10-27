<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMployee Registration Form</title>
</head>
<body>
<h2 style="color:red; text-align:center">Employee Registration Page</h2>
<form:form action="insert" method="POST" modelAttribute="employee">
<pre>
NAME     :<form:input path="empName"/><br>
GENDER   :<form:radiobutton path="empGen" value="Male"/>Male<br> 	  <form:radiobutton path="empGen" value="FeMale"/>FeMale<br>
ADDRESS  :<form:textarea path="empAddr"/><br>
COUNTRY  :<form:select path="empCntry">
		<form:option value="">--SELECT--</form:option>
		<form:option value="IND">India</form:option>
		<form:option value="ENG">England</form:option>
		<form:option value="US">UnitedStates</form:option>
</form:select><br>
Languages:<form:checkbox path="empLangs" value="ENG"/>English
	  <form:checkbox path="empLangs" value="TEL"/>Telugu
	  <form:checkbox path="empLangs" value="HIN"/>Hindi
</pre>
<input type="submit" value="Register">
</form:form>
${message}
</body>
</html>