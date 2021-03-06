<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="script.js"></script>
<title>Movie Cruiser</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://www.clipartmax.com/png/small/1-18589_movie-ticket-invitation-clipart-film-strip-solo-hi-png-film-reel.png"
			alt="Movie Ticket Invitation Clipart Film Strip Solo Hi - Png Film Reel @clipartmax.com">
		<a href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<h1>Movies</h1>
	<c:if test="${addFavoritesStatus}">
		<h3 class="success-message">Movies Added to Favorites
			Successfully</h3>
	</c:if>
	<table class="title">
		<tr>
			<th>Title</th>
			<th class="currency">Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${filteredMovies}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td class="currency">$.<fmt:formatNumber
						value="${movies.gross}" /></td>
				<td>${movies.genre}</td>
				<td><c:if test="${movies.hasTeaser}">Yes</c:if> <c:if
						test="${!movies.hasTeaser}">No</c:if></td>
				<td><a href="AddToFavorites?id=${movies.id}">Add to
						Favorites</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>