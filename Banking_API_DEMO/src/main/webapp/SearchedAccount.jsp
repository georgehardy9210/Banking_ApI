<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Searched Account</title>
</head>
<body>


<c:if test = "${user != null}">


<h2>User Information</h2>
${user.username} 
${user.firstName} 
${user.lastName} 
${user.email} 
${user.accountId} 


</c:if>

</body>
</html>