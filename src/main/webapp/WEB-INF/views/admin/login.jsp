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
<title>Admin Panel</title>
</head>
<body>
	<div class="container-fluid" align='center'
		style='background-image: url("${pageContext.request.contextPath}/images/hospitalreg.jpg"); background-attachment:fixed; background-size:100% 100%;'>
		<div class="container" align="center">
			<div class="alert alert-success">
				<h1
					style='font-family: serif; font-style: oblique; font-size: 250%;'>
					<img src="${pageContext.request.contextPath}/images/admin.png"
						height="100" width="100" />Admin Login Page
				</h1>
			</div>
			<hr />
			<div class="alert alert-light">
				<div class="row">
					<div class="col-md-12" align="left">
						<div class="form-horizontal">
							<div class="alert alert-danger" role="alert">
								${requestScope.message}</div>
							<hr />

							<form method="post">
								<div class="form-group">
									<label class="col-md-10 control-label">Enter User Name:
									</label>
									<div class="col-md-10">
										<input placeholder="Admin User Name" type="text"
											name="user_name" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-10 control-label">Password: </label>
									<div class="col-md-10">
										<input placeholder="Password" type="password" name="password"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-10">
										<button class="btn btn-success">Login</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="column" style='background-color: #e6f9ff;' align='right'>
					<button class="btn btn-link">
						<a href="<spring:url value='/'/>">Back to HomePage</a>
					</button>
					||
					<button class="btn btn-link">
						<a href="<spring:url value='/hospital/login'/>">Hospital Login
							Page</a>
					</button>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
	</div>
</body>
</html>