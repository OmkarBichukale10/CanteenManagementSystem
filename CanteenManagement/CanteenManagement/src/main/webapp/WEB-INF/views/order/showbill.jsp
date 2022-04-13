<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	font-family: "Helvetica Neue", Helvetica, sans-serif
}
body {

	background:
		url(https://mcdn.wallpapersafari.com/medium/1/72/LuExcT.jpg)
		no-repeat fixed center center;
}
caption {
	text-align: left;
	color: silver;
	font-weight: bold;
	text-transform: uppercase;
	padding: 5px;
}

thead {
	background: SteelBlue;
	color: white;
}

th, td {
	padding: 5px 10px;
}

tbody tr:nth-child(even) {
	background: WhiteSmoke;
}

tbody tr td:nth-child(2) {
	text-align: center;
}

tbody tr td:nth-child(3), tbody tr td:nth-child(4) {
	text-align: right;
	font-family: monospace;
}

tfoot {
	background: SeaGreen;
	color: white;
	text-align: right;
}

tfoot tr th:last-child {
	font-family: monospace;
}


.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {padding: 10px 24px;}
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






<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
function </script>
</head>
<body>
	<%-- <div align="center">
		<h2>&nbsp;&nbsp;&nbsp;User:${sessionScope.unamesb }&nbsp;&nbsp;&nbsp;User-Id:${sessionScope.uid }</h2>
	</div> --%>
	<ul>
		<li><a href="#home">${sessionScope.user_dtls.name}</a></li>

		<li style="float: right"><a class="active"
			href="/CanteenManagement/account/login">Log Out</a></li>
		<li style="float: right"><a href="#home">${sessionScope.user_dtls.userName}</a></li>
	</ul>
	<br>
	<br>
	<form>
		<table align="center">
			<caption>Order Details</caption>
			<thead>
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<sp:forEach var="d" items="${requestScope.cartdetails}">
					<tr>
						<td>${d.name }</td>
						<td>${d.qty }</td>
						<td>${d.price }</td>
						<td>${d.total }</td>
					</tr>
				</sp:forEach>
			<tfoot>
				<tr>
					<th colspan="3">Grand Total</th>
					<th>${sessionScope.totalBill }</th>
				</tr>
				<tr>
					<td align="center" colspan="4"><a href="payment" class="button button1" role="button">Make Payment</a></td>
				</tr>
			</tfoot>
		</table>
		
	</form>

</body>
</html>