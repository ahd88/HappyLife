<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>How I Look - My Profile</title>
	
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
			<li class="active"><a href="/HappyLife/pinfo">My Profile</a></li>
			<li><a href="/HappyLife/search">Search</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>

		<div class="tab-content">

			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				<br>
				<p>edit</p>
				<ul class="nav nav-pills updateProfile">
					<li><a href="${pageContext.request.contextPath}/aboutme&lookingfor">About Me / Looking for</a></li>
					<li><a href="#myPhoto">My Photo</a></li>
					<li><a href="#myQuestions">My Questions</a></li>
				</ul>
				<hr>
				<p>How others see me</p>

				<br>
				<div id="user-block" class="grid-container container">
					<div class="row">
						<div class="profile-image col-xs-12 col-md-2">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p>
									<a id="mainfullimage" href="http://placehold.it/400/00F/FFF">
										<img src="${pageContext.request.contextPath}/publicphotos/${publicPhoto}" alt="click to see larger photo"
										title="click to see larger photo">
									</a>
								</p>
								<p>
									<a href="#createphotoprofilepage"><button>Change Photo</button></a>
								</p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>

						<div class="item3 col-xs-12 col-md-5">
							<ul class="summary">
								<li><label>Age:</label></li>
								<li><label>Location:</label></li>
								<li><label>Last Login:</label></li>
								<li><label>I am currently available for communication:</label></li>
								<li><label>Message response rate:</label></li>
							</ul>
						</div>
						<div class="item4 col-xs-12 col-md-5">
							<ul class="primary">
								<li id="morelikeli"><a href="#prfprofile.php">More like ${username}</a></li>
								<li id="messagetoli"><a href="#purematches.php">send them a message </a></li>
								<li id="addfavli"><a href="#bestmatch.php">Add them to My Favourites</a></li>
								<li id="inviteli"><a href="#lookingforme.php">Invite them to view my profile</a></li>
								<li id="myfavli"><a href="#favourites.php">Your notes on them</a></li>
								<li id="historyli"><a href="" target="_blank">Your history with them</a></li>
								<li id="dontshowmeli"><a href="" target="_blank">Don't show me again</a></li>
								<li id="blockedli"><a href="" target="_blank">Block them</a></li>
							</ul>
						</div>
					</div>
					<!-- END .row -->
				</div>
				<!-- user-block -->
				<br>
				<div id="" class="grid-container">
					<h3 class="">Profile</h3>
					<p>${aboutMeInfo}</p>
				</div>

				<br>
				<div id="" class="grid-container">
					<h3 class="">Looking For</h3>
					<p>${lookingForInfo}</p>
				</div>
				<br>
			</div>


		</div>

	</div>
	<!-- container -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
	
</body>
</html>