<%@page import="org.mql.jee.entities.City"%>
<%@page import="java.util.List"%>
<%@page import="org.mql.jee.entities.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Une ville</title>
<link href="../resources/css/style.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../skeloton/header.html"%>
	<div class="card">
		<div class="card-header">Ajouter une nouvelle ville</div>
		<div class="card-body">
			<form action="saveCity" method="post">
				<table>
					<tr>
						<td><label>Identificateur de la ville : </label> </td>
						<td><input size="40" type="text" name="id"
						placeholder="Saisissez un id valide" /></td>
					</tr>
					<tr>
						<td><label>Nom de la ville :  </label> </td>
						<td><input size="40" type="text" name="name"
						placeholder="Saisissez le nom de l'entreprise " /></td>
					</tr>
					<tr><td></td><td><input type="submit" value="Ajouter"/></td></tr>
					
				</table>
				
			
			</form>
		</div>
	</div>
	
</body>
</html>