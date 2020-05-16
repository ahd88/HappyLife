<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/ico/favicon.ico">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Happy Life</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/floating-labels.css" rel="stylesheet">
</head>
<body>
	<form action="login" method="post"  class="form-signin" style="box-shadow: 0 0 black;">
      <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">Login Here</h1>
      </div>
		<p style="color:red; text-align: center;"> Sorry! username and password do not match. </p>
      <div class="form-label-group">
        <label for="inputEmail">Email address</label>
        <input type="email" path="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus=""/>
        <br>
		
      </div>

      <div class="form-label-group">
        <label for="inputPassword">Password</label>
        <input type="password" path="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required=""/>
        <br>
		
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">Sign in</button>
      <p class="mt-5 mb-3 text-muted text-center">� 2017-2018</p>
    </form>
</body>
</html>