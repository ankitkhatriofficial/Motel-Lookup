<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login to Your Account</title>
<link rel="stylesheet" href="assets/css/nav.css" />
<link rel="stylesheet" href="assets/css/shared.css" />
<link rel="stylesheet" href="assets/css/login.css" />
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
			<div class="register-container">
				<a href="/signup">Register</a>
			</div>
		</div>
		</div>
	</nav>

	<div class="form-container">
		<form action="/login" method="post">
			<div class="form-username">
				<label>username:</label> <input type="text" name="username" required />
			</div>
			<div class="form-password">
				<label>Password:</label> <input type="password" name="password"
					required />
			</div>
			<font color="red">${errorMsg}</font> <input type="submit"
				value="Login" />
		</form>
	</div>

	<%-- This is  the link to include Footer --%>
	<%@ include file="../fragments/footer.jspf"%>
</body>

</html>