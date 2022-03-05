package com.anuanu00.expensesmanager.entities;

import com.anuanu00.expensesmanager.exceptions.DuesPendingException;
import com.anuanu00.expensesmanager.exceptions.HousefulException;
import com.anuanu00.expensesmanager.exceptions.MemberAlreadyExistsException;
import com.anuanu00.expensesmanager.exceptions.MemberNotFoundException;
import lombok.Data;
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
        residents = new ArrayList<>();
    }

    public void addResidents(Resident resident) throws HousefulException, MemberAlreadyExistsException {
        if (residents.size() == MAX_RESIDENTS) {
            throw new HousefulException();
        } else if (residents.contains(resident)) {
            throw new MemberAlreadyExistsException();
        } else {
            addResidentToDueList(resident);
            residents.add(resident);
        }
    }

    public void removeResidents(Resident resident) throws MemberNotFoundException, DuesPendingException {
        System.out.println(resident);
        if (!residents.contains(resident)) {
            throw new MemberNotFoundException();
        } else if (checkDuesStatus(resident)) {
            throw new DuesPendingException();
        }
        residents.remove(resident);
        removeResidentFromOtherDueList(resident);
        System.out.println("SUCCESSFUL");
    }

    // Helper methods
    private void addResidentToDueList(Resident resident) {
        // Update Duelist for other residents
        for (Resident r : residents) {
            r.updateDues(resident, 0);
        }

        // Update Duelist for new residents
        for (Resident r : residents) {
            resident.updateDues(r, 0);
        }
    }

    private void removeResidentFromOtherDueList(Resident resident) {
        for (Resident r : residents) {
            r.getDues().remove(resident);
        }
    }

    private boolean checkDuesStatus(Resident resident) {
        //  resident has cleared all its dues
        if (resident.haveDues()) {
            return true;
        }
        // no other resident has due left hor this resident
        for (Resident r: residents) {
            if (r.haveDues(resident)) {
                return true;
            }
        }
        return false;
    }
}
