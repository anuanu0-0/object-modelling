package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Cinema;
import com.anuanu00.moviebooking.entity.Movie;
import com.anuanu00.moviebooking.entity.Screen;
import com.anuanu00.moviebooking.entity.Show;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DisplayName("ShowRepositoryTest")
public class ShowRepositoryTest {

    private ShowRepository showRepository;

    @BeforeEach
    void setup() throws ParseException {
        Map<String, Show> showMap = new HashMap<>();
        showMap.put("1", new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1", "ScreenA"),
                new Cinema("1", "CinemaA"),
                new Movie("1", "MovieA", 120)));
        showMap.put("2", new Show("2",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("2", "ScreenA"),
                new Cinema("1", "CinemaA"),
                new Movie("2", "MovieB", 120)));
        showMap.put("3", new Show("3",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("4", "ScreenA"),
                new Cinema("2", "CinemaB"),
                new Movie("1", "MovieA", 120)));
        showRepository = new ShowRepository(showMap);
    }

    @Test
    @DisplayName("getShowsByMovieNames Given Movie Name Should Return Shows")
    public void getShowsByMovieNames_GivenMovieName_ShouldReturnShows() throws ParseException {
        // Arrange
        List<Show> expectedShowList = new ArrayList<>(
                List.of(
                        new Show("3",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                                new Screen("4", "ScreenA"),
                                new Cinema("2", "CinemaB"),
                                new Movie("1", "MovieA", 120)),
                        new Show("1",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                                new Screen("1", "ScreenA"),
                                new Cinema("1", "CinemaA"),
                                new Movie("1", "MovieA", 120))

                ));
        // Act
        List<Show> actualShowList = showRepository.getShowsByMovieNames("MovieA");

        // Assert
        Assertions.assertTrue(expectedShowList.size() == actualShowList.size()
                && expectedShowList.containsAll(actualShowList)
                && actualShowList.containsAll(expectedShowList)
        );
    }

    @Test
    @DisplayName("getShowById method Should Return Show Given Show Id")
    public void getShowById_GivenShowId_ShouldReturnShow() throws ParseException {
        //Arrange
        Show expectedShow = new Show("3",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("4", "ScreenA"),
                new Cinema("2", "CinemaB"),
                new Movie("1", "MovieA", 120));
        //Act
        Show actualShow = showRepository.getShowById("3");
        //Assert
        Assertions.assertEquals(expectedShow, actualShow);
    }

    @Test
    @DisplayName("getShowById  method Should Return null Given Show Id If Show not found")
    public void getShowById_GivenShowId_ShouldReturnNull() {
        //Arrange
        String showId = "4";
        //Act
        Show actualShow = showRepository.getShowById(showId);
        //Assert
        Assertions.assertNull(actualShow);
    }

    @Test
    @DisplayName("saveShow method Should Save Show")
    public void saveShow_ShouldSaveShow() throws ParseException {
        //Arrange
        Show expectedShow = new Show("4",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("5", "ScreenA"),
                new Cinema("2", "CinemaB"),
                new Movie("1", "MovieA", 120));
        //Act
        showRepository.saveShow(expectedShow);

        //Assert
        Assertions.assertEquals(expectedShow, showRepository.getShowById("4"));
    }
}