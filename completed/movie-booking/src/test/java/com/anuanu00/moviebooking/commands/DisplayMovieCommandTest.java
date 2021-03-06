package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.entites.Movie;
import com.anuanu00.moviebooking.services.MovieService;
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

@DisplayName("DisplayMovieCommandTest")
@ExtendWith(MockitoExtension.class)
public class DisplayMovieCommandTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    MovieService movieServiceMock;

    @InjectMocks
    DisplayMovieCommand displayMovieCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    @DisplayName("execute method Should Print List of Movies to Console")
    public void execute_ShouldPrintMovieList() {
        // Arrange
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("1", "MovieA", 120));
        movieList.add(new Movie("2", "MovieB", 150));
        movieList.add(new Movie("3", "MovieC", 180));

        when(movieServiceMock.getAllMovies()).thenReturn(movieList);

        String expectedOutput = "Movie ID - 1\r\n" +
                "Title - MovieA\r\n" +
                "Duration - 120\r\n" +
                "\r\n" +
                "Movie ID - 2\r\n" +
                "Title - MovieB\r\n" +
                "Duration - 150\r\n" +
                "\r\n" +
                "Movie ID - 3\r\n" +
                "Title - MovieC\r\n" +
                "Duration - 180";

        // Act
        displayMovieCommand.execute(new ArrayList<>(List.of("DISPLAY-MOVIES")));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(movieServiceMock).getAllMovies();
    }

    @Test
    @DisplayName("execute method Should Empty to Console If No Movies Found")
    public void execute_ShouldPrintEmptyIfNoMovies() {
        // Arrange
        List<Movie> movieList = new ArrayList<>();
        when(movieServiceMock.getAllMovies()).thenReturn(movieList);
        String expectedOutput = "";
        // Act
        displayMovieCommand.execute(new ArrayList<>(List.of("DISPLAY-MOVIES")));
        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        verify(movieServiceMock).getAllMovies();
    }
}
