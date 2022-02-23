package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Cinema;

import java.util.HashMap;
import java.util.Map;

public class CinemaRepository implements ICinemaRepository{

    private final Map<String, Cinema> cinemaMap;

    public CinemaRepository() {
        this.cinemaMap = new HashMap<>();
    }

    public CinemaRepository(Map<String, Cinema> cinemaMap) {
        this.cinemaMap = cinemaMap;
    }

        @Override
    public Cinema getCinemaById(String id) {
        return cinemaMap.get(id);
    }

    @Override
    public void saveCinema(Cinema cinema) {
        cinemaMap.put(cinema.getId(), cinema);
    }

    @Override
    public void updateCinema(Cinema cinema) {
        cinemaMap.put(cinema.getId(), cinema);
    }
}
