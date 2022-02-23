package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Movie;

import java.util.List;

public interface IMovieRepository {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    Movie getMovieById(String id);
}
