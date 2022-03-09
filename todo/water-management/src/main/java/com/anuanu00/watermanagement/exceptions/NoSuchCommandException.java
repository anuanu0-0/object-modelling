package com.anuanu00.watermanagement.exceptions;

public class NoSuchCommandException extends Exception {
    @Override
    public String toString() {
        return "No such Command Found!";
    }
}
