<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Phoenix: ${movieDeets.title}</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body class="dark-theme">
<%@include file="partials/header.jsp"%>
<div class="page-content">
	<h1>${movieDeets.title}</h1>

	<c:choose>
		<c:when test="${movieDeets.posterUrl != null}">
			<img src="https://image.tmdb.org/t/p/w500${movieDeets.posterUrl}"
				class="profile">
		</c:when>
		<c:otherwise>
			<img src="broken_image.png" class="profile">
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<a href="/add-fav?type=movie&id=${movieDeets.id}"
		class="btn btn-danger">Add to Favorites</a>
		<c:if test="${upcoming == true }">
			<a href="/schedule-viewing?movie_id=${movieDeets.id }"
				class="btn btn-success">Schedule a viewing</a>
		</c:if>
	<h3>${movieDeets.overview }</h3>
	<p>
		<c:forEach var="mg" items="${movieDeets.genres}">
			<h4>${mg.name }</h4>
		</c:forEach>
		${dc.getEnglishDate(movieDeets.releaseDate) }
	<h4>${movieDeets.tagline }</h4>
	${movieDeets.runtime }
	<a class="btn btn-primary" href="home-page">Back to search</a>
	<br>
	<br>
	<h1>Cast</h1>
	<table class="table table-striped">
		<!-- WIP: new backround color makes table borders look bad -->
		<tr>
			<th></th>
			<th>Actor</th>
			<th>Character</th>
		</tr>
		<c:forEach var="c" items="${ actors}">
			<tr>
				<td><a href="/person-details?id=${c.castId }&credit_type=MOVIE">
						<img src="https://image.tmdb.org/t/p/w500${c.profilePath}"
						class="thumbnail">
				</a></td>
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
		</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>