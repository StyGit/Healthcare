<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project</title>
<style>
fieldset { 
    display: block;
    margin-left: 300px;
    margin-right: 300px;
    padding-top: 0.35em;
    padding-bottom: 1em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);
}
</style>
</head>
<body>
<h2 style="color:red;text-align:center">Project Registration Page</h2>
<fieldset>
<legend>
Project
</legend>
<pre>
<form:form action="insert" method="POST" modelAttribute="project">
Project Code :<form:input path="projCode"/><br>
Project Name :<form:input path="projName"/><br>
Department   :<form:select path="projDept">
				<form:option value="DEV">DEV</form:option>
				<form:option value="PS">PS</form:option>
				<form:option value="PD">PD</form:option>
				</form:select><br>
Note         :<form:textarea path="projNote"/><br><br>
				<input type="submit" value="Register Project"/>
</form:form>
${message}
</pre>
</fieldset>
</body>
</html>