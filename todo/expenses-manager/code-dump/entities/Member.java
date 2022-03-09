package com.anuanu00.expensesmanager.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Member {
    private final String id;
    private final String name;
    private final String houseId;
    private final List<Due> dues;

    public Member(String id, String name, String houseId) {
        this.id = id;
        this.name = name;
        this.houseId = houseId;
        this.dues = new ArrayList<>();
    }

    // Add members to duelist
//    public void add
    // Update members to duelist
}
