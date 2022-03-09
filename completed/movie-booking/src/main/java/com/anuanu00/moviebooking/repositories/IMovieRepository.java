package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Movie;

import java.util.List;

public interface IMovieRepository {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    Movie getMovieById(String id);
}
