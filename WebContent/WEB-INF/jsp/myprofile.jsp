<%@page import="com.happylife.pojo.User"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.*"%>
<%@page import="com.happylife.pojo.User, java.util.*" %>
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
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% if(session.getAttribute("username")==null) response.sendRedirect("/HappyLife");%>
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
		<a href="/HappyLife/search">Search</a>
		<a href="#">My Favorites</a>
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
									
									String path = (String) session.getAttribute("photopath");
									String photo = (String) session.getAttribute("personalPhoto");
									String gender = (String) session.getAttribute("gender");
									String b64 = "Nothing";
									System.out.println("Photo Path " + path);
									boolean personalPflag = false;
									System.out.println("b64 context path " + b64);
									if(!(photo.equalsIgnoreCase("manonymous.png")) && !(photo.equalsIgnoreCase("fanonymous.png"))){
										personalPflag = true;
										BufferedImage bInputImage = ImageIO.read(new File(path));
									    System.out.println("Path " + path);
									    System.out.println("Buffered Image" + bInputImage);
									    System.out.println("Gender is " + gender);
									    BufferedImage bOutputImage = new BufferedImage(150, 150, bInputImage.getType());
									    Graphics2D g2d = bOutputImage.createGraphics();
								        g2d.drawImage(bInputImage, 0, 0, 150, 150, null);
								        g2d.dispose();
									    
									    ByteArrayOutputStream baos = new ByteArrayOutputStream();
									    ImageIO.write( bOutputImage, "PNG", baos );
									    baos.flush();
									    byte[] imageInByteArray = baos.toByteArray();
									    baos.close();
									    b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray); 
									}
								    
								    
								    //String b64 = (String)session.getAttribute("b64");
									%>
									<a id="mainfullimage" href="">
										<%if(personalPflag) {%>
											<img src="data:image/png;base64, <%=b64%>"
												 alt="click to see larger photo"
												 title="click to see larger photo">
										<%}else{ %>
											<img src="/HappyLife/publicphotos/${sessionUser.image}"
											 alt="click to see larger photo"
											 title="click to see larger photo">
										<% } %>
											
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
								<li><label>Username: ${sessionUser.username}</label></li>
								<li><label>Last Login:</label></li>
							</ul>
						</div>
						<div class="item4 col-xs-12 col-md-5">
							<ul class="primary">
								<li id="updateli"><a href="#prfprofile.php">Edit my profile</a></li>
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
					<table class="table table-dark">
					<%
		  				List<User> viewedList = (List<User>)session.getAttribute("viewedMeList");
		  				for(int i=viewedList.size(); i--> 0;){
		  					
		  					User u = viewedList.get(i);
		  			%>
						<tbody>
							<tr>
								<th scope="col" class="col-md-4">
									<%=u.getUsername()%><br>
	    							<a href="${pageContext.request.contextPath}/candid?=<%=u.getUserId()%>">
	    								<img src="${pageContext.request.contextPath}/publicphotos/<%=u.getPublicPhoto() %>.JPG">
	    							</a>
								</th>
							</tr>
						</tbody>
						<% 
			    			} 
			    		%>
					</table>
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