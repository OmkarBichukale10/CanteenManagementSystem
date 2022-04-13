<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>




<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>









<style>
@import
	url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap")
	;

input {
	background-color: transparent;
	border: 0px solid;
	height: 20px;
	width: 160px;
	color: black;
	font-weight: bold;
}

body {
	background-color: #f5eee7;
	font-family: "Poppins", sans-serif;
	font-weight: 300
}

.container {
	height: 100vh
}

.card {
	border: none
}

.card-header {
	padding: .5rem 1rem;
	margin-bottom: 0;
	background-color: rgba(0, 0, 0, .03);
	border-bottom: none
}

.btn-light:focus {
	color: #212529;
	background-color: #e2e6ea;
	border-color: #dae0e5;
	box-shadow: 0 0 0 0.2rem rgba(216, 217, 219, .5)
}

.form-control {
	height: 50px;
	border: 2px solid #eee;
	border-radius: 6px;
	font-size: 14px
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #039be5;
	outline: 0;
	box-shadow: none
}

.input {
	position: relative
}

.input i {
	position: absolute;
	top: 16px;
	left: 11px;
	color: #989898
}

.input input {
	text-indent: 25px
}

.card-text {
	font-size: 13px;
	margin-left: 6px
}

.certificate-text {
	font-size: 12px
}

.billing {
	font-size: 11px
}

.super-price {
	top: 0px;
	font-size: 22px
}

.super-month {
	font-size: 11px
}

.line {
	color: #bfbdbd
}

.free-button {
	background: #1565c0;
	height: 52px;
	font-size: 15px;
	border-radius: 8px
}

.payment-card-body {
	flex: 1 1 auto;
	padding: 24px 1rem !important
}
</style>
</head>
<body>






<center>



	<div class="col-md-6">
		<span style="font-weight: bold" >INVOICE</span>
		<div class="card">
			<form method="post">
				<div class="d-flex justify-content-between p-3">
					<div class="d-flex flex-column">
						<span>Name<i class="fa fa-caret-down"></i></span> <a href="#"
							class="billing">Save 20% with annual billing</a>
					</div>
					<div class="mt-1">
						<input type="text" name="name" class="input"
							value="${sessionScope.name}" readonly="readonly"/> <span class="super-month"></span>
					</div>
				</div>
				<hr class="mt-0 line">
				<div class="p-3">
					<div class="d-flex justify-content-between mb-2">
						<span>Payment Type</span> <span><input type="text"
							name="type" class="input" readonly="readonly"value="Cash" /></span>
					</div>
					<div class="d-flex justify-content-between">
						<span>Date<i class="fa fa-clock-o"></i></span> <span><input
							type="text" name="date" class="input"
							value="${sessionScope.date}" readonly="readonly"/></span>
					</div>
				</div>
				<hr class="mt-0 line">
				<div class="p-3 d-flex justify-content-between">
					<div class="d-flex flex-column">
						<span>Today you pay(INR)</span> <small>After 30 days 10%
							extra</small>
					</div>
					<span><input type="text" name="totalBill" class="input"
						value="${sessionScope.totalBill}" readonly="readonly" /></span>
				</div>
				<div class="p-3">
					<input type="submit" class="btn btn-primary btn-block free-button"
						value="Confirm Order">
					</button>
					<div class="text-center">
						<a href="#">Have a promo code?</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	</div>
	</div>
	
	
	</center>
</body>
</html>