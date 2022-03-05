package com.anuanu00.expensesmanager.entities;

import java.util.List;

import static com.anuanu00.expensesmanager.globals.GlobalConstants.MAX_RESIDENTS;

public class House {
    private final String id;
    private final List<Member> members;

    public House(String id, List<Member> members) {
        this.id = id;
        this.members = members;
    }

    // Add members
    public void addMembers(Member member) {}

    // Update members
    public void updateMembers() {}
}
