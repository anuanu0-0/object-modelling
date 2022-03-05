package com.anuanu00.expensesmanager.exceptions;

public class IncorrectPaymentException extends Exception {
    @Override
    public String toString() {
        return "INCORRECT_PAYMENT";
    }
}