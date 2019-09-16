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
<a href="/add-fav?type=movie&id=${pDeets.id}" class="btn btn-danger">Add to Favorites</a>
<h3>${movieDeets.overview }</h3><p>
<c:forEach var="mg" items="${movieDeets.genres}">
		<h4>${mg.name }</h4>
		</c:forEach>
${movieDeets.releaseDate }
<h4>${movieDeets.tagline }</h4>
${movieDeets.runtime }
<a class="btn btn-primary" href="home-page">Back to search</a>

,<table class="table">
  <tr>
    <th></th>
    <th>Actor</th>
    <th>Character</th>
  </tr>
  <c:forEach var="c" items="${ actors}"> 
  <tr>
    <td><a href="/person-details?id=${c.castId }&credit_type=MOVIE"><img src="https://image.tmdb.org/t/p/w500${c.profilePath}" class="thumbnail"></a></td>
    <td>${c.name }</td>
    <td>${c.character }</td>
  </tr>
    </c:forEach>
</table>

</body>
</html>