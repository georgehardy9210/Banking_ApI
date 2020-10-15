<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>


<h2>Account Details</h2>


<form action="balanceResponse" method="post">
<h3>UserName</h3>

${user.userName}

<h3>Password</h3>


${user.password}



<h3>First Name</h3>



${user.firstName}
<h2>Last Name</h2>



${user.lastName}


<h2>Email</h2>

${user.email}





<h2>Current Amount</h2>

${balance}


<br/><br/>
<input type="submit" value="Back"/>
</form>
</body>
</html>