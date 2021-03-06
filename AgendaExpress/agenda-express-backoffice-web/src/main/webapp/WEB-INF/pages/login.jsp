<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Font Awesome -->
	<link href="resources/css/font-awesome.min.css" rel="stylesheet">
	
	<!-- Perfect -->
	<link href="resources/css/app.min.css" rel="stylesheet">

  </head>

  <body>
	<div class="login-wrapper">
		<div class="text-center">
			<h2 class="fadeInUp animation-delay8" style="font-weight:bold">
				<span class="text-success">Agenda</span> <span style="color:#ccc; text-shadow:0 1px #fff">Express</span>
			</h2>
		</div>
		<div class="login-widget animation-delay1">	
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<div class="pull-left">
						<i class="fa fa-lock fa-lg"></i> Login
					</div>

					<div class="pull-right">
						<span style="font-size:11px;">Don't have any account?</span>
						<a class="btn btn-default btn-xs login-link" href="register.html" style="margin-top:-2px;"><i class="fa fa-plus-circle"></i> Sign up</a>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-login" action="<c:url value="login"/>" method="post">
						<div class="form-group">
							<label>Username</label>
							<input type="text" placeholder="Username" class="form-control input-sm bounceIn animation-delay2" name="login">
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" placeholder="Password" class="form-control input-sm bounceIn animation-delay4" name="password">
						</div>
						<div class="form-group">
							<label class="label-checkbox inline">
								<input type="checkbox" class="regular-checkbox chk-delete" />
								<span class="custom-checkbox info bounceIn animation-delay4"></span>
							</label>
							Remember me		
						</div>
		
						<div class="seperator"></div>
						<div class="form-group">
							Forgot your password?<br/>
							Click <a href="#">here</a> to reset your password
						</div>

						<hr/>
							
						<a class="btn btn-success btn-sm bounceIn animation-delay5 login-link pull-right" type="submit"><i class="fa fa-sign-in"></i> Sign in</a>
					</form>
				</div>
			</div><!-- /panel -->
		</div><!-- /login-widget -->
	</div><!-- /login-wrapper -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- Jquery -->
	<script src="resources/js/jquery-1.10.2.min.js"></script>
    
    <!-- Bootstrap -->
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
   
	<!-- Modernizr -->
	<script src='resources/js/modernizr.min.js'></script>
   
    <!-- Pace -->
	<script src='resources/js/pace.min.js'></script>
   
	<!-- Popup Overlay -->
	<script src='resources/js/jquery.popupoverlay.min.js'></script>
   
    <!-- Slimscroll -->
	<script src='resources/js/jquery.slimscroll.min.js'></script>
   
	<!-- Cookie -->
	<script src='resources/js/jquery.cookie.min.js'></script>

	<!-- Perfect -->
	<script src="resources/js/app/app.js"></script>
  </body>
</html>
