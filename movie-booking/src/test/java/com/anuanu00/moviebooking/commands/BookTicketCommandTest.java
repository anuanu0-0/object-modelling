package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.ShowSeat;
import com.anuanu00.moviebooking.entites.Ticket;
import com.anuanu00.moviebooking.exceptions.SeatNotAvailableException;
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

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("BookTicketCommandTest")
@ExtendWith(MockitoExtension.class)
public class BookTicketCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    Ticket ticketMock;

    @Mock
    TicketService ticketServiceMock;

    @InjectMocks
    BookTicketCommand bookTicketCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("execute method Should Print Ticket Id")
    public void execute_ShouldPrintTicketId() throws SeatNotAvailableException {
        // Arrange
        String customerId = "1";
        String showId = "1";
        Seat seat1_2 = new Seat("1#2", 1, 2);
        Seat seat1_3 = new Seat("1#3", 1, 3);
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );
        String expectedOutput = "Ticket ID - 0";
        when(ticketServiceMock.bookTicket(customerId, showId, seatList)).thenReturn(ticketMock);
        // Act
        bookTicketCommand.execute(new ArrayList<String>(
                List.of("BOOK-TICKET", customerId, showId, seat1_2.getId(), seat1_3.getId()
                )));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(ticketServiceMock).bookTicket(anyString(), anyString(), anyList());
    }

    @Test
    @DisplayName("execute method Should Print Error Message to the console")
    public void execute_ShouldPrintErrorMessage() throws SeatNotAvailableException {
        // Arrange
        String customerId = "1";
        String showId = "1";
        Seat seat1_2 = new Seat("1#2", 1, 2);
        Seat seat1_3 = new Seat("1#3", 1, 3);
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );

        String expectedOutput = "Some Seats are already Booked! Please try booking available seats!";
        when(ticketServiceMock.bookTicket(customerId, showId, seatList)).thenThrow(new SeatNotAvailableException());
        // Act
        bookTicketCommand.execute(new ArrayList<>(
                List.of("BOOK-TICKET", customerId, showId, seat1_2.getId(), seat1_3.getId())
        ));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(ticketServiceMock).bookTicket(anyString(), anyString(), anyList());
    }
}
