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
<body class="dark-theme">
<%@include file="partials/header.jsp"%>
<div class="page-content">
	<h1 align="center" class="background">Welcome to Movie Phoenix, ${name }</h1>
	<h2 align="center">Search your favorite Actors, Movies and Tv Shows</h2>
	<h2 align="center">Add them to your Profile!</h2>
</div>
<%@include file="partials/footer.jsp"%>
</body>
</html>