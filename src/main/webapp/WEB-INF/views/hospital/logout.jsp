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
<title>Logged Out Successfully</title>
</head>
<body>
	<div class='container'>
		<div class='row' align='center'>
			<div class='col-md-4'>
				<br> <span style='font-size: 100px;'>&#128578;</span>
			</div>
			<div class='col-md-8' align='left'
				style='font-size: 250%; font-style: oblique; font-family: serif;'>
				<br> Thanks for visiting.<br>Get Back to us Soon. <br>

			</div>
		</div>

		<hr />
		<div class='row'>
			<div class='col-md-6' align='left'>
				<h3>Hello, you have been logged out successfully</h3>
				<br />
				<p>
					We are happy to serve you<br> Kindly login again with right
					credentials.<br>Your session has been invalidated for current
					request.<br>
				</p>
			</div>
			<div class='col-md-6' align='center'>
				<img src="${pageContext.request.contextPath}/images/arrow.png"
					height="60" width="60" />
				<button class="btn btn-light">
					<a href="<spring:url value='/'/>">Back To Home Page</a>
				</button>
			</div>
		</div>
	</div>
</body>
</html>