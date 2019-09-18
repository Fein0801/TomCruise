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

	<c:forEach var="show" items="${tvResults}" varStatus="i">
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
		<h1>${show.name }</h1>
		<h3>${show.firstAirDate }</h3>
	</c:forEach>
	
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>