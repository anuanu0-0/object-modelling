package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Cinema;

public interface ICinemaRepository {
    Cinema getCinemaById(String id);
    void saveCinema(Cinema cinema);
    void updateCinema(Cinema cinema);
}
