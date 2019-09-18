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

<div>
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
	${movieDeets.runtime } minutes <br>
	<br>
	<h6>"${movieDeets.tagline }"</h6>
</div>

</div>

</body>
</html>