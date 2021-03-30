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
<title>Hospital Login Panel</title>
</head>
<body>
	<div class="container-fluid" align='center'
		style='background-image: url("${pageContext.request.contextPath}/images/hospitalreg.jpg"); background-attachment:fixed; background-size:100% 100%;'>
		<div class='container'>
			<div class="alert alert-success">
				<h1
					style='font-family: serif; font-style: oblique; font-size: 250%;'>
					<img src="${pageContext.request.contextPath}/images/hospital.png"
						height="100" width="100" />Hospital Login Panel
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
									<label class="col-md-10 control-label">Enter Hospital
										Unique ID: </label>
									<div class="col-md-10">
										<input placeholder="Hospital ID" type="text"
											name="hospital_id" class="form-control" />
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

				<hr />
				<h6>
					<p>Does'nt have a account ?</p>
					<a href="<spring:url value='/hospital/register'/>">Sign up now</a>
				</h6>
			</div>
			<div class="column" style='background-color: #ffcccc;' align="right">

				<button class="btn btn-link">
					<a href="<spring:url value='/'/>">Back to HomePage</a>
				</button>
				||
				<button class="btn btn-link">
					<a href="<spring:url value='/admin/login'/>">Admin Login Page</a>
				</button>
			</div>
		</div>
		<br> <br> <br> <br>

	</div>
</body>
</html>
