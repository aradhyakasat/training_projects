<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		Welcome ${session.user}
	</div>
	
	<div>${param.msg }</div>
	<form method="post" action="LoginServlet">
		User <input type="text" name="user"> <br /> Password <input
			type="password" name="pwd"> <br />
		<button type="submit">Login</button>
	</form>

</body>
</html>