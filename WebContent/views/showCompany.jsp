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
		Company company =(Company) request.getAttribute("company");
	%>
	<%@ include file="../skeloton/header.html"%>
	<div class="card">
		<div class="card-header">${message}</div>
		<div class="card-body">
				<table>
					<tr>
						<td><label>Identificateur de l'entreprise : </label> </td>
						<td><%= company.getId() %></td>
					</tr>
					<tr>
						<td><label>Nom de l'entreprise :  </label> </td>
						<td><%=company.getName() %></td>
					</tr>
					<tr>
						<td><label>Email de l'entreprise : </label> </td>
						<td><%=company.getEmail() %></td>
					</tr>
					<tr>
						<td><label>Ville de l'entreprise : </label>  </td>
						<td><%=company.getCity().getName() %></td>
					</tr>
				</table>
		</div>
	</div>
	<footer>
		<h1>This is a footer</h1>
	</footer>
</body>
</html>