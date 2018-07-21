<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<link rel="icon" href="/ico/favicon.ico">
		<title>Sign Up Here</title>
		<!-- Bootstrap core CSS -->
    	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

   	 	<!-- Custom styles for this template -->
	    <link href="${pageContext.request.contextPath}/css/floating-labels.css" rel="stylesheet">
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data" commandName="user" class="form-signup" style="box-shadow: 0 0 black;">
		    
			<div class="col-md-12 col-md-push-3">
				<div class="text-center mb-4">
		    		<h1 class="h3 mb-3 font-weight-normal">Sign up or <a class="demo" href="${pageContext.request.contextPath}/login">Login Here</a> </h1>
		    	</div>
		    	
		    	<div class="row">
		    		<div class="form-group col-md-6">
	       				<input type="text" name="fname" id="inputFirstName" value="<%= (String)request.getAttribute("firstName")%>" class="form-control" placeholder="First Name" required="" autofocus="">
		    		</div>
		    		
		    		<div class="form-group col-md-6">
	       				<input type="text" name="lname" id="inputLastName" value="<%= (String)request.getAttribute("lastName")%>" class="form-control" placeholder="Last Name" required="" autofocus="">
		    		</div>
	     		</div>
				
	      		<div class="row">
	      			<div class="form-group col-md-12">
	        			<input type="email" name="email" id="inputEmail" value="<%= (String)request.getAttribute("email") %>" class="form-control" placeholder="Email address" required="" autofocus="">
	      			</div>
	      		</div>
	      		
	      		<div class="row">
	      			<div class="form-group col-md-6">
	        			<input type="text" name="username" id="inputUserName" class="form-control" placeholder="Username" required="" autofocus="">
	      			</div>
	      			<div class="form-group col-md-6">

		        	<select name="country" id="inputCountry" class="form-control" required="">
						<option value="Sudan">Sudan</option>
						<option value="Yemen" selected="selected">Yemen</option>
						<option value="India">India</option>
					</select>
		      	</div>
	      			
	      		</div>
	
	      		<div class="row">
	      			<div class="form-group col-md-6">
		        		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
		      		</div>
		      		<!-- <label for="inputPassword">Password</label>
		        	<input type="password" path="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required=""/> -->
		      		
		      		<div class="form-group col-md-6">
		        		<input type="password" name="repassword" id="inputRePassword" class="form-control" placeholder="re-Password" required=""/>
		      		</div>
		      	</div>
		      	
		      	<div class="row">
		        	<div class="form-group col-md-6">
		        		<input type="radio" name="gender" id="inputMale" class="left" value="M" required=""/>
		        		<label for="inputMale">Male</label>
	        		</div>
	        		<div class="form-group col-md-6">
		        		<input type="radio" name="gender" id="inputFemale" class="right" value="F" required=""/>
		        		<label class="right" for="inputFemale">Female</label>
		        	</div>
		      	</div>
		      	
		      	
		      	
		      	<div class="row">
		        	<div class="form-group col-md-12">
		        		<input type="text" name="phone" id="inputPhone" class="form-control" placeholder="phone" required=""/>
		        	</div>
		      	</div>
		      	
		      	<!-- <div class="row">
		        	<div class="form-group col-md-12">
		        		<input type="number" name="dob" id="dateOfBirth" class="form-control" placeholder="Date" required=""/>
		        	</div>
		      	</div> -->
		      	
		      	<div class="row">
		      		<div class="form-group col-md-12">
			        	<label for="inputImage">Image</label>
			        	<input type="file" name="image" id="inputImage" class="form-control" placeholder="select image" required=""/>
		        	</div>
		      	</div>
		      	
		      	<button class="btn btn-lg btn-primary btn-block" type="submit" value="Sign up">Sign up</button>
		      	<p class="mt-5 mb-3 text-muted text-center">© 2017-2018</p>
		      	  	
			</div>
	      	<hr>
    	</form>
    	
	</body>
</html>