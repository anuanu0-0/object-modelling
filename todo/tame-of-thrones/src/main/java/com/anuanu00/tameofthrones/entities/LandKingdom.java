package com.anuanu00.tameofthrones.entities;

import java.util.Set;

public class LandKingdom extends Kingdom{
    protected LandKingdom(String name, String emblem, Set<Kingdom> allies) {
        super(name, emblem, allies);
    }
}
