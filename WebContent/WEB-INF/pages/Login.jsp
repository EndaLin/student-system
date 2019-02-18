<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>学生信息管理平台</title>

		<!-- CSS -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
		<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
		<link rel="stylesheet" href="assets/css/style.css">

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

		<!-- Favicon and touch icons -->
		<link rel="shortcut icon" href="assets/ico/favicon.png">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
		<style type="text/css">
			body {
				font-family: 'Roboto', sans-serif;
				font-size: 16px;
				font-weight: 300;
				color: #888;
				line-height: 30px;
				text-align: center;
			}
			
			strong {
				font-weight: 500;
			}
			
			a,
			a:hover,
			a:focus {
				color: #4aaf51;
				text-decoration: none;
				-o-transition: all .3s;
				-moz-transition: all .3s;
				-webkit-transition: all .3s;
				-ms-transition: all .3s;
				transition: all .3s;
			}
			
			h1,
			h2 {
				margin-top: 10px;
				font-size: 38px;
				font-weight: 100;
				color: #555;
				line-height: 50px;
			}
			
			h3 {
				font-size: 22px;
				font-weight: 300;
				color: #555;
				line-height: 30px;
			}
			
			img {
				max-width: 100%;
			}
			
			::-moz-selection {
				background: #4aaf51;
				color: #fff;
				text-shadow: none;
			}
			
			::selection {
				background: #4aaf51;
				color: #fff;
				text-shadow: none;
			}

			
			.btn-link-1 i {
				padding-right: 5px;
				vertical-align: middle;
				font-size: 20px;
				line-height: 20px;
			}

			/***** Top content *****/
			
			.inner-bg {
				padding: 100px 0 170px 0;
			}
			
			.top-content .text {
				color: #fff;
			}
			
			.top-content .text h1 {
				color: #fff;
			}
			
			.top-content .description {
				margin: 20px 0 10px 0;
			}
			
			.top-content .description p {
				opacity: 0.8;
			}
			
			.top-content .description a {
				color: #fff;
			}
			
			.top-content .description a:hover,
			.top-content .description a:focus {
				border-bottom: 1px dotted #fff;
			}
			
			.form-box {
				margin-top: 35px;
			}
			
			.form-top {
				overflow: hidden;
				padding: 0 25px 15px 25px;
				background: #fff;
				-moz-border-radius: 4px 4px 0 0;
				-webkit-border-radius: 4px 4px 0 0;
				border-radius: 4px 4px 0 0;
				text-align: left;
			}
			
			.form-top-left {
				float: left;
				width: 75%;
				padding-top: 25px;
			}
			
			.form-top-left h3 {
				margin-top: 0;
			}
			
			.form-top-right {
				float: left;
				width: 25%;
				padding-top: 5px;
				font-size: 66px;
				color: #ddd;
				line-height: 100px;
				text-align: right;
			}
			
			.form-bottom {
				padding: 25px 25px 30px 25px;
				background: #eee;
				-moz-border-radius: 0 0 4px 4px;
				-webkit-border-radius: 0 0 4px 4px;
				border-radius: 0 0 4px 4px;
				text-align: left;
			}
			
			.form-bottom form textarea {
				height: 100px;
			}
			
			.form-bottom form button.btn {
				width: 100%;
			}

			
			.social-login h3 {
				color: #fff;
			}

			/***** Media queries *****/
			
			@media (min-width: 992px) and (max-width: 1199px) {}
			
			@media (min-width: 768px) and (max-width: 991px) {}
			
			@media (max-width: 767px) {
				.inner-bg {
					padding: 60px 0 110px 0;
				}
			}
			
			@media (max-width: 415px) {
				h1,
				h2 {
					font-size: 32px;
				}
			}
		</style>
	</head>

	<body>

		<!-- Top content -->
		<div class="top-content">

			<div class="inner-bg">
				<div class="container">
					<div class="row">
						<div class="col-sm-8 col-sm-offset-2 text">
							<h1>
							<strong>“学生信息”</strong> 管理平台
						</h1>
							<div class="description"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3 form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>Login to our site</h3>
									<p>Enter your username and password to log on:</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">
								<form role="form" action="/StuSys/LoginServlet" method="post" class="login-form">
									<div class="form-group">
										<label class="sr-only" for="form-username">Username</label> <input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username" value=" ">
								</div>
								<div class="form-group ">
									<label class="sr-only " for="form-password ">Password</label> <input
										type="password " name="form-password " placeholder="Password... "
										class="form-password form-control " id="form-password " value=" ">
								</div>
								<button type="submit " class="btn ">Sign in!</button>
								<div style="color:red; ">${mess }${mess = " " }</div>
							</form>
							<br />
							<form role="form " action="/StuSys/RegisterUIServlet " method="post "
								class="login-form ">
								<button type="submit " class="btn ">管理员账号注册</button>
							</form>
							<div style="color: red; ">${message} ${message = " "}</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div style="border-top: solid; border-color: white; width: 500px; height: 100px; margin-left: auto; margin-right: auto; text-align: center; ">
		平台解释权归本小组所有
	</div>



	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js "></script>
	<script src="assets/bootstrap/js/bootstrap.min.js "></script>
	<script src="assets/js/jquery.backstretch.min.js "></script>
	<script src="assets/js/scripts.js "></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js "></script>
        <![endif]-->

</body>
</html>