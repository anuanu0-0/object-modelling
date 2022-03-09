package com.anuanu00.expensesmanager.commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}
