package com.anuanu00.moviebooking.repositories.data;

import com.anuanu00.moviebooking.entites.Movie;
import com.anuanu00.moviebooking.repositories.IMovieRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MovieData implements IData {

    private final IMovieRepository iMovieRepository;

    public MovieData(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader((new FileReader(dataPath)));
            String line = bufferedReader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addMovie(tokens.get(0), tokens.get(1), Integer.parseInt(tokens.get(2)));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addMovie(String movieId, String title, int durationInMins) {
        this.iMovieRepository.saveMovie(new Movie(movieId, title, durationInMins));
    }
}
