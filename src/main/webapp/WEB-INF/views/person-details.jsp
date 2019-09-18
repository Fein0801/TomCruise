<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Phoenix: ${pDeets.name }</title>
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
	<div class="avatar-profile">
		<c:choose>
			<c:when test="${pDeets.imageUrl != null}">
				<img src="https://image.tmdb.org/t/p/w500${pDeets.imageUrl}"
					class="profile">
			</c:when>
			<c:otherwise>
				<img src="broken_image.png" class="profile">
			</c:otherwise>
		</c:choose>
	</div>
	<div class="summary dark-theme">
		<h1>${pDeets.name }</h1>
		<a href="/add-fav?type=person&id=${pDeets.id}" class="btn btn-danger">Add
			to Favorites</a>
	
		<h3>Bio:</h3>
		<p>${pDeets.biography }</p>
	
		<h4>Department:</h4>
		<p>${pDeets.department }</p>
	</div>
	<div class="cast-crew">
		<h4>Credits:</h4>
		<a class="btn btn-primary"
			href="/person-details?id=${pDeets.id}&credit_type=MOVIE">Movies</a>
		<a class="btn btn-primary"
			href="/person-details?id=${pDeets.id}&credit_type=TV">TV Shows</a>
	
		<h4>Filmography:</h4>
		<c:if test="${creditType == 0}">
			<table class="table table-striped">
				<tr>
					<th></th>
					<th>Release Date</th>
					<th>Title</th>
					<th>Character</th>
	
				</tr>
				<c:forEach var="movie" items="${cast }">
					<tr>
						<td>
							<a href="/movie-details?id=${movie.id }">
							<c:choose>
								<c:when test="${movie.posterUrl != null }">
									<img src="https://image.tmdb.org/t/p/w500${movie.posterUrl }" class="thumbnail">
								</c:when>
								<c:otherwise>
									<img src="broken_image.png" class="thumbnail">
								</c:otherwise>
							</c:choose>
							</a>
						</td>
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
					<th>First Air Date</th>
					<th>Title</th>
					<th>Character</th>
				</tr>
				<c:forEach var="tv" items="${pKnown.cast }">
					<tr>
						<td>${tv.firstAirDate }</td>
						<td>${tv.name }</td>
						<td>${tv.character }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>