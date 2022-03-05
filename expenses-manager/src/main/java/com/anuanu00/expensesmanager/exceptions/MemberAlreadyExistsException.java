package com.anuanu00.expensesmanager.exceptions;

public class MemberAlreadyExistsException extends Exception {
    @Override
    public String toString() {
        return "Member already exists in the house!!";
    }
}
