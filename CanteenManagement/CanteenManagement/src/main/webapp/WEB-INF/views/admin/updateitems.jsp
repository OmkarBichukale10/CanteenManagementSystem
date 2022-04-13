<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
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
<br>
<br>
<br>
<br>
<form method="get" action="update_info">
	<center>
	<table>
		<tr>
			<td>Item Name:</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>Item Price:</td>
			<td><input type="text" name="price"  /></td>
		</tr>
		<tr>		
			<td></td><td><input type="submit" name="btn" value="update" class="btn btn-primary"/></td>
		</tr>
	</table>
	</center>
	</form>
</body>
</html>