<%@page import = "java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("Errors"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un film</title>
</head>
<body>

<center>
		<h1>Ajouter un film</h1>
	</center>

	<center>
	
	<div id="Inscription">
		<form action="ajouter-film" method="post">
			</br>
			<span>Nom* : </span><input type = "text" name = "nom" />
			</br>
			<span>Description* : </span><input type = "text" name = "description" />
			</br>
			<span>Réalisateur* : </span><input type = "text" name = "realisateur" />
			</br>
			<span>Date de sortie* : </span><input type = "text" name = "datedesortie" />
			</br>
			</br>
			Les champs terminant par "*" sont obligatoires.
			</br>
			<input type="submit" name="valider" value = "Validez l'ajout" />
			</br>
			
<%
			if(errorList != null){

				for (String s : errorList){ 
				System.out.println(s);
				%>
					
				<span><%= s %></span></br>	
			<% } 
							
			}%>
		</form>
	</div>
	</center>

</body>
</html>