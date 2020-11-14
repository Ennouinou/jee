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
		List<Company> companies = (List<Company>) request.getAttribute("companies");
	%>
	<%@ include file="../skeloton/header.html" %>
	<div class="title">
		Gestion des entreprises : <a href="../MQL/addCompany">Ajouter Une Entreprise: </a>
	</div>
	<table class="table">
		<tr>
			<th class="th">ID</th>
			<th class="th">Name</th>
			<th class="th">Email</th>
			<th class="th">Ville</th>
			<th class="th">Action</th>
		</tr>
		<% 
		for(Company cmp : companies) {
			%>
			<tr>
			<td class="td"><%=cmp.getId() %></td>
			<td class="td"><%=cmp.getName() %></td>
			<td class="td"><%=cmp.getEmail() %></td>
			<td class="td"><%=cmp.getCity().getName() %></td>
			<td class="td">Action</td>
		</tr>
		<%
		}
		%>
			
	</table>
	<footer><h1>This is a footer</h1></footer>
</body>
</html>