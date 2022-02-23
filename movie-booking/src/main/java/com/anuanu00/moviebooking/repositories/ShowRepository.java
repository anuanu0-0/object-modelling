package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowRepository implements IShowRepository{

    private final Map<String, Show> showMap;

    public ShowRepository() {
        this.showMap = new HashMap<>();
    }

    public ShowRepository(Map<String, Show> showMap) {
        this.showMap = showMap;
    }

    @Override
    public List<Show> getShowsByMovieNames(String title) {
        return showMap.values()
                .stream()
                .filter(show -> title.equals(show.getMovieTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public Show getShowById(String id) {
        return showMap.get(id);
    }

    @Override
    public void saveShow(Show show) {
        showMap.put(show.getId(), show);
    }
}
