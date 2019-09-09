<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mission Possible</title>
<!-- <img src="jeremy-yap-J39X2xX_8CQ-unsplash" height="42" width="42"> -->

<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iqcNtN3rj6Y1HX/R0a3zu3ngmbdwEa9qQGHdkXwSRoiE+Gj71p0UNDSm99LcXiXV"
	crossorigin="anonymous">
</head>
<body>

	<form action="person-search" method="post">
		<input type="text" name="query" placeholder="Search by actor">
		<input type="submit" value="Search">
	</form>
	<br>

	<form action="movie-search" method="post">
		<input type="text" name="query" placeholder="Search by movie">
		<input type="submit" value="Search">
	</form>
	<br>

	<form action="tv-search" method="post">
		<input type="text" name="query" placeholder="Search by tv"> <input
			type="submit" value="Search">
	</form>
	<br>

</body>
</html>