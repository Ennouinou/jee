<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'accueil</title>
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
	<%@ include file="skeloton/header.html"%>
	<div class="home">
		<div class="home-header">
			<img src="resources/img/MQL_LOGO.png" alt="">
		</div>
		<div class="home-description">
		C'est une application web developpée par
		ennouinou Alaeddinne dans le cadre d'une foramtion jee assurée par
		monsieur Nourdine Chenfour; L'application est basée sur une
		architecture distribuée 3 tiers, dont la couche présentation est une interface web basée sur le patron de conception MVC2, la couche
		d'accès aux données est présentée en deux possibiltés, la première en
		utilisant une base de données en mémoire et l'autre en se basant sur
		l'api jdbc en utilisant le design pattern singleton.
		</div>
	</div>
	
</body>
</html>