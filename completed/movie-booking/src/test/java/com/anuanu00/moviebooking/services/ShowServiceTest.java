package com.anuanu00.moviebooking.services;

import com.anuanu00.moviebooking.dto.ShowResponse;
import com.anuanu00.moviebooking.entites.*;
import com.anuanu00.moviebooking.repositories.ShowRepository;
import com.anuanu00.moviebooking.repositories.ShowSeatRepository;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("ShowServiceTest")
@ExtendWith(MockitoExtension.class)
public class ShowServiceTest {

    @Mock
    ShowRepository showRepositoryMock;

    @Mock
    ShowSeatRepository showSeatRepositoryMock;

    @InjectMocks
    ShowService showService;

    @Test
    @DisplayName("getAllShowsByMovieTitle Given Movie Title Should Return Show Response List")
    public void getAllShowsByMovieTitle_GivenMovieTitle_ShouldReturnShowResponseList() throws ParseException {
        // Arrange
        List<Show> showList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            showList.add(new Show(
                    Integer.toString(i),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                    new Screen(Integer.toString(i), "Screen#" + i),
                    new Cinema(Integer.toString(i), "Cinema#" + i),
                    new Movie("1", "MovieA", 120)
            ));
        }

        List<ShowResponse> actualShowResponseList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            actualShowResponseList.add(new ShowResponse(
                    Integer.toString(i),
                    "MovieA",
                    "Cinema#" + i,
                    "Screen#" + i,
                    new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                    new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00")
            ));
        }

        when(showRepositoryMock.getShowsByMovieNames("MovieA")).thenReturn(showList);
        // Act
        List<ShowResponse> expectedShowResponseList = showService.getAllShowsByMovieTitle("MovieA");
        // Assert
        Assertions.assertEquals(expectedShowResponseList, actualShowResponseList);
        verify(showRepositoryMock).getShowsByMovieNames("MovieA");
    }

    @Test
    @DisplayName("getAllShowsByMovieTitle Given Movie Title Should Return Empty Show Response List If No Movies Found")
    public void getAllShowsByMovieTitle_GivenMovieTitle_ShouldReturnEmptyShowResponseListIfNoMoviesFound() {
        // Arrange
        List<Show> showList = new ArrayList<>();
        List<ShowResponse> actualShowResponseList = new ArrayList<>();
        when(showRepositoryMock.getShowsByMovieNames("MovieA")).thenReturn(showList);
        // Act
        List<ShowResponse> expectedShowResponseList = showService.getAllShowsByMovieTitle("MovieA");
        // Assert
        Assertions.assertEquals(expectedShowResponseList, actualShowResponseList);
        verify(showRepositoryMock).getShowsByMovieNames("MovieA");
    }

    @Test
    @DisplayName("getAllShowSeats module Given ShowId Should Return ShowSeat List")
    public void getAllShowSeats_GivenShowId_ShouldReturnShowSeatList() throws ParseException {
        // Arrange
        Show show = new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1", "ScreenA"),
                new Cinema("1", "CinemaA"),
                new Movie("1", "MovieA", 120));

        List<ShowSeat> actualShowSeatList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                String rowCol = i + "#" + j;
                actualShowSeatList.add(new ShowSeat("1#" + rowCol, new Seat(rowCol, i, j), show));
            }
        }
        when(showSeatRepositoryMock.getShowSeatsByShowId("1")).thenReturn(actualShowSeatList);
        // Act
        List<ShowSeat> expectedShowSeatList = showService.getAllShowSeats("1");
        // Assert
        Assertions.assertEquals(expectedShowSeatList, actualShowSeatList);
        verify(showSeatRepositoryMock).getShowSeatsByShowId("1");
    }
}
