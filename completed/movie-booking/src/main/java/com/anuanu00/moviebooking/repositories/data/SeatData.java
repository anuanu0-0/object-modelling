package com.anuanu00.moviebooking.repositories.data;

import com.anuanu00.moviebooking.entites.Cinema;
import com.anuanu00.moviebooking.entites.Screen;
import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.repositories.ICinemaRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SeatData implements IData {

    private final ICinemaRepository iCinemaRepository;

    public SeatData(ICinemaRepository iCinemaRepository) {
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
                addSeat(tokens.get(0), tokens.get(1), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
                // read next line
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addSeat(String cinemaId, String screenId, int numRows, int numCols) {
        Cinema cinema = iCinemaRepository.getCinemaById(cinemaId);
        Screen screen = cinema.getScreenById(screenId);
        for(int i = 1 ; i <= numRows; i++){
            for(int j = 1 ; j<= numCols; j++){
                screen.addSeat(new Seat(i + "#" + j, i, j));
            }
        }
        cinema.addScreen(screen);
        iCinemaRepository.updateCinema(cinema);
    }
}
