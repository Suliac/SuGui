<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String login = (String) request.getAttribute("login");
   String password = (String) request.getAttribute("password");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>

	<h1>Bienvenue <%= login %> !</h1>

</body>
</html>