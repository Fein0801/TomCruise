<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule a viewing for "${movie.title }"</title>
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
	<form action="add-event">
		<label for="title">Event name</label>
		<input type="text" name="title" value="Watch ${movie.title}" readonly>
		<label for="date">Date</label>
		<input type="date" name="date" min="${movie.releaseDate}" value="${movie.releaseDate}">
		<label for="startTime">Start Time</label> 
		<input type="time" name="startTime">
		<label for="endTime">End Time</label> 
		<input type="time" name="endTime">
		<label for="description"></label>
		<input name="description" value="" type="hidden">
		<input type="submit" value="Add">
	</form>
	<iframe src="/movie-details2?id=${movie.id }" style="width:100%; height: 500px;"></iframe>
<%-- 	<img src="https://image.tmdb.org/t/p/w500${movie.posterUrl }" class="thumbnail">
	<br>
	<h2>Description</h2>
	<p>${movie.overview }</p>
	<h2>Release Date</h2>
	<p>${movie.releaseDate }</p> --%>
</div>
</body>
</html>