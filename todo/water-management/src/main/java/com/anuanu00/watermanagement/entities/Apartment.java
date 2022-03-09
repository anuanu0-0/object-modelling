package com.anuanu00.watermanagement.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

//@Getter
//@EqualsAndHashCode
public abstract class Apartment {
    protected final Integer numOfResidents;

    protected Apartment(Integer numOfResidents) {
        this.numOfResidents = numOfResidents;
    }
}
