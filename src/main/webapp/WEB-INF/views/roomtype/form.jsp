<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Select Rooms Available</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-md-12'>
				<h1>Room Type Selection Form</h1>
			</div>
			
			<div class='col-md-12'>
				<div class="alert alert-danger" role="alert">
					${requestScope.message}</div>
			</div>
			<div class='col-md-12'>
				<form:form method="post" modelAttribute="roomtype">
					<div class='row'>
						<div class='col-md-4'>Room Types</div>
						<div class='col-md-4'>Number of Beds Available</div>
						<div class='col-md-4'>Bed price per day(in INR)</div>
					</div>
					<div class='row'>
						<div class='col-md-4'>
							ICU:
							<form:checkbox path="icu" value="ICU" />
						</div>
						<div class='col-md-4'>
							<form:input path="icuQuantity" class="form-control"
								placeholder='Enter number of ICU Beds' />
						</div>
						<div class='col-md-4'>
							<form:input path="icuPrice" class="form-control"
								placeholder='Enter ICU bed price per day' />
						</div>
					</div>
					<div class='row'>
						<div class='col-md-4'>
							Non-ICU:
							<form:checkbox path="nonicu" value="non-ICU" />
						</div>
						<div class='col-md-4'>
							<form:input path="nonicuQuantity" class="form-control"
								placeholder='Enter number of non-ICU Beds' />
						</div>
						<div class='col-md-4'>
							<form:input path="nonicuPrice" class="form-control"
								placeholder='Enter non-ICU bed price per day' />
						</div>
					</div>
					<div class='row'>
						<div class='col-md-4'>
							General:
							<form:checkbox path="general" value="General" />
						</div>
						<div class='col-md-4'>
							<form:input path="generalQuantity" class="form-control"
								placeholder='Enter number of GENERAL Beds' />
						</div>
						<div class='col-md-4'>
							<form:input path="generalPrice" class="form-control"
								placeholder='Enter GENERAL bed price per day' />
						</div>
					</div>

					<hr />
					<button class="btn btn-success">Register</button>

				</form:form>
			</div>
		</div>
</body>
</html>