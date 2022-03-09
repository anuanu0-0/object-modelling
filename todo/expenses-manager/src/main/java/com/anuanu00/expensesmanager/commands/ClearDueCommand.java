package com.anuanu00.expensesmanager.commands;

import com.anuanu00.expensesmanager.exceptions.IncorrectPaymentException;

import java.util.List;

public class ClearDueCommand implements ICommand{

    // Add service layer dependency

    @Override
    public void execute(List<String> tokens) {
        String memberOwningMoney = tokens.get(1);
        String memberLendingMoney = tokens.get(2);
        Integer amount = Integer.parseInt(tokens.get(3));

        try {
            // Amount can be partial or full
            // Amount cannot be more than amount owned
            // Print the remaining balance
            throw new IncorrectPaymentException();
        } catch (IncorrectPaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}
