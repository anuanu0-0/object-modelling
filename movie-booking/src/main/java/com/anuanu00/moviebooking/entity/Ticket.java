package com.anuanu00.moviebooking.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Ticket {
    private final Integer id;
    private final Show show;
    private final Customer customer;
    private final List<Seat> seatList;

    public Ticket(Integer id, Show show, Customer customer) {
        this.id = id;
        this.show = show;
        this.customer = customer;
        this.seatList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getShowId() {
        return show.getId();
    }
}
