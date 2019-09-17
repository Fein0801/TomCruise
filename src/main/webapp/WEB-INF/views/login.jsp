<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body class="dark-theme">
<div class="login" align="center">
		<div class="card text-white bg-dark mb-3 center" style="max-width: 20rem; width: 20rem;">
			<div class="card-body">
				<h1>Welcome!</h1>
				<h2>Login to Begin</h2>
				<a class="btn btn-primary"
					href="https://accounts.google.com/o/oauth2/v2/auth${params }">Google
					Login</a>
			</div>
		</div>
		</div>
</body>
</html>