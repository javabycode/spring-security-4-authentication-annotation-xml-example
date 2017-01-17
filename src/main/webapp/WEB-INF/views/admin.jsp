<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>
	Welcome <strong>${userName}</strong>, You are authorized to access the Admin page.
	<br>
	<a href="<c:url value="/root" />">Login as Root</a>
	<br>
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>