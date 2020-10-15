<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<title>Main!</title>
<style>
     <%@ include file="css/style.css"%>
</style>


</head>



<header>

<nav id = "navbar">

	<div class = "container">
	<h1 class="logo"><a href="logout">Revature</a></h1>
	<ul>
	
		<li><a href="updates">Edit Account</a></li>
		<li><a href="logout">Logout</a></li>
	
	</ul>
	</div>
</nav>

</header>
<body>




	<c:if test="${user.firstName != null}">
	

	<h2>Hello, </h2>
	<h2><c:out value='${user.firstName}' />  <c:out value='${user.lastName}' /> </h2>

		

	</c:if>

	<c:if test="${status == 'admin'}">

		<h2>Status is Admin</h2>
		<form action="adminControl" method="post">
			<select name="options">
					<option value="Withdraw">Withdraw</option>
					<option value="Deposit">Deposit</option>
					<option value="Transfer">Transfer</option>
					<option value="Update">Update Account</option>
					<option value="Search_Username">Search Username</option>
					<option value="Search_Account">Search Account</option>
					<option value="View_Balance">View Balance</option>
					<option value="View_All_Accounts">View All Accounts</option>
					
			
			</select>
 			<input type="submit" value="Submit">

 		</form>



	</c:if>


	<c:if test="${status == 'employee'}">

		<h2>Status is Employee</h2>

		<form action="adminControl" method="post">
			<div>
				<select name="options">
					<option value="Withdraw">Withdraw</option>
					<option value="Deposit">Deposit</option>
					<option value="Transfer">Transfer</option>
					<option value="Update">Update Account</option>
					<option value="Search_Username">Search Username</option>
					<option value="Search_Account">Search Account</option>
					<option value="View_Balance">View Balance</option>
					<option value="View_All_Accounts">View Balance</option>
					</select>
			</div>
			<input type="submit" value="Submit">

		</form>


	</c:if>






	<c:if test="${status == 'user'}">

		<h2>Status is User</h2>

		<form action="" method="post">
			<div>
				<select name="user_form">
					<option value="Withdraw">Withdraw</option>
					<option value="Deposit">Deposit</option>
					<option value="Transfer">Transfer</option>
					<option value="Update">Update Account</option>
					<option value="Search_Username">Search Username</option>
					<option value="Search_Account">Search Account</option>
					<option value="View_Balance">View Balance</option>
					<option value="View_All_Accounts">View Balance</option>
				</select> Enter Value <input type="text" name="valuue">


			</div>
			<input type="submit" value="Submit">

		</form>


	</c:if>


</body>
</html>