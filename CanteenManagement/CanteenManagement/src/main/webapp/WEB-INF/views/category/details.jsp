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
	height: 500px;
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
		url(https://thumbs.dreamstime.com/z/open-vintage-book-spices-wooden-background-healthy-vegetarian-food-recipe-menu-mock-up-cooking-old-62210386.jpg)
		no-repeat fixed center center;
}

section {
	margin: 50px;
}


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
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.active {
	background-color: #04AA6D;
}

</style>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 10px 21px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */
</style>
</head>
<body>

	<ul>
		<li><a href="#home">${sessionScope.user_dtls.name}</a></li>

		<li style="float: right"><a class="active"
			href="/CanteenManagement/account/login">Log Out</a></li>
		<li style="float: right"><a href="#home">${sessionScope.user_dtls.userName}</a></li>
	</ul>
	<h1 align="center">Menu ${sessionScope.mesg}</h1>
	<form action="order/submit">

		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0" align="center">
				<thead>
					<tr>
						<th></th>
						<th></th>
						<th>Item Name</th>
						<th>Price</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0" align="center">
				<tbody>
					<c:forEach var="e" items="${requestScope.item_list}">
						<td></td>

						<tr>

							<td><label><input type="checkbox" id="${e.code}"name="products" value="${e.code}"></td>
							<td><label for="${e.code}">${e.name}</label></td>
							<td>${e.price}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center">
			<input type="submit" name="addToCart" value="Add To Cart"
				formaction="add" class="button button2"> <input type="submit"  name="cart"
				value="Show Cart" formaction="show" class="button">
		</div>
		<div align="center">
			<input type="submit" name="cart" value="back" formaction="back" class="button button5">
		</div>


	</form>
</body>
</html>

