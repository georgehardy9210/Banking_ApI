<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
     <%@ include file="css/style.css"%>
</style>

<title>Transfering</title>
</head>
<body>

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


	<h2>Enter the Account Information</h2>


	<form action="deposit" method="post">
		<c:if test="${selection == 'deposit'}">
			<div>

				<h3>Deposit</h3>
				<input type="number" min="1" step="any" name="amount"
					placeholder="Enter Amount" /> <input type="submit" value="Submit" />

			</div>
		</c:if>
	</form>
	
		<form action="withdraw" method="post">
		<c:if test="${selection == 'withdraw'}">
			<div>

				<h3>Withdrawl</h3>
				<input type="number" min="1" step="any" name="amount"
					placeholder="Enter Amount" /> <input type="submit" value="Submit" />

			</div>
		</c:if>
	</form>


	<form action="transfer" method="post">
		<c:if test="${selection == 'transfer'}">
			<div>
				<h3>Transferring Money</h3>

				<input type="text" name="accountId" placeholder="Enter Account You Wish to Transfer To" /> 
				<input type="number" min="1" step="any" name="amount" placeholder="Enter Amount" />
				<input type="submit" value="Submit" />

			</div>
		</c:if>
	</form>


</body>
</html>