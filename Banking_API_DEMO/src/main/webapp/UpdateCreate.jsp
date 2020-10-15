<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"/>

<meta charset="UTF-8">
<title>
<c:if test="${sessionScope.user!= null}">
Update Page </c:if>
<c:if test="${sessionScope.user == null}">
Register Page </c:if>
</title>

<style>
     <%@ include file="css/style.css"%>
</style>


</head>



<header>

<nav id = "navbar">

	<div class = "container">
	<h1 class="logo"><a href="logout">Revature</a></h1>
	<ul>
	
		<li><a href="logout">Logout</a></li>
		
	
	</ul>
	</div>
</nav>

</header>

<body>

<header>


<%-- IF USER IS NOT EMPTY UPDATE FORM --%>

<%-- <h2> Gelloo</h2> --%>
<%-- 
<h2> Gelloo</h2>

<h2> Gelloo</h2>

<c:if test="${sessionScope.user!= null}"> Update Page IT WORKS YOU SON OF A GUN!!! 
</c:if> 

<c:if test="${user = null}"> Register Page 
</c:if>

<c:if test="${1 != 0}"> 1 != 0 
</c:if>
 --%>
 

<%-- WHEN YOU WAKE UP, SOMETHINE ABOUT user!=null is not working
	THEN FINISH FINDbyID's
	THEN DELETE
	THEN UPDATE FRONT END

 --%>
<c:if test="${sessionScope.user!= null}">



<h2>Update Page</h2>


<h3>UserName</h3>

<form action = "registerResponse" method = "post">

<tr>
<td><input type="text" name="userName" 
value="  <c:out value='${user.userName}'/>"/> </td>
</tr>
<h3>Password</h3>

<tr>
<td><input type="text" name="password"
value="<c:out value='${user.password}'/>"

/></td>
</tr>

<h3>First Name</h3>



<tr>
<td><input type="text" name="firstName" 
value="<c:out value='${user.firstName}'/>"

/></td>
</tr>

<h2>Last Name</h2>


<tr>
<td><input type="text" name="lastName" 
value="<c:out value='${user.lastName}'/>"
/></td>
</tr>

<h2>Email</h2>
<tr>
<td><input type="text" name="email" 
value="<c:out value='${user.email}'/>"
/></td>
</tr>

<tr>
<td><input type="submit" value="Submit"/></td>
</tr>

</form>
</c:if> 



<%-- <%-- IF USER IS EMPTY PLEASE FILL OUT A REGISTER FORM --%>


<c:if test="${user == null}">Register

<h2></h2>

<tr>
<td><input type="text" name="userName" placeholder="Enter UserName"/></td>
</tr>
<h2></h2>

<tr>
<td><input type="password" name="password" placeholder="Enter Password"/></td>
</tr>
<h2></h2>

<tr>
<td><input type="text" name="firstName" placeholder="Enter First Name"/></td>
</tr>
<h2></h2>

<tr>
<td><input type="text" name="lastName" placeholder="Enter Last Name"/></td>
</tr>
<h2></h2>

<tr>
<td><input type="text" name="email" placeholder="Enter Email"/></td>
</tr>
<h2></h2>

<tr>
<td><input type="text" name="userName" placeholder="Enter Privlege"/></td>
</tr>
<h2></h2>

<tr>
<td><input type="submit" value="Submit"/></td>
</tr>

</c:if> 





</body>
</html>