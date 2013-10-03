<%@page import = "java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	
	ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
	if(errorList != null){
		for(String s : errorList){
			System.out.println(s);
		}
	}

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscripion</title>
</head>
<body>
<center>
		<h1>Inscription</h1>
	</center>

	<center>
	<div id="fenetreinscription">
		<form action="servletinscription" method="get">
			</br>
			<span>Nom* : </span><input type = "text" name = "firstname" />
			</br>
			<span>Prénom* : </span><input type = "text" name = "lastname" />
			</br>
			<span>Login* : </span><input type = "text" name = "login" />
			</br>
			<span>Mot de passe* : </span><input type = "password" name ="password" />
			</br>
			<span>Confirmation du mot de passe* : </span><input type = "text" name = "passwordconf" />
			</br>
			<span>Surnom : </span><input type = "text" name = "nickname" />
			</br>
			<span>Image : </span><input type = "file" name = "picture" />
			</br>
			</br>
			Les champs terminant par "*" sont obligatoires.
			</br>
			<input type="submit" name="inscription" value = "Validez l'inscription" />
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