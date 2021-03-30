<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Patient Admit Form</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-md-6'
				style='font-family: serif; font-style: oblique; font-size: 250%'>
				Patient Registration Form</div>
			<div class='col-md-6' align='right'>
				<br>
				<button class="btn btn-light">
					<a href="<spring:url value='/hospital/welcome'/>">Back to Home
						Page</a>
				</button>
			</div>
		</div>
		<hr />
		<div class='form-horizontal'>
			<form:form method="post" modelAttribute="patient">
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Name: </label>
						<div class='col-md-6'>
							<form:input path="name" class='form-control'
								placeholder='Enter Patient full name' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="name" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Gender: </label>
						<div class='col-md-2' align='left'>
							Male:
							<form:radiobutton path="gender" value="Male" />
						</div>
						<div class='col-md-2' align='left'>
							Female:
							<form:radiobutton path="gender" value="Female" />
						</div>
						<div class='col-md-2' align='left'>
							Transgender:
							<form:radiobutton path="gender" value="Transgender" />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="gender" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Age(in years): </label>
						<div class='col-md-6'>
							<form:input path="age" class='form-control'
								placeholder='Enter valid age' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="age" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Contact No: </label>
						<div class='col-md-6'>
							<form:input path="contactNo" class='form-control'
								placeholder='Enter Contact No.' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="contactNo" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Address: </label>
						<div class='col-md-6'>
							<form:input path="address" class='form-control'
								placeholder='Enter Address with landmark' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="address" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>City: </label>
						<div class='col-md-6'>
							<form:input path="city" class='form-control'
								placeholder='Enter City name' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="city" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>State: </label>
						<div class='col-md-6'>
							<form:input path="state" class='form-control'
								placeholder='Enter State name' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="state" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Disease: </label>
						<div class='col-md-6'>
							<form:input path="disease" class='form-control'
								placeholder='Enter Disease of patient' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="disease" />
							</div>
						</div>
					</div>
				</div>
				<div class='form'>
					<div class='row'>
						<label class='col-md-2 control-label'>Admit Date: </label>
						<div class='col-md-6'>
							<form:input path="admitDate"
								value="<%=java.time.LocalDate.now()%>" class='form-control' />
						</div>
						<div class='col-md-4'>
							<div class="alert alert-danger" role="alert">
								<form:errors path="admitDate" />
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-8" align='right'>
						<button class="btn btn-success">Proceed to allocate room</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>