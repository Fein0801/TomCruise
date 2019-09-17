<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Favorites</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<%@include file="partials/header.jsp"%>
<body class="dark-theme">
<div class="page-content">
	<table class="table">
		<tr>
			<th></th>
			<th>Name</th>
		</tr>
		<c:forEach var="actor" items="${favActors}">
			<tr>
				<td><img
					src="https://image.tmdb.org/t/p/w500${actor.imageUrl }"
					class="thumbnail"></td>
				<td>${actor.name }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>