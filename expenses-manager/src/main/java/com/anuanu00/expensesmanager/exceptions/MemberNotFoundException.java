package com.anuanu00.expensesmanager.exceptions;

public class MemberNotFoundException extends Exception{
    @Override
    public String toString() {
        return "MEMBER_NOT_FOUND";
    }
}
