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
			<th class="th">Action</th>
		</tr>
		<% 
		for(City city : cities) {
			%>
			<tr>
			<td class="td"><%=city.getId() %></td>
			<td class="td"><%=city.getName() %></td>
			<td class="td"><a href="showCity?id=<%=city.getId() %>">Afficher</a></td>
		</tr>
		<%
		}
		%>
			
	</table>
	
</body>
</html>