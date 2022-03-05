package com.anuanu00.expensesmanager.entities;

import com.anuanu00.expensesmanager.entities.*;
import com.anuanu00.expensesmanager.exceptions.DuesPendingException;
import com.anuanu00.expensesmanager.exceptions.HousefulException;
import com.anuanu00.expensesmanager.exceptions.MemberAlreadyExistsException;
import com.anuanu00.expensesmanager.exceptions.MemberNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("House Test")
public class HouseTest {

    private House house;
    Resident resident_1, resident_2;

    @BeforeEach
    public void setup() throws HousefulException, MemberAlreadyExistsException {
        house = new House("1");
        resident_1 = new Resident("1", "user1");
        resident_2 = new Resident("2", "user2");

        house.addResidents(resident_1);
        house.addResidents(resident_2);
    }

    @Test
    @DisplayName("addResidents method Should Add Residents Given Resident Object")
    public void addResidents_ShouldAddResidents() throws HousefulException, MemberAlreadyExistsException {
        // Arrange
        Resident actualResident = new Resident("3", "user3");
        house.addResidents(actualResident);
        // Act
        Resident expectedResident = house.getResidents().get(2);
        // Assert
        Assertions.assertEquals(expectedResident, actualResident);
    }

    @Test
    @DisplayName("addResidents method Should Throw Exception if House is Full")
    public void addResidents_ShouldThrowException() throws HousefulException, MemberAlreadyExistsException {
        // Arrange
        house.addResidents(new Resident("3", "user3"));
        // Act & Assert
        Assertions.assertThrows(HousefulException.class,
                () -> house.addResidents(new Resident("4", "user4")));
    }

    @Test
    @DisplayName("addResidents method Should Throw Exception if Resident Already Exists")
    public void addResidents_ShouldThrowException_GivenResidentAlreadyExists() {
        // Act & Assert
        Assertions.assertThrows(MemberAlreadyExistsException.class, ()-> house.addResidents(resident_1));
    }

    @Test
    @DisplayName("addResidents method Should Update Residents DuesList Given New Resident")
    public void addResidents_ShouldUpdateResidentsDueList_GivenNewResident() throws MemberAlreadyExistsException, HousefulException {
        // Arrange
        Resident newResident = new Resident("3", "user3");
        // Act
        house.addResidents(newResident);
        // Assert
        Assertions.assertTrue(resident_1.getDues().containsKey(newResident));
        Assertions.assertTrue(resident_2.getDues().containsKey(newResident));
        Assertions.assertTrue(newResident.getDues().containsKey(resident_1));
        Assertions.assertTrue(newResident.getDues().containsKey(resident_2));

        Assertions.assertFalse(newResident.getDues().containsKey(newResident));

    }

    @Test
    @DisplayName("removeResidents method Should Remove Residents")
    public void removeResidents_ShouldRemoveResident() throws HousefulException, MemberNotFoundException, DuesPendingException, MemberAlreadyExistsException {
        // Arrange
        Resident resident = new Resident("3", "user3");
        house.addResidents(resident);
        int expectedSize = house.getResidents().size();
        // Act
        house.removeResidents(resident);
        int actualSize = house.getResidents().size();
        // Act & Assert
        Assertions.assertTrue(expectedSize == actualSize + 1);
    }

    @Test
    @DisplayName("removeResidents method Should Throw Exception Given Resident Doesn't belong to House")
    public void removeResidents_ShouldThrowException_GivenInvalidResident() throws MemberNotFoundException, DuesPendingException {
        // Arrange
        Resident resident = new Resident("5", "user5");
        // Act & Assert
        Assertions.assertThrows(MemberNotFoundException.class, () -> house.removeResidents(resident));

    }

    @Test
    @DisplayName("removeResidents Should Throw Exception Given Residents Have Uncleared Dues")
    public void removeResidents_ShouldThrowException_GivenResidentHaveUnclearedDues() throws HousefulException, MemberAlreadyExistsException {
        // Arrange
        Resident resident_3 = new Resident("3", "user3");
        house.addResidents(resident_3);
        resident_3.updateDues(resident_2, 100);
        // Act & Assert
        Assertions.assertThrows(DuesPendingException.class, () -> house.removeResidents(resident_3));
    }

}
