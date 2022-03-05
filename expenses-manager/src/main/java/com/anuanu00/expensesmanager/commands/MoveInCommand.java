package com.anuanu00.expensesmanager.commands;

import com.anuanu00.expensesmanager.exceptions.HousefulException;

import java.util.List;

public class MoveInCommand implements ICommand{

    // Call the service layer

    @Override
    public void execute(List<String> tokens) {
        String memberName = tokens.get(1);
        try {
            // Moving in new member
            System.out.println("SUCCESS");
            throw new HousefulException();
        } catch (HousefulException e) {
            System.out.println(e.getMessage());
        }
    }
}
