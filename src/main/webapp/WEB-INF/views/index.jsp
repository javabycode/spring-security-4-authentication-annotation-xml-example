<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>
	${message}
	<br>
	<a href="<c:url value="/admin" />">Login as Admin</a>
	<br>
	<a href="<c:url value="/root" />">Login as Root</a>
</body>
</html>