package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.exceptions.NoSuchTicketFoundException;
import com.anuanu00.moviebooking.services.TicketService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@DisplayName("CancelTicketCommandTest")
@ExtendWith(MockitoExtension.class)
public class CancelTicketCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    TicketService ticketServiceMock;

    @InjectMocks
    CancelTicketCommand cancelTicketCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("")
    public void execute_ShouldPrintSuccessfulMessage() throws NoSuchTicketFoundException {
        // Arrange
        Integer ticketId = 1;
        String expectedOutput = "Cancellation Successful!";
        // Act
        cancelTicketCommand.execute(new ArrayList<>(
                List.of("CANCEL-TICKET", ticketId.toString())
        ));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(ticketServiceMock).cancelTicket(anyInt());
    }

    @Test
    @DisplayName("")
    public void execute_ShouldPrintErrorMessageIfTicketNotFound() throws NoSuchTicketFoundException {
        // Arrange
        Integer ticketId = 1;
        String expectedOutput = "No Such Ticket found!";
        doThrow(NoSuchTicketFoundException.class).when(ticketServiceMock).cancelTicket(ticketId);
        // Act
        cancelTicketCommand.execute(new ArrayList<>(
                List.of("CANCEL-TICKET", ticketId.toString())
        ));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(ticketServiceMock).cancelTicket(anyInt());
    }
}
