<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an event</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iqcNtN3rj6Y1HX/R0a3zu3ngmbdwEa9qQGHdkXwSRoiE+Gj71p0UNDSm99LcXiXV"
	crossorigin="anonymous">
</head>
<body>
	<form action="add-event">
		<label for="title">Title</label>
		<input type="text" name="title">
		<label for="date">Date</label>
		<input type="date" name="date" min="2019-09-20">
		<label for="startTime">Start Time</label> 
		<input type="time" name="startTime">
		<label for="endTime">End Time</label> 
		<input type="time" name="endTime">
		<label for="description">Description</label>
		<input name="description">
		<input type="submit" value="Add">
	</form>
</body>
</html>