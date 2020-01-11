package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavorites() {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.addFavoriteMovies(2L, 4L);
		System.out.println(favoritesDaoSqlImpl);
		System.out.println("User Added To Favorites Successfully");
	}

	public static void testGetAllAddFavorites() throws FavoritesEmptyException {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorites = favoritesDaoSqlImpl.getAllFavoriteMovies(2l);
		System.out.println(favorites.getMovieList());
		System.out.println(favorites.getTotal());
	}

	public static void testRemoveFavorites() {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.removeFavoriteMovies(1L, 3L);
		System.out.println("Movies removed from favorites successfully");
	}

	public static void main(String args[]) throws FavoritesEmptyException {
		testAddFavorites();
		testGetAllAddFavorites();
		testRemoveFavorites();
	}
}