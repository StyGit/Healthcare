<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Update Form</title>
</head>
<body>
<h2 style="color:red; text-align:center">Employee Update Page</h2>
<form:form action="update" method="POST" modelAttribute="employee">
<pre>
EMPLOYEE ID:<form:input path="empId" readonly="true"/>
NAME :	<form:input path="empName"/>
GENDER :<form:radiobutton path="empGen" value="Male"/>Male
		<form:radiobutton path="empGen" value="FeMale"/>FeMale
ADDRESS:<form:textarea path="empAddr"/>
COUNTRY:<form:select path="empCntry">
		<form:option value="">--SELECT--</form:option>
		<form:option value="IND">India</form:option>
		<form:option value="ENG">England</form:option>
		<form:option value="US">UnitedStates</form:option>
</form:select>
Languages:<form:checkbox path="empLangs" value="ENG"/>English
	<form:checkbox path="empLangs" value="TEL"/>Telugu
	<form:checkbox path="empLangs" value="HIN"/>Hindi
</pre>
<input type="submit" value="Update">
</form:form>
${message}
</body>
</html>