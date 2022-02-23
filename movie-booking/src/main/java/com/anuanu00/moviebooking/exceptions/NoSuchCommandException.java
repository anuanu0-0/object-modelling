package com.anuanu00.moviebooking.exceptions;

public class NoSuchCommandException extends Exception {
    @Override
    public String toString() {
        return "No such Command Found!";
    }

}
