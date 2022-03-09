package com.anuanu00.watermanagement.commands;

import com.anuanu00.watermanagement.exceptions.NoSuchCommandException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {
    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register commands in map
    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    // Get registered command
    public ICommand get(String commandName) {
        return commandMap.get(commandName);
    }

    // Execute the registered command
    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = get(commandName);
        if(command == null) {
            throw new NoSuchCommandException();
        }
        command.execute(tokens);
    }
}
