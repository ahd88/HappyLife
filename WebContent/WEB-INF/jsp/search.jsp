<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Profile</title>
		
		<!-- Bootstrap core CSS -->
    	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    	
    	<!-- specific -->
    	<link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
    	
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
    				
    				<span id="hiUser">welcome ${username}</span>
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
	    		<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
	    		<li><a data-toggle="tab" href="#menu1">My Profile</a></li>
	    		<li><a data-toggle="tab" href="#menu2">Search</a></li>
	    		<li><a data-toggle="tab" href="#menu3">Marriage Advice</a></li>
  			</ul>
		
		<div class="tab-content">
		    <div id="home" class="tab-pane fade in active">
		    	<h3>HOME</h3>
		    	
		    </div>
		    <div id="menu1" href="${pageContext.request.contextPath}/howilook" class="tab-pane fade">
		    	<h3>Menu 1</h3>
		      	<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
		    </div>
		    <div class="active" id="menu2" href="${pageContext.request.contextPath}/search" class="tab-pane fade">
		      	<h3>Menu 2</h3>
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
						
					<div class="col-9">
						<h1>The Results</h1>
					  	<div class="resultBox col-8">
					  		
					  	</div>
					</div>

				</div>
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