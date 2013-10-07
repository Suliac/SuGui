<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter Evaluation</title>
</head>
<body>

	<center>
		<h1>Ajouter Evaluation</h1>
	</center>

	<center>
	<div id="Inscription">
		<form action="ajouter-evaluation" method="post">
			</br>
			<span>Nom film* : </span><input type = "text" name = "film" />
			</br>
			<span>Identifiant de l'utilisateur* : </span><input type = "text" name = "utilisateur" />
			</br>
			<span>Note* : </span><input type = "text" name = "note" />
			</br>
			<span>Titre* : </span><input type = "text" name ="titre" />
			</br>
			<span>Description* : </span><input type = "text" name = "description" />
			</br>
			</br>
			Les champs terminant par "*" sont obligatoires.
			</br>
			<input type="submit" name="connexion" value = "Validez l'élvaluation" />
			</br>
		</form>
	</div>
	</center>

</body>
</html>