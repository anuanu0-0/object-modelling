package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Show;

import java.util.List;

public interface IShowRepository {
    List<Show> getShowsByMovieNames(String title);
    Show getShowById(String id);
    void saveShow(Show show);
}
