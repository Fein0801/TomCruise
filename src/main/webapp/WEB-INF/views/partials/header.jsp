<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<!-- Make a header -->
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary header">
<!-- 		<a href="#"><img src="MoviePhoenixLogo.png" class="logo"></a> -->
	  <a class="navbar-brand" href="#">Welcome, ${name }</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarColor01">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/home-page">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/view-favs">Favorites</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="https://calendar.google.com/calendar/r" target="_blank">Google Calendar</a>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0" action="/all-search">
	      <input type="hidden" name="result_type" value="ALL">
	      <input name="query" class="form-control mr-sm-2" type="text" placeholder="Search">
	      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>
</header>
</html>