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
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
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
		<a href="/HappyLife/myinbox">Inbox</a>
		<a href="#">Sent</a>
		<a href="#">Search</a>
		<a href="#">Contact</a>
	</div>

	<br>
	<br>
		
	<br><br>
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="/HappyLife/myprofile">Home</a></li>
			<li><a href="/HappyLife/pinfo">My Profile</a></li>
			<li><a href="/HappyLife/search">Search</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<div id="user-block" class="grid-container container">
					<div class="row">
						<div class="profile-image col-xs-12 col-md-2">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p>
									<%
									String photo = (String) session.getAttribute("personalPhoto");
									BufferedImage bImage = ImageIO.read(new File("F:/Github/HappyLife/WebContent/WEB-INF/usrphotos/"+photo));
								    System.out.println("Photo " + photo);
								    System.out.println("Buffered Image" + bImage);
								    ByteArrayOutputStream baos = new ByteArrayOutputStream();
								    ImageIO.write( bImage, "PNG", baos );
								    baos.flush();
								    byte[] imageInByteArray = baos.toByteArray();
								    baos.close();
								    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray); 
								    
								    //String b64 = (String)session.getAttribute("64");
									%>
									<a id="mainfullimage" href="">
										
										<img src="data:image/png;base64, <%=b64%>"
											 alt="click to see larger photo"
											 title="click to see larger photo">
									</a>
								</p>
								<p>
									<a href="#createphotoprofilepage"><button>Change
											Photo</button></a>
								</p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>

						<div class="item3 col-xs-12 col-md-5">
							<ul class="summary">
								<li><label>Username:</label></li>
								<li><label>Last Login:</label></li>
							</ul>
						</div>
						<div class="item4 col-xs-12 col-md-5">
							<ul class="primary">
								<li id="updateli"><a href="#prfprofile.php">Edit myprofile</a></li>
								<li id="findexactli"><a href="#purematches.php">Find my exact </a></li>
								<li id="findli"><a href="#bestmatch.php">Members I am looking for</a></li>
								<li id="lookformeli"><a href="#lookingforme.php">Members looking for me</a></li>
								<li id="myfavli"><a href="#favourites.php">My Favourites</a></li>
								<li id="youtubeli"><a href="" target="_blank">Watch our Quick Start video</a></li>
							</ul>
						</div>
					</div>
					<!-- END .row -->
				</div>
				<!-- user-block -->
				<br>
				<div id="myIdeal" class="grid-container">
					<h3>My Ideal Matches..</h3>
				</div>

				<br>
				<div id="lastViewers" class="grid-container">
					<h3 class="">Members who've recently viewed me ...</h3>
				</div>

				<br>
				<div id="newMembers" class="grid-container">
					<h3 class="">New members of Happy Life ...</h3>
				</div>

				<br>
				<div id="view-profile" class="grid-container">
					<h3 class=""></h3>
				</div>
				<br> <br>
			</div>
			<!-- home tab -->


			<!-- howilook taken from myprofile.jsp -->

			
		</div>


	</div>
	<!-- container close -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
</body>
</html>