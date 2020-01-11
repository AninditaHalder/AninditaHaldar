package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMovieListAdmin() {
		System.out.println("Item List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testGetMovieListCustomer() {
		System.out.println("Item List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies item = new Movies(5L, "Avengers", 5750760348L, true, new DateUtil().convertToDate("22/12/2022"),
				"Superhero", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovie(item);
		System.out.println("\n*** Modified Menu Item List***");
		testGetMovieListAdmin();
		Movies modified_item = moviesDao.getMovie(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovies();
	}
}