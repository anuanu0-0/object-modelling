package com.anuanu00.expensesmanager.entities;

import com.anuanu00.expensesmanager.exceptions.HousefulException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("House Test")
public class HouseTest {

    private House house;

    @BeforeEach
    public void setup() throws HousefulException {
//        house = new House("1");
//        house.addResidents(new Resident("1", "user1", house));
//        house.addResidents(new Resident("2", "user2", house));
    }

    @Test
    @DisplayName("addResidents method Should Add Residents Given Resident Object")
    public void addResidents_ShouldAddResidents() throws HousefulException {
        house = new House("1");
        house.addResidents(new Resident("1", "user1", house));
        house.addResidents(new Resident("2", "user2", house));
        // Arrange
        Resident actualResident = new Resident("3", "user3", house);
        // Act
        Resident expectedResident = house.getResidents().get(2);
        // Assert
        Assertions.assertEquals(expectedResident, actualResident);
    }

    @Test
    @DisplayName("addResidents method Should Throw Exception if House is Full")
    public void addResidents_ShouldThrowException() {

    }

    @Test
    @DisplayName("removeResidents method Should Remove Residents")
    public void removeResidents_ShouldRemoveResident() {

    }

    @Test
    @DisplayName("removeResidents method Should Throw Exception Given Resident Doesn't belong to House")
    public void removeResidents_ShouldThrowException_GivenInvalidResident() {

    }

    @Test
    @DisplayName("removeResidents Should Throw Exception Given Residents Have Uncleared Dues")
    public void removeResidents_ShouldThrowException_GivenResidentHaveUnclearedDues() {

    }
}
