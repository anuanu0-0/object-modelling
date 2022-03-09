package com.anuanu00.moviebooking.repositories.data;


import com.anuanu00.moviebooking.entites.Cinema;
import com.anuanu00.moviebooking.entites.Screen;
import com.anuanu00.moviebooking.repositories.ICinemaRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ScreenData implements IData{

    private final ICinemaRepository iCinemaRepository;

    public ScreenData(ICinemaRepository iCinemaRepository) {
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
                addScreen(tokens.get(0),tokens.get(1),tokens.get(2));
                // read next line
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addScreen(String screenId, String screenName, String cinemaId) {
        Cinema cinema = iCinemaRepository.getCinemaById(cinemaId);
        cinema.addScreen(new Screen(screenId, screenName));
        iCinemaRepository.updateCinema(cinema);
    }
}
