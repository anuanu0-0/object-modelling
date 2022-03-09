package com.anuanu00.expensesmanager.commands;

import com.anuanu00.expensesmanager.services.IHouseService;

import java.util.List;

public class MoveInCommand implements ICommand{

    // Call the service layer
    private final IHouseService iHouseService;

    public MoveInCommand(IHouseService iHouseService) {
        this.iHouseService = iHouseService;
    }

    @Override
    public void execute(List<String> tokens) {
        String memberName = tokens.get(1);

        // Creating a custom house for demo implementation

//        try {
//            iHouseService.moveInMember(memberName, house.getId());
//            System.out.println("SUCCESS");
//        } catch (HousefulException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
