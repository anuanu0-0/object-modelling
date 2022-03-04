package com.anuanu00.expensesmanager.entities;

import com.anuanu00.expensesmanager.exceptions.DuesPendingException;
import com.anuanu00.expensesmanager.exceptions.HousefulException;
import com.anuanu00.expensesmanager.exceptions.MemberNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static com.anuanu00.expensesmanager.globals.GlobalConstants.MAX_RESIDENTS;

@Getter
@ToString
@EqualsAndHashCode
public class House {
    private final String id;
    private final List<Resident> residents;

    public House(String id) {
        this.id = id;
        this.residents = new ArrayList<>();
    }

    public void addResidents(Resident resident) throws HousefulException {
        if (residents.size() == MAX_RESIDENTS) {
            throw new HousefulException();
        }
        residents.add(resident);
    }

    public void removeResidents(Resident resident) throws MemberNotFoundException, DuesPendingException {
        if(!residents.contains(resident)) {
            throw new MemberNotFoundException();
        } else if (resident.haveDues()) {
            throw new DuesPendingException();
        }

        residents.remove(resident);
    }
}
