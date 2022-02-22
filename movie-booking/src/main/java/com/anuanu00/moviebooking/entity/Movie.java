package com.anuanu00.moviebooking.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Movie {
    private final String id;
    private final String title;
    private final Integer durationInMins;
}
