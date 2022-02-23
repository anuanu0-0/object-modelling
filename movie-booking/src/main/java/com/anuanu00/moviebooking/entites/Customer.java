package com.anuanu00.moviebooking.entites;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Customer {
    private final String id;
    private final String name;
    private final String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
