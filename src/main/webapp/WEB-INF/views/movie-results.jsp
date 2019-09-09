<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<c:forEach var="movie" items="${movieResults }">
		<a href="/movie-details?id=${movie.id}"> 
			<img src="https://image.tmdb.org/t/p/w500${movie.posterUrl}" alt="broken_image.png" class="thumbnail">
		</a>
		<h1>${movie.title }</h1>
		<h3>${movie.releaseDate }</h3>
	</c:forEach>
</body>
</html>