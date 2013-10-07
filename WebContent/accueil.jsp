<%@page import="Model.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

User userloged = (User) request.getAttribute("userLog");

%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Brb</title>
	</head>
	<body>
 
	 <a href="AjoutCategorie.jsp">Ajout catégorie</a>
	 <a href="AjoutFilm.jsp">Ajout film</a>
		
		
	</body>
</html>