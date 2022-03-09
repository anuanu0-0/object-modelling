package com.anuanu00.moviebooking.services;

import com.anuanu00.moviebooking.entites.*;
import com.anuanu00.moviebooking.exceptions.NoSuchTicketFoundException;
import com.anuanu00.moviebooking.exceptions.SeatNotAvailableException;
import com.anuanu00.moviebooking.repositories.CustomerRepository;
import com.anuanu00.moviebooking.repositories.ShowRepository;
import com.anuanu00.moviebooking.repositories.ShowSeatRepository;
import com.anuanu00.moviebooking.repositories.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("TicketServiceTest")
@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    private Customer customer;
    private Show show;
    private ShowSeat showSeat1_1_2;
    private ShowSeat showSeat1_1_3;
    private Seat seat1_2;
    private Seat seat1_3;

    @Mock
    TicketRepository ticketRepositoryMock;

    @Mock
    CustomerRepository customerRepositoryMock;

    @Mock
    ShowRepository showRepositoryMock;

    @Mock
    ShowSeatRepository showSeatRepositoryMock;

    @InjectMocks
    TicketService ticketService;

    @BeforeEach
    public void setup() throws ParseException {
        customer = new Customer("1", "CustomerA", "customera@gmail.com");
        show  = new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));
        seat1_2 = new Seat("1#2", 1, 2);
        seat1_3 = new Seat("1#3", 1, 3);
        showSeat1_1_2 = new ShowSeat("1#1#2", seat1_2, show);
        showSeat1_1_3 = new ShowSeat("1#1#3", seat1_3, show);
    }

    @Test
    @DisplayName("bookTicket Should Book Ticket")
    public void bookTicket_ShouldBookTicket() throws SeatNotAvailableException {
        // Arrange
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );
        Ticket actualTicket = new Ticket(1, customer, show, seatList);

        when(customerRepositoryMock.getCustomerById("1")).thenReturn(customer);
        when(showRepositoryMock.getShowById("1")).thenReturn(show);
        when(showSeatRepositoryMock.getShowSeat(anyString(), anyString())).thenReturn(showSeat1_1_2, showSeat1_1_3);
        when(ticketRepositoryMock.saveTicket(customer, show, seatList)).thenReturn(new Ticket(1, customer, show, seatList));
        // Act
        Ticket expectedTicket = ticketService.bookTicket("1", "1", seatList);
        // Assert
        Assertions.assertEquals(expectedTicket, actualTicket);
    }

    @Test
    @DisplayName("bookTicket Should Throw Exception If Seat Already Booked")
    public void bookTicket_ShouldThrowException_IfSeatAlreadyBooked() {
        // Arrange
        showSeat1_1_2.lock();
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );

        when(customerRepositoryMock.getCustomerById("1")).thenReturn(customer);
        when(showRepositoryMock.getShowById("1")).thenReturn(show);
        when(showSeatRepositoryMock.getShowSeat(anyString(), anyString())).thenReturn(showSeat1_1_2, showSeat1_1_3);

        // Act & Assert
        Assertions.assertThrows(SeatNotAvailableException.class, () -> ticketService.bookTicket("1", "1", seatList));
    }

    @Test
    @DisplayName("cancelTicket method Given Ticket Id Should Cancel Ticket")
    public void cancelTicket_GivenTicketId_ShouldCancelTicket() throws NoSuchTicketFoundException {
        // Arrange
        showSeat1_1_2.lock();
        showSeat1_1_3.lock();
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );
        Ticket ticket = new Ticket(1, customer, show, seatList);
        when(ticketRepositoryMock.getTicketById(1)).thenReturn(ticket);
        when(showSeatRepositoryMock.getShowSeat("1","1#2")).thenReturn(showSeat1_1_2);
        when(showSeatRepositoryMock.getShowSeat("1","1#3")).thenReturn(showSeat1_1_3);

        // Act
        ticketService.cancelTicket(1);

        // Assert
        showSeat1_1_2.unlock();
        verify(showSeatRepositoryMock).updateShowSeat(showSeat1_1_2);
        showSeat1_1_3.unlock();
        verify(showSeatRepositoryMock).updateShowSeat(showSeat1_1_3);
        verify(ticketRepositoryMock).removeTicket(1);
    }

    @Test
    @DisplayName("cancelTicket method Given Ticket Id Should Throw Exception If Ticket Not Found")
    public void cancelTicket_GivenTicketId_ShouldThrowExceptionIfTicketNotFound() throws NoSuchTicketFoundException {
        // Arrange
        Integer ticketId = 1;
        when(ticketRepositoryMock.getTicketById(ticketId)).thenReturn(null);
        // Act & Assert
        Assertions.assertThrows(NoSuchTicketFoundException.class, () -> ticketService.cancelTicket(1));
        verify(ticketRepositoryMock).getTicketById(1);
    }
}
