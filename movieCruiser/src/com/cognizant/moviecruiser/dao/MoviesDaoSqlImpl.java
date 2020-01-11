package com.cognizant.moviecruiser.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String GET_ALL_MOVIES_ADMIN = "select mov_id,mov_title,mov_box_office,mov_active,mov_date_of_launch,mov_genre,mov_has_teaser from movie_cruiser.movies";
	public static final String GET_ALL_MOVIES_CUSTOMER = "select mov_id,mov_title,mov_box_office,mov_active,mov_date_of_launch,mov_genre,mov_has_teaser from movie_cruiser.movies where mov_active='1' and mov_date_of_launch > (SELECT CURRENT_DATE())";
	public static final String GET_MOVIES = "select mov_id,mov_title,mov_box_office,mov_active,mov_date_of_launch,mov_genre,mov_has_teaser from movie_cruiser.movies where mov_id = ?";
	public static final String EDIT_MOVIES = "update movie_cruiser.movies set mov_title = ?, mov_box_office=?, mov_active=?, mov_date_of_launch=?, mov_genre=?, mov_has_teaser =? where mov_id=?";

	@Override
	public List<Movies> getMovieListAdmin() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_ADMIN);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_box_office"));
				movies.setActive(resultSet.getString("mov_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser(resultSet.getString("mov_has_teaser").equals("1"));
				movieList.add(movies);
			}
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
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> filteredMovies = new ArrayList<Movies>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_box_office"));
				movies.setActive(resultSet.getString("mov_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser(resultSet.getString("mov_has_teaser").equals("1"));
				filteredMovies.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		System.out.println(filteredMovies);
		return filteredMovies;
	}

	@Override
	public void modifyMovie(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(EDIT_MOVIES);
			preparedStatement.setString(1, movies.getTitle());
			preparedStatement.setLong(2, movies.getGross());
			preparedStatement.setBoolean(3, movies.getActive());
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setBoolean(6, movies.getHasTeaser());
			preparedStatement.setLong(7, movies.getId());
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
	public Movies getMovie(Long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES);
			preparedStatement.setLong(1, moviesId);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(movies);
		return movies;
	}
}