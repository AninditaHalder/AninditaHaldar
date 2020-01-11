package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testGetMovieListAdmin() {

		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		System.out.println("Admin List\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%15s%20s%20s%15s%25s%25s%25s", "mov_id", "mov_title", "mov_box_office", "mov_active",
				"mov_date_of_launch", "mov_genre", "mov_has_teaser");
		for (Movies movies : movieList) {
			String date = sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			System.out.format("\n%15d%20s%20s%15s%25s%25s%25s", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getActive(), date, movies.getGenre(), movies.getHasTeaser());
		}
	}

	public static void testGetMovieListCustomer() {
		// MoviesDao moviesDao = new MoviesDaoCollectionImpl();

		List<Movies> movieList = new MoviesDaoCollectionImpl().getMovieListCustomer();

		System.out.println("\n");
		System.out.println("Customer List");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%15s%20s%20s%15s%25s%25s%25s", "mov_id", "mov_title", "mov_box_office", "mov_active",
				"mov_date_of_launch", "mov_genre", "mov_has_teaser");
		for (Movies movies : movieList) {
			String date = sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			System.out.format("\n%15d%20s%20s%15s%25s%25s%25s", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getActive(), date, movies.getGenre(), movies.getHasTeaser());
		}
	}

	public static void testModifyMovies() {
		Movies movies = new Movies(1l, "If I Stay", 259744l, false, new DateUtil().convertToDate("04/01/2023"),
				"Romance", true);
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();
		moviesDaoSqlImpl.modifyMovie(movies);
		System.out.println("\t\n");
		System.out.println("Modified Data");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%15s%20s%20s%15s%25s%25s%25s", "mov_id", "mov_title", "mov_box_office", "mov_active",
				"mov_date_of_launch", "mov_genre", "mov_has_teaser");
		String date = sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
		System.out.format("\n%15d%20s%20s%15s%25s%25s%25s", movies.getId(), movies.getTitle(), movies.getGross(),
				movies.getActive(), date, movies.getGenre(), movies.getHasTeaser());
		System.out.println("\t\n");
		System.out.println("\n\n\t Menu Item List Modified Successfully");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovies();
	}
}