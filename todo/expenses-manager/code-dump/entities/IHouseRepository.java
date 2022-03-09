package com.anuanu00.expensesmanager.repositories;

import com.anuanu00.expensesmanager.entities.House;

public interface IHouseRepository {
    House getHouseById(String id);
    void saveHouse(House house);
    /**
     * Suppose we have 2 members in a particular id=1, we now want to add
     * 3rd member to that house
     *
     *
     * MOVE_IN ADAM ->
     * Check if the house is full,
     * Throw new HousefulException if is full
     * if not, create a new member and add it to the house
     *
     *
     *
     *
     * **/
}
