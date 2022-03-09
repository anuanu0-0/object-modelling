package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.Show;
import com.anuanu00.moviebooking.entites.ShowSeat;
import com.anuanu00.moviebooking.services.ShowService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("DisplayShowSeatCommandTest")
@ExtendWith(MockitoExtension.class)
public class DisplayShowSeatCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    Show show;

    @Mock
    ShowService showServiceMock;

    @InjectMocks
    DisplayShowSeatCommand displayShowSeatCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("execute method Should Print List of ShowSeats to Console")
    public void execute_ShouldShowSeatList() {
        // Arrange
        String showId = "1";
        List<ShowSeat> showSeatList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                String rowCol = i + "#" + j;
                showSeatList.add(new ShowSeat("1" + rowCol, new Seat(rowCol, i, j), show));
            }
        }
        when(showServiceMock.getAllShowSeats(showId)).thenReturn(showSeatList);
        String expectedOutput = "SeatRow - 1\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED";

        // Act
        displayShowSeatCommand.execute(new ArrayList<>(List.of("DISPLAY-SEATS", showId)));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(showServiceMock).getAllShowSeats(showId);
    }
}
