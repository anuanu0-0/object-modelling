package com.anuanu00.watermanagement.entities.apartments;

import com.anuanu00.watermanagement.entities.Apartment;

public class ThreeBHK extends Apartment {
    private static int numOfResidents = 5;
    protected ThreeBHK() {
        super(numOfResidents);
    }
}
