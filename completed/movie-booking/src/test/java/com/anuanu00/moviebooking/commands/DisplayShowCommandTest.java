package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.dto.ShowResponse;
import com.anuanu00.moviebooking.services.ShowService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("DisplayShowCommandTest")
@ExtendWith(MockitoExtension.class)
public class DisplayShowCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    ShowService showServiceMock;

    @InjectMocks
    DisplayShowCommand displayShowCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("execute method Should Print List of Shows to Console")
    public void execute_ShouldPrintShowList() throws ParseException {
        // Arrange
        String movieTitle = "MovieA";
        List<ShowResponse> showResponseList = new ArrayList<>();

        Date start = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 10:30");
        Date end = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:00");

        for (int i = 1; i <= 3; i++) {
            showResponseList.add(new ShowResponse(Integer.toString(i), "MovieA", "CinemaA", "Screen" + i, start, end));
        }

        when(showServiceMock.getAllShowsByMovieTitle(movieTitle)).thenReturn(showResponseList);
        String expectedOutput = "Show ID - 1\r\n" +
                "Title - MovieA\r\n" +
                "Start - 20/07/2021 10:30\r\n" +
                "End - 20/07/2021 13:00\r\n" +
                "Cinema - CinemaA\r\n" +
                "Screen - Screen1\r\n" +
                "\r\n" +
                "Show ID - 2\r\n" +
                "Title - MovieA\r\n" +
                "Start - 20/07/2021 10:30\r\n" +
                "End - 20/07/2021 13:00\r\n" +
                "Cinema - CinemaA\r\n" +
                "Screen - Screen2\r\n" +
                "\r\n" +
                "Show ID - 3\r\n" +
                "Title - MovieA\r\n" +
                "Start - 20/07/2021 10:30\r\n" +
                "End - 20/07/2021 13:00\r\n" +
                "Cinema - CinemaA\r\n" +
                "Screen - Screen3";

        // Act
        displayShowCommand.execute(new ArrayList<>(List.of("DISPLAY-SHOWS", movieTitle)));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(showServiceMock).getAllShowsByMovieTitle(movieTitle);

    }

    @Test
    @DisplayName("execute Should Print Empty to Console If No Shows")
    public void execute_ShouldPrintEmptyIfNoShows() {
        // Arrange
        String movieTitle = "MovieA";
        List<ShowResponse> showResponseList = new ArrayList<>();
        when(showServiceMock.getAllShowsByMovieTitle(movieTitle)).thenReturn(showResponseList);
        String expectedOutput = "";
        // Act
        displayShowCommand.execute(new ArrayList<>(List.of("DISPLAY-MOVIES",movieTitle)));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(showServiceMock).getAllShowsByMovieTitle(movieTitle);

    }
}
