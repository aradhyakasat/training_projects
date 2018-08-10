<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error {
	color: red;
	font-size: 12pt;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Form</h1>
	<form:form commandName="book" action="addBook.do">
	ID <form:input path="id" />
		<form:errors path="id" cssClass="error" />
		<br />
	Title <form:input path="title" />
		<form:errors path="title" cssClass="error" />
		<br />
	Price <form:input path="price" />
		<form:errors path="price" cssClass="error"  />
		<br />
	Category <form:input path="category" />
		<br />
	Published Date [dd-mm-yyyy] <form:input path="publishedDate" />
		<br />
	Publisher Address <form:input path="publisherAddress" />
		<br />

		<button type="submit">Add a book</button>
	</form:form>

</body>
</html>