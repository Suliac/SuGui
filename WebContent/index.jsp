<%@page import = "java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	
	ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("Errors");

%>


<html>

<head>
	<link rel="stylesheet" href="index.css" />
	<meta charset="ISO-8859-1">
	<title>Connection</title>
</head>

<body>
	<center>
	
		<h1>SuGui</h1>
	
	</center>
	
	<center>
	
		<div id="fenetreLogin">
		
			<form action="connection" method="post">
			
				</br>
				<span>Login : </span><input type = "text" name = "login" />
				</br>
				<span>Mot de passe : </span><input type = "password" name ="password" />
				</br>
				</br>
				<input type="submit" name="connexion" value = "Se connecter" />
				
			</form>
			<a href="inscription.jsp">S'inscrire</a>
			
			<%
			if(errorList != null){

				for (String s : errorList){ 
				System.out.println(s); %>
					
				<span><%= s %></span></br>	
			<% } } %>
			
		</div>
		
	</center>
	
</body>

</html>