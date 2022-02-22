package com.anuanu00.moviebooking.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Show {
    private final String id;
    private final LocalDate start;
    private final LocalDate end;
    private final Movie movie;
    private final Cinema cinema;
    private final Screen screen;

    public String getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
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
