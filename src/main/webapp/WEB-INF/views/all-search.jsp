<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
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
	<c:forEach var="movie" items="${movieResults }">
		<a href="/movie-details?id=${movie.id}"> <c:choose>
				<c:when test="${movie.posterUrl != null}">
					<img src="https://image.tmdb.org/t/p/w500${movie.posterUrl}"
						class="thumbnail">
				</c:when>
				<c:otherwise>
					<img src="broken_image.png" class="thumbnail">
				</c:otherwise>
			</c:choose>
		</a>
		<a class="btn btn-primary" href="home-page">Back to search</a>
		<h1>${movie.title }</h1>
		<h3>${movie.releaseDate }</h3>
	</c:forEach>
	
	
	<c:forEach var="person" items="${personResults }">
		<h4>${person.name }</h4>
		<h4>
			${person.department } :
			<c:forEach var="movie" items="${person.knownFor }">
		${movie.title },
	</c:forEach>
		</h4>
		<a href="/person-details?id=${person.id}&credit_type=MOVIE"> <c:choose>
				<c:when test="${person.imageUrl != null}">
					<img src="https://image.tmdb.org/t/p/w500${person.imageUrl}"
						alt="broken_image.png" class="thumbnail">
				</c:when>
				<c:otherwise>
					<img src="broken_image.png" class="thumbnail">
				</c:otherwise>
			</c:choose>
		</a>
	</c:forEach>
	
	
	
	
	
	
	<c:forEach var="show" items="${tvResults}" varStatus="i">
		<a href="/tv-details?id=${show.id}"> <img
			src="https://image.tmdb.org/t/p/w500${show.imageUrl}"
			alt="broken_image.png" class="thumbnail">
		</a>
		<a class="btn btn-primary" href="home-page">Back to search</a>
		<h1>${show.name }</h1>
		<h3>${show.firstAirDate }</h3>
	</c:forEach>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>