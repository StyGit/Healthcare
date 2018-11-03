<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Developer</title>
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
<h2 style="color:red;text-align:center">Developer Update Page</h2>
<fieldset>
<legend>
Developer
</legend>
<pre>
<form:form action="update" method="POST" modelAttribute="developer">
Developer Code :<form:input path="devCode"/><br>
Developer Name :<form:input path="devName"/><br>
Project        :<form:select path="project">--SELECT--
				<form:options  items="${projects}" itemLabel="${projCode}" itemValue="${projId}" />
				</form:select><br>
Salary         :<form:input path="devSalary"/><br><br>
				<input type="submit" value="Update Developer"/>
</form:form>
${message}
</pre>
</fieldset>
</body>
</html>