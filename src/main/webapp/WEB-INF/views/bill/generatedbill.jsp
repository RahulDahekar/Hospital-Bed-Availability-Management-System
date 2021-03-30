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
<title>Patient Bill</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12"
				style="font-style: italic; font-size: 410%; font-family: serif;"
				align="center">${sessionScope.hospital_details.name}</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-6" align='left'
				style="background-color: #66e0ff; font-family: serif; font-size: 300%; font-style: oblique;">
				Patient Bill Record<br>
				<p style="font-size: 45%; font-style: normal;">
					Discharge Date:
					<%=java.time.LocalDate.now()%><br> Bill ID:
					${sessionScope.bill_details.billID}
				</p>
			</div>
			<div class="col-md-6" align="justify"
				style="font-size: medium; color: black; background-color: #66e0ff;">
				<h5 align="right" style="color: black; font-style: italic;">Hospital
					Details</h5>
				<p align="right">
					Hospital ID: ${sessionScope.hospital_details.hospitalAdminID}<br>
					Location: ${sessionScope.hospital_details.address}<br> City:
					${sessionScope.hospital_details.city}<br> State:
					${sessionScope.hospital_details.state}<br> Contact No.:
					${sessionScope.hospital_details.contactNo}
				</p>
			</div>
		</div>
		<div class='container' align="justify">
			<div class='row' align="justify">
				<br>
				<div class='col-md-12'>
					<table class='table table-bordered'>

						<tr>
							<th style='font-style: oblique;'>Patient ID:</th>
							<td>${sessionScope.patient_details.patientID}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Name:</th>
							<td>${sessionScope.patient_details.name}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Gender:</th>
							<td>${sessionScope.patient_details.gender}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Age:</th>
							<td>${sessionScope.patient_details.age}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Contact No:</th>
							<td>${sessionScope.patient_details.contactNo}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Address:</th>
							<td>${sessionScope.patient_details.address}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>City:</th>
							<td>${sessionScope.patient_details.city}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>State:</th>
							<td>${sessionScope.patient_details.state}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Disease:</th>
							<td>${sessionScope.patient_details.disease}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Admit Date:</th>
							<td>${sessionScope.patient_details.admitDate}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Room Type:</th>
							<td>${sessionScope.bill_details.roomType}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Room Charge per Day(in INR):</th>
							<td>${sessionScope.bill_details.roomCharge}/-</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>No. of Days Admitted:</th>
							<td>${sessionScope.bill_details.admittedDays}</td>
						</tr>
						<tr>
							<th style='font-style: oblique;'>Total Bill:</th>
							<td style='font-size: large; font-weight: bold;'>${sessionScope.bill_details.totalBill}/-</td>
						</tr>

					</table>
				</div>
			</div>

			<div class="row">
				<div class='col-md-6'>
					<button class="btn btn-light">
						<a href="<spring:url value='/hospital/welcome'/>">Back to Home
							Page</a>
					</button>
				</div>
				<div class='col-md-6' align="right">
					<img src="${pageContext.request.contextPath}/images/printicon.png"
						height="60" width="60" />
					<button class="btn btn-light">
						<a href="#" onclick="javascript:window.print();">Print the
							Bill</a>
					</button>

				</div>
			</div>
		</div>
	</div>
</body>
</html>