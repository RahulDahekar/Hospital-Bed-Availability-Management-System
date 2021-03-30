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
<title>Hospital Welcome Page</title>
</head>
<body>
	<div class='container-fluid'
		style='background-image: url("${pageContext.request.contextPath}/images/hospitalwelcome4.jpg"); background-attachment:fixed; background-size:100% 100%; background-color:transparent;");'>
		<div class="container">
			<div class='jumbotron' style='background-color: transparent;'>
				<div class="row" style="background-color: transparent;">
					<div class="col-md-4" align="left">
						<div class="alert alert-success">
							Welcome to <strong>Hospital Admin Panel</strong>
						</div>
					</div>
					<div class='col-md-4'></div>
					<div class="col-md-3" style="color: red" align="right">
						<div class="alert alert-danger">
							Login Successfully with Hospital ID: <strong>${sessionScope.hospital_details.hospitalAdminID}</strong>
						</div>

						<h5>
							<button class="btn btn-light">
								<a href="<spring:url value='/hospital/logout'/>">Log Out </a>
							</button>
						</h5>
					</div>

				</div>
				<div class="row">
					<div class="col-lg-12"
						style="font-style: italic; font-size: 400%; font-family: serif; color: black"
						align="center">
						<div class="alert alert-success">
							<strong>${sessionScope.hospital_details.name}</strong>
						</div>
					</div>
				</div>
			</div>
			<div class="row"
				style="font-size: medium; color: black; background-color: #f5f5ef;">

				<div class="col-md-3" align="left">
					<h5 align="left" style="color: black; font-style: italic;">
						<div class="alert alert-info">Hospital Details</div>
					</h5>
					<table align="left">
						<tr>
							<th>Hospital ID:</th>
							<td>${sessionScope.hospital_details.hospitalAdminID}</td>
						</tr>
						<tr>
							<th>Location:</th>
							<td>${sessionScope.hospital_details.address}</td>
						</tr>
						<tr>
							<th>City:</th>
							<td>${sessionScope.hospital_details.city}</td>
						</tr>
						<tr>
							<th>State:</th>
							<td>${sessionScope.hospital_details.state}</td>
						</tr>
						<tr>
							<th>Contact No.:</th>
							<td>${sessionScope.hospital_details.contactNo}</td>
						</tr>
					</table>
				</div>
				<div class='col-md-3' align='center'>
					<br> <a href="<spring:url value='/patient/register'/>"><img
						src="${pageContext.request.contextPath}/images/patientadmiticon.png"
						height="100" width="100" /></a><br>
					<button class="btn btn-light">
						<a href="<spring:url value='/patient/register'/>">Add a
							Patient</a>
					</button>
				</div>
				<div class='col-md-3' align='center'>
					<br> <a href="<spring:url value='/patient/admittedlist'/>"><img
						src="${pageContext.request.contextPath}/images/patinetlisticon.png"
						height="100" width="100" /></a><br>
					<button class="btn btn-light">
						<a href="<spring:url value='/patient/admittedlist'/>">List of
							Admitted Patients</a>
					</button>
				</div>
				<div class='col-md-3' align='center'>
					<br> <a href="<spring:url value='/patient/dischargedlist'/>"><img
						src="${pageContext.request.contextPath}/images/dischargeicon.png"
						height="100" width="100" /></a><br>
					<button class="btn btn-light">
						<a href="<spring:url value='/patient/dischargedlist'/>">List
							of Discharged Patients</a>
					</button>
				</div>
			</div>
			<div class='row'>
				<div class="alert alert-danger" role="alert">
					${requestScope.message}</div>
			</div>
			<div class='row'>
				<br> <br> <br>
			</div>
		</div>
	</div>
</body>
</html>