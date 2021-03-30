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
<title>Admitted Patients List</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-md-8' align='left'>
				<h2 style="font-family: serif; font-size: 250%">Admitted
					Patients List:</h2>
			</div>
			<div class='col-md-2' align='right'>
				<button class="btn btn-light">
					<a href="<spring:url value='/hospital/welcome'/>">Back to Home
						Page</a>
				</button>
			</div>
			<div class='col-md-2' align='left'>
				<button class="btn btn-light">
					<a href="<spring:url value='/patient/dischargedlist'/>">List of
						Discharged Patients</a>
				</button>
			</div>
		</div>

		<div class='container'>
			<table class="table table-hover">
				<tr style="background-color: #ffcccc; color: black;">
					<th>Patient ID</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Age</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Disease</th>
					<th>Admit Date</th>
					<th>Status</th>
					<th>Discharge and Generate Bill</th>
				</tr>
				<c:forEach var="v" items="${sessionScope.patient_list}">
					<tr>
						<td>${v.patientID}</td>
						<td>${v.name}</td>
						<td>${v.gender}</td>
						<td>${v.age}</td>
						<td>${v.contactNo}</td>
						<td>${v.address}</td>
						<td>${v.city}</td>
						<td>${v.state}</td>
						<td>${v.disease}</td>
						<td>${v.admitDate}</td>
						<td>${v.status}</td>

						<td><button class="btn btn-light">
								<a
									href="<spring:url value='/bill/generatedbill?vpid=${v.patientID}'/>">Click
									Here</a>
							</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>



	</table>
</body>
</html>