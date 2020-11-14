<%@page import="org.mql.jee.entities.City"%>
<%@page import="java.util.List"%>
<%@page import="org.mql.jee.entities.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Entreprises</title>
<link href="../resources/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		List<City> cities = (List<City>) request.getAttribute("cities");
	%>
	<%@ include file="../skeloton/header.html"%>
	<div class="card">
		<div class="card-header">Ajouter une nouvelle entreprise</div>
		<div class="card-body">
			<form action="../MQL/saveCompany" method="post">
				<table>
					<tr>
						<td><label>Identificateur de l'entreprise : </label> </td>
						<td><input size="40" type="text" name="id"
						placeholder="Saisissez un id valide" /></td>
					</tr>
					<tr>
						<td><label>Nom de l'entreprise :  </label> </td>
						<td><input size="40" type="text" name="name"
						placeholder="Saisissez le nom de l'entreprise " /></td>
					</tr>
					<tr>
						<td><label>Email de l'entreprise : </label> </td>
						<td><input size="40" type="text"
						name="email" placeholder="Saisissez l'email de l'entreprise"/></td>
					</tr>
					<tr>
						<td><label>Ville de l'entreprise : </label>  </td>
						<td><select name="idc">
						<% for(City city : cities){
							%>
						<option  value="<%=city.getId()%>"> <%= city.getName() %> </option>
							<%
						}
							%>
						
					</select></td>
					</tr>
					<tr><td></td><td><input type="submit" value="Ajouter"/></td></tr>
					
				</table>
				
			
			</form>
		</div>
	</div>
	<footer>
		<h1>This is a footer</h1>
	</footer>
</body>
</html>