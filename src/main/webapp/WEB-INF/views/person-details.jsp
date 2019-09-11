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


	<h1>${pDeets.name }</h1>
	<img src="https://image.tmdb.org/t/p/w500${pDeets.imageUrl}"
		alt="broken_image.png" class="profile">

	<h3>Bio:</h3>
	<p>${pDeets.biography }</p>

	<h4>Department:</h4>
	<p>${pDeets.department }</p>

	<h4>Known For:</h4>
	<p>${pDeets.knownFor }</p>


<<<<<<< HEAD
	<%-- <h4>Credits:</h4>
	<p>${pKnown.cast }</p>

	<p>${pKnown.crew }</p> --%>

	<table class="table">
  <tr>
    <th>Movie Credits</th>
    
  </tr>
  <c:forEach var="movie" items="${test }" varStatus="i">
  <tr>
    <td>${movie.toString }</td>
    
  </tr>
  </c:forEach>
</table>
=======
	<h4>Credits:</h4>
	<a href="/person-details?id=${pDeets.id}&credit_type=MOVIE">Movies</a>
	<a href="/person-details?id=${pDeets.id}&credit_type=TV">TV Shows</a>

<h3>Cast:</h3>
	<table class="table">
		<tr>
			<th>Release Year</th>
			<th>Title</th>
			<th>Character</th>
		</tr>
		<c:forEach var="movie" items="${pKnown.cast }">
		<tr>
			<td>${movie.releaseDate }</td>
			<td>${movie.title }</td>
			<td>${movie.character }</td>
		</tr>
		</c:forEach>
	</table>

	
	<p>${pKnown.crew }</p>
	
	<h3>Crew:</h3>
	<table>
		<tr>
			<th>Column 1 Heading</th>
			<th>Column 2 Heading</th>
		</tr>
		<tr>
			<td>Row 1: Col 1</td>
			<td>Row 1: Col 2</td>
		</tr>
	</table>

>>>>>>> 0c34b9c1d28353a4d5c3c250e881864d1fffd1aa


</body>
</html>