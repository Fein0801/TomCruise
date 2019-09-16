<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html itemscope itemtype="http://schema.org/Article">
<head>
<meta charset="ISO-8859-1">
<title>Movie Phoenix</title>
<!-- <img src="jeremy-yap-J39X2xX_8CQ-unsplash" height="42" width="42"> -->
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>

<h1 align ="center" class="background" style="color: black">Welcome to Movie Phoenix, ${name }</h1>
<h2 align = "center"><font color="black">Search your favorite Actors, Movies and Tv Shows</font></h2>
<h2 align = "center"><font color="black">Add them to your Profile!</font></h2>
<body>

	<form action="person-search" method="get">
		<input type="text" name="query" placeholder="Search by actor">
		<input type="submit" value="Search">
	</form>
	<br>

	<form action="movie-search" method="get">
		<input type="text" name="query" placeholder="Search by movie">
		<input type="submit" value="Search">
	</form>
	<br>

	<form action="tv-search" method="get">
		<input type="text" name="query" placeholder="Search by tv"> <input
			type="submit" value="Search">
	</form>
	<br>

</body>
</html>