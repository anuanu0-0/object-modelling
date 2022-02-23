package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Show;

import java.util.List;

public interface IShowRepository {
    List<Show> getShowsByMovieNames(String title);
    Show getShowById(String id);
    void saveShow(Show show);
}
