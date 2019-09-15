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
<body>


	<h1>${pDeets.name }</h1>
	<img src="https://image.tmdb.org/t/p/w500${pDeets.imageUrl}"
		alt="broken_image.png" class="profile">

	<h3>Bio:</h3>
	<p>${pDeets.biography }</p>

	<h4>Department:</h4>
	<p>${pDeets.department }</p>

	<h4>Credits:</h4>
	<a class="btn btn-primary" href="/person-details?id=${pDeets.id}&credit_type=MOVIE">Movies</a>
	<a class="btn btn-primary" href="/person-details?id=${pDeets.id}&credit_type=TV">TV Shows</a>

<h4>Filmography:</h4>
<c:if test="${creditType == 0}">
	<table class="table">
		<tr>
			<th>Release Year</th>
			<th>Title</th>
			<th>Character</th>
		</tr>
		<c:forEach var="movie" items="${pKnown.cast }">
		<tr>
			<td>${movie.releaseDate }</td>
			<td>${movie.title }</td>
			<td>${movie.character }</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${creditType == 1}">
	<table class="table">
		<tr>
			<th>Release Year</th>
			<th>Title</th>
			<th>Character</th>
		</tr>
		<c:forEach var="movie" items="${pKnown.cast }">
		<tr>
			<td>${movie.firstAirDate }</td>
			<td>${movie.name }</td>
			<td>${movie.character }</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>