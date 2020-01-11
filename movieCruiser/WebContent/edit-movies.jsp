<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
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
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<h1 class="edit">Edit Movie</h1>
	<div class="body-content-colour">
		<form action="EditMovies" onsubmit="return validateMoviesForm()"
			name="editMovie" method="post">
			<div>
				<div class="form-field-spacing">
					<label for="title">Title</label> <input type="text"
						class="text-box text-box-title" name="title" id="name"
						value="${movies.title}">
				</div>
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="gross">Gross ($)</label>
					<div>
						<input type="text" class="text-box" name="gross" id="gross"
							value="${movies.gross}">
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="active">Active</label> <input class="radio"
						type="radio" name="active" value="Yes"
						<c:if test="${movies.active}">checked</c:if>>Yes <input
						class="radio" type="radio" name="active" value="No"
						<c:if test="${!movies.active}">checked</c:if>>No
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label>
					<div>
						<input type="text" class="text-box" name="dateOfLaunch"
							value=<fmt:formatDate value="${movies.dateOfLaunch}"
                             pattern="dd/MM/yyyy" />>
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="genre">Genre</label>
					<div>
						<select name="genre" class="dropdown">
							<option value="${movies.genre}">${movies.genre}</option>
							<option value="Science Fiction">Superhero</option>
							<option value="Romance">Romance</option>
							<option value="Comedy">Comedy</option>
							<option value="Adventure">Adventure</option>
							<option value="Thriller">Thriller</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="hasTeaser">Has Teaser</label>
				<c:if test="${movies.hasTeaser}">
					<input type="checkbox" name="hasTeaser" checked>
				</c:if>
				<c:if test="${!movies.hasTeaser}">
					<input type="checkbox" name="hasTeaser">
				</c:if>
			</div>
			<div>
				<input type="hidden" name="id" value="${movies.id }">
			</div>
			<div>
				<input type="submit" class="button success-button" value="Save">
			</div>

		</form>

	</div>

	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>