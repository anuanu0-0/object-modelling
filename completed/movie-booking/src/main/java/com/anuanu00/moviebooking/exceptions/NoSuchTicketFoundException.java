package com.anuanu00.moviebooking.exceptions;

public class NoSuchTicketFoundException extends Exception{
    @Override
    public String toString() {
        return "No Such Ticket found!";
    }

}
