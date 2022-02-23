package com.anuanu00.moviebooking.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CinemaTest")
public class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    public void setup() {
        cinema = new Cinema("1", "CinemaA");
        cinema.addScreen(new Screen("1", "ScreenA"));
        cinema.addScreen(new Screen("2", "ScreenB"));
        cinema.addScreen(new Screen("3", "ScreenC"));
    }

    @Test
    @DisplayName("getScreenByName method should return screen given screenName")
    public void getScreenByName_GivenScreenName_ShouldReturnScreen() {
        // Arrange
        Screen actualScreen = new Screen("2", "ScreenB");

        // Act
        Screen expectedScreen = cinema.getScreenByName("ScreenB");

        // Assert
        Assertions.assertEquals(expectedScreen, actualScreen);
    }

    @Test
    @DisplayName("getScreenById method should return screen given screenId")
    public void getScreenById_GivenScreenId_ShouldReturnScreen() {
        // Arrange
        Screen actualScreen = new Screen("2", "ScreenB");

        // Act
        Screen expectedScreen = cinema.getScreenById("2");

        // Assert
        Assertions.assertEquals(expectedScreen, actualScreen);
    }

    @Test
    @DisplayName("getScreenByName method should return null given screenName not present in cinema")
    public void getScreenByName_GivenScreenNameNotPresentInCinema_ShouldReturnNull() {
        // Act
        Screen expectedScreen = cinema.getScreenByName("ScreenD");

        // Assert
        Assertions.assertNull(expectedScreen);
    }

    @Test
    @DisplayName("getScreenById method should return null given screenId not present in cinema")
    public void getScreenId_GivenScreenIdNotPresentInCinema_ShouldReturnNull() {
        // Act
        Screen expectedScreen = cinema.getScreenById("4");

        // Assert
        Assertions.assertNull(expectedScreen);
    }
}
