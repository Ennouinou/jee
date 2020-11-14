<%@page import="org.mql.jee.entities.City"%>
<%@page import="java.util.List"%>
<%@page import="org.mql.jee.entities.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Villes</title>
<link href="../resources/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		List<City> cities = (List<City>) request.getAttribute("cities");
	%>
	<%@ include file="../skeloton/header.html" %>
	<div class="title">
		Gestion des villes : <a href="addCity">Ajouter Une Ville: </a>
	</div>
	<table class="table">
		<tr>
			<th class="th">ID</th>
			<th class="th">Name</th>
		</tr>
		<% 
		for(City city : cities) {
			%>
			<tr>
			<td class="td"><%=city.getId() %></td>
			<td class="td"><%=city.getName() %></td>
		</tr>
		<%
		}
		%>
			
	</table>
	<footer><h1>This is a footer</h1></footer>
</body>
</html>