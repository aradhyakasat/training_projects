<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Please fill the details below</h1>
	<br />
	<form:form commandName="user" action="addUser.do">

	First Name <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br />
	Last Name <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
	E-Mail id <form:input path="email" />
	<form:errors path="email" cssClass="error" />
		<br />
	Phone No. <form:input path="phone" />
		<br />
	
		<button type="submit">Add user</button>



	</form:form>

</body>
</html>