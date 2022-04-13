<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<br>
<center>
<h3>Enter the item to add:</h3>
<form method="post">
<table>
	<tr>
	<td>Enter Item Name</td>
	<td><input type="text" name="name" /></td>
	</tr>
	<br>
	<tr>
	<td></td><td></td>
	</tr>
	
	<tr>
	<td>Enter Item Price</td>
	<td><input type="number" name="price" /></td>
	</tr>
<tr>
<td><input type="submit"class="btn btn-primary" value="Add Item" /></td>
<td><input type="reset" value="reset" class="btn btn-success" />
</tr>
</table>
</form>
</center>
</body>
</html>