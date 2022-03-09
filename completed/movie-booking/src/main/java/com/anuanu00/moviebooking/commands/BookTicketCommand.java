package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.Ticket;
import com.anuanu00.moviebooking.exceptions.SeatNotAvailableException;
import com.anuanu00.moviebooking.services.ITicketService;

import java.util.ArrayList;
import java.util.List;

public class BookTicketCommand implements ICommand{

    private final ITicketService iTicketService;

    public BookTicketCommand(ITicketService iTicketService) {
        this.iTicketService = iTicketService;
    }

    @Override
    public void execute(List<String> tokens) {
        String customerId = tokens.get(1);
        String showId = tokens.get(2);
        List<Seat> seatList = new ArrayList<>();
        for(int i=3; i<tokens.size(); i++) {
            String[] words = tokens.get(i).split("#");
            Seat seat = new Seat(tokens.get(i), Integer.parseInt(words[0]), Integer.parseInt(words[1]));
            seatList.add(seat);
        }

        try {
            Ticket ticket = iTicketService.bookTicket(customerId, showId, seatList);
            System.out.println("Ticket ID - " + ticket.getId());
            System.out.println();
        } catch(SeatNotAvailableException e) {
            System.out.println(e);
        }
    }
}
