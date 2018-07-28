<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search result My Profile</title>
		
		<!-- Bootstrap core CSS -->
    	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    	
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
	    	<nav class="navbar navbar-light navbar-expand-md bg-dark fixed-top justify-content-center">
    			
    			<div class="navbar-brand d-flex w-50 mr-auto">
    				<span href="javascript:void(0)" style="cursor:pointer;" id="nav_title" onclick="openNav()">&#9776; Happy Life</span>
    				
    				<span id="hiUser">welcome ${username}&nbsp; <a href="${pageContext.request.contextPath}/logout">Logout</a></span>
    				
    			</div>
	    </header>
	
		<div id="mySidenav" class="sidenav">
		  	<a href="#">Inbox</a>
		  	<a href="#">Sent</a>
		  	<a href="#">Search</a>
		  	<a href="#">Contact</a>
		</div>
		
		<br>
		<br>
		
		<br><br>
		<div class="container">
			<ul class="nav nav-tabs">
	    		<li><a data-toggle="tab" href="#home">Home</a></li>
	    		<li><a data-toggle="tab" href="#howilook">My Profile</a></li>
	    		<li  class="active"><a data-toggle="tab" href="#menu2">Search</a></li>
	    		<li><a data-toggle="tab" href="#menu3">Marriage Advice</a></li>
  			</ul>
		
			<div class="tab-content">
			    <div id="home" class="tab-pane fade">
			    	<div id="user-block" class="grid-container">
						<div class="profile-image">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p><a id="mainfullimage" href="http://placehold.it/400/00F/FFF"><img src="${pageContext.request.contextPath}/img/usrphotos/${usrImage}" alt="click to see larger photo" title="click to see larger photo"></a></p>
								<p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>
						
						<div class="item3">
							<ul class="summary">
			    				<li><label>Username:</label></li>
			    				<li><label>Last Login:</label></li>
			    			</ul>
						</div>  
						<div class="item4">
							<ul class="primary">
			    				<li id="updateli"><a href="#prfprofile.php">Edit my profile</a></li>
			    				<li id="findexactli"><a href="#purematches.php">Find my exact </a></li>
			    				<li id="findli"><a href="#bestmatch.php">Members I am looking for</a></li>
			    				<li id="lookformeli"><a href="#lookingforme.php">Members looking for me</a></li>
			    				<li id="myfavli"><a href="#favourites.php">My Favourites</a></li>
			    				<li id="youtubeli"><a href="" target="_blank">Watch our Quick Start video</a></li>
			    			</ul>
						</div>
			    	</div>	<!-- user-block -->
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
			    	<br>
			    	<br>
			    </div> <!-- home tab -->
			    
			    
			    <div id="howilook" class="tab-pane fade">
			    	<br>
			    	<!-- <p><a href="${pageContext.request.contextPath}/howilook">How I Look</a></p>  -->
			    	<br>
			    	<p>edit</p>
			      	<ul class="nav nav-pills updateProfile">
	    				<li><a href="${pageContext.request.contextPath}/aboutme">About Me</a></li>
	    				<li><a href="#myPhoto">My Photo</a></li>
	    				<li><a href="${pageContext.request.contextPath}/lookingfor">Looking For</a></li>
	    				<li><a href="#myQuestions">My Questions</a></li>
	  				</ul>
	  				<hr>
	  				<p>How others see me</p>
	  				
	  				<br>
	  				<div id="user-block" class="grid-container">
						<div class="profile-image">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p><a id="mainfullimage" href="http://placehold.it/400/00F/FFF"><img src="${pageContext.request.contextPath}/img/publicphotos/${usrPublicPhoto}" alt="click to see larger photo" title="click to see larger photo"></a></p>
								<p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>
						
						<div class="item3">
							<ul class="summary">
			    				<li><label>Age:</label></li>
			    				<li><label>Location:</label></li>
			    				<li><label>Last Login:</label></li>
			    				<li><label>I am currently available for communication:</label></li>
			    				<li><label>Message response rate:</label></li>
			    			</ul>
						</div>  
						<div class="item4">
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
			    	</div>	<!-- user-block -->
			    	<br>
			    	<div id="" class="grid-container">
			    		<h3 class="">Profile</h3>
			    		<p>${AboutMeInfo}</p>
			    	</div>
			    	
			    	<br>
			    	<div id="" class="grid-container">
			    		<h3 class="">Looking For</h3>
			    	</div>
			    	<br>
			    </div>
			    <div id="menu2" class="tab-pane fade in active">
			      	<div class="header">
	  					<h1>Chania</h1>
					</div>
					
					<form action="${pageContext.request.contextPath}/search" method="GET">
					<div class="row">
						
						<div class="col-3 menu">
		  					<ul>
		    					<li id="idmatch" >Ideal Match</li>
		    					
		    					<li id="lookingFor">Whom I'm looking for</li>
		    					<li id="lookingForMe">who's looking for me</li>
		    					<li id="onlineNow">on-Line Now</li>
		    					<li id="photosUploaded">Photos uploaded</li>
		    					<li id="hvntviewed">only those I haven't viewed</li>
		    					<li id="hvntmessgd">only those I haven't messaged</li>
		    					<li>Aged from</li>
		    					<li>to</li>
		    					<li id="selectContainer"><div>In 
		    						<select name="country" id="inputCountry" class="form-control" required="">
										<option value="Sudan">Sudan</option>
										<option value="Yemen" selected="selected">Yemen</option>
										<option value="India">India</option>
									</select>
		    					</div></li>
		    					<li><input class="btn btn-lg btn-primary btn-block" type="submit" value="Find a match"></li>
		  					</ul>
		  					<input type="hidden" id="idmatchflag" value="" />
		  					<input type="hidden" id="lookingforflag" value="" />
		  					<input type="hidden" id="lookingforMeflag" value="" />
						</div>
							
							<!-- <div class="togimg">
    								<a class="hasViewedBandContainer" onmouseover="FocusOnSearchUserBiog(122486);" href="view.php?candid=122486">
										<span class="hasViewedBand" onmouseover="FocusOnSearchUserBiog(122486);">Viewed</span>
									</a>
									<a href="view.php?candid=122486">
										<img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="sansk94" class="profile-image" onmouseover="FocusOnSearchUserBiog(122486);" style="">
									</a>
					    		</div> -->
						
					    <!-- <ul>${user.username}</ul> -->						
						<div class="col-9">
							<h3>We have found these results</h3>
						  	<div class="resultBox col-8">
						  		<ul id="search-li" class="col-8">
					    			<c:forEach items="${searchList}" var="user">
					    				<li class="col-8"><a href="${pageContext.request.contextPath}/candid">${user.username}</a></li>
					    				<br>
					    			</c:forEach>
			    				</ul>
						  	</div>
						</div>
	
					</div>	<!-- row -->
					</form>
			      	
			    </div>
			    <div id="menu3" class="tab-pane fade">
			      	<h3>Menu 3</h3>
			      	<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
			    </div>
	  		</div>
		
		
		</div><!-- container close -->
		
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
	</body>
</html>