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
<div class="avatar-profile">
	<c:choose>
		<c:when test="${movieDeets.posterUrl != null}">
			<img src="https://image.tmdb.org/t/p/w500${movieDeets.posterUrl}"
				class="profile">
		</c:when>
		<c:otherwise>
			<img src="broken_image.png" class="profile">
		</c:otherwise>
	</c:choose>
</div>
<div class="summary dark-theme">
	<h1>${movieDeets.title}</h1>
		<c:forEach var="mg" items="${movieDeets.genres}">
			<h6>${mg.name }</h6>
		</c:forEach>
	<a href="/add-fav?type=movie&id=${movieDeets.id}"
		class="btn btn-danger">Add to Favorites</a>
		<br>
		<br>
		<c:if test="${upcoming == true }">
			<a href="/schedule-viewing?movie_id=${movieDeets.id }"
				class="btn btn-success">Schedule a viewing</a>
		</c:if>
		<h3>Plot Summary:</h3>

	<p>${movieDeets.overview }</p>
		<h4> Release Date:</h4>
		 ${movieDeets.releaseDate }
		 <p></p>
	<h4>Runtime: </h4>
	${movieDeets.runtime } minutes
	<p>
	<h6>"${movieDeets.tagline }"</h6></p>
</div>
<div class="credits">
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
				<td>
				<a href="/person-details?id=${c.castId }&credit_type=MOVIE">
					<c:choose>
						<c:when test="${c.profilePath != null }">
							<img src="https://image.tmdb.org/t/p/w500${c.profilePath }" class="thumbnail">
						</c:when>
						<c:otherwise>
							<img src="broken_image.png" class="thumbnail">
						</c:otherwise>
					</c:choose>
				</a>
				</td>
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
				<td>
				<a href="/person-details?id=${c.crewId }&credit_type=TV">
					<c:choose>
						<c:when test="${c.profilePath != null }">
							<img src="https://image.tmdb.org/t/p/w500${c.profilePath }" class="thumbnail">
						</c:when>
						<c:otherwise>
							<img src="broken_image.png" class="thumbnail">
						</c:otherwise>
					</c:choose>
				</a></td>
				<td>${c.name }</td>
				<td>${c.job }</td>
			</tr>
		</c:forEach>
		</table>
		</div>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>