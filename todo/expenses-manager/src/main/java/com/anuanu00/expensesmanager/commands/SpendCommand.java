package com.anuanu00.expensesmanager.commands;

import com.anuanu00.expensesmanager.exceptions.MemberNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SpendCommand implements ICommand{

    // Call the service layer

    @Override
    public void execute(List<String> tokens) {
        Integer amount = Integer.parseInt(tokens.get(1));
        String memberLendingMoney = tokens.get(2);
        List<String> memberOwningMoney = new ArrayList<>();
        for(int i=3; i<tokens.size(); i++) {
            memberOwningMoney.add(tokens.get(i));
        }

        try {
            // Add dues respectively
            // Resolve due conflicts if any
            // Check is the member exists
            System.out.println("SUCCESS");
            throw new MemberNotFoundException();
        } catch (MemberNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
