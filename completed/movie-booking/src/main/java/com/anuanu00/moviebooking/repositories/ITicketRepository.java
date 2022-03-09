package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Customer;
import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.Show;
import com.anuanu00.moviebooking.entites.Ticket;

import java.util.List;

public interface ITicketRepository {
    Ticket getTicketById(Integer id);
    Ticket saveTicket(Customer customer, Show show, List<Seat> seatList);
    void removeTicket(Integer id);
}
