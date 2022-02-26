package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

@DisplayName("CommandInvokerTest")
@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {

    private CommandInvoker commandInvoker;

    @Mock
    BookTicketCommand bookTicketCommandMock;

    @Mock
    CancelTicketCommand cancelTicketCommandMock;

    @Mock
    DisplayMovieCommand displayMovieCommandMock;

    @Mock
    DisplayShowCommand displayShowCommandMock;

    @Mock
    DisplayShowSeatCommand displayShowSeatCommandMock;

    @BeforeEach
    public void setUp() {
        commandInvoker = new CommandInvoker();
        commandInvoker.register("DISPLAY-MOVIES", displayMovieCommandMock);
        commandInvoker.register("DISPLAY-SHOWS", displayShowCommandMock);
        commandInvoker.register("DISPLAY-SEATS", displayShowSeatCommandMock);
        commandInvoker.register("BOOK-TICKET", bookTicketCommandMock);
        commandInvoker.register("CANCEL-TICKET", cancelTicketCommandMock);
    }

    @Test
    @DisplayName("executeCommand method Should Execute Command Given CommandName and List of tokens")
    public void executeCommand_GivenCommandNameAndTokenList_ShouldExecuteCommand() throws NoSuchCommandException {
        // Act
        commandInvoker.executeCommand("DISPLAY-MOVIES", anyList());
        commandInvoker.executeCommand("DISPLAY-SHOWS", anyList());
        commandInvoker.executeCommand("DISPLAY-SEATS", anyList());
        commandInvoker.executeCommand("BOOK-TICKET", anyList());
        commandInvoker.executeCommand("CANCEL-TICKET", anyList());

        // Assert
        verify(displayMovieCommandMock).execute(anyList());
        verify(displayShowCommandMock).execute(anyList());
        verify(displayShowSeatCommandMock).execute(anyList());
        verify(bookTicketCommandMock).execute(anyList());
        verify(cancelTicketCommandMock).execute(anyList());
    }

    @Test
    @DisplayName("executeCommand Should Throw Exception Given Incorrect CommandName and List of Tokens")
    public void executeCommand_GivenIncorrectCommandNameAndTokenList_ShouldThrowException() {
        // Act and Assert
        Assertions.assertThrows(NoSuchCommandException.class, () -> commandInvoker.executeCommand("INCORRECT-COMMAND", new ArrayList<String>()));
    }
}
