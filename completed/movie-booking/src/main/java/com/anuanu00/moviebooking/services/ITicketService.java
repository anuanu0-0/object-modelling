package com.anuanu00.moviebooking.services;

import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.Ticket;
import com.anuanu00.moviebooking.exceptions.NoSuchTicketFoundException;
import com.anuanu00.moviebooking.exceptions.SeatNotAvailableException;

import java.util.List;

public interface ITicketService {
    Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException;
    void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException;
}
