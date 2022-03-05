package com.anuanu00.expensesmanager.entities;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String id;
    private final String name;
    private final List<Due> dues;

    public Member(String id, String name, List<Due> dues) {
        this.id = id;
        this.name = name;
        this.dues = new ArrayList<>();
    }

    // Add members to duelist
//    public void add
    // Update members to duelist
}
