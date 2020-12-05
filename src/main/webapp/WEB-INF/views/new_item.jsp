<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page isELIgnored="false" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
New Item Register
</h3>
<form:form action="new_item.htm" method="post" modelAttribute="item">
<label>Name</label>:<form:input path="name"/> <br>
<label>Qty</label>:<form:input path="qty"/><br>
<label>Price</label>:<form:input path="price"/>
<br>
<label>Color</label>:<form:select path="color">
<c:forEach items="${colorList }" var="c">
	<form:option value="${c }">${c }</form:option>
</c:forEach>
</form:select><br>
<label>Inventory Type:</label><form:radiobuttons path="inventoryStatus" items="${inventoryList}"/><br>
<input type="submit" value="Save" />
</form:form>
</body>
</html>