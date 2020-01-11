<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
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
		<a href="ShowFavorites">Favorite</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<h1>Favorites</h1>
	<c:if test="${message }">
		<h3 class="success-message">Movies Removed from Favorites
			Successfully</h3>
	</c:if>
	<table class="title">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th></th>
		</tr>
		<c:forEach items="${favorites.movieList}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td>$.<fmt:formatNumber
						value="${movies.gross}" pattern="#,##,##,##,###.00" />
				</td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavorites?id=${movies.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>No. of Favorites:</td>
			<td>${favorites.total}</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>