package com.anuanu00.moviebooking.repositories.data;

import com.anuanu00.moviebooking.entites.Cinema;
import com.anuanu00.moviebooking.repositories.ICinemaRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CinemaData implements IData{

    private final ICinemaRepository iCinemaRepository;

    public CinemaData(ICinemaRepository iCinemaRepository) {
        this.iCinemaRepository = iCinemaRepository;
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(dataPath));
            String line = bufferedReader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addCinema(tokens.get(0), tokens.get(1));
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCinema(String cinemaId, String cinemaName) {
        this.iCinemaRepository.saveCinema(new Cinema(cinemaId, cinemaName));
    }
}
