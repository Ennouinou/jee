<%@page import="org.mql.jee.entities.City"%>
<%@page import="java.util.List"%>
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
		City city =(City) request.getAttribute("city");
	%>
	<%@ include file="../skeloton/header.html"%>
	<div class="card">
		<div class="card-header">${message}</div>
		<div class="card-body">
				<table>
					<tr>
						<td><label>Identificateur de la ville : </label> </td>
						<td><%= city.getId() %></td>
					</tr>
					<tr>
						<td><label>Nom de la ville :  </label> </td>
						<td><%=city.getName() %></td>
					</tr>
				</table>
		</div>
	</div>

</body>
</html>