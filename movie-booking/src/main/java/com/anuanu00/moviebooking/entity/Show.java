package com.anuanu00.moviebooking.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
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

    private String getScreenName() {
        return screen.getName();
    }

    private String getCinemaName() {
        return cinema.getName();
    }

    private String getMovieTitle() {
        return movie.getTitle();
    }
}
