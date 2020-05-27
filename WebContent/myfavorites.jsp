<%@page import="com.happylife.pojo.User"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Profile</title>

	<!-- Bootstrap core CSS -->
	<!--link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
	<!-- specific -->

	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/myfav.css" rel="stylesheet">

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Side navigation menu -->
	<link href="${pageContext.request.contextPath}/css/sidnavpush.css" rel="stylesheet">

	<!-- font awesome -->
	<link href="${pageContext.request.contextPath}/fonts/css/font-awesome.min.css" rel="stylesheet">

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
		<a href="/HappyLife/myinbox">Inbox</a>
		<a href="#">Sent</a>
		<a href="#">Search</a>
		<a href="#">My Favorites</a>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="jumbotron font">
			<div class="row">
				<div class="col-xs-2 col-md-2">
					<a href="publicphotos/1.JPG" class="thumbnail">
						<img src="publicphotos/1.JPG" alt="...">
					</a>
				</div>
				<div class="col-xs-4 col-md-4 move">
				<h3>Noorah Ali
					<span class="label label-default overrides">New</span>
				</h3>
				<p>Loving, Friendly Trustworthy</p>
				<p>Age: 25 Years old</p>
				<p>Location: Cardiff , United Kingdom</p>
				<p>Message response rate : 80%</p>
				</div>
				<div class="col-xs-4 col-sm-4 moveleft">
					<div class="list-group">
						<a href="#" class="list-group-item active">Send message</a>
						<a href="#" class="list-group-item">Remove her from my favourites</a>
						<a href="#" class="list-group-item">invite her to view my profile</a>
						<a href="#" class="list-group-item">Ask to exchange photos with her</a>
						<a href="#" class="list-group-item">Your notes on her</a>
					</div>
				</div>		
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-2 col-md-2">
					<a href="publicphotos/1.JPG" class="thumbnail">
						<img src="publicphotos/1.JPG" alt="...">
					</a>
				</div>
				<div class="col-xs-4 col-md-4 move">
				<h3>Noorah Ali
					<span class="label label-default overrides">New</span>
				</h3>
				<p>Loving, Friendly Trustworthy</p>
				<p>Age: 25 Years old</p>
				<p>Location: Cardiff , United Kingdom</p>
				<p>Message response rate : 80%</p>
				</div>
				<div class="col-xs-4 col-sm-4 moveleft">
					<div class="list-group">
						<a href="#" class="list-group-item active">Send message</a>
						<a href="#" class="list-group-item">Remove her from my favourites</a>
						<a href="#" class="list-group-item">invite her to view my profile</a>
						<a href="#" class="list-group-item">Ask to exchange photos with her</a>
						<a href="#" class="list-group-item">Your notes on her</a>
					</div>
				</div>		
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-2 col-md-2">
					<a href="publicphotos/1.JPG" class="thumbnail">
						<img src="publicphotos/1.JPG" alt="...">
					</a>
				</div>
				<div class="col-xs-4 col-md-4 move">
				<h3>Noorah Ali
					<span class="label label-default overrides">New</span>
				</h3>
				<p>Loving, Friendly Trustworthy</p>
				<p>Age: 25 Years old</p>
				<p>Location: Cardiff , United Kingdom</p>
				<p>Message response rate : 80%</p>
				</div>
				<div class="col-xs-4 col-sm-4 moveleft">
					<div class="list-group">
						<a href="#" class="list-group-item active">Send message</a>
						<a href="#" class="list-group-item">Remove her from my favourites</a>
						<a href="#" class="list-group-item">invite her to view my profile</a>
						<a href="#" class="list-group-item">Ask to exchange photos with her</a>
						<a href="#" class="list-group-item">Your notes on her</a>
					</div>
				</div>		
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
</body>
</html>