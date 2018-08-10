<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To add products</title>
</head>
<body>
	<h1>Please fill the following fields</h1>
	<div>
	${param.msg}
	</div>
	<form action="addProduct.do" method="post">
		Name <input type="text" name="name" required /> <br/>
	 	Price <input type="number" name="price" required min="0" /> <br/>
		Quantity <input type="number" name="qty" required min="1" /> <br/>
		<button type="submit"> Add</button>
		
	</form>
	
</body>
</html>