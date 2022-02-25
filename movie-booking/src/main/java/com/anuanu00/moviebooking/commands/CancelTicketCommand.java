package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.exceptions.NoSuchTicketFoundException;
import com.anuanu00.moviebooking.services.ITicketService;

import java.util.List;

public class CancelTicketCommand implements ICommand{

    private final ITicketService iTicketService;

    public CancelTicketCommand(ITicketService iTicketService) {
        this.iTicketService = iTicketService;
    }

    @Override
    public void execute(List<String> tokens) {
        Integer ticketId = Integer.parseInt(tokens.get(1));
        try {
            iTicketService.cancelTicket(ticketId);
            System.out.println("Cancellation Successful!");
        } catch (NoSuchTicketFoundException e) {
            System.out.println(e);
        }
    }
}
