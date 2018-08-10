<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rental Form</title>
</head>
<body>
	<h2>Rental Form</h2>
	<div>
		Welcome ${sessionScope.user}
	</div>
	
	<form method="post" action="hireVehicle.do">
	Select Vehicle: <select name="vehicle">
	<%
	List <String> nos =(List <String>) request.getAttribute("regNos");
	for(String no:nos){
	%>
	<option value="<%= no %>"> <%= no %> </option>
	<%
	}
	%>
	</select>
	
	Select Customer: <input type="text" name="customerId" /> <br/>
	
	Amount: <input type="text" name="rentalAmount" /> <br/>
	
	<button type="submit"> Rent a vehicle</button>
	</form>

</body>
</html>