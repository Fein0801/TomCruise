<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css" rel="stylesheet" integrity="sha384-iqcNtN3rj6Y1HX/R0a3zu3ngmbdwEa9qQGHdkXwSRoiE+Gj71p0UNDSm99LcXiXV" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<c:forEach var="person" items="${personResults }">
	<a href="/person-details?id=${person.id}">
		<!-- Ben doesn't understand alt attribute -->
		<img src="https://image.tmdb.org/t/p/w500${person.imageUrl}" alt="broken_image.png" class="thumbnail">
	</a>
		
		<h1>${person.name }</h1>
		<h3>
			Known For: <c:forEach var="film" items="${person.knownFor }">${film.ogTitle }</c:forEach>
		</h3>
		
	</c:forEach>

<%-- <h1>${person.birthday }</h1>
		<h1>${person.placeOfBirth }</h1>
		
		<h1>
		${person.biography }
		</h1> --%>
</body>
</html>