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


${pDeets.name }
 
	
		
 
		
		<img src="https://image.tmdb.org/t/p/w500${pDeets.imageUrl}" alt="broken_image.png" class="thumbnail">
	
		
		 
		<h3>Bio:</h3>
		 <p>${pDeets.biography }</p>
		 
		<h4>Department:</h4>
		 <p>${pDeets.department }</p>
		
		<h4>Known For:</h4>
		<p>${pDeets.knownFor }</p>
		
		
		<h4>Credits:</h4>
		<p>${pKnown.cast }</p>
		
		<td>${pKnown.crew }</td>
		
			

</body>
</html>