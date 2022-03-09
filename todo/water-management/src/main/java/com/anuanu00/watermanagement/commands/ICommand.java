package com.anuanu00.watermanagement.commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}
