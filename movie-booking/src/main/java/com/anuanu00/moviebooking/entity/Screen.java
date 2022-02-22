package com.anuanu00.moviebooking.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Screen {
    private final String id;
    private final String name;
    private final List<Seat> seatList;

    public Screen(String id, String name) {
        this.id = id;
        this.name = name;
        this.seatList = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seatList.add(seat);
    }
}
