<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index Page</title>
<link rel="stylesheet" href="assets/css/index.css">
<link rel="stylesheet" href="assets/css/nav.css">
<link rel="stylesheet" href="assets/css/shared.css">
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

	<%-- This is  the link to include navbar based on user logged in or not --%>
	<c:choose>
		<c:when test="${token != null}">
			<%@ include file="../fragments/DashboardNavbar.jspf"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../fragments/navbar.jspf"%>
		</c:otherwise>
	</c:choose>

	<div class="main-container">
		<div class="filter-container">
			<div class="left-filter-container">
				<select name="states" class="select" id="fetchval">
					<option value="all" selected>All States</option>
					<option value="New Delhi">New Delhi</option>
					<option value="Haryana">Haryana</option>
					<option value="Gujarat">Gujarat</option>
					<option value="Karnataka">Karnataka</option>
					<option value="Kerala">Kerala</option>
					<option value="Maharastra">Maharastra</option>
					<option value="Rajasthan">Rajasthan</option>
					<option value="Uttar Pradesh">Uttar Pradesh</option>
					<option value="West Bengal">West Bengal</option>
				</select> <input type="date" class="date" placeholder="Avaiable Date" />
			</div>
			<div class="right-filter-container">
				<div class="searchbox">
					<input type="text" placeholder="Search...." id="Input" />
					<div class="search-btn">
						<i class="fa fa-search" aria-hidden="true"></i>
					</div>
				</div>
			</div>
		</div>

		<%--This will display all the rooms  --%>
		<div class="container" id="container">
			<%@ include file="../fragments/DisplayRooms.jspf"%>
		</div>
	</div>

	<%-- This is  the link to include Footer --%>
	<%@ include file="../fragments/footer.jspf"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#fetchval").on('change', function() {
				var value = $(this).val();
				$.ajax({
					url : '/dashboard',
					type : 'POST',
					data : 'request=' + value,
					beforeSend : function() {
						$("#container").html('Loading...');
					},
					success : function(data) {
						if (data == "error")
							window.location = "/dashboard";
						else
							$("#container").html(data);
					},
				});
			});
		});

		$(document)
				.ready(
						function() {
							let isactive = false;
							$("#Input").on("click", function() {
								if (!checkSession()) {
									window.location = "/dashboard";
								} else {
									isactive = true;
								}

							});
							$("#Input")
									.on(
											"keyup",
											function() {
												if (isactive) {
													var value = $(this).val()
															.toLowerCase();
													for (i = 1; i <= 12; i++) {
														$("#card" + i)
																.filter(
																		function() {
																			$(
																					this)
																					.toggle(
																							$(
																									this)
																									.text()
																									.toLowerCase()
																									.indexOf(
																											value) > -1)
																		});
													}
												}

											});
						});

		function checkSession() {
			var abc = false;
			$.ajax({
				url : '/logout',
				type : 'POST',
				success : function(data) {
					if (data == "valid") {
						abc = true;
					}

				},
				async : false
			});

			console.log(abc);
			return abc;
		}
	</script>
</body>
</html>