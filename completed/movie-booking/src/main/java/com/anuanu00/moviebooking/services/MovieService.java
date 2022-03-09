package com.anuanu00.moviebooking.services;

import com.anuanu00.moviebooking.entites.Movie;
import com.anuanu00.moviebooking.repositories.IMovieRepository;

import java.util.List;

public class MovieService implements IMovieService{

    private final IMovieRepository iMovieRepository;

    public MovieService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return iMovieRepository.getAllMovies();
    }
}
