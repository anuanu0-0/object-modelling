package com.anuanu00.expensesmanager.commands;

import com.anuanu00.expensesmanager.exceptions.MemberNotFoundException;

import java.util.List;

public class DuesCommand implements ICommand{

    // Add the service dependency

    @Override
    public void execute(List<String> tokens) {
        String memberOwningMoney = tokens.get(1);

        try {
            // Get dueslist of the member corresponding to other members
            // Print member - amount

            throw new MemberNotFoundException();
        } catch (MemberNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
