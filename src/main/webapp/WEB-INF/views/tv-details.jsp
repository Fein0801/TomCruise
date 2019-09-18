<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Overview</title>
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
		<c:when test="${tvDeets.imageUrl != null}">
			<img src="https://image.tmdb.org/t/p/w500${tvDeets.imageUrl}"
				class="profile">
		</c:when>
		<c:otherwise>
			<img src="broken_image.png" class="profile">
		</c:otherwise>
	</c:choose>
</div>
<div class="summary">
	<h1>${tvDeets.name }</h1>
	<c:forEach var="mg" items="${tvDeets.genres}">
			<h6>${mg.name }</h6>
		</c:forEach>
		<p>
	<a href="/add-fav?type=tv&id=${tvDeets.id}" class="btn btn-danger">Add
		to Favorites</a>
	</p>
	<br>
	<h5>First episode date: ${tvDeets.firstAirDate }</h5>
	<h5>Last episode date: ${tvDeets.lastAirDate }</h5>
		<br>

	<h1>Summary</h1>
	<p>${tvDeets.overview }</p>
	<br>
</div>
<div class="credits">	
	<h1>CAst</h1>
	<table class="table table-striped">
		<tr>
			<th></th>
			<th>Actor</th>
			<th>Character</th>
		</tr>
		<c:forEach var="c" items="${ actors}">
			<tr>
				<td>
					<a href="/person-details?id=${c.actorId }&credit_type=TV">
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
		<table class="table table-striped">
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
					</a>
				</td>
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
