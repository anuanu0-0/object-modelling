package com.anuanu00.expensesmanager.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@Getter
@ToString
@EqualsAndHashCode
public class Resident {
    private final String id;
    private final String name;
    @ToString.Exclude @EqualsAndHashCode.Exclude private final Map<Resident, Integer> dues;

    public Resident(String id, String name) {
        this.id = id;
        this.name = name;
        dues = new HashMap<>();
    }

    public boolean haveDues() {
        return dues.values().stream().reduce(0, Integer::sum) != 0;
    }

    public boolean haveDues(Resident resident) {
        System.out.println("In Resident " + resident);
        return dues.get(resident) != 0;
    }

    public void updateDues(Resident resident, Integer amountDue) {
        dues.put(resident, amountDue);
    }

/** TODO
     * ALL TASKS ->
     *
     * ->/ Whenever a resident is created and added to a specific house, add this resident to all other
     *   residents dues list with a total of 0 due amt.
     * - Check that the resident has cleared all its dues, and no other resident has due left hor this resident.
     * - Remove the moved out resident from all other residents due list.
     *
     * - Method to update the dues with new values
     *
     * ****/

    // Add

}
