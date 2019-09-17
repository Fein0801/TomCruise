<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body class="dark-theme">
<div class="page content">
<div id="parent" style="text-align:center">  
	<div id="child">
	<h1>Welcome!</h1>
	<h2>Login to Begin</h2>
	<a class="btn btn-primary" href="https://accounts.google.com/o/oauth2/v2/auth${params }">Google Login</a>
	</div>
</div>


</div>	<!-- 	<a class="btn btn-primary" href="https://accounts.google.com/o/oauth2/v2/auth?client_id=490474699637-28km14ohul4qfafmc0h429lslt19irgs.apps.googleusercontent.com&key=AIzaSyAZqRL8cxDO252QcnlzquJUhcyUjb3lWKA&&response_type=coderedirect_uri=https://movie-phoenix.herokuapp.com/&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile">Login take 2</a> -->
</body>
</html>