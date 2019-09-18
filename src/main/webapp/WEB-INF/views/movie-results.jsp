<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie results for query "${query }"</title>
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
	<div class="list">
		<c:forEach var="movie" items="${movieResults }">
		
		<div class="card text-white bg-dark mb-3 mp-card" style="overflow: hidden;">
				<div class="card-body">
					<div class="avatar">
						<a href="/movie-details?id=${movie.id}">
							<c:choose>
								<c:when test="${movie.posterUrl != null}">
									<img src="https://image.tmdb.org/t/p/w500${movie.posterUrl}"
										alt="broken_image.png" class="thumbnail">
								</c:when>
								<c:otherwise>
									<img src="broken_image.png" class="thumbnail">
								</c:otherwise>
							</c:choose>
						</a>
					</div>
					<div class="card-content">
						<h4>
							<a href="/movie-details?id=${movie.id}">
								${movie.title }
							</a>
						</h4>
						<p>
							${movie.overview }
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>