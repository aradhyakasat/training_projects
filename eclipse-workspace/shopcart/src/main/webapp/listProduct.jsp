<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Products</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Select</th>
		</tr>
		<c:forEach items="${p}" var="q">
		<tr>
			<td>"${q.id}"</td>
			<td>"${q.name}"</td>
			<td>"${q.price}"</td>
			<td>"${q.quantity}"</td>
			<td><input type="checkbox" name="productSelect"/> </td>
			
		</tr>
		</c:forEach>
		<br/>
		<button type="submit" action="listCart.do">Add to cart</button>
	</table>

</body>
</html>