package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		long totalGross = 0L;
		favoritesDao.addFavoriteMovies(1, 2L);
		favoritesDao.addFavoriteMovies(1, 5L);
		favoritesDao.addFavoriteMovies(2, 1L);
		favoritesDao.addFavoriteMovies(2, 3L);
		@SuppressWarnings("unchecked")
		List<Movies> movieListCustomer = (List<Movies>) favoritesDao.getAllFavoriteMovies(1);
		System.out.println("User Added Favorites for CheckOut");
		for (Movies movies : movieListCustomer) {
			System.out.println(movies);
			totalGross += movies.getGross();
		}
		System.out.println("Total no of Favorites: " + movieListCustomer.size());
		System.out.println("Total Gross is : " + totalGross);
	}

	public static void testRemoveFavoriteMovies() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		long totalGross = 0L;
		System.out.println("Item List for Customer after Remove");
		try {
			favoritesDao.removeFavoriteMovies(1, 2L);
			@SuppressWarnings("unchecked")
			List<Movies> movieListCustomer = (List<Movies>) favoritesDao.getAllFavoriteMovies(1);
			for (Movies movies : movieListCustomer) {
				System.out.println(movies);
				totalGross += movies.getGross();
			}
			System.out.println("Total no of Favorites: " + movieListCustomer.size());
			System.out.println("Total Gross is : " + totalGross);
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
	}
}