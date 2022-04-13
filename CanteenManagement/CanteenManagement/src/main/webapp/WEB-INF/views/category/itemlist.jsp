<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Employee</title>
</head>
<jsp:setProperty property="*" name="cat"/>
<body>
<center>
<div>
<h1>Menu :</h1>
<form>
<table style="width:100%">
<caption>Category Name:${param.cat_name}</caption>
<tr>
<th>Name</th>
</tr>
	<c:forEach var="d" items="${sessionScope.cat.departmentEmployees.items}">
	<tr>
	<td>${d.name}</td>
	</tr>
	
	</c:forEach>
<tr>
	<td><input type="submit" value="Add to cart"></td>
</tr>
</table>
</form>


</div>

</center>
</body>
</html>