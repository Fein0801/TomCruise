<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Search</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body class="dark-theme">
<%@include file="partials/header.jsp"%>
<div class="page-content">
<div class="row">
<div class="col-lg-6">
<div class="list">
	<c:forEach var="show" items="${tvResults}" varStatus="i">
		
		<div class="card text-white bg-dark mb-3 mp-card">
				<div class="card-body">
					<div class="avatar">
						<a href="/tv-details?id=${show.id}">
							<c:choose>
								<c:when test="${show.imageUrl != null }">
									<img src="https://image.tmdb.org/t/p/w500${show.imageUrl}" class="thumbnail">
								</c:when>
								<c:otherwise>
									<img src="broken_image.png" class="thumbnail">
								</c:otherwise>
							</c:choose>
						</a>
						
					</div>
					<div class="card-content">
						<h4>
							<a href="/tv-details?id=${show.id}">
								${show.name }
							</a>
						</h4>
						<p>${show.firstAirDate}</p>
						<p>${show.overview}</p>
					</div>
				</div>
			</div>
		
	</c:forEach>
	</div>
</div>
	<div class="col-lg-6" id="buttons" style="position: fixed; padding-top: 20px; right: 20px;">
		<a href="/movie-search?query=${query}" class="btn btn-primary">Show movie results</a>
		<a href="/person-search?query=${query}" class="btn btn-primary">Show person results</a>
		<a href="/all-search?query=${query}" class="btn btn-primary">Show all results</a>
	</div>
</div>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>