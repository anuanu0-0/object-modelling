package com.anuanu00.watermanagement.entities;

import com.anuanu00.watermanagement.exceptions.ApartmentNotFoundException;
import lombok.*;

/**
 * @author Anupam Srivastava
 * @date
 * */

//@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Bill {
//    private final String id;
    @NonNull private final int waterAllocatedPerPersonInLts;
    @NonNull private final int billableDaysInMonth;
    private final Apartment apartment;
    private int guests;

    public Bill (@NonNull int waterAllocatedPerPersonInLts, @NonNull int billableDaysInMonth) {
        this.waterAllocatedPerPersonInLts = waterAllocatedPerPersonInLts;
        this.billableDaysInMonth = billableDaysInMonth;
    }

    public void addGuests(int guests) throws ApartmentNotFoundException {
        if(apartment != null) {
            throw new ApartmentNotFoundException();
        }
        this.guests += guests;
    }
}
