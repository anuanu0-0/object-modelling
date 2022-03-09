package com.anuanu00.expensesmanager.services;

import com.anuanu00.expensesmanager.exceptions.HousefulException;

public interface IHouseService {
    void moveInMember(String memberName, String houseId) throws HousefulException;
    void moveOutMember(String memberName);
}
