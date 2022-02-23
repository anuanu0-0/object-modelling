package com.anuanu00.moviebooking.services;

import com.anuanu00.moviebooking.entites.*;
import com.anuanu00.moviebooking.exceptions.NoSuchTicketFoundException;
import com.anuanu00.moviebooking.exceptions.SeatNotAvailableException;
import com.anuanu00.moviebooking.repositories.ICustomerRepository;
import com.anuanu00.moviebooking.repositories.IShowRepository;
import com.anuanu00.moviebooking.repositories.IShowSeatRepository;
import com.anuanu00.moviebooking.repositories.ITicketRepository;

import java.util.List;

public class TicketService implements ITicketService{

    private final ITicketRepository iTicketRepository;
    private final ICustomerRepository iCustomerRepository;
    private final IShowRepository iShowRepository;
    private final IShowSeatRepository iShowSeatRepository;

    public TicketService(ITicketRepository iTicketRepository, ICustomerRepository iCustomerRepository, IShowRepository iShowRepository, IShowSeatRepository iShowSeatRepository) {
        this.iTicketRepository = iTicketRepository;
        this.iCustomerRepository = iCustomerRepository;
        this.iShowRepository = iShowRepository;
        this.iShowSeatRepository = iShowSeatRepository;
    }

    @Override
    public Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException {
        Customer customer = iCustomerRepository.getCustomerById(customerId);
        Show show = iShowRepository.getShowById(showId);

        // Check if seats are available
        for(Seat seat: seatList) {
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(showId, seat.getId());
            if(showSeat.isLocked()){
                throw new SeatNotAvailableException();
            }
        }

        // Reserve the seats
        for(Seat seat: seatList) {
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(showId, seat.getId());
            showSeat.lock();
            iShowSeatRepository.updateShowSeat(showSeat);
        }

        Ticket ticket = iTicketRepository.saveTicket(customer, show, seatList);
        return ticket;
    }

    @Override
    public void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException {
        Ticket ticket = iTicketRepository.getTicketById(ticketId);
        if(ticket == null) {
            throw new NoSuchTicketFoundException();
        }
        List<Seat> seatList = ticket.getSeatList();
        for(Seat seat: seatList) {
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(ticket.getShowId(), seat.getId());
            showSeat.unlock();
            iShowSeatRepository.updateShowSeat(showSeat);
        }

        iTicketRepository.removeTicket(ticketId);
    }
}
