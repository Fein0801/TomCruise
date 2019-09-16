<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Phoenix: ${movieDeets.title}</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>

<h1>${movieDeets.title}</h1>
<img src="https://image.tmdb.org/t/p/w500${movieDeets.posterUrl}" alt="broken_image.png" class="profile">
<h3>${movieDeets.overview }</h3><p>
<c:forEach var="mg" items="${movieDeets.genres}">
		<h4>${mg.name }</h4>
		</c:forEach>
${movieDeets.releaseDate }
<h4>${movieDeets.tagline }</h4>
${movieDeets.runtime }
</body>
</html>