package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public interface MoviesDao {

	public List<Movies> getMovieListAdmin();

	public List<Movies> getMovieListCustomer();

	public void modifyMovie(Movies movies);

	public Movies getMovie(Long moviesId);

}