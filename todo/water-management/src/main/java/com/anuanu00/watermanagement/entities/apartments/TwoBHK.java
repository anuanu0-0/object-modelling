package com.anuanu00.watermanagement.entities.apartments;

import com.anuanu00.watermanagement.entities.Apartment;

public class TwoBHK extends Apartment {
    private static int numOfResidents = 3;
    protected TwoBHK() {
        super(numOfResidents);
    }
}
