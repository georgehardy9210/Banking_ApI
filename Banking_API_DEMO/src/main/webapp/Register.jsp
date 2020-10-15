<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
     <%@ include file="css/style.css"%>
</style>
<title>Register Page</title>
</head>
<body>

<header>

<nav id = "navbar">

	<div class = "container">
	<h1 class="logo"><a href="logout">Revature</a></h1>
	<ul>
	
		<li><a href="logout">Home</a></li>
	
	</ul>
	</div>
</nav>

</header>

<section id="contact-form" class="py-3">
<div>

	<h1 class = "l-heading"><span>Fill</span> out your information </h1>
	
<table border="1px">
<tr>
<td><input type="text" name="userame" placeholder="Enter a Username"/></td>
</tr>

<tr>
<td><input type="password" name="password" placeholder="Enter a Password"/></td>
</tr>


<tr>
<td><input type="email" name="email" placeholder="Enter a Email"/></td>
</tr>


<tr>
<td><input type="text" name="firstName" placeholder="First Name"/></td>
<td><input type="text" name="lastName" placeholder="Last Name"/></td>
</tr>
	
	<button type="submit" class="btn">Submit</button>
</div>

</section>

<!-- 
<table border="1px">
<tr>
<td><input type="text" name="userame" placeholder="Enter a Username"/></td>
</tr>

<tr>
<td><input type="password" name="password" placeholder="Enter a Password"/></td>
</tr>


<tr>
<td><input type="email" name="email" placeholder="Enter a Email"/></td>
</tr>


<tr>
<td><input type="text" name="firstName" placeholder="First Name"/></td>
<td><input type="text" name="lastName" placeholder="Last Name"/></td>
</tr>



<tr>
<td><input type="submit" value="Login"/></td>
</tr>

</table>
 -->



</body>
</html>