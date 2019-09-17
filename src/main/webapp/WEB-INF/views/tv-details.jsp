<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<h1>${tvDeets.name }</h1>
	<img src="https://image.tmdb.org/t/p/w500${tvDeets.imageUrl }" class="profile">
	<a href="/add-fav?type=tv&id=${pDeets.id}" class="btn btn-danger">Add
		to Favorites</a>
	<br>
	<h3>First episode date: ${tvDeets.firstAirDate }</h3>
	<h3>Last episode date: ${tvDeets.lastAirDate }</h3>

	<h1>Summary</h1>
	<p>${tvDeets.overview }</p>
	<a class="btn btn-primary" href="home-page">Back to search</a>
	<table class="table table-striped">
		<tr>
			<th></th>
			<th>Actor</th>
			<th>Character</th>
		</tr>
		<c:forEach var="c" items="${ actors}">
			<tr>
				<td><a href="/person-details?id=${c.actorId }&credit_type=TV"><img
						src="https://image.tmdb.org/t/p/w500${c.profilePath}"
						class="thumbnail"></a></td>
				<td>${c.name }</td>
				<td>${c.character }</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Crew</h1>
		<table class="table">
		<tr>
			<th></th>
			<th>Crew Name</th>
			<th>Job</th>
		</tr>
		
		<c:forEach var="c" items="${ crewMen}">
			<tr>
				<td><a href="/person-details?id=${c.crewId }&credit_type=TV"><img
						src="https://image.tmdb.org/t/p/w500${c.profilePath}"
						class="thumbnail"></a></td>
				<td>${c.name }</td>
				<td>${c.job }</td>
			</tr>
		</c:forEach>
	</table>
	<div class="page-content">
</body>
</html>