<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item List</title>
</head>
<body>
<h3>Item List</h3>
<table>
 <thead>
 	<tr>
 		<th>No</th>
 		<th>Name</th>
 		<th>Price</th>
 		<th>Qty</th>
 		<th>Color</th>
 	</tr>
 </thead>
 <tbody>
 	<c:forEach items="${itemList}" varStatus="row" var="item">
 		<tr>
 			<td>${row.count}</td>
 			<td>${item.name }</td>
 			<td>${item.price }</td>
 			<td>${item.qty }</td>
 			<td>${item.color }</td>
 		</tr>
 	</c:forEach>
 </tbody>
</table>
</body>
</html>