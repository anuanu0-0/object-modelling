package com.anuanu00.expensesmanager.repositories;

import com.anuanu00.expensesmanager.entities.House;

import java.util.HashMap;
import java.util.Map;

public class HouseRepository implements IHouseRepository{
    private final Map<String, House> houseMap;

    public HouseRepository() {
        this.houseMap = new HashMap<>();
    }

    public HouseRepository(Map<String, House> houseMap) {
        this.houseMap = houseMap;
    }


    @Override
    public House getHouseById(String id) {
        return null;
    }

    @Override
    public void saveHouse(House house) {

    }
}
