<%@page import="Model.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	User userloged = (User) request.getAttribute("userLog");

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>

	<h1>Bienvenue <%= userloged.get_nnameUser() %> !</h1>

</body>
</html>