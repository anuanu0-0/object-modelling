package com.anuanu00.moviebooking.commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}
