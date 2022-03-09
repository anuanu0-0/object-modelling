package com.anuanu00.moviebooking.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Seat {
    private final String id;
    private final Integer seatRow;
    private final Integer seatColumn;
}
