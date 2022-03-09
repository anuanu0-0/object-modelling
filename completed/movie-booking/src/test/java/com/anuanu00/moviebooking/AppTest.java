package com.anuanu00.moviebooking;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Integration Test")
class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Integration Test")
    void runTest() {
        //Arrange
        List<String> arguments = new ArrayList<>(List.of("INPUT-FILE=temp/input.txt",
                "CINEMA-DATA=temp/cinema.csv",
                "SCREEN-DATA=temp/screen.csv",
                "SEAT-DATA=temp/seat.csv",
                "CUSTOMER-DATA=temp/customer.csv",
                "MOVIE-DATA=temp/movie.csv",
                "SHOW-DATA=temp/show.csv"));

        String expectedOutput = "Movie ID - 1\r\n" +
                "Title - MovieA\r\n" +
                "Duration - 120\r\n" +
                "\r\n" +
                "Movie ID - 2\r\n" +
                "Title - MovieB\r\n" +
                "Duration - 120\r\n" +
                "\r\n" +
                "Movie ID - 3\r\n" +
                "Title - MovieC\r\n" +
                "Duration - 120\r\n" +
                "\r\n" +
                "Show ID - 1\r\n" +
                "Title - MovieA\r\n" +
                "Start - 14/10/2020 10:30\r\n" +
                "End - 14/10/2020 13:00\r\n" +
                "Cinema - CinemaA\r\n" +
                "Screen - SCREENA\r\n" +
                "\r\n" +
                "Show ID - 4\r\n" +
                "Title - MovieA\r\n" +
                "Start - 14/10/2020 10:30\r\n" +
                "End - 14/10/2020 13:00\r\n" +
                "Cinema - CinemaB\r\n" +
                "Screen - SCREENA\r\n" +
                "\r\n" +
                "Show ID - 7\r\n" +
                "Title - MovieA\r\n" +
                "Start - 14/10/2020 10:30\r\n" +
                "End - 14/10/2020 13:00\r\n" +
                "Cinema - CinemaC\r\n" +
                "Screen - SCREENA\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "Ticket ID - 1\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - RESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - RESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - RESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "Cancellation Successful!\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 4\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 5\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 6\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 1\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 2\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 4\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 3\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 6\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 5\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 2\r\n" +
                "Status - UNRESERVED\r\n" +
                "\r\n" +
                "SeatRow - 3\r\n" +
                "SeatColumn - 1\r\n" +
                "Status - UNRESERVED";

        //Act
        App.run(arguments);

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
}
