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
<body class="dark-theme">
<div class="page-content">
<%@include file="partials/header.jsp"%>
<h1>People</h1>
	<table class="table table-striped">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Remove</th>
		</tr>
		<c:forEach var="actor" items="${favActors}">
			<tr>
				<td>
					<a href="/person-details?id=${actor.actorId}&credit_type=MOVIE">
					<img src="https://image.tmdb.org/t/p/w500${actor.imageUrl }" class="thumbnail">
					</a>
				</td>
				<td>
					<a href="/person-details?id=${actor.actorId}&credit_type=MOVIE">
						${actor.name }
					</a>
				</td>
				<td>
					<a href="/remove-favorite?id=${actor.entryId }&type=PERSON" class="btn btn-danger">Remove</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<h1>Movies</h1>
	<table class="table table-striped">
		<tr>
			<th></th>
			<th>Title</th>
			<th>Remove</th>
		</tr>
		<c:forEach var="movie" items="${favMovies}">
			<tr>
				<td>
				<a href="/movie-details?id=${movie.mediaId }">
				<img
					src="https://image.tmdb.org/t/p/w500${movie.imageUrl }"
					class="thumbnail">
				</a>
				</td>
				<td>
					<a href="/movie-details?id=${movie.mediaId }">
						${movie.title}
					</a>
				</td>
				<td>
					<a href="/remove-favorite?id=${movie.entryId }&type=MOVIE" class="btn btn-danger">Remove</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Tv shows</h1>
	<table class="table table-striped">
		<tr>
			<th></th>
			<th>Title</th>
			<th>Remove</th>
		</tr>
		<c:forEach var="show" items="${favTv}">
			<tr>
				<td>
					<a href="/tv-details?id=${show.tvId }">
						<c:choose>
							<c:when test="${show.imageUrl != null }">
								<img src="https://image.tmdb.org/t/p/w500${show.imageUrl}" class="thumbnail">
							</c:when>
							<c:otherwise>
								<img src="broken_image.png" class="thumbnail">
							</c:otherwise>
						</c:choose>
					</a>
				</td>			
				<td>
					<a href="/tv-details?id=${show.tvId}">
						${show.title }
					</a>
				</td>
				<td>
					<a href="/remove-favorite?id=${show.entryId }&type=TV" class="btn btn-danger">Remove</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>