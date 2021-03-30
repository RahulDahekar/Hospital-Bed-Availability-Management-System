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
<title>LOGIN PANEL</title>
</head>
<body>
	<div class='container-fluid'
		style='background-image: url("${pageContext.request.contextPath}/images/gallery.jpg"); background-attachment:fixed; background-size:100% 100%;'>

		<div class="container-fluid">
			<div class="jumbotron" style='background-color: transparent;'>
				<div class="alert alert-warning" role="alert">
					<h1 align="center" style="font-family: serif; font-size: 300%;">Hospital
						Bed Availability And Management Web App</h1>
				</div>
				<div class="alert alert-success">
					<p align='center'>
						<strong> We all are working together to take the
							technology to the next level.<br> With us you can manage
							hospital and patient details.<br> Any person can able to see
							beds available in their nearby hospital.
						</strong>
					</p>
				</div>
				<div class='row'>
					<div class='col-md-3'>
						<div class="alert alert-dark" role="alert">
							<h5>Choose your User type below:</h5>
						</div>
					</div>
				</div>
			</div>
			<div class='container'>
				<div class="alert alert-light" role="alert">
					<div class="row">
						<div class="col-md-4" align="center">
							<a href="<spring:url value='/admin/login'/>"><img
								src="${pageContext.request.contextPath}/images/admin.png"
								height="100" width="100" /></a><br> <a
								href="<spring:url value='/admin/login'/>">Admin Login</a>
						</div>
						<div class="col-md-4" align="center">
							<a href="<spring:url value='/hospital/login'/>"><img
								src="${pageContext.request.contextPath}/images/hospital.png"
								height="100" width="100" /></a><br> <a
								href="<spring:url value='/hospital/login'/>">Hospital Admin
								Login</a>
						</div>
						<div class="col-md-4" align="center">
							<a href="<spring:url value='/user/enduserlist'/>"><img
								src="${pageContext.request.contextPath}/images/bed.png"
								height="100" width="100" /></a><br> <a
								href="<spring:url value='/user/enduserlist'/>">Bed
								Availability in Nearby Hospital</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br>

	</div>
</body>
</html>