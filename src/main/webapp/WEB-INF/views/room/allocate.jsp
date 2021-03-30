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
<title>Room Allocation Page</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-md-8'
				style='font-family: serif; font-style: oblique; font-size: 250%'>Room
				Allocation Page</div>
			<div class='col-md-4'>
				<br>
				<div class="alert alert-danger">${requestScope.message}</div>
			</div>
		</div>
		<hr />
		<form:form method="post" modelAttribute="room">
			<div class='column'>
				<div class='col-md-12'>
					<h2 style='font-family: serif; font-style: oblique;'>Select
						Room Type:-</h2>
				</div>
				<div class='row'>
					<div class='col-md-3'></div>
					<div class='col-md-4'>
						ICU:
						<form:radiobutton path="roomType" value="ICU" />
					</div>
				</div>
				<div class='row'>
					<div class='col-md-3'></div>
					<div class='col-md-4'>
						non-ICU:
						<form:radiobutton path="roomType" value="non-ICU" />
					</div>
				</div>
				<div class='row'>
					<div class='col-md-3'></div>
					<div class='col-md-4'>
						General:
						<form:radiobutton path="roomType" value="General" />
					</div>
				</div>
				<div class='row'>
					<div class='col-md-4'></div>
					<div class='col-md-4'>
						<div class="alert alert-danger">
							<form:errors path="roomType" />
						</div>
						<button class="btn btn-success">Allocate</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>