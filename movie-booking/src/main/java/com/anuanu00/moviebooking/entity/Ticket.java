package com.anuanu00.moviebooking.entity;

import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
public class Ticket {
    private final Integer id;
    private final Customer customer;
    private final Show show;
    private final List<Seat> seatList;

    public Ticket(Integer id, Customer customer, Show show, List<Seat> seatList) {
        this.id = id;
        this.customer = customer;
        this.show = show;
        this.seatList = seatList;
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
