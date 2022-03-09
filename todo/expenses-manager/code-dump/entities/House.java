package com.anuanu00.expensesmanager.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final String id;
    private final List<Member> members;

    public House(String id) {
        this.id = id;
        this.members = new ArrayList<>();
    }

    // Add members
    public void addMembers(Member member) {}

    // Update members
    public void updateMembers() {}
}
