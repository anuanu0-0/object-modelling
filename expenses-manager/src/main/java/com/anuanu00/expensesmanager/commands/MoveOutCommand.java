package com.anuanu00.expensesmanager.commands;

import com.anuanu00.expensesmanager.exceptions.DuesPendingException;
import com.anuanu00.expensesmanager.exceptions.MemberNotFoundException;

import java.util.List;

public class MoveOutCommand implements ICommand{

    // Add the service layer dependency

    @Override
    public void execute(List<String> tokens) {
        String memberName = tokens.get(1);

        try {
            // perform dues check from service layer
            if (true) {
                System.out.println("SUCCESS");
            } else  {
                throw new DuesPendingException();
            }
            throw new MemberNotFoundException();
        } catch (MemberNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (DuesPendingException e) {
            System.out.println(e.getMessage());
        }
    }
}
