package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Cinema;

public interface ICinemaRepository {
    Cinema getCinemaById(String id);
    void saveCinema(Cinema cinema);
    void updateCinema(Cinema cinema);
}
