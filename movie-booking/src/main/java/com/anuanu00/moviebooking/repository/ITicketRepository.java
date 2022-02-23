package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Customer;
import com.anuanu00.moviebooking.entity.Seat;
import com.anuanu00.moviebooking.entity.Show;
import com.anuanu00.moviebooking.entity.Ticket;

import java.util.List;

public interface ITicketRepository {
    Ticket getTicketById(Integer id);
    Ticket saveTicket(Customer customer, Show show, List<Seat> seatList);
    void removeTicket(Integer id);
}
