<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>New Item Detail</h3>
<table border="1">
	<tr>
		<td>Name</td><td>${item.name }</td>
	</tr>
	<tr>
		<td>Qty</td><td>${item.qty }</td>
	</tr>
	<tr>
		<td>Price</td><td>${item.price }</td>
	</tr>
	<tr>
		<td>Color</td><td>${item.color }</td>
	</tr>
	<tr>
		<td>Inventory Type</td><td>${item.inventoryStatus}</td>
	</tr>
</table>
</body>
</html>