<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Send message</title>

	<!-- Bootstrap core CSS -->
	<!--link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"-->
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
   	<!-- specific -->
   	
   	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
   	<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
   	
   	<meta name="viewport" content="width=device-width, initial-scale=1">
 		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
   	
   	<!-- Side navigation menu -->
   	<link href="${pageContext.request.contextPath}/css/sidnavpush.css" rel="stylesheet">
	
	<!-- for responsive tabs -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap337.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
 	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
</head>
<body>
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="javascript:void(0)"
						style="cursor: pointer;" id="nav_title" onclick="openNav()">&#9776;
						Happy Life</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a>welcome ${username}</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</header>
	
	<div id="mySidenav" class="sidenav">
		<a href="#">Inbox</a>
		<a href="#">Sent</a>
		<a href="#">Search</a>
		<a href="#">Contact</a>
	</div>

	<br>
	<br>

	<br>
	<br>
	<div class="container">
		<ul class="nav nav-tabs">
			<li><a href="/HappyLife/myprofile">Home</a></li>
			<li><a href="/HappyLife/pinfo">My Profile</a></li>
			<li><a href="/HappyLife/search">Search</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>

		<div class="tab-content">

			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				<br>
				<hr>

				<div id="" class="grid-container">
					<form action="${pageContext.request.contextPath}/sendmessage" method="POST">
						<div class="row">
							<div class="col-12">
								<p>message to ${candidName}</p>
								<textarea class="col-12" name="message" id="profiletextarea"
									rows="7" cols="100">${aboutMeInfo}</textarea>
							</div>
						</div>
						<br>

						<div class="row">
							<div class="col-2">
								<input type="submit" name="submit" value="submit">
							</div>
						</div>
					</form>
				</div>
				<hr>
				
				<!-- user-block -->
				<br>
				
				<br>
			</div>


		</div>

	</div>
	<!-- container -->
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>	
</body>
</html>