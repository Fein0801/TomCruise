<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body class="dark-theme">
<c:forEach var="show" items="${tvResults}" varStatus="i">
		<a href="/tv-details?id=${show.id}">
			<img src="https://image.tmdb.org/t/p/w500${show.imageUrl}" alt="broken_image.png" class="thumbnail">
		</a>
		<a class="btn btn-primary" href="home-page">Back to search</a>
		<h1>${show.name }</h1>
		<h3>${show.firstAirDate }</h3>
	</c:forEach>
</body>
</html>