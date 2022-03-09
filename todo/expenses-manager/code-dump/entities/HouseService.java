package com.anuanu00.expensesmanager.services;

import com.anuanu00.expensesmanager.entities.House;
import com.anuanu00.expensesmanager.entities.Member;
import com.anuanu00.expensesmanager.exceptions.HousefulException;
import com.anuanu00.expensesmanager.repositories.IHouseRepository;

import static com.anuanu00.expensesmanager.globals.GlobalConstants.MAX_MEMBERS;

public class HouseService implements IHouseService{

    private final IHouseRepository iHouseRepository;

    public HouseService(IHouseRepository iHouseRepository) {
        this.iHouseRepository = iHouseRepository;
    }

    @Override
    public void moveInMember(String memberName, String houseId) throws HousefulException {
        // Check the repository layer for house if the house this member is being added to
        // is available for accommodation
        // If the house repository method returns false, then throw HousefulException
        House house = iHouseRepository.getHouseById(houseId);
        if (house.getMembers().size() == MAX_MEMBERS) {
            throw new HousefulException();
        } else {
            // Add the given member into the house
//            Member member = new Member("")
        }
    }

    @Override
    public void moveOutMember(String memberName) {

    }
}
