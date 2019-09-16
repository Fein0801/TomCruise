<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css" rel="stylesheet" integrity="sha384-iqcNtN3rj6Y1HX/R0a3zu3ngmbdwEa9qQGHdkXwSRoiE+Gj71p0UNDSm99LcXiXV" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>

	<c:forEach var="person" items="${personResults }">
	<h4>${person.name }</h4>
	<a href="/person-details?id=${person.id}&credit_type=MOVIE">
	<c:choose>
		<c:when test="${person.imageUrl != null}">
			<img src="https://image.tmdb.org/t/p/w500${person.imageUrl}" alt="broken_image.png" class="thumbnail">
		</c:when>
		<c:otherwise>
			<img src="broken_image.png" class="thumbnail">
		</c:otherwise>
	</c:choose>
	</a>
		<a class="btn btn-primary" href="home-page">Back to search</a>


</c:forEach>
</body>
</html>