<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<c:set var="context" scope="session"
	value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Login | E-Shopper</title>
<link href="${context}/css/menu.css" rel="stylesheet">
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/font-awesome.min.css" rel="stylesheet">
<link href="${context}/css/prettyPhoto.css" rel="stylesheet">
<link href="${context}/css/price-range.css" rel="stylesheet">
<link href="${context}/css/animate.css" rel="stylesheet">
<link href="${context}/css/main.css" rel="stylesheet">
<link href="${context}/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="${context}/js/html5shiv.js"></script>
    <script src="${context}/js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="${context}/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${context}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${context}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${context}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${context}/images/ico/apple-touch-icon-57-precomposed.png">
<script type="text/javascript">
	function signupValidation() {
		// get the form values
		var emailId = $('#email').val();
		var password = $('#pass').val();
		$.ajax({
			url : '${context}/user/validate',
			data : "email=" + emailId + "&password=" + password,
			success : function(response) {
				// we have the response
				if (response.status == "SUCCESS") {
					//submit sign up form
					$('#signup_form').submit();
				} else {
					var errorInfo = "";
					for (i = 0; i < response.result.length; i++) {
						errorInfo += "<br>" + (i + 1) + ". "
								+ response.result[i].code;
					}
					//print error on UI
					$('#error').html(
							"Please correct following errors: " + errorInfo);
				}
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

	function loginValidation() {
		// get the form values
		var emailId = $('#login_email').val();
		var password = $('#login_pass').val();
		$.ajax({
			url : '${context}/user/validate',
			data : "email=" + emailId + "&password=" + password,
			success : function(response) {
				// we have the response
				if (response.status == "SUCCESS") {
					//submit sign up form
					$('#login_form').submit();
				} else {
					var errorInfo = "";
					for (i = 0; i < response.result.length; i++) {
						errorInfo += "<br>" + (i + 1) + ". "
								+ response.result[i].code;
					}
					//print error on UI
					$('#login_error').html(
							"Please correct following errors: " + errorInfo);
				}
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
</script>
</head>
<!--/head-->

<body>
	<jsp:include page="header.jsp" />

	<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>Login to your account</h2>
					<div id="login_error" class="errorblock"></div>
					<c:if test="${not empty error}">
						<div style="color: red">
							<span>Your fake login attempt was bursted, dare again !!<br />
								Caused :
								${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
						</div>
					</c:if>
					<form action="${context}/j_spring_security_check" id="login_form"
						method="post">
						<%-- <form:errors path="*" cssClass="errorblock" /> --%>
						<input name="j_username" id="login_email"
							placeholder="Email Address" /> <input name="j_password"
							type="password" id="login_pass" placeholder="Password" /> <span>
							<input id="j_remember" name="_spring_security_remember_me"
							type="checkbox" class="checkbox"> Keep me signed in </span>
						<!-- - See more at: http://outbottle.com/spring-3-security-custom-login-form-with-remember-me/#sthash.GS2FD2N3.dpuf -->
						<button type="button" class="btn btn-default"
							onclick="loginValidation()">Login</button>
					</form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->

					<h2>New User Signup!</h2>
					<div id="error" class="errorblock"></div>
					<form:form action="${context}/registration"
						modelAttribute="userBean" id="signup_form">
						<%-- <form:errors path="*" cssClass="errorblock" /> --%>
						<form:input path="emailId" id="email" placeholder="Email Address" />
						<form:password path="password" id="pass" placeholder="Password" />
						<form:button type="button" class="btn btn-default"
							onclick="signupValidation()">Signup</form:button>
					</form:form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
	</section>
	<!--/form-->

	<jsp:include page="footer.jsp" />

	<script src="${context}/js/jquery.js"></script>
	<script src="${context}/js/price-range.js"></script>
	<script src="${context}/js/jquery.scrollUp.min.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>
	<script src="${context}/js/jquery.prettyPhoto.js"></script>
	<script src="${context}/js/main.js"></script>
</body>
</html>