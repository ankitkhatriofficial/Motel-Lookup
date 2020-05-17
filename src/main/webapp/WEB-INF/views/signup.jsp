<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Resgiter your Account here</title>
<link rel="stylesheet" href="assets/css/nav.css" />
<link rel="stylesheet" href="assets/css/shared.css" />
<link rel="stylesheet" href="assets/css/signup.css" />
<link rel="stylesheet" href="assets/css/footer.css" />
</head>
<body>

	<nav>
		<div class="navbar">
			<div class="left-nav">
				<div class="logo"></div>
				<div class="logo-heading">Motel-Lookup</div>
				<ul>
					<li class="active"><a href="/index">Home</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="https://www.github.com/khatri09">Github Codes</a></li>
				</ul>
			</div>
			<div class="right-nav">
				<div class="login-container">
					<a href="/login">Login</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="form-container">
		<form action="/signup" method="post">
			<div class="form-firstName">
				<label>First Name:</label> <input type="text" name="fname" required />
			</div>
			<div class="form-lastName">
				<label>Last Name:</label> <input type="text" name="lname" required />
			</div>
			<div class="form-email">
				<label>Email ID:</label> <input type="email" name="email" required />
			</div>
			<div class="form-password">
				<label>Choose Password:</label> <input type="password" name="pwd"
					required />
			</div>
			<div class="form-password2">
				<label>Confirm Password:</label> <input type="password" name="pwd2"
					required />
			</div>
			<font color="red">${errorMsg}</font> <input type="submit"
				value="Register" />
		</form>
	</div>


	<%-- This is  the link to include Footer --%>
	<%@ include file="../fragments/footer.jspf"%>

</body>
</html>