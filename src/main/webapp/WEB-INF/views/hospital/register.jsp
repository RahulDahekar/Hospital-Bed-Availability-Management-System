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
<title>Hospital Registration Form</title>
</head>
<body>
	<div class='container-fluid'
		style='background-image: url("${pageContext.request.contextPath}/images/hospitalreg.jpg"); background-attachment:fixed; background-size:100% 100%;'>
		<div class="container" align="center">
			<div class="jumbotron" style="border-style: double;">
				<h1 style="font-family: serif;">Register with Us</h1>
				<br>
				<h5 align='left'>Why register with us ?</h5>
				<p>
					Manage your hospital without any paid services. <br> And help
					us in our initiative to provide bed availability in nearby
					hospitals for patients at their crucial stage between life and
					death.<br> We'll do it together for a better cause
				</p>
				<h5 style="font-family: serif; font-size: 200%; color: red">Safety
					starts with "S" but begins with you.</h5>
			</div>
			<hr />
			<div class='container'>
				<div class='row'>
					<div class='col-md-12' align='right'>
						<h5>
							<button class="btn btn-light">
								<a href="<spring:url value='/hospital/login'/>">Hospital
									Login Page</a>
							</button>
							||
							<button class="btn btn-light">
								<a href="<spring:url value='/admin/login'/>">Admin Login
									Page</a>
							</button>
							||
							<button class="btn btn-light">
								<a href="<spring:url value='/'/>">Back to HomePage</a>
							</button>
						</h5>
					</div>
					<div class="col-md-12" align='left'>

						<div class="form-horizontal">
							<h4>Create a New Account:</h4>
							<hr />
							<form:form method="post" modelAttribute="hospital">
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>Hospital Unique ID: </label>
									<div class="row">
										<div class='col-md-8'>
											<form:input path="hospitalAdminID" class="form-control"
												placeholder='Enter Hopital Unique ID' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="hospitalAdminID" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>Hospital Name: </label>
									<div class="row">
										<div class="col-md-8">
											<form:input path="name" class="form-control"
												placeholder='Enter Hospital Name' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="name" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>Address: </label>
									<div class="row">
										<div class="col-md-8">
											<form:input path="address" class="form-control"
												placeholder='Enter Hospital Address' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="address" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>City: </label>
									<div class="row">
										<div class="col-md-8">
											<form:input path="city" class="form-control"
												placeholder='Enter City Name' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="city" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>State: </label>
									<div class="row">
										<div class="col-md-8">
											<form:input path="state" class="form-control"
												placeholder='Enter State Name' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="state" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>Contact No: </label>
									<div class="row">
										<div class="col-md-8">
											<form:input path="contactNo" class="form-control"
												placeholder='Enter max 10 digit contact number' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="contactNo" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label"
										style='font-style: oblique;'>Password: </label>
									<div class="row">
										<div class="col-md-8">
											<form:input path="hospitalAdminPassword" class="form-control"
												placeholder='Enter Strong Password' type='password' />
										</div>
										<div class="col-md-4">
											<div class="alert alert-danger" role="alert">
												<form:errors path="hospitalAdminPassword" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-10">
										<button class="btn btn-success">Proceed</button>
									</div>
								</div>
						</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>