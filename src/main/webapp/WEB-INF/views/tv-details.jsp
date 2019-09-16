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
<body>
	<h1>${tvDeets.name }</h1>
	<img src="https://image.tmdb.org/t/p/w500${tvDeets.imageUrl }" class="profile">
	<br>
	<h3>First episode date: ${tvDeets.firstAirDate }</h3>
	<h3>Last episode date: ${tvDeets.lastAirDate }</h3>
	<a class="btn btn-primary" href="home-page">Back to search</a>
	<h1>Summary</h1>
	<p>${tvDeets.overview }</p>
</body>
</html>