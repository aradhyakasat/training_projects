<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Shopping App</h3>
	<div>
		Welcome ${sessionScope.email}
	</div>
	<div>
		${param.msg}
	</div>
	<a href="addProduct.jsp"> Add a product</a> <br/>
	<a href="listProduct.do">List Products </a> <br/>
</body>
</html>