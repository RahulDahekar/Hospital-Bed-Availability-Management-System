<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>End Users Hospital</title>
</head>
<body>
	<div class="container">
		<div class='row'>
			<div class='col-md-8' align='left'>
				<h2 style="font-family: serif; font-size: 375%">Hospitals List</h2>
			</div>
			<div class='col-md-4' align='right'>
				<button class="btn btn-light">
					<a href="<spring:url value='/'/>">Back to HomePage</a>
				</button>
			</div>
		</div>
		<div class="container" align='center'>
			<div class="alert alert-danger" role="alert">
				${requestScope.message}</div>
			<hr />
			<div class='form-horizontal'>
				<form method="post">
					<div class='form-group'>
						<label class='col-md-5 control-label'>Enter City Name</label>
						<div class='col-md-3'>
							<input type="text" name="city" placeholder='City name'
								class='form-control' />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<button class="btn btn-success">Search</button>
						</div>
					</div>

				</form>
			</div>
		</div>
		<hr />
		<div class='container'>

			<table class='table table-hover'>
				<tr style="background-color: #ffcccc; color: black;">
					<th>Hospital ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Contact No</th>
					<th>Show Beds List</th>
				</tr>
				<c:forEach var="h" items="${sessionScope.hospital_list}">
					<tr>
						<td>${h.hospitalAdminID}</td>
						<td>${h.name}</td>
						<td>${h.address}</td>
						<td>${h.city}</td>
						<td>${h.state}</td>
						<td>${h.contactNo}</td>
						<td><button class="btn btn-light">
								<a
									href="<spring:url value='/user/bedlist?hid=${h.hospitalID}'/>">Show
									Beds at ${h.name}</a>
							</button></td>

					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>