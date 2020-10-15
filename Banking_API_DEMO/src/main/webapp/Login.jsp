<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta charset="UTF-8">

<style>
     <%@ include file="css/style.css"%>
</style>

<title>Login Page</title>
</head>
<body>


<header>

<nav id = "navbar">

	<div class = "container">
	<h1 class="logo"><a href="logout">Revature</a></h1>
	<ul>
	
		<li><a href="updates">Register Account</a></li>
		
	
	</ul>
	</div>
</nav>

</header>


<h1> Welcome to Revature Bank</h1>
<h2>Login</h2>

<form action="login" method="post">


<input type="text" name="userName" placeholder="Enter UserName"/>


<input type="password" name="password" placeholder="Enter Password"/>


<input type="submit" value="Login"/>




</form>

<footer id="main-footer">

<p>Revature Co. &copy; 2020, All rights belongs to revature</p>
</footer>

</body>
</html>