<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(window).on(
			"load resize ",
			function() {
				var scrollWidth = $('.tbl-content').width()
						- $('.tbl-content table').width();
				$('.tbl-header').css({
					'padding-right' : scrollWidth
				});
			}).resize();
</script>
<meta charset="ISO-8859-1">
<title>Items</title>
<style>
h1 {
	font-size: 30px;
	color: #000000;
	text-transform: uppercase;
	font-weight: 300;
	text-align: center;
	margin-bottom: 15px;
}

table {
	width: 50%;
}

.tbl-header {
	background-color: rgba(255, 255, 255, 0.3);
}

.tbl-content {
	height: 300px;
	overflow-x: auto;
	margin-top: 0px;
	border: 1px solid rgba(255, 255, 255, 0.3);
}

th {
	padding: 20px 15px;
	text-align: left;
	font-weight: 500;
	font-size: 20px;
	color: #000000;
	text-transform: uppercase;
}

td {
	padding: 15px;
	text-align: left;
	vertical-align: middle;
	font-weight: 300;
	font-size: 18px;
	color: #000000;
	border-bottom: solid 1px rgba(255, 255, 255, 0.1);
}

/* demo styles */
@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);

body {
	font-family: 'Roboto', sans-serif;
	background:
		url(https://previews.123rf.com/images/belchonock/belchonock1502/belchonock150206481/36694271-spices-with-recipe-book-on-white-background.jpg)
		no-repeat fixed center center;
}

section {
	margin: 50px;
}

/* follow me template */
.made-with-love {
	margin-top: 40px;
	padding: 10px;
	clear: left;
	text-align: center;
	font-size: 10px;
	font-family: arial;
	color: #fff;
}

.made-with-love i {
	font-style: normal;
	color: #F50057;
	font-size: 14px;
	position: relative;
	top: 2px;
}

.made-with-love a {
	color: #fff;
	text-decoration: none;
}

.made-with-love a:hover {
	text-decoration: underline;
}

/* for custom scrollbar for webkit browser*/
::-webkit-scrollbar {
	width: 6px;
}

::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

::-webkit-scrollbar-thumb {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<br><br><br>

	<h1 align="center">Item Details</h1>
	<div class="tbl-header">
		<table cellpadding="0" cellspacing="0" border="0" align="center">
			<thead>
				<tr>

					<th>Item Name</th>
					<th>Price</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="tbl-content">
		<table cellpadding="0" cellspacing="0" border="0" align="center">
			<tbody>
				<c:forEach var="e" items="${requestScope.item_list}">

					<tr>
						<td></td>
						<td>${e.name}</td>
						<td></td>
						<td></td>
						<td>${e.price}</td>
						<td><a
							href="<spring:url value='/item/delete?code=${e.code}'/>">Delete</a></td>
						<td><a
							href="<spring:url value='/item/updateitems?code=${e.code}'/>">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div align="center">
		<h3><a href="<spring:url value='/admin/additem'/>">Add Items</a></h3>
	</div>
	<div align="center">
		<h3><a href="<spring:url value='/admin/home'/>">Go to Home Page </a></h3>
	</div>
</body>
</html>