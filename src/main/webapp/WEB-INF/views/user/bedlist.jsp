<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Available Beds</title>
</head>
<body>
	<div class='container-fluid'>
		<div class='container'>
			<div class='row'>
				<div class='col-md-8' align='left'>
					<h2 style="font-family: serif; font-size: 250%">Available Bed
						Quantity and Price</h2>
				</div>
				<div class='col-md-4' align='right'>
					<button class="btn btn-light">
						<a href="<spring:url value='/user/enduserlist'/>">Back to
							Hospitals List</a>
					</button>
				</div>
			</div>
			<hr />
			<table class="table table-hover">
				<tr style="background-color: #ffcccc; color: black;">
					<th>Bed Category</th>
					<th>Price of a bed per day (in INR)</th>
					<th>Number of Beds Available</th>
				</tr>
				<tr>
					<td style='font-style: oblique;'>ICU</td>
					<td>${sessionScope.room_details.icuPrice}/-</td>
					<td>${sessionScope.room_details.icuQuantity}</td>
				</tr>
				<tr>
					<td style='font-style: oblique;'>Non-ICU</td>
					<td>${sessionScope.room_details.nonicuPrice}/-</td>
					<td>${sessionScope.room_details.nonicuQuantity}</td>
				</tr>
				<tr>
					<td style='font-style: oblique;'>General Ward</td>
					<td>${sessionScope.room_details.generalPrice}/-</td>
					<td>${sessionScope.room_details.generalQuantity}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>