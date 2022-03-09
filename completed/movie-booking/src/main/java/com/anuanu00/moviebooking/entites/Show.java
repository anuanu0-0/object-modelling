package com.anuanu00.moviebooking.entites;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Show {
    private final String id;
    private final Date start;
    private final Date end;
    private final Screen screen;
    private final Cinema cinema;
    private final Movie movie;

    public String getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getScreenName() {
        return screen.getName();
    }

    public String getCinemaName() {
        return cinema.getName();
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }
}
