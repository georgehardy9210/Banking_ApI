<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Finding Account</title>
</head>
<body>

<c:if test="${selection == 'account_Id'}">

<h2>Enter Account ID</h2>
<table border="1px">
<tr>
<td><input type="text" name="accountid" placeholder="Enter Account ID"/></td>
</tr>

</c:if>


<c:if test="${selection == 'user_id'}">
<h2>Enter User ID</h2>
<table border="1px">
<tr>
<td><input type="text" name="userid" placeholder="Enter Status ID"/></td>
</tr>
</c:if>

<c:if test="${selection == 'status_id'}">
<h2>Enter Status ID</h2>
<table border="1px">
<tr>
<td><input type="text" name="statusid" placeholder="Enter User ID"/></td>
</tr>

</c:if>

</body>
</html>