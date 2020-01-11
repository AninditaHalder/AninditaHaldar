package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.dao.ConnectionHandler;

public class FavoritesDaoSqlImpl implements FavoritesDao {
	public static final String ADD_MOVIES_TO_FAVORITES = "insert into favorites(fav_us_id,fav_mov_id) values(?,?)";
	public static final String GET_MOVIES_FROM_FAVORITES = "select mov_id,mov_title,mov_box_office,mov_active,mov_date_of_launch,mov_genre,mov_has_teaser from movies inner join favorites on mov_id = fav_mov_id where fav_us_id=?";
	public static final String GET_TOTAL = "select count(mov_box_office) as total from movies inner join favorites on fav_mov_id=mov_id where fav_us_id=?";
	public static final String DELETE_FROM_FAVORITES = "delete from favorites where fav_us_id=? and fav_mov_id=? limit 1";

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		Favorites favorites = new Favorites();
		ArrayList<Movies> movieFavorites = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTwo = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES_FROM_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_box_office"));
				movies.setActive(resultSet.getString("mov_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser(resultSet.getString("mov_has_teaser").equals("1"));
				movieFavorites.add(movies);
			}
			favorites.setMovieList(movieFavorites);
			preparedStatementTwo = connection.prepareStatement(GET_TOTAL);
			preparedStatementTwo.setLong(1, userId);
			resultSetTotal = preparedStatementTwo.executeQuery();
			if (movieFavorites.size() == 0) {
				throw new FavoritesEmptyException();
			}
			while (resultSetTotal.next()) {
				favorites.setTotal(resultSetTotal.getLong("Total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSet != null)
					resultSet.close();
				if (preparedStatementTwo != null)
					preparedStatementTwo.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userID, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_FROM_FAVORITES);
			preparedStatement.setLong(1, userID);
			preparedStatement.setLong(2, moviesId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}