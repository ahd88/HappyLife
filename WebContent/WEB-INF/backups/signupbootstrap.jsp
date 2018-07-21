<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<form action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data" class="form-signup" style="box-shadow: 0 0 black;">
		    <div class="text-center mb-4">
		    	<h1 class="h3 mb-3 font-weight-normal">Sign up Here</h1>
		    </div>
		    
			<div class="form-label-group">
       			<label for="inputFirstName">First Name</label>
       			<input type="text" name="fname" id="inputFirstName" class="form-control" placeholder="First Name" required="" autofocus="">
     		</div>
     		
     		<div class="form-label-group">
       			<label for="inputLastName">Last Name</label>
       			<input type="text" name="lname" id="inputLastName" class="form-control" placeholder="Last Name" required="" autofocus="">
     		</div>
			
			
      		<div class="form-label-group">
        		<label for="inputEmail">Email address</label>
        		<input type="email" path="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
      		</div>
      		
      		<div class="form-label-group">
        		<label for="inputUserName">Username</label>
        		<input type="text" name="username" id="inputUserName" class="form-control" placeholder="choose Username" required="" autofocus="">
      		</div>

      		<div class="form-label-group">
	        	<label for="inputPassword">Password</label>
	        	<input type="password" path="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
	      	</div>
	      	
	      	<div class="form-label-group">
	      		<!-- <label for="inputPassword">Password</label>
	        	<input type="password" path="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required=""/> -->
	      		
	        	<label for="inputRePassword">Re-Password</label>
	        	<input type="password" name="repassword" id="inputRePassword" class="form-control" placeholder="Password" required=""/>
	      	</div>
	      	
	      	<div class="form-label-group" >
	        	<label for="inputSex"></label>
	        	<div>
	        		<input type="radio" name="gender" id="inputMale" class="left" value="M" required=""/>
	        		<label for="inputMale">Male</label>
	        		<input type="radio" name="gender" id="inputFemale" class="right" value="F" required=""/>
	        		<label class="right" for="inputFemale">Female</label>
	        	</div>
	      	</div>
	      	
	      	<div class="form-label-group">
	        	<label for="inputCountry">Country</label>
	        	<select name="country" id="inputCountry" class="form-control" required="">
					<option value="Sudan">Sudan</option>
					<option value="Yemen" selected="selected">Yemen</option>
					<option value="India">India</option>
				</select>
	      	</div>
	      	
	      	<div class="form-label-group">
	        	<label for="inputPhone">Phone</label>
	        	<input type="number" name="phone" id="inputPhone" class="form-control" placeholder="phone" required=""/>
	      	</div>
	      	
	      	<div class="form-label-group">
	        	<label for="inputImage">Image</label>
	        	<input type="file" name="image" id="inputImage" class="form-control" placeholder="select image" required=""/>
	      	</div>
	      	
	      	<button class="btn btn-lg btn-primary btn-block" type="submit" value="Sign up">Sign up</button>
	      	<p class="mt-5 mb-3 text-muted text-center">© 2017-2018</p>
	      	
	      	<hr>
			<a class="demo" href="${pageContext.request.contextPath}/login">Login</a>
    	</form>
    	
	</body>
</html>