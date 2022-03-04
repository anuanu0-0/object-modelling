package com.anuanu00.expensesmanager.entities;

import com.anuanu00.expensesmanager.exceptions.HousefulException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@EqualsAndHashCode
public class Resident {
    @Getter
    private final String id;
    @Getter
    private final String name;
    private final House house;
    @Getter
    private final Map<Resident, Integer> dues;

    public Resident(String id, String name, House house) throws HousefulException {
        this.id = id;
        this.name = name;
        this.house = house;
        this.dues = new HashMap<>();
        addMembersToDueList();
        house.addResidents(this);
    }

    public String getHouseId() {
        return house.getId();
    }

    public void updateDue(Resident resident, Integer dueAmount) {
        if (resident != this) {
            dues.put(resident, dueAmount);
        }
    }

    /**
     * TODO : Refactor
     **/
    public void addMembersToDueList() {
        int initialDue = 0;
        // Update other lists with this new resident
        house.getResidents().stream()
                .forEach(resident -> {
                    if (!resident.equals(this)) {
                        resident.updateDue(this, initialDue);
                    }
                });
        // Update this list with other resident
        house.getResidents().stream()
                .forEach(resident -> {
                    if (!resident.equals(this)) {
                        this.updateDue(resident, initialDue);
                    }
                });
    }

    public boolean haveDues() {
        int totalDue = dues.values().stream().reduce(0, Integer::sum);
        return totalDue == 0;
    }
}
