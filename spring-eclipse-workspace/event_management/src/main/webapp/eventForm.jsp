<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Event Form</h1>
<form:form commandName="event" action="addEvent.do">
Event Name <form:input path="eventName" />
		<form:errors path="eventName" cssClass="error" />
		<br />
	Event Date <form:input path="eventDate" />
		<form:errors path="eventDate" cssClass="error" />
		<br />
	Event Location<form:input path="location" />
	<form:errors path="Location" cssClass="error" />
	
	<button tpye="submit">Add Event</button>
		<br />
	
</form:form>
</body>
</html>